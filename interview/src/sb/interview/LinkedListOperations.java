package sb.interview;

public class LinkedListOperations {

	public static void main(String[] args) {
		findMiddle();
		findLast3rd();
		reverseLinkList();
		reverseLinkListRecursion();
		reverseLinkList1();
		reverseLinkListRecursion1();
	}
	
/**
 * Write code to reverse a linked list, if you able to do it using loops, try to solve with recursion
 * Read more: http://javarevisited.blogspot.com/2016/01/top-20-amazon-and-google-programming-interview-questions.html#ixzz49MFcHrHY
 *  Using a double linkedlist & loop
 */
	private static void reverseLinkList() {
		System.out.println("** Original **");
		Node<Long> first = generateDoubleLinkedList(1,5);
		first = reverseLoop(first);
		System.out.println("** Reversed **");
		printLinkedList(first);
	}
	private static <T> Node<T> reverseLoop(Node<T> first) {
		Node<T> next = null;
		Node<T> last = null;
		Node<T> current = first;
		while (current!=null) {
			// Swap next and prev
			next = current.next;
			current.next = current.prev;
			current.prev = next;
			if (next==null)
				last = current;
			// Move to next element
			current = next;
		}
		return last;
	}
	// Using recursion
	private static void reverseLinkListRecursion() {
		System.out.println("** Original **");
		Node<Long> first = generateDoubleLinkedList(1,5);
		first = reverseRecursive(first);
		System.out.println("** Reversed **");
		printLinkedList(first);
	}
	private static <T> Node<T> reverseRecursive(Node<T> current) {
		Node<T> next = null;
		if (current.next!=null) {
			// not last node, swap
			next = current.next;
			current.next = current.prev;
			current.prev = next;
		} else {
			// last node become new start node
			current.next = current.prev;
			current.prev = null;
			return current;
		}
		return reverseRecursive(next);
	}
	
	/**
	 * Write code to reverse a linked list, if you able to do it using loops, try to solve with recursion
	 * Read more: http://javarevisited.blogspot.com/2016/01/top-20-amazon-and-google-programming-interview-questions.html#ixzz49MFcHrHY
	 *  Using a single linkedlist & loop
	 */
	private static void reverseLinkList1() {
		System.out.println("** Original SingleLinkedList **");
		SingleNode<Long> first = generateSingleLinkedList(1,5);
		first = reverseLoop1(first);
		System.out.println("** Reversed SingleLinkedList **");
		printLinkedList(first);
	}
	private static <T> SingleNode<T> reverseLoop1(SingleNode<T> first) {
		SingleNode<T> next = null;
		SingleNode<T> previous = null;
		SingleNode<T> current = first;
		while (current!=null) {
			// Swap next and prev
			next = current.next;
			current.next = previous;
			// Move to next element
			previous = current;
			current = next;
		}
		return previous;
	}
	// Using recursion
	private static void reverseLinkListRecursion1() {
		System.out.println("** Original SingleLinkedList **");
		SingleNode<Long> first = generateSingleLinkedList(1,5);
		first = reverseRecursive1(first, null);
		System.out.println("** Reversed SingleLinkedList **");
		printLinkedList(first);
	}
	private static <T> SingleNode<T> reverseRecursive1(SingleNode<T> current, SingleNode<T> previous) {
		SingleNode<T> next = null;
		if (current.next!=null) {
			// not last node, swap
			next = current.next;
			current.next = previous;
		} else {
			// last node become new start node
			current.next = previous;
			return current;
		}
		return reverseRecursive1(next, current);
	}

/**
 * ********************************************************************
 * How to find middle element of linked list in one pass?
 * Read more: http://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html#ixzz49M7Aby5r
 * ********************************************************************
 */
	private static void findMiddle() {
		SingleNode<Long> first = generateSingleLinkedList(1,9);
		// Traverse the LinkedList in one pass
		// Use 2 pointers to find the middle
		SingleNode<Long> current = first;
		SingleNode<Long> middle = first;
		int i=1;
		while (current !=null) {
			//if (i%2 == 0) {	// Round up in the middle
			if (i%2 == 0 && current.next!=null) {	// Round down in the middle
				middle = middle.next;
			}
			current = current.next;
			i++;
		}
		System.out.println("middle=" + middle);
	}
/**************************************************************************************
 *	How to find the 3rd element from end, in a singly linked, in a single pass?
 *	Read more: http://javarevisited.blogspot.com/2016/01/top-20-amazon-and-google-programming-interview-questions.html#ixzz49LFP1PYH
 **************************************************************************************	
*/
	private static void findLast3rd() {
		SingleNode<Long> first = generateSingleLinkedList(1,10);
		
		// Traverse the LinkedList in one pass
		// Use 2 pointers to find the 3rd from last
		SingleNode<Long> current = first;
		SingleNode<Long> third = first;
		int i=1;
		while (current !=null) {			
			if (i > 2 && current.next!=null) {
				third = third.next;
			}
			current = current.next;
			i++;
		}
		System.out.println("third=" + third);
	}
	
	public static class Node<T> {
		public Node<T> prev = null;
		public Node<T> next = null;
		public T element = null;

		public Node(Node<T> previous, T element, Node<T> next) {
			this.prev = previous;
			this.next = next;
			this.element = element;
		}
		public String toString() {
			if (element!=null)
				return element.toString();
			else
				return "null";
		}
	}
	
	public static class SingleNode<T> {
		public SingleNode<T> next = null;
		public T element = null;
		
		public SingleNode() {}
		
		public SingleNode(SingleNode<T> next, T element) {
			this.next = next;
			this.element = element;
		}
		public String toString() {
			if (element!=null)
				return element.toString();
			else
				return "null";
		}
	}
	
	// return the first node of the single linked list
	private static <T> SingleNode<T> generateSingleLinkedList(int start, int max) {
		SingleNode<T> first = generateSingleNode(start);
		System.out.print("list=["+ first +", ");
		SingleNode<T> previous = first;
		for (int i=start+1; i <= max; i++) {
			SingleNode<T> current = generateSingleNode(i);
			previous.next = current;
			previous = current;
			System.out.print(current);
			if (i!=max)
				System.out.print(", ");
			else
				System.out.println("]");
		}
		return first;
	}
	private static <T> SingleNode<T> generateSingleNode(int i) {
		//Long n = Math.round(Math.random()*100 + Math.random()*10);
		return new SingleNode(null, new Long(i));
	}
	
	// return the first node of the single linked list
	private static <T> Node<T> generateDoubleLinkedList(int start, int max) {
		Node<T> first = generateNode(start);
		Node<T> previous = first;
		for (int i=start+1; i <= max; i++) {
			Node<T> current = generateNode(i);
			previous.next = current;
			current.prev = previous;
			previous = current;
		}
		printLinkedList(first);
		return first;
	}
	private static <T> Node<T> generateNode(int i) {
		//Long n = Math.round(Math.random()*100 + Math.random()*10);
		return new Node(null, new Long(i), null);
	}
	private static <T> void printLinkedList(Node<T> first) {
		Node<T> current = first;
		System.out.print("list=[");
		while (current != null) {
			System.out.print(current);
			if (current.next!=null) {
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.println("]");
	}
	private static <T> void printLinkedList(SingleNode<T> first) {
		SingleNode<T> current = first;
		System.out.print("list=[");
		while (current != null) {
			System.out.print(current);
			if (current.next!=null) {
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.println("]");
	}
}
