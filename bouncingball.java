package eecs2030.lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import princeton.introcs.StdDraw;

public class BouncingBall implements ActionListener {

	static {
		StdDraw.setCanvasSize(20 * 40, 20 * 40);
		StdDraw.setXscale(0.0, 20.0);
		StdDraw.setYscale(0.0, 20.0);
	}

	private Timer timer;
	private Ball ball;
	private final double radius = 1.0;
	private static final double X_LEFT = 0.0;
	private static final double X_RIGHT = 20.0;

	public BouncingBall() {
		this.timer = new Timer(25, this);
		this.ball = new Ball(new Point2(10.0, 15.0), new Vector2(2.3, 0.0));
	}

	private void drawBall() {
		double x = this.ball.getPosition().getX();
		double y = this.ball.getPosition().getY();
		StdDraw.filledCircle(x, y, this.radius);
	}

	public void run() {
		this.timer.start();

		while (true) {
			StdDraw.show(0);
			StdDraw.clear();
			this.drawBall();
			StdDraw.show(0);
			if (StdDraw.hasNextKeyTyped()) {
				char c = StdDraw.nextKeyTyped();
				if (c == 'q') {
					this.timer.stop();
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ball.move(0.1);
		if (this.ball.getPosition().getY() <= 0.0) {
			Vector2 v = this.ball.getVelocity();
			v.setY(-v.getY());
			this.ball.setVelocity(v);
		}
		if (this.ball.getPosition().getX() <= BouncingBall.X_LEFT
				|| this.ball.getPosition().getX() >= BouncingBall.X_RIGHT) {
			Vector2 v = this.ball.getVelocity();
			v.setX(-v.getX());
			this.ball.setVelocity(v);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BouncingBall test = new BouncingBall();
		test.run();
		StdDraw.close();
	}

}