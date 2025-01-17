package org.acme.geometry;

public class Point extends AbstractGeometry {
    private Coordinate coordinates;

    public Point() {
        this.coordinates = new Coordinate();
    }

    public Point(Coordinate coord) {
        this.coordinates = coord;
    }

    public Coordinate getCoordinate() {
        return this.coordinates;
    }

    @Override
    public String getType() {
        return "POINT";
    }

    @Override
    public boolean isEmpty() {
        return this.coordinates.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.coordinates = new Coordinate(this.coordinates.getX() + dx, this.coordinates.getY() + dy);
        this.triggerChange();
    }

    @Override
    public Point clone() {
        return new Point(this.coordinates);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
