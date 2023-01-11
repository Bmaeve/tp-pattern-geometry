package org.acme.geometry;

public class Point implements Geometry {
    private Coordinate coordinate;

    public Point() {}

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
}
