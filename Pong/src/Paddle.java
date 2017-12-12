import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Paddle extends Rectangle{
	
	private AIface bot;
	private int paddleOrientation;
	private final int WIDTH = 15;
	private final int HEIGHT = 125;
	private boolean holdUp = false;
	private boolean holdDown = false;
	
	private final double GRAVITY = .94;
	private int speed = 2;
	private int yVel;
	private int yVelCap = 10;
	
	private long easingStart = 0;
	private long timeLapsed = 0;
	private long interTime = 1000;
	private boolean tweenDebounce = false;
	
	public Paddle(int orientation) {
		this.paddleOrientation = orientation;
		if (paddleOrientation == 1) {
			setBounds(0, Game.HEIGHT/2-HEIGHT/2, WIDTH, HEIGHT);
		} else if (paddleOrientation == 2) {
			setBounds(Game.WIDTH-WIDTH, Game.HEIGHT/2-HEIGHT/2, WIDTH, HEIGHT);
		}
	}
	
	public Paddle(int orientation, AIface bot) {
		this.paddleOrientation = orientation;
		if (paddleOrientation == 1) {
			setBounds(0, Game.HEIGHT/2-HEIGHT/2, WIDTH, HEIGHT);
		} else if (paddleOrientation == 2) {
			setBounds(Game.WIDTH-WIDTH, Game.HEIGHT/2-HEIGHT/2, WIDTH, HEIGHT);
		}
		
		bot.setBall(Game.newGame.getBall());
		bot.setPaddle(this);
		this.bot = bot;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	//idk the fuk im doing ok?
	//quartic easing out
	public int easingStyle(long t, int b, int c, long d) {
		return (int) (c*t/d + b);
	}
	
	public void setEasingStart(boolean reset) {
		if (reset) {
			tweenDebounce = false;
		} else {
			if (!tweenDebounce) {
				tweenDebounce = true;
				easingStart = System.currentTimeMillis();
			}
		}
	}
	
	public void update() {
		if (bot != null) {
			String dir = bot.getDir();
			if (dir.equalsIgnoreCase("up")) {
				holdUp = true;
				holdDown = false;
			} else if (dir.equalsIgnoreCase("down")) {
				holdDown = true;
				holdUp = false;
			} else if (dir.equalsIgnoreCase("null")) {
				holdUp = false;
				holdDown = false;
			}
		}
		// changes yVel
		if (holdUp && holdDown || !holdUp && !holdDown) {
			setEasingStart(false);
			timeLapsed = System.currentTimeMillis() - easingStart;
			if (timeLapsed <= interTime) {
				//System.out.println(easingStylae(timeLapsed, yVel, -yVel, interTime) + ", " + timeLapsed);
				yVel = easingStyle(timeLapsed, yVel, -yVel, interTime);
			} else {
				yVel = 0;
			}
		}
		else if (holdUp && !holdDown) {
			setEasingStart(true);
			yVel -= speed;
		}
		else if (holdDown && !holdUp) {
			setEasingStart(true);
			yVel += speed;
		}
		
		// cap yVel
		if (yVel >= yVelCap)
			yVel = yVelCap;
		else if (yVel <= -yVelCap)
			yVel = -yVelCap;
		
		// applies yVel to vPos;
		if (y + yVel >= 0 && y + HEIGHT + yVel <= Game.HEIGHT)
			y += yVel;
		else if (y + yVel <= 0)
			y = 0;
		else if (y + HEIGHT + yVel >= Game.HEIGHT)
			y = Game.HEIGHT - HEIGHT;
	}

	public void pressed(int keyCode) {
		if (bot == null) {
			if (paddleOrientation == 1) {
				if (keyCode == KeyEvent.VK_W) {
					holdUp = true;
				} else if (keyCode == KeyEvent.VK_S){
					holdDown = true;
				}
			} else if (paddleOrientation == 2){
				if (keyCode == KeyEvent.VK_UP) {
					holdUp = true;
				} else if (keyCode == KeyEvent.VK_DOWN){
					holdDown = true;
				}
			}
		}
	}

	public void released(int keyCode) {
		if (paddleOrientation == 1) {
			if (keyCode == KeyEvent.VK_W) {
				holdUp = false;
			} else if (keyCode == KeyEvent.VK_S){
				holdDown = false;
			}
		} else if (paddleOrientation == 2){
			if (keyCode == KeyEvent.VK_UP) {
				holdUp = false;
			} else if (keyCode == KeyEvent.VK_DOWN){
				holdDown = false;
			}
		}
	}

}
