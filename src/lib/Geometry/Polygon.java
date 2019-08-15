package lib.Geometry;

import java.util.Arrays;

public class Polygon extends GeometricObject {

    protected int numOfSides;
    protected double sideLength;
    protected double radius; // radius of the circle formed by corners
    protected Point center;
    protected Point[] points;

    protected Polygon() {
    }

    public Polygon(int numOfSides) {
        this();
        this.numOfSides = numOfSides;
        this.center = new Point(0, 0);
    }

    public Polygon(int numOfSides, double sideLength) {
        this(numOfSides);
        this.sideLength = sideLength;
        this.radius = computeRadius();
    }

    public Polygon(int numOfSides, double radius, boolean dummy) {
        this(numOfSides);
        this.radius = radius;
        this.sideLength = computeSideLength();
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point[] getPoints() {
        return points;
    }

    public double[] getRawPoints() {
        double[] ps = new double[points.length * 2];
        for (int point = 0, value = 0; point < points.length; point++) {
            ps[value++] = points[point].x;
            ps[value++] = points[point].y;
        }
        return ps;
    }

    public Point[] setPoints(double angleOfPoint0) {
        points = new Point[numOfSides];
        if (center == null) {
            center = new Point(0, 0);
        }
        double div = 360.0 / numOfSides;
        angleOfPoint0 = angleOfPoint0 % div;

        Circle circle = new Circle(radius, center);
        for (int point = 0; point < points.length; point++) {
            points[point] = circle.pointOnAngle(-90 + angleOfPoint0 + (point * div));
        }
        return points;
    }

    public Point[] setVertexOnTop() {
        setPoints(0);
        return points;
    }

    public Point[] setTopHorizontal() {
        double div = 360.0 / numOfSides;
        setPoints(div / 2);
        return points;
    }

    public Point[] setBotHorizontal() {
        if (numOfSides % 2 == 0) {
            setTopHorizontal();
        } else {
            setVertexOnTop();
        }
        return points;
    }

    public Point[] setBotOnVertex() {
        if (numOfSides % 2 != 0) {
            setTopHorizontal();
        } else {
            setVertexOnTop();
        }
        return points;
    }

    public double getArea() {
        return (numOfSides * sideLength * sideLength) / (4 * Math.tan(Math.PI / numOfSides));
    }

    public double getPerimeter() {
        return sideLength * numOfSides;
    }

    private double computeSideLength() {
        return 2 * radius * Math.sin(Math.PI / numOfSides);
    }

    private double computeRadius() { // center to vertex
        return sideLength / (2 * Math.sin(Math.PI / numOfSides));
    }

    @Override
    public String toString() {
        return "Polygon{"
            + "\nnumOfSides="
            + numOfSides
            + ",\n sideLength="
            + sideLength
            + ",\n radius="
            + radius
            + ",\n center="
            + center.toString()
            + ",\n points="
            + Arrays.toString(points)
            + ",\n getArea="
            + getArea()
            + ",\n getPerimeter="
            + getPerimeter()
            + '}';
    }
}
