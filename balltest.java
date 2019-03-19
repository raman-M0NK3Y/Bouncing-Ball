package eecs2030.lab3;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BallTest {

	@Test
	public void test01_ctor() {
		Point2 p = new Point2(-1.5, 15.5);
		Vector2 v = new Vector2(2.5, 3.5);
		Ball b = new Ball(p, v);
		
		Point2 pExpected = new Point2(p);
		Vector2 vExpected = new Vector2(v);
		
		Point2 pGot = b.getPosition();
		assertEquals("unexpected position: " + pGot,
				pExpected, pGot);
		
		Vector2 vGot = b.getVelocity();
		assertEquals("unexpected velocity: " + vGot,
				vExpected, vGot);
	}

	@Test
	public void test02_setPosition() {
		Point2 p = new Point2(-1.5, 15.5);
		Vector2 v = new Vector2(2.5, 3.5);
		Ball b = new Ball(p, v);
		
		Point2 newP = new Point2(32.0, 100.0);
		Point2 pExpected = new Point2(newP);
		
		b.setPosition(newP);
		Point2 got = b.getPosition();
		assertEquals("unexpected position: " + got,
				pExpected, got);
	}
	
	@Test
	public void test02_setVelocity() {
		Point2 p = new Point2(-1.5, 15.5);
		Vector2 v = new Vector2(2.5, 3.5);
		Ball b = new Ball(p, v);
		
		Vector2 newV = new Vector2(1.0, -1.0);
		Vector2 vExpected = new Vector2(newV);
		b.setVelocity(newV);
		
		Vector2 got = b.getVelocity();
		assertEquals("unexpected velocity: " + got,
				vExpected, got);
	}
	
	@Test
	public void test03_move() {
		Point2 p = new Point2();
		Vector2 v = new Vector2(1.0, 0.0);
		Ball b = new Ball(p, v);
		
		final double X[] = { 1.0,
				2.0,
				3.0,
				4.0,
				5.0,
				6.0,
				7.0,
				8.0,
				9.0,
				10.0};
		final double Y[] = { -4.905, 
				-19.62, 
				-44.145, 
				-78.48, 
				-122.625, 
				-176.58, 
				-240.34500000000003, 
				-313.92, 
				-397.305, 
				-490.5};
		final double VX[] = { 1.0,
				1.0,
				1.0,
				1.0,
				1.0,
				1.0,
				1.0,
				1.0,
				1.0,
				1.0};
		final double VY[] = {-9.81, 
				-19.62, 
				-29.43, 
				-39.24, 
				-49.050000000000004, 
				-58.86000000000001, 
				-68.67, 
				-78.48, 
				-88.29, 
				-98.10000000000001};
		
		for (int i = 0; i < X.length; i++) {
			b.move(1.0);
			
			Point2 pExpected = new Point2(X[i], Y[i]);
			Point2 pGot = b.getPosition();
			assertTrue("unexpected position: " + pGot,
					pExpected.similarTo(pGot, 1e-9));
			
			Vector2 vExpected = new Vector2(VX[i], VY[i]);
			Vector2 vGot = b.getVelocity();
			assertTrue("unexpected velocity: " + vGot,
					vExpected.similarTo(vGot, 1e-9));
		}
	}
}