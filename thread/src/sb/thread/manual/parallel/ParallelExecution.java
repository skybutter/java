package sb.thread.manual.parallel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import sb.thread.external.SomeService;
import sb.thread.external.TestQuery;
import sb.thread.external.TestResult;

/**
 * Singleton that access Thread Scheduler
 * This is the entry point to use the ThreadScheduler.
 */
public class ParallelExecution {
	
    private final static Logger logger = Logger.getLogger(ParallelExecution.class.getName());
    private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();    
    
    private static int defaultQueryTimeout = 6000;
    private SomeService service = null;

    private ParallelExecution() {
    	init();
    }

    private static ParallelExecution instance;

    /** singleton */
    public synchronized static ParallelExecution getInstance () {
        if (instance == null) {
            instance = new ParallelExecution();
        }
        return instance;
    }

    public static int getQueryTimeout () {
        return defaultQueryTimeout;
    }

    private void init() {
    	service = new SomeService();
    	service.start();
    }

    public void cleanup () {
        if (service != null) {
            service.stop();
        }
    }

    public TestResult executeQuery (TestQuery query) throws TestException {
        if (service != null) {
            FutureTask<Object> task = null;
            try {
                task = new FutureTask<Object>(new MyCallable<Object>(query));
                Object result = timedCall(task, defaultQueryTimeout, TimeUnit.MILLISECONDS);
                TestResult results = new TestResult(query, result);
                return results;
            } catch (Exception e) {
                    task.cancel(true);
                    throw new TestException("Query timed out " + query.queryId);
            }
        }
        throw new TestException("Service Not Available" + query.queryId);
    }
    
    class MyCallable<T> implements Callable<T> {
    	private TestQuery query = null;
    	public MyCallable(TestQuery query) {
    		this.query = query;
    	}
        public T call() throws Exception {
            Object result = service.doSomething(query);
            return (T) result;
        }    	
    }
    
    private static <T> T timedCall(FutureTask<T> task, long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        THREAD_POOL.execute(task);
        return task.get(timeout, timeUnit);
    }
}