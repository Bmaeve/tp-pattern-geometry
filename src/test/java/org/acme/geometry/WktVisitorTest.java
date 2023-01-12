package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

public class WktVisitorTest {

    @Test
    public void testFctGetResultPoint() {
        WktVisitor v1 = new WktVisitor();
        WktVisitor v2 = new WktVisitor();
        Point p1 = new Point();
        Point p2 = createPointA();
        v1.visit(p1);
        v2.visit(p2);
        Assert.assertEquals("POINT EMPTY", v1.getResult());
        Assert.assertEquals("POINT(0.0 0.0)", v2.getResult());
    }

    @Test
    public void testFctGetResultLineString() {
        WktVisitor v1 = new WktVisitor();
        WktVisitor v2 = new WktVisitor();
        LineString l1 = new LineString();
        LineString l2 = createLineStringSizeN(2);
        v1.visit(l1);
        v2.visit(l2);
        Assert.assertEquals("LINESTRING EMPTY", v1.getResult());
        Assert.assertEquals("LINESTRING(0.0 0.0,1.0 1.0)", v2.getResult());
    }
}
