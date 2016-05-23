package sb.interview;

import java.util.LinkedList;
import java.util.List;

public class RotateArray {

	/**
	 * Rotate Array of size n by K
	 * 
	 * Given array: 1,2,3,4,5,6
	 * Rotate by 2 yield: 3,4,5,6,1,2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int rotateBy = 3;
		int[] array = generateRandomArray(10);
		System.out.print("original: ");
		printArray(array);
		System.out.print("rotated: ");
		int[] result = rotateUseLinkListStack(array, rotateBy);
		printArray(result);
		System.out.print("original: ");
		printArray(array);
		System.out.print("rotated 2: ");
		int[] result2 = rotateUseArray(array, rotateBy);
		printArray(result2);
		System.out.print("original: ");
		printArray(array);
		System.out.print("rotated 3: ");
		int[] result3 = rotateOneByOne(array, rotateBy);
		printArray(result3);
		System.out.print("original: ");
		printArray(array);
		System.out.print("rotated 4: ");
		int[] result4 = rotateKtime(array, rotateBy);
		printArray(result4);
		System.out.print("original: ");
		printArray(array);
		System.out.print("rotated 5: ");
		int[] result5 = rotateUseReversal(array, rotateBy);
		printArray(result5);		
	}

	// Rotate the array by k element using a LinkedList
	//  Original array not modified
	private static int[] rotateUseLinkListStack(int[] array, int k) {
		if (array==null)
			throw new IllegalArgumentException("Invalid array");
		if (array.length <= k) {
			// array size less than rotate size, no rotation
			return array;
		}
		LinkedList<Integer> list = convertArrayToList(array);
		for (int i=0; i < k; i++) {
			Integer item = list.pop();
			list.addLast(item);
		}
		int[] result = convertListToArray(list);
		return result;
	}
	// Rotate the array by k element using temp array
	//  Original array modified
	//  space: O(k)
	//  time:  O(n)
	private static int[] rotateUseArray(int[] array, int k) {
		if (array==null || k > array.length)
			throw new IllegalArgumentException("Invalid array or k");
		int[] temp = new int[k];
		for (int i=0; i < k; i++) {
			temp[i] = array[i];
		}
		// shift the array by k
		for (int i=0; i < array.length-k; i++) {
			array[i] = array[i+k];
		}
		// append the temp to array
		int l = array.length - k;
		for (int i=0; i < temp.length; i++) {
			array[l+i] = temp[i];
		}
		return array;
	}
	// Rotate the array by k element in place
	//  Original array is modified.
	//  Shift the element one by one, over k times.  
	//  Like Bubble Sort
	//  Not very efficient in speed.
	//  Use less memory
	//  space : O(1)
	//  time : O(n*k)
	private static int[] rotateOneByOne(int[] array, int k) {
		if (array==null || k > array.length)
			throw new IllegalArgumentException("Invalid array or k");
		for (int j=0; j < k; j++) {
			int temp = array[0];
			for (int i=0; i < array.length-1; i++) {
				array[i] = array[i+1];
			}
			array[array.length-1]=temp;
		}
		return array;
	}
	// Rotate the array by k element in place
	//  Original array is modified.
	//  Divide the array in groups.  Each group has k elements.
	//  Shift the element by k
	// Juggling algorithm.
	// see explanation at http://www.geeksforgeeks.org/array-rotation/
	private static int[] rotateKtime(int[] array, int k) {
		if (array==null || k > array.length)
			throw new IllegalArgumentException("Invalid array or k");
		int last = array[array.length-1];
		for (int i=k-1; i >= 0; i--) {
			int temp = array[i];
			for (int j=i; (j+k) < array.length; j+=k) {
				array[j] = array[j+k];
			}
			int l = array.length - k + i;
			array[l] = temp;
		}
		array[array.length-k-1] = last;
		return array;
	}
	// Rotate the array by k element in place using Reversal
	//  Original array is modified.
	//  Divide the array into two group.
	//  One group is the size of k (start from the 0).
	//  The other group is the rest of the array.
	//  Ex: k=2
	//     array: {1,2,3,4,5,6]
	//     group 1: {1,2}
	//     group 2: {3,4,5,6}
	//     Reverse them: {6,5,4,3} and {2,1}
	//     Put them together: {2,1,6,5,4,3}
	//		Reverse the array: {3,4,5,6,1,2}
	//  Implementation is somewhat simple.
	//  space: O(1)
	//  time: O(n)
	// See http://www.programcreek.com/2015/03/rotate-array-in-java/
	private static int[] rotateUseReversal(int[] array, int k) {
		if (array==null || k > array.length)
			throw new IllegalArgumentException("Invalid array or k");
		// Reverse for first group of k elements in the front
		reverse(array, 0, k-1);
		reverse(array, k, array.length-1);
		reverse(array, 0, array.length-1);
		return array;
	}
	// This method is used by the above method to reverse the array
	private static int[] reverse(int[] a, int start, int end) {
		if (a==null)
			throw new IllegalArgumentException("Invalid array");
		int left = start;
		int right = end;
		while (left < right) {
			int temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			left++;
			right--;
		}
		return a;
	}
	
	private static LinkedList<Integer> convertArrayToList(int[] array) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
	private static int[] convertListToArray(List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i=0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	private static int[] generateRandomArray(int size) {
		int[] result = new int[size];
		for (int i=0; i < size; i++) {
			result[i] = (int) (Math.random()*10);
		}
		return result;
	}
	private static void printArray(int[] array) {
		System.out.print("[");
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i!= array.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
}
