import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SnakeNode extends Rectangle{
	
	
	
	Point lastLocation;
	SnakeNode next = null;
	
	public SnakeNode(Point pt) {
		this.setBounds(0,0, Border.GRID_DIMENSION, Border.GRID_DIMENSION);
		if (pt == null) {
			setLocation(0,0);
		} else {
			setLocation(pt);
		}
	}
		
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)getX(), (int)getY(), width, height);
	}
}
