
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel implements Runnable, KeyListener{
	
	public static Game newGame;
	
	private JFrame jFrame;
	
	private Boolean gameIsRunning = false;
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final String TITLENAME = "Tin's Pong";
	
	private int score1;
	private int score2;
	private Paddle paddle1;
	private Paddle paddle2;
	private Ball ball;
	private Thread thread;
	private Thread renderer;
	private boolean begin = false;
	
	public void init() {
		gameIsRunning = true;
		begin = false;
		
		//jpanel (this)
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		//game Objects
		ball = new Ball();
		paddle1 = new Paddle(1);
		paddle2 = new Paddle(2, new Botv1());
		ball.setRandomMotion();
		
		//threads
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
			renderer = new Thread(new Runnable() {

				@Override
				public void run() {
					repaint();
				}
				
			});
		}
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.addKeyListener(this);
		jFrame.repaint();
	}
	
	public static void main(String[] args) {
		newGame = new Game();
		
		newGame.jFrame = new JFrame(TITLENAME);
		newGame.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame.jFrame.setTitle(TITLENAME);
		newGame.jFrame.add(newGame);
		newGame.init();
	}
	
	
	@Override
	public void run() {
		
		int FPS = 60;
		
		long startTime;
		long elapsedTime = 0;
		long targetTime = 1000 / FPS;
		
		while (gameIsRunning) {
			
			if (begin) {
				startTime = System.currentTimeMillis();
				paddle1.update();
				paddle2.update();
				ball.update(paddle1, paddle2);
				repaint();
				elapsedTime = System.currentTimeMillis() - startTime;
				try {
					Thread.sleep(targetTime - elapsedTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (ball.touchedSides) {
					gameIsRunning = false;
					init();
				}
			} else {
				try {
					Thread.sleep(targetTime - elapsedTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setScore(int side) {
		if (side == 1) {
			score1++;
		} else {
			score2++;
		}
	}
	
	public Ball getBall() {
		return ball;
	}
	@Override
	public void keyPressed(KeyEvent event) {
		if (begin == false) {
			begin = true;
		}
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
		ball.draw(g);
		
		//redraw score
		String scoreDisplay = score1+" : "+score2;
		int width = g.getFontMetrics().stringWidth(scoreDisplay);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		g.drawString(scoreDisplay, WIDTH/2-width/2, 20);
	}

	public Paddle getPaddle(int i) {
		if (i == 1) {
			return paddle1;
		} else if (i==2) {
			return paddle2;
		}
		return null;
	}

}
