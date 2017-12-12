
public class Botv1 implements AIface{
	Paddle paddle;
	Ball ball;
	
	@Override
	public String getDir() {
		double centerOfPaddle = paddle.y+paddle.height/2;
		double ballY = ball.getCenterY();
		if (centerOfPaddle > ballY) {
			return "up";
		} else if (centerOfPaddle < ballY){
			return "down";
			
		} else {
			return "null";
		}
	}

	@Override
	public void setPaddle(Paddle paddle) {
		// TODO Auto-generated method stub
		this.paddle = paddle;
	}

	@Override
	public void setBall(Ball ball) {
		// TODO Auto-generated method stub
		this.ball = ball;
	}

}
