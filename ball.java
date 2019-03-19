package eecs2030.lab3;

/**
 * A class that represents an ideal point projectile moving under the
 * influence of gravity.
 * 
 * @author 
 *
 */
public class Ball {
	
	/**
	 * The current position of the ball.
	 */
	private Point2 position; 
	
	/**
	 * The current velocity of the ball.
	 */
	private Vector2 velocity;
	
	
	/**
	 * Gravitational acceleration vector.
	 */
	private static final Vector2 G = new Vector2(0.0, -9.81);
	

	/**
	 * Initialize the ball so that its position and velocity are
	 * equal to the given position and velocity.
	 * 
	 * @param position the position of the ball
	 * @param velocity the velocity of the ball
	 */
	public Ball(Point2 position, Vector2 velocity) {
		this.position = new Point2(position);
		this.velocity = new Vector2(velocity);
	}
	
	/**
	 * Return the position of the ball.
	 * @return the position of the ball
	 */
	public Point2 getPosition() {
		return new Point2(this.position);
	}
	
	/**
	 * Return the velocity of the ball.
	 * @return the velocity of the ball
	 */
	public Vector2 getVelocity() {
		return new Vector2(this.velocity);
	}
	
	/**
	 * Set the position of the ball to the given position.
	 * 
	 * @param position the new position of the ball
	 */
	public void setPosition(Point2 position) {
		this.position = new Point2(position);
	}
	
	/**
	 * Set the velocity of the ball to the given velocity.
	 * 
	 * @param velocity the new velocity of the ball
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = new Vector2(velocity);
	}
	
	/**
	 * Moves the ball from its current position using its current
	 * velocity accounting for the force of gravity. See the Lab 3
	 * document for a description of how to compute the new position
	 * and velocity of the ball.
	 * 
	 * @param dt the time period over which the ball has moved
	 * @return the new position of the ball
	 */
	public Point2 move(double dt) {
		Vector2 dp1 = Lab3Util.multiply(dt, this.velocity);
		Vector2 dp2 = Lab3Util.multiply(0.5 * dt * dt, Ball.G);
		Vector2 dp = Lab3Util.add(dp1, dp2);
		this.position = Lab3Util.add(this.position, dp);
		Vector2 dv = Lab3Util.multiply(dt, Ball.G);
		this.velocity = this.velocity.add(dv);
		return new Point2(this.position);
	}
	
	public static void main(String[] args) {
		Ball b = new Ball(new Point2(), new Vector2(1.0, 0.0));
		for (int t = 0; t < 10; t++ ) {
			b.move(1.0);
			System.out.print(b.getPosition().getX() + ", ");
		}
	}
}