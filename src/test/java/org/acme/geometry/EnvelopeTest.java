package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.acme.geometry.GeometryFactoryTest.createEnvelope;

public class EnvelopeTest {
    @Test
    public void testDefaultConstructor() {
        Envelope e = new Envelope();
        Assert.assertTrue(e.isEmpty());
    }

    @Test
    public void testSecondConstructor() {
        Envelope e = createEnvelope();
        Assert.assertFalse(e.isEmpty());
    }
}
