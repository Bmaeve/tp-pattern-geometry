package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder buffer;

    public WktVisitor() {
        this.buffer = new StringBuilder();
    }

    public String getResult() {
        return buffer.toString();
    }

    @Override
    public void visit(Point point) {
        if (point.isEmpty()) {
            buffer.append("POINT EMPTY");
        } else {
            buffer.append("POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
        }
    }

    @Override
    public void visit(LineString lineString) {
        if (lineString.isEmpty()) {
            buffer.append("LINESTRING EMPTY");
        } else {
            buffer.append("LINESTRING(");
            for (int i = 0; i<lineString.getNumPoints(); i++){
                if (i != 0) {
                    buffer.append(",");
                }
                buffer.append(lineString.getPointN(i).getCoordinate().getX() + " ");
                buffer.append(lineString.getPointN(i).getCoordinate().getY());
            }
            buffer.append(")");
        }
    }
}
