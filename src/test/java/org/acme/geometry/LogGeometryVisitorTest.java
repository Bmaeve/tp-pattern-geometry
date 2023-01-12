package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;
import static org.acme.geometry.GeometryFactoryTest.createPointA;

public class LogGeometryVisitorTest {
    @Test
    public void testFctVisitPoint() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        Point p = createPointA();
        p.accept(visitor);
        String result = os.toString();
        Assert.assertEquals("Je suis un point avec x=0.0 et y=0.0.", result.trim());
    }

    @Test
    public void testFctVisitLineString() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        LineString l = createLineStringSizeN(3);
        l.accept(visitor);
        String result = os.toString();
        Assert.assertEquals("Je suis une polyligne définie par 3 point(s).", result.trim());
    }
}
