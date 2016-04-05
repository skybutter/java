package sb.thread.external;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.istack.internal.logging.Logger;

public class SomeService {

	private static Logger logger = Logger.getLogger(SomeService.class);
	private static final int MIN = 1000;
	private static final int MAX = 10000;

	public Object doSomething(TestQuery query) {
		Object result = null;
		// do something
		int sleepTime = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
		result = new Integer(query.queryId);
		String threadName = Thread.currentThread().getName();
		Date now = new Date(System.currentTimeMillis());
		logger.info("Sleep for " + sleepTime + " second on query=" + query.queryId + " , thread="+ threadName + " , at " + now);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// handle the exception if needed
		}
		return result;
	}
	
	public boolean start() {
		// Starting the Service
		return true;
	}
	public boolean stop() {
		// Stopping the Service
		return true;
	}
}
