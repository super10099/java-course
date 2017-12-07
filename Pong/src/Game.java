
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame implements Runnable, KeyListener{
	
	private Boolean gameIsRunning = false;
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final String TITLENAME = "Tin's Pong";
	private Paddle paddle1 = new Paddle(1);
	private Paddle paddle2 = new Paddle(2);
	
	public void init() {
		gameIsRunning = true;
		JFrame jFrame = this;
		JPanel jPanel = new JPanel();
		
		jFrame.setSize(new Dimension(WIDTH, HEIGHT));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle(TITLENAME);
		jFrame.add(jPanel);
		jPanel.setBackground(Color.BLACK);
		
		//paddles
		jPanel.setLayout(new BorderLayout());
		jPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		jPanel.add(paddle2, BorderLayout.WEST);
		jPanel.add(paddle1, BorderLayout.EAST);

		jFrame.setVisible(true);
		jFrame.pack();
		super.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.init();
	}
	
	@Override
	public void run() {
		while (gameIsRunning) {
			update();
			render();
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		System.out.println('1');
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

}
