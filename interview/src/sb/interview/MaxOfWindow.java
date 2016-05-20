package sb.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Given an array of integers a[] and a window k={some integer}, write an algorithm to return an array of each of the maximums for all the windows in the array.
 * For example, if your input was [2, 3, 5, 7, 1, 6] and k=3, the output should be [5, 7, 7, 7].
 * Or [2, 5, 6, 8, 4, 1, 9, 13, 23] and k = 4, you would get [8, 8, 8, 9, 13, 23].
 */
public class MaxOfWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = new int[] {2, 3, 5, 7, 1, 6};
		int[] two = new int[] {2, 5, 6, 8, 4, 1, 9, 13, 23};
		List<Integer> oneS = getMaxPerWindow(one, 3);
		System.out.println("output=" + oneS);
		oneS = getMaxPerWindow2(one, 3);
		System.out.println("output2=" + oneS);
		oneS = getMaxPerWindow3(one, 3);
		System.out.println("output3=" + oneS);

		List<Integer> twoS = getMaxPerWindow(two, 4);
		System.out.println("output=" + twoS);
		twoS = getMaxPerWindow2(two, 4);
		System.out.println("output2=" + twoS);
		twoS = getMaxPerWindow3(two, 4);
		System.out.println("output3=" + twoS);

	}

	public static List<Integer> getMaxPerWindow(int[] a, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i < k; i++) {
			list.add(a[i]);
		}
		int max = Collections.max(list);
		result.add(max);
		int i = k;
		while (i < a.length) {
			list.remove(0);
			list.add(a[i]);			
			max = Collections.max(list);
			result.add(max);
			i++;
		}
		return result;
	}
	public static List<Integer> getMaxPerWindow2(int[] a, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		int max = 0;
		int maxIdx = 0;
		for (int i=0; i < k; i++) {
			list.add(a[i]);
			if (a[i]>max) {
				max = a[i];
				maxIdx = i;
			}
		}
		result.add(max);
		int i = k;
		while (i < a.length) {
			list.remove(0);
			list.add(a[i]);
			if (maxIdx == (i-k)) {
				// the one dropping off was the max, need to recalculate from all
				max = Collections.max(list);
			} else if (a[i] > max) {
				max = a[i];
				maxIdx = i;
			}
			result.add(max);
			i++;
		}
		return result;
	}
	public static List<Integer> getMaxPerWindow3(int[] a, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		int max = 0;
		int maxIdx = 0;
		for (int i=0; i < a.length; i++) {
			if (list.size()<k) {
				// list size less than window size, keep adding
				list.add(a[i]);
				if (a[i] > max) {
					max = a[i];
					maxIdx = i;
				}
				if (list.size()==k) {
					result.add(max);
				}
			} else {
				list.remove(0);
				list.add(a[i]);
				if (maxIdx == (i-k)) {
					// the one dropping off was the max, need to recalculate from all
					max = Collections.max(list);
				} else if (a[i] > max) {
					max = a[i];
					maxIdx = i;
				}
				result.add(max);
			}
		}
		return result;
	}
}
