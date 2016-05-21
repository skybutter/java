package sb.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates the code to remove duplicates from list or array
 * @author skybutter
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		Integer[] a = new Integer[] {5,3,6,4,9,1,3,2,4,5,8,7,1,4,0};
		List<Integer> input = Arrays.asList(a);
		System.out.println("input: " + input);
		List<Integer> output = removeDuplicates1(input);
		System.out.println("removeDuplicates1: " + output);
		// Arrays.asList() return a list that does not support the remove(int idx) method
		//input = Arrays.asList(a);
		input = convertToList(a);
		output = removeDuplicates2(input);
		System.out.println("removeDuplicates2: " + output);
	}

	// This method remove duplicates in the list.  
	// List can hold any Java Object
	// Using Java HashSet and create new List
	// Use more memory as copying List to Set and copy to new List
	//  Not the most optimized for speed, but fastest to code
	public static <T> List<T> removeDuplicates1(List<T> list) {
		// boundary condition check is missing
		if (list.size() < 2)
			return list;	 
	    HashSet<T> set = new HashSet<T>(list);
	    List<T> result = new ArrayList<T>(set);
	    return result;
	}
	// This method remove duplicates in the list.
	// List can hold any Java Object, but the Object must implement Comparable interface for Collections.sort() to work
	// Use less memory, the same List is modified in place
	public static <T extends Comparable<T>> List<T> removeDuplicates2(List<T> list) {
		long start = System.currentTimeMillis();
		if (list.size() < 2)
			return list;	 
		int i = 0;
		// Using Java built-in merge sort to sort the array. 
		Collections.sort(list);
		while (i < list.size()-1) {
			int j=i + 1;
			if (list.get(i).equals(list.get(j))) {
				list.remove(j);
			}
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println("Remove duplicate return new array: " + (end-start));		
		return list;
	}
	
	// Arrays.asList() return a List not supporting add/remove(), which change size
	private static <T> List<T> convertToList(T[] array) {
		ArrayList<T> list = new ArrayList<T>(array.length);
		for (int i=0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
	// This method remove duplicates in the Integer[]
	// This is similar to above but using arrays.
	// Using new HashSet(List) and set.toArray() instead of loop over list
	// array does not need to be sorted
	// This is slower than the next method with loop
	public static Integer[] removeDuplicates(Integer[] ar) {
		long start = System.currentTimeMillis();
		if (ar.length < 2)
			return ar;
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(ar));
		Integer[] noDups = set.toArray(new Integer[0]);
		long end = System.currentTimeMillis();
		System.out.println("Using HashSet time taken: " + (end-start));
		return noDups;
	}

	// This method remove duplicates in the int[]
	// This is similar to above but using primitive arrays.
	// This required a sorted array of int.
	// Loop thru the array to compare the current and next element
	public static int[] removeDuplicates(int[] A) {
		long start = System.currentTimeMillis();
		if (A.length < 2)
			return A;	 
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		int[] B = Arrays.copyOf(A, j + 1);
		long end = System.currentTimeMillis();
		System.out.println("Remove duplicate return new array: " + (end-start));		
		return B;
	}
 }
