package sb.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FibonacciSeries {

	/**
	 * This program generate the numbers in Fibonacci Series up to the given number.
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 12;
		List<Integer> list1 = getFibonacciList1(max);
		System.out.println("Fibonacci Recursion (" + max + ")=" + list1);
		System.out.println("counter=" + counter);
		counter = 0;
		List<Integer> list2 = getFibonacciList2(max);
		System.out.println("Fibonacci Loop (" + max + ")=" + list2);
		System.out.println("counter=" + counter);
		counter = 0;
	}

	private static int counter = 0;
	// Tail recursion
	public static int fibonacciRecursion(int num) {
		counter++;
		if (num < 0)
			throw new IllegalArgumentException("input is less than 0.");
		if (num==0 || num==1)
			return num;
		return fibonacciRecursion(num-1) + fibonacciRecursion(num-2);
	}
	
	public static List<Integer> getFibonacciList1(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i=0; i < num; i++) {
			int fn = fibonacciRecursion(i);
			list.add(fn);
		}
		return list;
	}

	public static int fibonacciLoop(int num) {
		if (num < 0)
			throw new IllegalArgumentException("input is less than 0.");
		if (num==0 || num==1)
			return num;
		int fn = 0;
		int f1 = 0;
		int f2 = 1;
		for (int i=1; i < num; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
			counter++;
		}
		return fn;
	}

	public static List<Integer> getFibonacciList2(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i=0; i < num; i++) {
			int fn = fibonacciLoop(i);
			list.add(fn);
		}
		return list;
	}
}
