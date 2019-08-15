package lib.Geometry;

public class Pentagon extends Polygon {

    protected Pentagon() {
        super(5);
    }

    public Pentagon(double sideLength) {
        super(5, sideLength);
    }

    public Pentagon(double radius, boolean dummy) {
        super(5, radius, dummy);
    }
}
