import java.awt.Point;

public class SnakeLinkedList {
	
	Point currentPoint;
	SnakeNode head = null;
	SnakeNode next = null;
	
	public SnakeLinkedList() {
		head = new SnakeNode(Border.startingLocation);
		next = head;
		for (int i=0; i<Border.STARTING_LENGTH_NODE; i++) {
			
			SnakeNode newHead = new SnakeNode(new Point(305,205));
			System.out.println(newHead.getLocation());
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
		node.lastLocation = node.getLocation();
		node.setLocation(newHeadLocation);
		while ((node = node.next) != null) {
			node.lastLocation = node.getLocation();
			node.setLocation(prevNode.lastLocation);
			prevNode = node;
		}
	}
	
	
}
