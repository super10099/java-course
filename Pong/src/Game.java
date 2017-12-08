
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel implements Runnable, KeyListener{
	
	private Boolean gameIsRunning = false;
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final String TITLENAME = "Tin's Pong";
	private Paddle paddle1 = new Paddle(1);
	private Paddle paddle2 = new Paddle(2);
	private Thread thread;
	
	public void init() {
		gameIsRunning = true;
		JFrame jFrame = new JFrame(TITLENAME);
		
		jFrame.setSize(new Dimension(WIDTH, HEIGHT));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle(TITLENAME);
		jFrame.add(this);
		
		//jpanel (this)
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//threads
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}

		jFrame.setVisible(true);
		jFrame.pack();
		jFrame.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.init();
	}
	
	
	@Override
	public void run() {
		
		int FPS = 60;
		
		long startTime;
		long elapsedTime;
		long targetTime = 1000 / FPS;
		
		while (gameIsRunning) {
			startTime = System.currentTimeMillis();
			paddle1.update();
			paddle2.update();
			repaint();
			elapsedTime = System.currentTimeMillis() - startTime;
			try {
				Thread.sleep(targetTime - elapsedTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		paddle1.pressed(event.getKeyCode());
		paddle2.pressed(event.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		paddle1.released(event.getKeyCode());
		paddle2.released(event.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paddle1.draw(g);
		paddle2.draw(g);
	}

}
