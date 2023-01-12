package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GeometryFactoryTest {

	public static Point createPointEmpty() {
		Coordinate c = new Coordinate();
		return new Point(c);
	}

	public static Point createPointA() {
		Coordinate c = new Coordinate(0.0, 0.0);
		return new Point(c);
	}

	public static LineString createLineStringSizeN(int n) {
		List<Point> points = new ArrayList<Point>();
		for (int i=0; i<n; i++) {
			Coordinate c = new Coordinate(i, i);
			points.add(new Point(c));
		}
		return new LineString(points);
	}
}
