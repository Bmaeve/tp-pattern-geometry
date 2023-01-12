package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor() {
		LineString l = new LineString();
		Assert.assertEquals("LINESTRING", l.getType());
	}

	@Test
	public void testSecondConstructor() {
		LineString l = createLineStringSizeN(3);
		Assert.assertEquals("LINESTRING", l.getType());
	}

	@Test
	public void testFctGetNumPointEmpty() {
		int n = 2;
		LineString l = createLineStringSizeN(n);
		Assert.assertEquals(n, l.getNumPoints());
	}

	@Test
	public void testFctGetNumPointNoEmpty() {
		int n = 4;
		LineString l = createLineStringSizeN(n);
		Assert.assertEquals(n, l.getNumPoints());
	}

	@Test
	public void testFctGetPointN() {
		List<Point> points = new ArrayList<Point>();
		Point p1 = new Point();
		points.add(p1);
		Point p2 = new Point();
		points.add(p2);
		LineString l = new LineString(points);
		Assert.assertSame(p1, l.getPointN(0));
	}

	@Test
	public void testFctIsEmpty() {
		int n = 0;
		LineString l = createLineStringSizeN(0);
		Assert.assertTrue(l.isEmpty());
	}

	@Test
	public void testFctNotIsEmpty() {
		int n = 4;
		LineString l = createLineStringSizeN(n);
		Assert.assertFalse(l.isEmpty());
	}

	@Test
	public void testFctTranslate() {
		LineString l = createLineStringSizeN(2);
		l.translate(1.0, 2.0);
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(2.0, l.getPointN(0).getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testFctClone() {
		LineString l1 = createLineStringSizeN(2);
		Assert.assertNotSame(l1, l1.clone());
	}
}
