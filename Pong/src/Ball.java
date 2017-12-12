import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

//hmm

public class Ball extends java.awt.geom.Ellipse2D{
	
	public boolean touchedSides = false;
	
	private int width = 30;
	private int height = 30;
	
	private int xPos = Game.WIDTH/2-width/2;
	private int yPos = Game.HEIGHT/2-height/2;
	
	private double xSpeed = 5;
	private double ySpeed = 2;
	
	private double xAccel = 0;
	private double yAccel = 8;
	
	private double xVel;
	private double yVel;
	
	public void setRandomMotion() {
		Random random = new Random();
		
		//xVel
		if (random.nextBoolean()) {
			xVel = -1;
		} else {
			xVel = 1;
		}
		//yVel
		if (random.nextBoolean()) {
			yVel = -1;
		} else {
			yVel = 1;
		}
	}
	
	@SuppressWarnings("unused")
	public void update(Paddle paddle1, Paddle paddle2) {
		
		// sides hit Detection
			if (xPos <= 0) {
				xVel *= -1;
				touchedSides = true;
				Game.newGame.setScore(2);
			}
			if (xPos+width >= Game.WIDTH) {
				xVel *= -1;
				touchedSides = true;
				Game.newGame.setScore(1);
			}
			if (yPos <= 0) {
				yVel *= -1;
			}
			if (yPos+height >= Game.HEIGHT) {
				yVel *= -1;
			}
		
		
		// paddle hit Detection
		if (getBounds().intersects(paddle1.getBounds())) {
			xVel *= -1;
		} else if (getBounds().intersects(paddle2.getBounds())) {
			xVel *= -1;
		}
		
		xPos += xVel*xSpeed;
		yPos += yVel*ySpeed;
		
		//accel
		xSpeed += xAccel;
		ySpeed += yAccel;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(xPos, yPos, width, height);
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getX() {
		return xPos;
	}

	@Override
	public double getY() {
		return yPos;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void setFrame(double x, double y, double w, double h) {
		this.xPos = (int) x;
		this.yPos = (int) y;
		this.width = (int) w;
		this.height = (int) h;
	}

}
