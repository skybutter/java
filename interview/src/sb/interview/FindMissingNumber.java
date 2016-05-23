package sb.interview;

public class FindMissingNumber {
/*
 * Find Missing Number in a Sorted Array of integers.
 * First element should be 0.
 * Second element should be 1.
 * 
 * Note: Adding all numbers and compare the sum does not work, because missing 0 will have the same sum.
 * In addition, you still need to loop over the entire array 1 time + 1 time for no missing numbers to calculate the two sum.
 * 
 * Using Binary Search is faster than linear search.
 * 
 * You can loop over the array and find the first index != a[index].  Efficiency is O(n)
 * Binary search only need to search half of it.  Efficiency O(log n)
 * see explanation: http://java67.blogspot.com/2014/12/how-to-find-missing-number-in-sorted.html
 */
	public static void main(String[] args) {
		int[] a = getSortedArray();
		int missing = findMissingNumber(a);
		printArray(a);
		System.out.println("missing=" + missing);
	}

	private static int[] getSortedArray() {
		int[] a = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12};
		return a;
	}
	
	private static int findMissingNumber(int[] a) {
		if (a==null || a.length<1) {
			throw new IllegalArgumentException("Invalid array");
		}
		int low = 0;
		int high = a.length-1;
		while (low < high) {
			int mid = (low + high)/2;	// (low+high) >> 1 has the same effect (shift bits)
			if (mid == a[mid]) {
				// Missing number is larger than current middle
				// Only need to search the upper segment
				low = mid+1;				
			} else {
				// Missing number is less than current middle
				if (mid==0 || (a[mid-1]==(mid-1))) {
					// check the previous element to see if this is the first element that !=
					// yes, first element, found missing number
					return mid;
				}
				// Only need to search the lower segment
				high = mid;
			}
		}
		throw new RuntimeException("No missing number");
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
