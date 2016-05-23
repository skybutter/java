package sb.interview;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * 
 * Use a map to store the mapping of character from s1 to s2.
 * @author alan
 *
 * see http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 */
public class IsomorphicString {

	public static void main(String[] args) {
		String s1, s2 = null;
		s1 = "foo";
		s2 = "bar";		
		System.out.println(s1 + " " + s2 + " isIsomorphic=" + isIsomorphic(s1,s2));
		s1 = "add";
		s2 = "egg";		
		System.out.println(s1 + " " + s2 + " isIsomorphic=" + isIsomorphic(s1,s2));
		s1 = "bat";
		s2 = "cat";		
		System.out.println(s1 + " " + s2 + " isIsomorphic=" + isIsomorphic(s1,s2));
	}
	
	public static boolean isIsomorphic(String s1, String s2) {		
		boolean result = true;
	    if(s1==null||s2==null)
	        return false;
	    if(s1.length()!=s2.length())
	        return false;		
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		HashMap<Character, Character> map = new HashMap<>();		
		for (int i=0; i < c1.length; i++) {
			if (map.get(c1[i])!=null) {
				if (c2[i]==map.get(c1[i])) {
					continue;
				} else {
					result = false;
					break;
				}
			} else {
				if (map.get(c2[i])==null)
					map.put(c1[i], c2[i]);
				else if (map.get(c2[i])!=c1[i]) {
					result = false;
					break;
				}				
			}
		}
		return result;
	}

}
