import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class SnakeNode extends Rectangle{
	Point location;
	SnakeNode next = null;
	
	public SnakeNode(Point pt) {
		location = pt;
	}
	
	public void setLocation() {
		
	}
	
	public void paintComponent(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
}
