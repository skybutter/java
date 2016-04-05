package sb.thread.manual.serial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import sb.thread.external.SomeService;
import sb.thread.external.TestQuery;
import sb.thread.external.TestResult;

/**
 * This is the main class with the mechanism.
 * 
 * @author AWong
 *
 */
public class ThreadScheduler implements Runnable {

    protected static int queryTimeout = 1000;					// millisecond timeout by default
    protected final static int CRITICAL_TIMEOUT = 60000;		// Critical timeout in milliseconds.  This time out is the maximum time thread wait (including waiting for all threads to finish).  Not individual thread processing time.
    
    protected final static Logger logger = Logger.getLogger(ThreadScheduler.class.getName());

    private boolean started = false;
    private boolean runnable = false;
    private ArrayList<MethodRequest> executeQueue = new ArrayList<MethodRequest>();
    private Object semaphore = new Object();
    private int cookieCounter = 0;

    // SomeService class should be some service that need to maintain a connection and session for the life of the application
    private SomeService service = null;
    
    ThreadScheduler (int queryTimeout) {
        this.queryTimeout = queryTimeout;
        logger.log(Level.INFO, "Initialize default timeout to " + queryTimeout);
        init();
    }
    
    private boolean validateQuery(MethodRequest method) {
    	boolean result = true;
    	// Validate if the Input Query is good
    	TestQuery query = method.getQuery();
    	// validate query
    	if (query==null) {
    		method.setException(new TestException("Validation Error..."));
    	}
    	return result;
    }
    
    protected void doExecuteQuery (MethodRequest method) {
    	// Validate Query
    	boolean validated = validateQuery(method);
    	if (!validated)
    		return;
    	
    	// do something
    	TestQuery query = method.getQuery();
    	Object result = service.doSomething(query);
    	method.setResult(new TestResult(query, result));
        // Release the method
        synchronized (method) {
            method.setDone(true);
            method.notifyAll();
        }
    }

    protected void init() {
    	service = new SomeService();
        if (!service.start()) {
            String errorMessage = "Could not start service";
            logger.log(Level.SEVERE, "init", new Exception(errorMessage));
            return;
        }
    }

    protected void release() throws Exception {
        if (service != null) {
            logger.log(Level.INFO, "Stopping service");
            service.stop();
            logger.log(Level.INFO, "Service stopped");
        }
    }

    protected void waitForCompletion (MethodRequest method) {
        try {
            synchronized (method) {
                if (!method.isDone()) {
                    method.wait(CRITICAL_TIMEOUT);
                }
            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Interrupted", e);
        }
    }

    // From Abstract - BEGIN
    final synchronized void stop () {
        runnable = false;
        started = false;
        synchronized (semaphore) {
            semaphore.notify();
        }
    }

    final synchronized void start () {
        if (started) {
            return;
        }
        Thread thr = new Thread(this, "ThreadScheduler");
        thr.setDaemon(true);
        runnable = true;
        thr.start();
        logger.log(Level.INFO, "Started Scheduler Thread.");
    }

    // This method is called by other class to run the query
    public final TestResult executeQuery (TestQuery query) throws TestException {

        MethodRequest method = null;
        long start = System.currentTimeMillis();
        synchronized (semaphore) {
            method = new MethodRequest(MethodRequest.SYNC_EXECUTE, query, ++cookieCounter);
            executeQueue.add(method);
            semaphore.notify();
        }
        waitForCompletion(method);
        // if the request timed out
        if (!method.isDone()) {
            throw new TestException("Request Time Out!\nYour query has been running for more than\n"
                + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
        }
        // throw the exception if one was found.
        if (method.getException() != null) {
            throw method.getException();
        }
        // return the result in all other cases
        return method.getResult();
    }

    final public void run () {
        try {
            init();
            logger.log(Level.INFO, "Scheduler started.");
            while (runnable) {
                try {
                    while (executeQueue.size() > 0) {
                        doExecuteQuery((MethodRequest) executeQueue.remove(0));
                    }
                    synchronized (semaphore) {
                        // wait here and wake up every now and then
                        semaphore.wait(queryTimeout);
                    }
                } catch (Throwable e) {
                    logger.log(Level.SEVERE, "Caught exception", e);
                }
            }
            release();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unable to continue!", e);
        } finally {
            runnable = false;
            logger.log(Level.INFO, "Done.");
        }
    }

    protected void restartService() {
        synchronized (semaphore) {
            logger.warning("============================");
            try {
                release();
                init();
            } catch (IOException | InterruptedException e) {
                logger.log(Level.SEVERE, "restartService failed.", e);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "restartService failed.", e);
            }
            logger.warning("============================");
        }
    }
}
