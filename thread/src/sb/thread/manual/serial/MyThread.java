package sb.thread.manual.serial;

import com.sun.istack.internal.logging.Logger;

import sb.thread.external.TestQuery;
import sb.thread.external.TestResult;

public class MyThread implements Runnable {
	
	private static final Logger logger = Logger.getLogger(MyThread.class);
	
	public int count;
	public TestQuery query;
	public TestResult result;
	
	public MyThread(int count, TestQuery query) {
		this.count = count;
		this.query = query;
	}
	public void run() {
		SerialExecution tool = SerialExecution.getInstance();
    	try {
    		result = tool.executeQuery(query);
    		System.out.println("result=" + result);
    	} catch (TestException e) {
    		logger.severe("MyThread: " + e.getMessage());
    	}
	}
}
