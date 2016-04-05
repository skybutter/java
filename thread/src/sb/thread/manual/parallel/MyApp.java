package sb.thread.manual.parallel;

import com.sun.istack.internal.logging.Logger;

import sb.thread.external.TestQuery;

public class MyApp {

	private static final Logger logger = Logger.getLogger(MyApp.class);
	
	// This is the starting point.
	// This thread scheduler will execute the SomeService.
	// SomeService is a service that maintain connection and session to external system
	// The call to SomeService is synchronized (and process in serial order)
	// Any request wait time reached critical timed out will get exception 
	//  (including time waiting for other thread to finish)
	public static void main(String[] args) {
    	ParallelExecution tool = ParallelExecution.getInstance();
    	for (int i=0; i < 5; i++) {
    		TestQuery query = new TestQuery(i);
    		try {
    			MyThread th = new MyThread(i, query);
    			new Thread(th, "Th" + i).start();
    		} catch (Exception e) {
    			logger.severe("MyApp: " + e.getMessage());
    		}
    	}
	}
}
