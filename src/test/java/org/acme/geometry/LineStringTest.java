package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		LineString l = new LineString();
		Assert.assertEquals("LINESTRING", l.getType());
	}

	@Test
	public void testSecondConstructor(){
		List<Point> points = new ArrayList<Point>();
		points.add(new Point());
		points.add(new Point());
		points.add(new Point());
		points.add(new Point());
		LineString l = new LineString(points);
		Assert.assertEquals("LINESTRING", l.getType());
	}

	@Test
	public void testFctGetNumPointEmpty(){
		List<Point> points = new ArrayList<Point>();
		LineString l = new LineString(points);
		Assert.assertEquals(0, l.getNumPoints());
	}

	@Test
	public void testFctGetNumPointNoEmpty(){
		int n = 4;
		List<Point> points = new ArrayList<Point>();
		points.add(new Point());
		points.add(new Point());
		points.add(new Point());
		points.add(new Point());
		LineString l = new LineString(points);
		Assert.assertEquals(n, l.getNumPoints());
	}

	@Test
	public void testFctGetPointN(){
		List<Point> points = new ArrayList<Point>();
		Point p1 = new Point();
		points.add(p1);
		Point p2 = new Point();
		points.add(p2);
		LineString l = new LineString(points);
		Assert.assertSame(p1, l.getPointN(0));
	}
}
