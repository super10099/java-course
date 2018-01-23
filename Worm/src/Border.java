import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Border extends JPanel implements Runnable, KeyListener{
	
	public static final int GRID_DIMENSION = 10;
	public static final int STARTING_LENGTH_NODE = 3;
	public static Point startingLocation;
	private final int TARGET_FPS = 60;
	
	private final int WIDTH = 610;
	private final int HEIGHT = 410;
	
	
	//direction
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	
	
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
		startingLocation = new Point(610/2, 410/2);
		snakeNodes = new SnakeLinkedList();
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
		Point headLocation = snakeNodes.head.getLocation();
		
		if (right) {
			System.out.println("right");
		} else if (left) {
			System.out.println("left");
		} else if (up) {
			System.out.println("up");
		} else if (down) {
			System.out.println("down");
		}
		return newLocation;
	}
	public void render(Point newLocation) {
		snakeNodes.updateSnake(newLocation);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		SnakeNode node = snakeNodes.head;
		do {
			node.draw(g);
		} while ((node = node.next) != null);
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		int keyPressed = keyEvent.getKeyCode();
		System.out.println("");
		if (keyPressed == KeyEvent.VK_D) {
			right = true;
			left = false;
			up = false;
			down = false;
		} else if (keyPressed == KeyEvent.VK_A) {
			right = false;
			left = true;
			up = false;
			down = false;
		} else if (keyPressed == KeyEvent.VK_W) {
			right = false;
			left = false;
			up = true;
			down = false;
		} else if (keyPressed == KeyEvent.VK_S) {
			right = false;
			left = false;
			up = false;
			down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
}
