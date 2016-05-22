package sb.interview;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = generateRandomArray(10);
		System.out.print("original: ");
		printArray(array);
		System.out.print("sorted: ");
		sort(array);
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
		System.out.print("[");
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i!= array.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
	// Bubble Sort the array in place
	private static void sort(int[] array) {
		for (int i=0; i < array.length; i++) {
			for (int j=i; j < array.length; j++) {
				if (array[i] > array[j]) {
					// swap the elements
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
