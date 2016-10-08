package sb.interview;

// http://www.programcreek.com/2014/04/leetcode-remove-element-java/
public class RemoveElement {
	
	public static void main(String[] args) {
		int[] test1 = new int[] {1,2,3,4,5,6};
		int[] test2 = new int[] {2, 7, 7, 4};
		
		System.out.println("test1=" + removeElement(test1, 3));
		System.out.println("test1=" + removeElement(test1, 7));
		System.out.println("test2=" + removeElement(test2, 4));
		System.out.println("test2=" + removeElement(test2, 7));
	}
	
	public static int removeElement(int[] A, int elem) {
	    int i=0;
	    int j=0;
	 
	    while(j < A.length){
	        if(A[j] != elem){
	            A[i] = A[j];
	            i++; 
	        }
	 
	        j++;
	    }
	 
	    return i;
	}
}