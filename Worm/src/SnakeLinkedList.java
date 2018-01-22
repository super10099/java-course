
public class SnakeLinkedList {
	
	SnakeNode head;
	SnakeNode end;
	
	public SnakeLinkedList() {
		head = new SnakeNode(Border.startingLocation);
		end = head;
		for (int i=0; i>Border.startingLengthNode; i++) {
			SnakeNode newHead = new SnakeNode(null);
			
		}
	}
	
	public void append(SnakeNode node) {
		end.next = node;
		end = node;
	}
}
