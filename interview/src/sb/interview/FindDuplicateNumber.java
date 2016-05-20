package sb.interview;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = generateDuplicateArray(4);
		findDuplicateOfSequence(list, 4);
	}
	
	private static Integer[] generateDuplicateArray(int size) {
		// Only one duplicate in array
		List<Integer> list = new ArrayList<Integer>(size+1);
		for (int i=1; i <= size; i++) {
			list.add(i);			
		}
		list.add(size/2, size/2);
		System.out.println(list);
		return list.toArray(new Integer[0]);
	}
	private static int getSumOfSequence(int n) {
		int total = 0;
		total = n * (n+1) / 2;
		return total;
	}
	private static int getSumOfArray(Integer[] a) {
		int total = 0;
		for (int i=0; i < a.length; i++) {
			total = total + a[i];
		}
		return total;
	}

	private int[] generateIntArray(int size) {
		int[] a = new int[size];
		for (int i=0; i < size; i++) {
			a[i] = i+1;
		}
		return a;
	}
	
	private static void findDuplicateOfSequence(Integer[] a, int max) {
		int totalOfSeq = getSumOfSequence(max);
		int totalOfArray = getSumOfArray(a);
		int duplicate = totalOfArray - totalOfSeq;
		System.out.println("SumOfSequence=" + totalOfSeq);
		System.out.println("SumOfArray=" + totalOfArray);
		System.out.println("duplicate=" + duplicate);
	}
}
