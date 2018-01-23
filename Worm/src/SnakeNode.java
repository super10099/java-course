import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SnakeNode extends Rectangle{
	
	
	
	Point currentLocation;
	Point lastLocation;
	SnakeNode next = null;
	
	public SnakeNode(Point pt) {
		this.setBounds(0,0, Border.GRID_DIMENSION, Border.GRID_DIMENSION);
		currentLocation = pt;
	}
	
	public void setLocation() {
		
	}
}
