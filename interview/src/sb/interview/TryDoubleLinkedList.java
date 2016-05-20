package sb.interview;

public class TryDoubleLinkedList {

	public static void main(String[] args) {
		tryDoubleLinkedList();
	}

	public static void tryDoubleLinkedList() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		for (int i=0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		for (int i=0; i < 2; i++) {
			list.removeLast();
		}
		System.out.println(list);
		for (int i=0; i < 2; i++) {
			list.removeFirst();
		}
		System.out.println(list);
		list.add(2, 99);
		System.out.println(list);
	}
}
