

public class MyLinkedList {
	
	private Node head = null;
	
	public void append(int data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void traverse() {
		if (head == null) {
			System.out.printf("%s", "null");
		} else {
			Node current = head;
			do {
				System.out.printf("%s, ", current.data);
				current = current.next;
			} while (current != null);
			System.out.println();
		}
	}
}
