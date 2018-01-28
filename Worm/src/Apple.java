import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Apple extends Rectangle{
	
	public Apple(Point pt) {
		setLocation(pt);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, Border.GRID_DIMENSION, Border.GRID_DIMENSION);
	}
}
