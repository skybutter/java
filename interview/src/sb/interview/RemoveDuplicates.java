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
		int[] dups = new int[]{ 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 7, 8, 8, 9, 10, 11, 11, 12, 13, 14, 15, 16, 17, 18, 18, 19, 20 };
//		int[] dups = { 1, 2, 2, 3, 3};
		System.out.println("array length=" + dups.length);
		int[] noDups = removeDuplicates(dups);
		convertArrayToString(noDups);
		dups = new int[]{ 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 7, 8, 8, 9, 10, 11, 11, 12, 13, 14, 15, 16, 17, 18, 18, 19, 20 };
		convertArrayToString(dups);
		int[] myNoDups = myRemoveDuplicates(dups);
		convertArrayToString(myNoDups);
	}

	// This method remove duplicates in the list.  
	// List can hold any Java Object
	// Using Java HashSet and create new List
	//  Not the most optimized, but fastest to code
	public static <T> List<T> removeDuplicates(List<T> list) {
		// boundary condition check is missing
	    HashSet<T> set = new HashSet<T>(list);
	    List<T> result = new ArrayList<T>(set);
	    return result;
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
	
	private static void convertArrayToString(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < a.length; i++) {
			sb.append(a[i] + ",");
		}
		String result = sb.substring(0, sb.length()-1);
		System.out.println("{" + result + "}");
	}
	private static void convertArrayToString(Integer[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < a.length; i++) {
			sb.append(a[i] + ",");
		}
		String result = sb.substring(0, sb.length()-1);
		System.out.println("{" + result + "}");
	}
	
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}
	// Assume sorted array
	public static int[] myRemoveDuplicates(int[] a) {
		long start = System.currentTimeMillis();
		if (a.length<2) {
			return a;
		}
		int i=1;
		int j=0;
		while (i<a.length) {
			if (a[i] == a[j]) {
				// found duplicate
				i++;
			} else {
				j++;
				a[j] = a[i];
				i++;
			}
		}
		int[] noDups = Arrays.copyOf(a, j+1);
		long end = System.currentTimeMillis();
		System.out.println("My Remove duplicate return new array: " + (end-start));		
		return noDups;
	}

	private static List<Integer> toList(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i < a.length; i++) {
			list.add(a[i]);
		}
		HashSet set = new HashSet();
		list.addAll(set);
		return list;
	}

}
