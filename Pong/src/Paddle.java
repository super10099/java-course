import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Paddle extends JPanel{

	private int paddleOrientation;
	private final int WIDTH = 50;
	private final int HEIGHT = 200;
	
	public Paddle(int orientation) {
		this.paddleOrientation = orientation;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		if (paddleOrientation == 1) {
			g.fillRect(0, getHeight()/2-HEIGHT/2, WIDTH, HEIGHT);
		} else if (paddleOrientation == 2) {
			g.fillRect(getWidth()-WIDTH, getHeight()/2-HEIGHT/2, WIDTH, HEIGHT);
		}
	}

	public void pressed(int keyCode) {
		if (paddleOrientation == 1) {
			if (keyCode == KeyEvent.VK_A) {
				System.out.println("a");
			} else if (keyCode == KeyEvent.VK_D){
				System.out.println("d");
			}
		} else if (paddleOrientation == 2){
			if (keyCode == KeyEvent.VK_LEFT) {
				System.out.println("l");
			} else if (keyCode == KeyEvent.VK_RIGHT){
				System.out.println("r");
			}
		}
	}

	public void released(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
