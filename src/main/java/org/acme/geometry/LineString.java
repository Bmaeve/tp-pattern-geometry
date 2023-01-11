package org.acme.geometry;

import java.util.List;

public class LineString implements Geometry {
    private List<Point> point;

    public LineString() {}

    public LineString(List<Point> p) {
        this.point = p;
    }

    public int getNumPoints() {
        return this.point.size();
    }

    public Point getPointN(int n) {
        return this.point.get(n);
    }

    @Override
    public String getType() {
        return "LINESTRING";
    }
}
