package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    public String asText() {
        WktVisitor v = new WktVisitor();
        this.accept(v);
        return v.getResult();
    }

    public abstract Geometry clone();

    public Envelope getEnvelope() {
        EnvelopeBuilder eB = new EnvelopeBuilder();
        this.accept(eB);
        return eB.build();
    }
}
