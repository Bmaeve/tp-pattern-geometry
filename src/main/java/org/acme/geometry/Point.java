package org.acme.geometry;

public class Point implements Geometry {
    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coord) {
        this.coordinate = coord;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public String getType() {
        return "POINT";
    }

    @Override
    public boolean isEmpty() {
        return this.coordinate.isEmpty();
    }
}
