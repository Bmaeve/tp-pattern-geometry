package org.acme.geometry;

public class WktWriter {

    public String write(Geometry geometry) {
        StringBuilder r = new StringBuilder();
        if (geometry instanceof Point) {
            Point point = (Point) geometry;
            if (point.isEmpty()) {
                r.append("POINT EMPTY");
            } else {
                r.append("POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
            }
        } else if ( geometry instanceof LineString ) {
            LineString lineString = (LineString)geometry;
            if (lineString.isEmpty()) {
                r.append("LINESTRING EMPTY");
            } else {
                r.append("LINESTRING(");
                for (int i = 0; i<lineString.getNumPoints(); i++){
                    if (i != 0) {
                        r.append(",");
                    }
                    r.append(lineString.getPointN(i).getCoordinate().getX() + " ");
                    r.append(lineString.getPointN(i).getCoordinate().getY());
                }
                r.append(")");
            }
        } else {
            throw new RuntimeException("geometry type not supported");
        }
        return r.toString();
    }
}
