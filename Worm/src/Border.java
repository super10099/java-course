import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class Border extends JPanel implements Runnable{
	
	public static final int GRID_DIMENSION = 10;
	public static final int STARTING_LENGTH_NODE = 3;
	public static Point startingLocation;
	private final int TARGET_FPS = 60;
	
	private final int WIDTH = 610;
	private final int HEIGHT = 410;
	
	
	
	private SnakeLinkedList snakeNodes;
	
	private boolean isRunning = false;

	Thread thread;
	
	
	
	public Border() {
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		init();
		thread = new Thread(this);
		thread.start();
	}
	
	public void init() {
		snakeNodes = new SnakeLinkedList();
		startingLocation = new Point(610/2, 410/2);
	}
	
	public void run() {
		isRunning = true;
		
		double fpsTimer = System.currentTimeMillis();
		double lastTime = System.nanoTime();
		double currentTime = System.nanoTime();
		double delta = 0D;
		int fps = 0;
		
		while (isRunning) {
			lastTime = currentTime;
			currentTime = System.nanoTime();
			delta += (currentTime-lastTime) / (1000000000/TARGET_FPS);
			if (delta >= 0 ) {
				delta--;
				render(update());
				fps++;
			}
			
			if (System.currentTimeMillis() - fpsTimer >= 1000) {
				fpsTimer += 1000;
				System.out.println("FPS: " + fps);
				fps = 0;
			}
		}
	}
	public Point update() {
		Point newLocation = new Point();
		return newLocation;
	}
	public void render(Point newLocation) {
		snakeNodes.updateSnake(newLocation);
	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}
	
	
}
