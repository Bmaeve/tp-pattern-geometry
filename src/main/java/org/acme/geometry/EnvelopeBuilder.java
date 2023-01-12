package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor {

    private List<Double> xVals = new ArrayList<Double>();
    private List<Double> yVals = new ArrayList<Double>();
    public void insert(Coordinate coordinate) {
        xVals.add(coordinate.getX());
        yVals.add(coordinate.getY());
    }

    public Envelope build() {
        if (!xVals.isEmpty()) {
            Coordinate c1 = new Coordinate(Collections.min(xVals), Collections.min(yVals));
            Coordinate c2 = new Coordinate(Collections.max(xVals), Collections.max(yVals));
            return new Envelope(c1, c2);
        } else {
            return new Envelope();
        }
    }

    @Override
    public void visit(Point point) {
        this.insert(point.getCoordinate());
    }

    @Override
    public void visit(LineString lineString) {
        for (int i = 0; i<lineString.getNumPoints(); i++){
            this.insert(lineString.getPointN(i).getCoordinate());
        }
    }
}
