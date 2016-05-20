package sb.interview;

import java.util.LinkedList;

public class DoubleLinkedList<T> {

	private Node<T> first = null;
	private Node<T> last = null;
	private int size = 0;
	
	public class Node<T> {
		Node<T> previous;
		Node<T> next;
		T element;
		
		Node(Node<T> prev, T e, Node<T> nxt) {
			previous = prev;
			next = nxt;
			element = e;
		}
	}
	
	public void addFirst(T e) {
		if (first==null) {
			Node<T> node = new Node<T>(null, e, null);
			first = node;
			last = node;
		} else {
			Node<T> node = new Node<T>(null, e, first);
			first.previous = node;			
		}
		size++;
	}
	public void addLast(T e) {
		if (last!=null) {
			Node<T> node = new Node<T>(last, e, null);
			last.next = node;
			last = node;
			size++;			
		} else {
			addFirst(e);
		}
	}
	public void add(T e) {
		addLast(e);
	}
	public Node<T> removeFirst() {		
		Node<T> oldFirst = first;
		Node<T> newFirst = first.next;
		first = newFirst;
		first.previous = null;
		size--;
		return oldFirst;
	}
	public Node<T> removeLast() {
		Node<T> newLast = last.previous;
		Node<T> oldLast = last;
		last = newLast;
		last.next = null;
		size--;
		return oldLast;
	}
	public void add(int index, T e) {
		if (isPositionIndex(index)) {
			Node<T> node = getNode(index);
			addBefore(node, e);
		}
	}
	private void addBefore(Node<T> node, T e) {
		Node<T> newNode = new Node<T>(node.previous, e, node);
		Node<T> prevNode = node.previous;
        if (prevNode == null)
            first = newNode;
        else {
        	prevNode.next = newNode;
        }
		size++;
	}
	
	private Node<T> getNode(int idx) {
		Node<T> node = null;
		if (isPositionIndex(idx)) {
			node = first;
			for (int i=0; i < idx; i++) {
				node = node.next;
			}
		}
		return node;
	}
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> current = first;
 		while (current!=null) {
 			sb.append(current.element);
 			sb.append(",");
 			current = current.next;
 		}
 		String temp = sb.substring(0, sb.length()-1);
		return "size=" + size + ":" + temp + "]";
	}
}
