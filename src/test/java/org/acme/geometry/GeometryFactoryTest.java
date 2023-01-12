package org.acme.geometry;

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

	public static Envelope createEnvelope() {
		Coordinate c1 = new Coordinate(1.0, 1.0);
		Coordinate c2 = new Coordinate(2.0, 2.0);
		Envelope envelope = new Envelope(c1, c2);
		return envelope;
	}

	public static Envelope createEnvelopeBuilder() {
		EnvelopeBuilder envelopeB = new EnvelopeBuilder();
		envelopeB.insert(new Coordinate(2.4, 1.0));
		envelopeB.insert(new Coordinate(1.0, 2.0));
		envelopeB.insert(new Coordinate(0.0, 4.0));
		return envelopeB.build();
	}

	public static GeometryWithCachedEnvelope createGeometryWithCachedEnvelopePoint() {
		Point p = createPointA();
		GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(p);
		return g;
	}

	public static GeometryWithCachedEnvelope createGeometryWithCachedEnvelopeLineString() {
		LineString l = createLineStringSizeN(4);
		GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(l);
		return g;
	}
}
