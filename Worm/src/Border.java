import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class Border extends JPanel implements Runnable{
	
	
	public static final int startingLengthNode = 3;
	public static final Point startingLocation = new Point();
	private final int TARGET_FPS = 60;
	
	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	
	private boolean isRunning = false;

	Thread thread;
	
	
	public Border() {
		setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		init();
		thread = new Thread(this);
		thread.start();
	}
	
	public void init() {
		
	}
	
	public void run() {
		double lastTime = System.nanoTime();
		double currentTime = System.nanoTime();
		double delta = 0;
		
		while (isRunning) {
			lastTime = currentTime;
			currentTime = System.nanoTime();
			delta = (currentTime-lastTime) / (1000000000/TARGET_FPS);
			if (delta >= 0 ) {
				delta--;
				System.out.println("updating");
				update();
			}
			
		render();
		}
	}
	public void update() {
		
	}
	public void render() {
	}
}
