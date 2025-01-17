package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<>();
    }

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
        this.triggerChange();
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
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
