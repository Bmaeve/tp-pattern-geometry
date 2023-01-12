package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createLineStringSizeN;

public class AbstractGeometryTest {

    @Test
    public void testFctAsText() {
        LineString l1 = new LineString();
        LineString l2 = createLineStringSizeN(2);
        Assert.assertEquals("LINESTRING EMPTY", l1.asText());
        Assert.assertEquals("LINESTRING(0.0 0.0,1.0 1.0)", l2.asText());
    }
}
