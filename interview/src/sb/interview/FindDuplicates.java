package sb.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates the code to find duplicates from list or array.
 * This class is similar in many ways to the RemoveDuplicates class.
 * However, some of the method used in the RemoveDuplicates can not be used here.
 * @author skybutter
 *
 */
public class FindDuplicates {

	public static void main(String[] args) {
		Integer[] a = new Integer[] {5,3,6,4,9,1,3,2,4,5,8,7,1,4,0};
		List<Integer> input = Arrays.asList(a);
		System.out.println("input: " + input);
		List<Integer> output = findDuplicates1(input);
		System.out.println("findDuplicates1: " + output);
		// Arrays.asList() return a list that does not support the remove(int idx) method
		input = Arrays.asList(a);
		output = findDuplicates2(input);
		System.out.println("findDuplicates2: " + output);
	}

	// This method find duplicates in the list
	// Bubble sort way
	public static <T> List<T> findDuplicates1(List<T> list) {
		long start = System.currentTimeMillis();
		if (list==null || list.size() < 2)
			return Collections.emptyList();
		HashSet<T> duplicates = new HashSet<T>();
	    for (int i=0; i < list.size()-1; i++) {
	    	for (int j=i+1; j < list.size()-1; j++) {
	    		if (list.get(i).equals(list.get(j))) {
	    			duplicates.add(list.get(i));
	    		}
	    	}
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("time taken findDuplicates1: " + (end-start));
	    return new ArrayList<T>(duplicates);
	}
	// This method find duplicates in the list.  You can have 4 repeating 3 times, and it return 4 once on the result
	// List can hold any Java Object.  
	// Object must implement Comparable interface for Collections.sort() to work
	public static <T extends Comparable<T>> List<T> findDuplicates2(List<T> list) {
		long start = System.currentTimeMillis();
		if (list==null || list.size() < 2)
			return Collections.emptyList();	 
		int i = 0;
		// Using Java built-in merge sort to sort the array. 
		Collections.sort(list);
		// if object repeat n times, use HashSet to make it show once.
		// use List to make it show n times
		HashSet<T> duplicates = new HashSet<T>();
		while (i < list.size()-1) {
			int j=i + 1;
			if (list.get(i).equals(list.get(j))) {
				duplicates.add(list.get(i));
			}
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken findDuplicates2: " + (end-start));		
		return new ArrayList<T>(duplicates);
	}	
}
