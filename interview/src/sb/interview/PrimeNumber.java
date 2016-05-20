package sb.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author alan
 *
 */
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 40;
		List<Integer> output1 = generatePrime1(max);
		System.out.println("generatePrime1=" + output1);
		List<Integer> output2 = generatePrime2(max);
		System.out.println("generatePrime2=" + output2);
	}
	
	// Get all the prime numbers up to the max
	private static List<Integer> generatePrime1(int max) {
		List<Integer> primeList = new ArrayList<Integer>(max);
		if (max < 2) {
			return Collections.emptyList();
		} else {
			primeList.add(2);
		}
		for (int i=2; i <= max; i++) {
			if (isPrime1(i)) {
				primeList.add(i);
			}
		}
		return primeList;
	}
	private static boolean isPrime1(int n) {
		boolean result = true;
		if (n%2==0) {
			return false;
		}
		// shortcut 1 - only need to check up to sqrt(n)
		int max = (int) Math.sqrt(n);
		// skip even number
		for (int i=3; i <= max; i+=2 ) {
			if (n%i==0) {
				result = false;
				break;
			}
		}
		return result;
	}
    /**
     * 
     * @param upperLimit
     * @return a list of prime numbers from 2 to upperLimit inclusive
     * @throws IllegalArgumentException if upperLimit is less than 0 
     */
    public static List<Integer> generatePrime2(int upperLimit) {

        if(upperLimit < 0) 
            throw new IllegalArgumentException("Negative size");

        // at first all are numbers (0<=i<=n) not composite
        boolean[] isComposite = new boolean[upperLimit + 1]; 
        for (int i = 2; i * i <= upperLimit; i++) {
            if (!isComposite [i]) {
                // populate all multiples as composite numbers
                for (int j = i; i * j <= upperLimit; j++) {
                    isComposite [i*j] = true;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        // make a list of all non-composite numbers(prime numbers)
        int arrLength = isComposite.length;
        for(int index = 2; index < arrLength; index++) {
            if(!isComposite[index]) {
                primeList.add(new Integer(index));
            }
        }
        return primeList;
    }	
	// shortcut 1 - only need to check up to sqrt(n)
	// shortcut 2 - only need to check if divisible by the prime numbers < number
}
