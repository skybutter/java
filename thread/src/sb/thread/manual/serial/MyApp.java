package sb.thread.manual.serial;

import sb.thread.external.TestQuery;

public class MyApp {

	// This is the starting point.
	// This thread scheduler will execute the SomeService.
	// SomeService is a service that maintain connection and session to external system
	// The call to SomeService is synchronized (and process in serial order)
	// Any request wait time reached critical timed out will get exception 
	//  (including time waiting for other thread to finish)
	public static void main(String[] args) {
    	SerialExecution tool = SerialExecution.getInstance();
    	for (int i=0; i < 5; i++) {
    		TestQuery query = new TestQuery(i);
    		try {
    			MyThread th = new MyThread(i, query);
    			new Thread(th, "Th" + i).start();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
	}

}
