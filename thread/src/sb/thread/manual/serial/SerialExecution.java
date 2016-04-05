package sb.thread.manual.serial;

import java.util.logging.Level;
import java.util.logging.Logger;

import sb.thread.external.TestQuery;
import sb.thread.external.TestResult;

/**
 * Singleton that access Thread Scheduler
 * This is the entry point to use the ThreadScheduler.
 */
public class SerialExecution {
	
    private final static Logger logger = Logger.getLogger(SerialExecution.class.getName());
    
    private static ThreadScheduler scheduler = null;
    private static int defaultQueryTimeout = 6000;
    private static boolean isSchedulerStarted = false;

    private SerialExecution() {
    	init();
    }

    /** the one and only */
    private static SerialExecution instance;

    /** singleton */
    public synchronized static SerialExecution getInstance () {
        if (instance == null) {
            instance = new SerialExecution();
        }
        return instance;
    }

    /**
     * Retrieve the default query timeout
     * 
     * @return
     */
    public static int getQueryTimeout () {
        return defaultQueryTimeout;
    }

    /**
     * Initialize the tool
     */
    private void init() {
        scheduler = new ThreadScheduler(defaultQueryTimeout);
        scheduler.start();
        isSchedulerStarted = true;
    }

    /**
     * Cleanup and Release resources...
     */
    public void cleanup () {
        if (scheduler != null) {
            scheduler.stop();
        }
    }

    /**
     * @param query
     * @return
     * @throws TestException
     */
    public TestResult executeQuery (TestQuery query) throws TestException {
        if (scheduler != null) {
            return scheduler.executeQuery(query);
        }
        throw new TestException("Scheduler Not Available");
    }    
}