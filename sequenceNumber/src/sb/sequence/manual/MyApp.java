package sb.sequence.manual;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class run multiple threads to test the sequence number code. 
 * @author AWong
 *
 */
public class MyApp {

	public static final int MAX_THREAD_POOL_SIZE = 1000;

	public static void main(String[] args) {
		startThreads2();
	}
	
	public static String startThreads() {
		
		StringBuilder msg = new StringBuilder("ThreadNextKey startThreads ");
		int count = 100;
		
		// Run Tasks in fixed size thread pool, not getting results back
		ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD_POOL_SIZE);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) {
			ThreadTask task1 = new ThreadTask();
			task1.sequence = SequenceConstants.CLASS;
			pool.submit(task1);
		}

		// Run Task in fixed size thread pool, Getting results back, but will wait for results based on the task adding order
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		
		for(int i = 0; i < count; i++) {
			ThreadTask task2 = new ThreadTask();
			task2.sequence = SequenceConstants.TEACHER;
			futures.add(pool.submit(task2));
		}
//		msg.append("Task2: \n");
//		for (Future<Integer> future : futures) {
//			try {
//				Integer result = future.get();
//				msg.append(" " + result);
//			} catch (InterruptedException | ExecutionException e) {
//				e.printStackTrace();
//			}
//		}

		// Run Task in fixed size thread pool, Getting results back, will process results based on task finishing order
		ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD_POOL_SIZE);
		CompletionService<Integer> pool3 = new ExecutorCompletionService<Integer>(threadPool);
		for(int i = 0; i < count; i++){
			ThreadTask task3 = new ThreadTask();
			task3.sequence = SequenceConstants.SEMESTER;
			pool3.submit(task3);
		}
		for(int i = 0; i < count; i++){
			try {
				Integer result = pool3.take().get();
//				msg.append(" " + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
				
		long end = System.currentTimeMillis();
		msg.append("time taken: " + (end-start) + " ms");
		System.out.println(msg.toString());		
		pool.shutdown();
		threadPool.shutdown();
		return msg.toString();
	}
	
	public static String startThreads2() {
		StringBuilder msg = new StringBuilder("ThreadNextKey startThreads2 ");
		String[] keysArray = new String[] {SequenceConstants.STUDENT
				, SequenceConstants.CLASS
				, SequenceConstants.TEACHER
				, SequenceConstants.SEMESTER };
		
		int count = 10;
		ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD_POOL_SIZE);
		long start = System.currentTimeMillis();
		for(int j = 0; j < count; j++) {
			// Run Tasks in fixed size thread pool, not getting results back				
			for (int i=0; i < keysArray.length; i++) {
				ThreadTask task1 = new ThreadTask();
				task1.sequence = keysArray[i];
				pool.submit(task1);
			}
		}
		long end = System.currentTimeMillis();
		msg.append("time taken: " + (end-start) + " ms");
		System.out.println(msg.toString());		
		pool.shutdown();
		return msg.toString();
	}
}
