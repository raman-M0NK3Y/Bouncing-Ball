package eecs2030.lab3;

import java.util.Objects;

/**
 * A simple class for representing points in 2D Cartesian coordinates. Every
 * <code>Point2D</code> instance has an x and y coordinate.
 * 
 * @author EECS2030 Winter 2016-17
 *
 */
public class Point2 {

	private double x;
	private double y;

	/**
	 * Initialize the point to have coordinates <code>(0, 0)</code>.
	 */
	public Point2() {
		this.set(0.0, 0.0);
	}

	/**
	 * Initialize the point to have coordinates <code>(x, y)</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 */
	public Point2(double x, double y) {
		this.set(x, y);
	}

	/**
	 * Initialize a point to have the same coordinates as <code>other</code>.
	 * 
	 * @param other
	 *            another point
	 */
	public Point2(Point2 other) {
		this(other.x, other.y);
	}

	/**
	 * Returns the x-coordinate of this point.
	 * 
	 * @return the x-coordinate of this point
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Returns the y-coordinate of this point.
	 * 
	 * @return the y-coordinate of this point
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Sets the x-coordinate of this point to <code>newX</code>.
	 * 
	 * @param newX
	 *            the new x-coordinate of this point
	 */
	public void setX(double newX) {
		this.x = newX;
	}

	/**
	 * Sets the y-coordinate of this point to <code>newY</code>.
	 * 
	 * @param newY
	 *            the new y-coordinate of this point
	 */
	public void setY(double newY) {
		this.y = newY;
	}

	/**
	 * Sets the x-coordinate and y-coordinate of this point to <code>newX</code>
	 * and <code>newY</code>, respectively.
	 * 
	 * @param newX
	 *            the new x-coordinate of this point
	 * @param newY
	 *            the new y-coordinate of this point
	 */
	public void set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	/**
	 * Move the point in the x direction by an amount dx. The new x coordinate
	 * of the point is equal to <code>(this.getX() + dx)</code>.
	 * 
	 * @param dx
	 *            the change in the x coordinate of this point
	 */
	public void moveX(double dx) {
		this.x += dx;
	}

	/**
	 * Move the point in the y direction by an amount dy. The new y coordinate
	 * of the point is equal to <code>(this.getY() + dy)</code>.
	 * 
	 * @param dy
	 *            the change in the y coordinate of this point
	 */
	public void moveY(double dy) {
		this.y += dy;
	}

	/**
	 * Returns the distance between this point and another point.
	 * 
	 * @param other
	 *            another point
	 * @return the distance between this point and another point
	 */
	public double distanceTo(Point2 other) {
		return Math.hypot(this.getX() - other.getX(), this.getY() - other.getY());
	}

	/**
	 * Determines if two points are almost equal (similar). Two points are
	 * similar if the distance between them is smaller than the specified
	 * tolerance.
	 * 
	 * @param other
	 *            the other point to compare
	 * @param tol
	 *            the threshold distance between this point and other
	 * @return true if the distance between this point and other is strictly
	 *         less than tol
	 */
	public boolean similarTo(Point2 other, double tol) {
		return this.distanceTo(other) < tol;
	}

	/**
	 * Returns a string representation of this point. The string representation
	 * of this point is the x and y-coordinates of this point, separated by a
	 * comma and space, inside a pair of parentheses.
	 * 
	 * @return a string representation of this point
	 */
	@Override
	public String toString() {
		String s = String.format("(%s, %s)", this.getX(), this.getY());
		return s;
	}

	/**
	 * Returns a hash code for this point. The hash code is computed by using
	 * <code>Objects.hash</code> to hash the values of the x and y coordinates
	 * of this point.
	 * 
	 * @return a hash code for this point
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}

	/**
	 * Compares this point with the given object. The result is
	 * <code>true</code> if and only if the argument is not <code>null</code>
	 * and is a <code>Point2</code> object having the same coordinates as this
	 * object.
	 * 
	 * @param obj
	 *            the object to compare this vector against
	 * @return true if the given object represents a Point2 equivalent to this
	 *         point, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Point2 other = (Point2) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return true;
	}

}