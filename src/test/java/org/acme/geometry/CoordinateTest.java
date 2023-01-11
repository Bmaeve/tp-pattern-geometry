package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}

	@Test
	public void testSecondConstructor(){
		Coordinate c = new Coordinate(1.0, 0.2);
		Assert.assertEquals(1.0, c.getX(), EPSILON);
		Assert.assertEquals(0.2, c.getY(), EPSILON);
	}

	@Test
	public void testFctIsEmpty(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}


	@Test
	public void testFctNotIsEmpty(){
		Coordinate c = new Coordinate(0.0, 0.0);
		Assert.assertFalse(c.isEmpty());
	}
}
