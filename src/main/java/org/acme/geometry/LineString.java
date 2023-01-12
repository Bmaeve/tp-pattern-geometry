package org.acme.geometry;

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
}
