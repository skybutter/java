package sb.interview;

import java.util.List;

public class YpPhoneQuestion {
 
	// Given a List<T> remove duplicates	
	public static <T> List<T> removeDuplicates(List<T> list) {
		return RemoveDuplicates.removeDuplicates1(list);
	}

/*
 * given a string input, reverse
	input: "hello"
	output:  "olleh"
*/
	public String reverse(String s) {
		return ReverseString.reverse1(s);
	}

/*
 * given a string sentence input 
	input: "hello world alan wong"
	output: "wong alan world hello"
 */
	public String reverseWord(String s) {
		return ReverseString.reverseWord1(s);
	}

/*
	real number: 6268637784
	database: 80k numbers 626, 310, 800

	design a system that provides the best matching ctn number
	1. find 626-863
	2. if nothing found, search for 626
	3. if nothing found, search for 800
	4. error

	public class PhoneNumber {
	    private String areaCode;    // 626, 800, etc...
	    private String regionCode;    // 626-863, 626-844
	    private String number;        // 7784, 7287, etc...
	    
	}

	public class PhoneNumberManager {
	// initialize the map somehow from database
	    HashMap<Integer, HashMap<Integer, List<PhoneNumber>) areaMap = new HashMap<>();                    // this map holds the area code as key
	    HaspMap<Integer, List<PhoneNumber>> regionNumberMap = new HashMap<Integer, List<PhoneNumber>();    // this map use the region as key,
	     
	    public PhoneNumber getPhoneNumber(String area, String region, String number) throws NotFoundException {
	        HashMap<Integer, HashMap<Integer, List<PhoneNumber>) map = areaMap.get(area);
	        if (map !=null ) {
	        
	        } else {
	        }
	    }
	}
*/    	 
}
