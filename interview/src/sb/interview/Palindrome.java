package sb.interview;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 1234321;
		int output1 = reverse1(number);
		int output2 = reverse2(number);
		System.out.println("reverse1=" + output1);
		System.out.println("reverse2=" + output2);
		int[] numbers = new int[]{121, 1, 10, 323, 456, 23, 99, 555, 679};
		
		for (int i=0; i < numbers.length; i++) {
			System.out.println("isPalindrome1(" + numbers[i] + ")=" + isPalindrome1(numbers[i]));			
		}
		for (int i=0; i < numbers.length; i++) {
			System.out.println("isPalindrome2(" + numbers[i] + ")=" + isPalindrome1(numbers[i]));			
		}
	}

	public static boolean isPalindrome1(int number) {
		return (number == reverse1(number));
	}
	public static int reverse1(int original) {
		int reversed = 0;
		int remainder = 0;
		int current = original; 
		while (current>0) {
			remainder = current % 10;
			reversed = reversed*10 + remainder;
			current = current / 10;
			if (current < 1)
				break;
		}
		return reversed;
	}
	
	public static boolean isPalindrome2(int number) {
		return (number == reverse2(number));
	}
	public static int reverse2(int original) {
		StringBuilder sb = new StringBuilder(String.valueOf(original));
		sb = sb.reverse();
		int reversed = Integer.valueOf(sb.toString());
		return reversed;
	}
}
