import java.awt.Point;

public class SnakeLinkedList {
	
	Point currentPoint;
	SnakeNode head = null;
	SnakeNode next = null;
	
	public SnakeLinkedList() {
		head = new SnakeNode(Border.startingLocation);
		next = head;
		for (int i=0; i>Border.STARTING_LENGTH_NODE; i++) {
			SnakeNode newHead = new SnakeNode(null);
			append(newHead);
		}
	}
	
	public void append(SnakeNode node) {
		next.next = node;
		next = node;
	}
	
	public void updateSnake(Point newHeadLocation) {
		SnakeNode node = head;
		SnakeNode prevNode = head;
		node.lastLocation = node.currentLocation;
		node.currentLocation = newHeadLocation;
		while ((node = node.next) != null) {
			node.lastLocation = node.currentLocation;
			node.currentLocation = prevNode.lastLocation;
			prevNode = node;
		}
	}
}
