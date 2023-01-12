package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

public class WktWriterTest {

    @Test
    public void testFctWritePoint() {
        WktWriter w = new WktWriter();
        Point p1 = new Point();
        Point p2 = createPointA();
        Assert.assertEquals("POINT EMPTY", w.write(p1));
        Assert.assertEquals("POINT(0.0 0.0)", w.write(p2));
    }

    @Test
    public void testFctWriteLineString() {
        WktWriter w = new WktWriter();
        LineString l1 = new LineString();
        LineString l2 = createLineStringSizeN(2);
        Assert.assertEquals("LINESTRING EMPTY", w.write(l1));
        Assert.assertEquals("LINESTRING(0.0 0.0,1.0 1.0)", w.write(l2));
    }
}
