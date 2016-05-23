package sb.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ReverseString {

	/*
	 * given a string input, reverse
		input: "hello"
		output:  "olleh"
	*/
	// Using char array and loop from end to beginning
	public static String reverse1(String s) {
	    StringBuilder sb = new StringBuilder();
	    char[] chArray = s.toCharArray();
	    for (int i=chArray.length-1; i >= 0; i--) {
	        sb.append(chArray[i]);
	    }
	    return sb.toString();
	}
	// Using StringBuilder reverse method
	public static String reverse2(String s) {
	    StringBuilder sb = new StringBuilder(s);
	    sb = sb.reverse();
	    return sb.toString();
	}

	/*
	 * given a string sentence input 
		input: "hello world alan wong"
		output: "wong alan world hello"
	 */
	// reverseWord1-6 is similar, just different approach to split the word
	//  use StringBuilder to store string
	//  use List, String[] , etc...
	//  space: O(n)
	// reverseWord7 use different approach, reverse in place
	// Using StringTokenizer to split the words
	// Using ArrayList to store the reversed sentence, then loop in descending order
	//  to put in StringBuilder
	// space: O(2n) = O(n) 
	public static String reverseWord1(String s) {
	    String delimiter = " ";
	    StringTokenizer st = new StringTokenizer(s, delimiter);
	    List<String> list = new ArrayList<String>();
	    while (st.hasMoreElements()) {
	        String word = st.nextToken();
	        list.add(word);
	    }
	    StringBuilder sb = new StringBuilder();    
	    for (int i=list.size()-1; i >= 0; i--) {
	        sb.append(list.get(i) + delimiter);
	    }
	    String result = sb.substring(0, sb.length()-1);
	    return result;
	}
	// Inserting word into StringBuilder in the beginning,
	//  no need to use another List/Stack as temp storage
	//  Use less memory than previous method, just one StringBuilder
	//  space: O(n)
	public static String reverseWord2(String s) {
	    String delimiter = " ";
	    StringTokenizer st = new StringTokenizer(s, delimiter);
	    StringBuilder sb = new StringBuilder();    
	    while (st.hasMoreElements()) {
	        String word = st.nextToken();
	        sb.insert(0, word + delimiter);
	    }
	    String result = sb.substring(0, sb.length()-1);
	    return result;
	}
	// Use a ArrayDeque as Stack, javadoc said ArrayDeque is better than Stack
	// space: O(n)
	public static String reverseWord3(String s) {
	    String delimiter = " ";
	    StringTokenizer st = new StringTokenizer(s, delimiter);
	    ArrayDeque<String> stack = new ArrayDeque<String>();
	    while (st.hasMoreElements()) {
	        String word = st.nextToken();
	        stack.push(word);
	    }
	    StringBuilder sb = new StringBuilder();    
	    for (String word: stack) {
	        sb.append(word + delimiter);
	    }
	    String result = sb.substring(0, sb.length()-1);
	    return result;
	}
	// Use String.split() to split words into array
	// Loop over array backwards
	// space: O(n)
	public static String reverseWord4(String s) {
	    String delimiter = " ";
	    String[] words = s.split(delimiter);
	    StringBuilder sb = new StringBuilder();
	    for (int i=words.length-1; i >= 0; i--) {
	    	sb.append(words[i] + delimiter);
	    }
	    return sb.substring(0, sb.length()-1);
	}
	// Using String.indexOf() to split the sentence into words manually
	//  indexOf() is the faster than StringTokenizer and split()
	// Use a LinkedList as Stack
	// space: O(n)
	public static String reverseWord5(String s) {
	    String delimiter = " ";
	    int current = 0;
	    int fromIdx = 0;
	    LinkedList<String> list = new LinkedList<String>();
	    while (current >= 0 && fromIdx < s.length()) {
	    	current = s.indexOf(delimiter, fromIdx);
	    	if (current >= 0) {
	    		String word = s.substring(fromIdx, current);
	    		list.push(word);
	    		fromIdx = current+1;
	    	} else {
	    		// last one
	    		String word = s.substring(fromIdx, s.length());
	    		list.push(word);
	    		fromIdx = s.length();
	    	}
	    }
	    StringBuilder sb = new StringBuilder();    
	    for (String word: list) {
	        sb.append(word + delimiter);
	    }
	    String result = sb.substring(0, sb.length()-1);	    
	    return result;
	}
	// Using Pattern to split the sentence into words
	// space: O(n)
	public static String reverseWord6(String s) {
	    String delimiter = " ";
	    Pattern spaceP = Pattern.compile(delimiter);
	    String[] words = spaceP.split(s);
	    StringBuilder sb = new StringBuilder();
	    for (int i=words.length-1; i >= 0; i--) {
	    	sb.append(words[i] + delimiter);
	    }
	    return sb.substring(0, sb.length()-1);
	}
	
	// Use Reverse array
	// Least memory use
	// space: O(1) if get character array
	// see explanation: http://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
	// Ex: 
	//  input is: The sky is blue
	//  reverse words: ehT yks si blue
	//  Note: last word is not reverse as there is no space at the end
	//  reverse last word: ehT yks si eulb
	//  reverse the entire string: blue is sky The
	public static String reverseWord7(String s) {
		if (s==null || s.length()==0) 
			throw new IllegalArgumentException("Invalid string");
		char[] a = s.toCharArray();
		int space = 0;
		for (int i=0; i < a.length; i++) {
			if (a[i] == ' ') {
				reverse(a, space, i-1);
				space = i+1;
			}
		}
		reverse(a, space, a.length-1);
		reverse(a, 0, a.length-1);
		return String.valueOf(a);
	}
	private static void reverse(char[] a, int start, int end) {
		if (a==null)
			throw new IllegalArgumentException("Invalid array");
		while (start < end) {
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		String sentence = "hello world alan wong";
		String output1 = reverseWord1(sentence);
		String output2 = reverseWord2(sentence);
		String output3 = reverseWord3(sentence);
		String output4 = reverseWord4(sentence);
		String output5 = reverseWord5(sentence);
		String output6 = reverseWord6(sentence);
		String output7 = reverseWord7(sentence);
		System.out.println("reverseWord1=" + output1);
		System.out.println("reverseWord2=" + output2);
		System.out.println("reverseWord3=" + output3);
		System.out.println("reverseWord4=" + output4);
		System.out.println("reverseWord5=" + output5);
		System.out.println("reverseWord6=" + output6);
		System.out.println("reverseWord7=" + output7);
	}
}
