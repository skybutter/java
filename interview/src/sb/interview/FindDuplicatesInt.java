package sb.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrate the code to find duplicate in an array of integer.
 * The array can be unsorted.
 * 
 * 
 * @author alan
 *
 */
public class FindDuplicatesInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 5;
		int[] array = generateArrayWithTwoDups(max);
		List<Integer> dups = findRepeating1(array, max);		
		System.out.println(" Repeating elements 1 are " + dups);
		dups = findRepeating2(array, max);
		System.out.println(" Repeating elements 2 are " + dups);
		dups = findRepeating3(array, max);
		System.out.println(" Repeating elements 3 are " + dups);
	}

	private static int[] generateArrayWithTwoDups(int max) {
		int[] array = new int[]{4, 2, 4, 5, 2, 3, 1};
		return array;
	}
	
	// Two loop Bubble sort approach
	// Optimize of memory usage
	// in the expense of speed/time - O(n^2)
	// Array can be unsorted
	// Not using the max number of sequence
	private static List<Integer> findRepeating1(int arr[], int size) {
		List<Integer> dups = new ArrayList<Integer>();
		  int i, j;
		  for(i = 0; i < arr.length; i++)
		    for(j = i+1; j < arr.length; j++)
		      if(arr[i] == arr[j])
		        dups.add(arr[i]);
		  return dups;
	}
	// Counter approach
	// Optimize of Speed O(n)
	// Array can be unsorted
	// in the expense of memory usage, extra array to keep count
	// we could replace count[] with a HashMap
	private static List<Integer> findRepeating2(int[] arr, int max) {
		List<Integer> dups = new ArrayList<Integer>();
		int[] count = new int[max+1];
		for (int i=0; i < arr.length; i++) {
			if ( count[arr[i]]==1 )
				dups.add(arr[i]);
			count[arr[i]]++;
		}
		return dups;
	}
	
	// Specific Case: 
	//  The number in the array is in a sequence like 1,2,3,4, etc...
	//  Array can be unsorted.
	// Two numbers are repeated.  Find the two repeated numbers in the sequence.
	// Using two equations to solve it
	// x+y = SumOfArray - SumOfSequence
	// x * y = ProductOfArray / n!
	// x - y = sqrt((x+y)^2 – 4*xy)
	// Optimize of memory and speed, but very specific to this scenario.	
	private static List<Integer> findRepeating3(int[] arr, int max) {
		  int S = 0;  /* S is for sum of elements in arr[] */
		  int P = 1;  /* P is for product of elements in arr[] */ 
		  int x,  y;   /* x and y are two repeating elements */
		  int D;      /* D is for difference of x and y, i.e., x-y*/
		  int n = max;
		
		  for(int i = 0; i < arr.length; i++) {
		    S = S + arr[i];
		    P = P*arr[i];
		  }
		  S = S - n*(n+1)/2;  /* S is x + y now */
		  P = P/fact(n);         /* P is x*y now */
		   
		  D = (int) Math.sqrt(S*S - 4*P); /* D is x - y now */
		   
		  x = (D + S)/2;
		  y = (S - D)/2;
		  
		List<Integer> dups = new ArrayList<Integer>();
		dups.add(x);
		dups.add(y);
		return dups;
	}
	private static int fact(int n) {
	   return (n == 0)? 1 : n*fact(n-1);
	} 

}
