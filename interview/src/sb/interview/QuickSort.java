package sb.interview;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = generateRandomArray(10);
		System.out.print("original: ");
		printArray(array);
		System.out.print("sorted: ");
		quicksort(array, 0, array.length-1);
		printArray(array);
	}
	private static int[] generateRandomArray(int size) {
		int[] result = new int[size];
		for (int i=0; i < size; i++) {
			result[i] = (int) (Math.random()*10);
		}
		return result;
	}
	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void quicksort(int[] arr, int low, int high) {
		if (arr==null || arr.length==0)
			return;
		if (low >= high)
			return;
		
		int mid = low + (high-low)/2;
		int pivot = arr[mid];
		int i=low;
		int j=high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i<=j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quicksort(arr, low, j);
		if (high > i)
			quicksort(arr, i, high);
	}
	
	public static void swap(int[] arr, int low, int high) {
		int temp =arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
