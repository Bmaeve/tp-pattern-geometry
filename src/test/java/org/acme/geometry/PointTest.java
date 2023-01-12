package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

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

	@Test
	public void testFctIsEmpty(){
		Point p = new Point();
		Assert.assertTrue(p.isEmpty());
	}

	@Test
	public void testFctNotIsEmpty(){
		Point p = createPointA();
		Assert.assertFalse(p.isEmpty());
	}

	@Test
	public void testFctTranslate(){
		Point p = createPointA();
		p.translate(3.0, 2.0);
		Assert.assertEquals(3.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(2.0, p.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testFctClone(){
		Point p = createPointA();
		Assert.assertNotSame(p, p.clone());
	}

	@Test
	public void testFctGetEnvelope() {
		Point p = createPointA();
		Assert.assertEquals(p.getCoordinate().getX(), p.getEnvelope().getXmin(), EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), p.getEnvelope().getYmin(), EPSILON);
		Assert.assertEquals(p.getCoordinate().getX(), p.getEnvelope().getXmax(), EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), p.getEnvelope().getYmax(), EPSILON);
	}
}
