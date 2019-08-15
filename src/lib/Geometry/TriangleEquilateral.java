package lib.Geometry;

public class TriangleEquilateral extends Polygon {

    public TriangleEquilateral() {
        super(3);
    }

    public TriangleEquilateral(double sideLength) {
        super(3, sideLength);
    }

    public TriangleEquilateral(double radius, boolean dummy) {
        super(3, radius, dummy);
    }
}
