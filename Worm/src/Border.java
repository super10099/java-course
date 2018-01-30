import java.awt.Color;

import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Border extends JPanel implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HIT_NULL = -1;
	private static final int HIT_SNAKE = 0;
	private static final int HIT_APPLE = 1;
	
	public static final int GRID_DIMENSION = 10;
	public static final int STARTING_LENGTH_NODE = 0;
	public static Point startingLocation;
	private final int TARGET_FPS = 25;
	
	private final int WIDTH = 610;
	private final int HEIGHT = 410;
	
	
	//direction
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	private boolean moving = false;
	private boolean keyCanRegister = false; // prevents player from glitching the game and moving the opposite direction until it has been updated.
	// makes sure that you can only press key once until the next update();
	@SuppressWarnings("unused")
	private int points = 0; // snake score
	
	private Apple currentApple = null;
	
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
		startingLocation = new Point(((int)(WIDTH/2/10))*10, ((int)(HEIGHT/2/10))*10);
		System.out.println(this.getSize());
		snakeNodes = new SnakeLinkedList();
	}
	
	public void run() {
		isRunning = true;
		
		double fpsTimer = System.currentTimeMillis();
		double lastTime = System.nanoTime();
		double currentTime = System.nanoTime();
		double delta = 0D;
		while (isRunning) {
			lastTime = currentTime;
			currentTime = System.nanoTime();
			delta += (currentTime-lastTime) / (1000000000/TARGET_FPS);
			if (delta >= 0 ) {
				delta--;
				render(update());
			}
			
			if (System.currentTimeMillis() - fpsTimer >= 1000) {
				fpsTimer += 1000;
			}
		}
	}
	public Point update() {
		
		// check if apple eaten
		if (currentApple == null) {
			Random rn = new Random();
			currentApple = new Apple(new Point(((int)(rn.nextInt(WIDTH)/10))*10, ((int)(rn.nextInt(HEIGHT)/10))*10));
		}
		
		// hit detection
		if (moving) {
			if (hitDetection() == Border.HIT_APPLE) {
				snakeNodes.append(new SnakeNode(null));
				currentApple = null;
			} else if (hitDetection() == Border.HIT_SNAKE) {
				isRunning = false;
			}
		}
		
		Point newLocation = snakeNodes.head.getLocation();
		if (isRunning) {
			if (right) {
				newLocation.translate(Border.GRID_DIMENSION, 0);
			} else if (left) {
				newLocation.translate(-Border.GRID_DIMENSION, 0);
			} else if (up) {
				newLocation.translate(0, -Border.GRID_DIMENSION);
			} else if (down) {
				newLocation.translate(0, Border.GRID_DIMENSION);
			} 
			int x = newLocation.x;
			int y = newLocation.y;
			if (x>=WIDTH) {
				x = 0;
			} else if (x < 0) {
				x = WIDTH-Border.GRID_DIMENSION;
			}
			if (y >= HEIGHT) {
				y = 0;
			} else if (y < 0) {
				y = HEIGHT-Border.GRID_DIMENSION;
			}
			newLocation.setLocation(x, y);
			return newLocation;
		}
		
		return newLocation; // returns unupdated location because game stopped // hit detection
	}
	public void render(Point newLocation) {
		snakeNodes.updateSnake(newLocation);
		repaint();
		keyCanRegister = true;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		SnakeNode node = snakeNodes.head;
		do {
			node.draw(g);
		} while ((node = node.next) != null);
		if (currentApple != null)
			currentApple.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		int keyPressed = keyEvent.getKeyCode();
		if (keyCanRegister) {
			if (keyPressed == KeyEvent.VK_D && left != true) {
				right = true;
				left = false;
				up = false;
				down = false;
				keyCanRegister = false;
				moving = true;
			} else if (keyPressed == KeyEvent.VK_A && right != true) {
				right = false;
				left = true;
				up = false;
				down = false;
				keyCanRegister = false;
				moving = true;
			} else if (keyPressed == KeyEvent.VK_W && down != true) {
				right = false;
				left = false;
				up = true;
				down = false;
				keyCanRegister = false;
				moving = true;
			} else if (keyPressed == KeyEvent.VK_S && up != true) {
				right = false;
				left = false;
				up = false;
				down = true;
				keyCanRegister = false;
				moving = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public int hitDetection() {
		SnakeNode snakeHead = snakeNodes.head;
		if (snakeHead.getLocation().equals(currentApple.getLocation())) {
			return Border.HIT_APPLE;
		}	
		// detects if hit snake itself
		boolean hitSnake = false;
		SnakeNode currentNode = snakeHead;
		while ((currentNode = currentNode.next) != null) {
			if (snakeHead.getLocation().equals(currentNode.getLocation())) {
				hitSnake = true;
			}
		}
		
		if (hitSnake) {
			return Border.HIT_SNAKE;
		}
		
		return Border.HIT_NULL;
	}
		
	
	
}
