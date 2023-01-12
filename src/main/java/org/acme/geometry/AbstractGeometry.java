package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    public String asText() {
        WktVisitor v = new WktVisitor();
        this.accept(v);
        return v.getResult();
    }

    public abstract Geometry clone();
}
