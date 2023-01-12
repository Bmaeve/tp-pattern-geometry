package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.*;

public class EnvelopeBuilderTest {
    public static final double EPSILON = 1.0e-15;
    @Test
    public void testDefaultConstructor() {
        EnvelopeBuilder e = new EnvelopeBuilder();
        Assert.assertTrue(e.build().isEmpty());
    }

    @Test
    public void testFctInsert() {
        EnvelopeBuilder envelopeB = new EnvelopeBuilder();
        {
            Envelope e = envelopeB.build();
            Assert.assertTrue(e.isEmpty());
        }
        envelopeB.insert(new Coordinate(2.0, 1.0));
        {
            Envelope e = envelopeB.build();
            Assert.assertEquals(2.0, e.getXmin(), EPSILON);
            Assert.assertEquals(1.0, e.getYmin(), EPSILON);
            Assert.assertEquals(2.0, e.getXmax(), EPSILON);
            Assert.assertEquals(1.0, e.getYmax(), EPSILON);
        }

        envelopeB.insert(new Coordinate(1.0, 2.0));
        {
            Envelope e = envelopeB.build();
            Assert.assertEquals(1.0, e.getXmin(), EPSILON);
            Assert.assertEquals(1.0, e.getYmin(), EPSILON);
            Assert.assertEquals(2.0, e.getXmax(), EPSILON);
            Assert.assertEquals(2.0, e.getYmax(), EPSILON);
        }
        envelopeB.insert(new Coordinate(0.0, 4.0));
        {
            Envelope e = envelopeB.build();
            Assert.assertEquals(0.0, e.getXmin(), EPSILON);
            Assert.assertEquals(1.0, e.getYmin(), EPSILON);
            Assert.assertEquals(2.0, e.getXmax(), EPSILON);
            Assert.assertEquals(4.0, e.getYmax(), EPSILON);
        }
    }
}
