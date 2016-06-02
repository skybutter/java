package sb.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class YpOnSite {

	// Implement a Blocking Queue class
/*	
 * Alvaro Question:
 * A blocking queue is a queue that blocks when you try to dequeue from it and 
 * the queue is empty, or if you try to enqueue items to it and the queue is already full. 
 * A thread trying to dequeue from an empty queue is blocked until some other thread inserts 
 * an item into the queue. A thread trying to enqueue an item in a full queue is blocked until 
 * some other thread makes space in the queue, either by dequeuing one or more items or clearing 
 * the queue completely. 	
 */
	
/* 
 * Ming Question:
 * Implement a function to find the n element of Fibonacci series
 * Recursive
 * And find a more efficient way to do it.
 */
	public static int fibRecursive(int n) {
		if (n==0 || n==1) {
			return 1;
		}
		if (n < 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		return fibRecursive(n-1) + fibRecursive(n-2);
	}
	// Loop is more efficient
	public static int fib(int n) {
		if (n==0 || n==1) {
			return 1;
		}
		if (n < 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		int fn1 = 1;
		int fn2 = 1;
		int fn = 0;
		for (int i=2; i <= n; i++) {
			fn = fn1 + fn2;
			fn1 = fn2;
			fn2 = fn;
		}
		return fn;
	}

/*
 * Roland Question:
 * Given a very large file with large number of int.  Each line is int.
 * Get the largest 100 numbers.
 * Hint: the file is large that it won't fit the memory.
 */
	public Integer[] getLargest(int n) {
		Integer[] largest = new Integer[n];
		BufferedReader reader = null;
		FileReader file = null;
		try {
			file = new FileReader("LargeIntFile.txt");
			reader = new BufferedReader(file);
			String s = reader.readLine();
			TreeSet<Integer> tree = new TreeSet<Integer>();
			while (s!=null) {
				int num = Integer.parseInt(s);
				if (tree.size() < n) {
					tree.add(num);
				} else {
					int first = tree.first();
					if (first < num) {
						tree.remove(first);
						tree.add(num);
					}
				}
				s = reader.readLine();
			}
			largest = tree.toArray(largest);
		} catch (Exception e) {
			throw new RuntimeException("Error");
		} finally {
			// close the Reader
		}
		return largest;
	}
	
	public void testSuit() {
		// David Question - Test
		Suit spade = Suit.SPADE;
		Suit heart = Suit.HEART;
		Suit s1 = Suit.SPADE;
		
		if (!spade.equals(heart)) {
			System.out.println("spade!=heart");
		}
		if (!spade.equals(null)) {
			System.out.println("spade!=null");
		}
		if (spade.equals(s1)) {
			System.out.println("spade==s1");
		}
	}
	
	public void testQueue() {
		Queue que = new Queue();
		que.push(1);
		que.push(2);
		que.push(3);
		Object o = que.pop();
		System.out.println("Pop1=" + o);
		que.push(4);
		que.push(5);
		o = que.pop();
		System.out.println("Pop2=" + o);

	}
	
	public int[] generateRandomIntArray(int size) {
		int[] array = new int[size];
		for (int i=0; i < size; i++) {
			array[i] = (int) (Math.random()*100 + Math.random()*10);
		}		
		return array;
	}
	public static void main(String[] s) {
		YpOnSite yp = new YpOnSite();
		yp.testSuit();
		yp.testQueue();
		testFib();
		testFindTarget();
	}
	
	private static void testFib() {
		int n = 4;
		System.out.println("Fib(" + n +")=" + fib(n));
		n = 5;
		System.out.println("Fib(" + n +")=" + fib(n));
		n = 6;
		System.out.println("Fib(" + n +")=" + fib(n));		
	}
	private static void testFindTarget() {
		int[] array = new int[] {1,2,3,4,5};
		int target = 6;
		System.out.println("Input array=" + Arrays.toString(array));
		System.out.println("Target=" + target);
		System.out.println("Found Target in Array=" + findTarget(array, target));
		array = new int[] {2, 5, 9, 11, 7, 3, 18};
		System.out.println("Input array=" + Arrays.toString(array));
		System.out.println("Target=" + target);
		System.out.println("Found Target in Array=" + findTarget(array, target));
		array = new int[] {1, 2, 3, 4, 5, 94, 100};
		target = 195;
		System.out.println("Input array=" + Arrays.toString(array));
		System.out.println("Target=" + target);
		System.out.println("Found Target in Array=" + findTarget(array, target));
		array = new int[] {2, 2, 3, 4, 5, 95, 100};
		target = 195;
		System.out.println("Input array=" + Arrays.toString(array));
		System.out.println("Target=" + target);
		System.out.println("Found Target in Array=" + findTarget(array, target));
	}
	
	/*
	 * Chen question:
	 * Given an array of int and a target.  Write a function to return true if any 3 or more elements add up to the target.
	 * Ex:
	 * 	Given array {1,2,3,4,5}, target is 6.  function return true.
	 *  Given array {2,5,9,18}, target is 6.  function return false.
	 */
	public static boolean findTarget(int[] arr, int target) {
		boolean result = false;
		// This list store all the combination that is less the target
		Collection<Integer> list = new ArrayList<>();
		for (int i=0; i < arr.length; i++) {
			if (arr[i] < target) {
				Collection<Integer> tempList = new ArrayList<>();
				Iterator<Integer> it = list.iterator();
				while (it.hasNext()) {
					int j = it.next();
					int sum = j + arr[i];
					if (sum == target)
						return true;
					else if (sum < target)
						tempList.add(sum);
				}
				list.add(arr[i]);
				list.addAll(tempList);
			}
		}
		return result;
	}

	/*
	 * Chen Question:
	 * For embedded system, you only have a Stack and no other data structure.
	 * Implement a Queue using Stack only.
	 * No array.  Just a Stack.
	 * Implement the class, with push and pop methods.
	 * 
	 */
	public class Queue {
		private Stack stack = new Stack();	// storing data as it is push on the stack
		private Stack queue = new Stack();	// storing data in reverse order
		
		public void push(Object o) {
			stack.push(o);
		}
		public Object pop() {
			Object o = null;
			if (queue.isEmpty()) {
				while (!stack.isEmpty()) {
					queue.push(stack.pop());
				}
				o = queue.pop();
			} else {
				o = queue.pop();
			}
			return o;
		}
	}
}
/*
 * David Question:
 * Playing cards have 4 Suits: Spade, Heart, Diamond, Club
 * 
 * Write a method interface that take in the suite as an enum and return a Card object.
 * The Method interface is like:
 * 	Card getRandom(Suit s)
 * 
 * If you need to use Java before enum is available, do you have to change the method signature.
 * If yes, how?  (wrong answer)
 * If no need to change method signature,
 * Write the Java implementation of a Suit class as if there is no enum.
 * Note: I just put this here as a class, it should be in its own file as public class.  
 * But I can not have a public class inside the same class file.
 */
class Suit {
	public static Suit SPADE = new Suit(1);
	public static Suit HEART = new Suit(2);
	public static Suit DIAMOND = new Suit(3);
	public static Suit CLUB = new Suit(4);
	
	private int suit = 0;
	
	private Suit(int s) {
		this.suit = s;
	}
	@Override
    public boolean equals(Object obj) {
		if (obj instanceof Suit) {
			Suit s = (Suit) obj;
			if (s.suit == this.suit)
				return true;
			else
				return false;
		} else 
			return false;
    }
}
