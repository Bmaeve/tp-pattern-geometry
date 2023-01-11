package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Point p = new Point();
		Assert.assertEquals("POINT", p.getType());
	}

	@Test
	public void testSecondConstructor(){
		Coordinate c = new Coordinate(1.0, 0.2);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());
		Assert.assertEquals("POINT", p.getType());
	}

}
