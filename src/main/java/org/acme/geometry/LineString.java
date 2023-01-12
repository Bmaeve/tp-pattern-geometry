package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    private List<Point> points;

    public LineString() {}

    public LineString(List<Point> p) {
        this.points = p;
    }

    public int getNumPoints() {
        return this.points.size();
    }

    public Point getPointN(int n) {
        return this.points.get(n);
    }

    @Override
    public String getType() {
        return "LINESTRING";
    }

    @Override
    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.points.forEach(p -> p.translate(dx, dy));
    }

    @Override
    public LineString clone() {
        List<Point> newPoints = new ArrayList<Point>();
        for (Point p: this.points){
            newPoints.add(p.clone());
        }
        return new LineString();
    }

    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder eB = new EnvelopeBuilder();
        for (Point p: this.points){
            eB.insert(p.getCoordinate());
        }
        return eB.build();
    }
}
