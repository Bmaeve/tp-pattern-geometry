package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    private List<GeometryListener> listeners = new ArrayList<>();

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

    protected void triggerChange() {
        for (GeometryListener listener : listeners) {
            listener.onChange(this);
        }
    }

    @Override
    public void addListener(GeometryListener listener) {
        this.listeners.add(listener);
    }
}
