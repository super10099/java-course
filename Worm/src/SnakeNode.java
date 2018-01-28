import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SnakeNode extends Rectangle{
	
	Point lastLocation;
	SnakeNode next = null;
	
	public SnakeNode(Point pt) {
		setSize(new Dimension(Border.GRID_DIMENSION, Border.GRID_DIMENSION));
		if (pt == null) {
			setLocation(new Point(0,0));
		} else {
			setLocation(pt);
		}
	}
		
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(x+1, y+1, width-2, height-2);
	}
}
