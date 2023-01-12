package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

public class GeometryWithCachedEnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Point p = createPointA();
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(p);
        Assert.assertEquals("POINT", g.getType());
    }

    @Test
    public void testFctIsEmpty() {
        LineString l = createLineStringSizeN(0);
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(l);
        Assert.assertTrue(g.isEmpty());
    }

    @Test
    public void testFctNotIsEmpty() {
        int n = 4;
        LineString l = createLineStringSizeN(n);
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(l);
        Assert.assertFalse(g.isEmpty());
    }

    @Test
    public void testFctClone() {
        LineString l = createLineStringSizeN(2);
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(l);
        Assert.assertNotSame(g, g.clone());
    }

    @Test
    public void testFctGetEnvelope() {
        LineString l = createLineStringSizeN(0);
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(l);
        Envelope e1 = g.getEnvelope();
        Envelope e2 = g.getEnvelope();
        Assert.assertSame(e1, e2);
    }
}