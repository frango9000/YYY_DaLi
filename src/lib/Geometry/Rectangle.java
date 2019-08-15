package lib.Geometry;

import java.util.Random;
import lib.Math.Algebra;

public class Rectangle extends GeometricObject {

    private final int numOfSides = 4;
    private double width;
    private double height;
    private Point center;

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Rectangle() {
    }

    public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        setCenter();
        setWidth();
        setHeight();
    }

    public Rectangle(Point pointA, Point pointC) { // opposite corners
        this(pointA, new Point(pointA.x, pointC.y), pointC, new Point(pointC.x, pointA.y));
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        center = new Point(0, 0);
    }

    public Rectangle(double width, double height, Point center) {
        this.width = width;
        this.height = height;
        this.center = center;
    }

    public static Rectangle boundingRectangle(Point... points) {
        double minX = Integer.MAX_VALUE,
            minY = Integer.MAX_VALUE,
            maxX = Integer.MIN_VALUE,
            maxY = Integer.MIN_VALUE;
        for (int point = 0; point < points.length; point++) {
            minX = Algebra.min(minX, points[point].x);
            minY = Algebra.min(minY, points[point].y);
            maxX = Algebra.max(maxX, points[point].x);
            maxY = Algebra.max(maxY, points[point].y);
        }
        return new Rectangle(new Point(minX, minY), new Point(maxX, maxY));
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Point getCenter() {
        return center;
    }

    private void setWidth() {
        width = pointA.distanceBetweenPoints(pointB);
    }

    private void setHeight() {
        height = pointA.distanceBetweenPoints(pointD);
    }

    private void setCenter() {
        center = pointA.middlePoint(pointB).middlePoint(pointC.middlePoint(pointD));
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getArea() {
        return width * height;
    }

    public double maxX() {
        return center.x + (width / 2);
    }

    public double minX() {
        return center.x - (width / 2);
    }

    public double maxY() {
        return center.y + (height / 2);
    }

    public double minY() {
        return center.y - (height / 2);
    }

    public double[] randomPoint() {
        Random rand = new Random();
        double[] randPoint = new double[2];

        int boundX = (int) (width * 100f);
        double randX = rand.nextInt(boundX);
        randPoint[0] = (randX - (boundX / 2f)) / 100 + center.x;

        int boundY = (int) (height * 100f);
        double randY = rand.nextInt(boundY);
        randPoint[1] = (randY - (boundY / 2f)) / 100 + center.y;

        return randPoint;
    }

    public boolean contains(Point point) {

        boolean xInBound = point.x < (maxX()) && point.x > (minX());
        boolean yInBound = point.y < (maxY()) && point.y > (minY());
        return xInBound && yInBound;
    }

    public boolean contains(Rectangle rectangle) {
        double xDistance = Math.abs(this.center.x - rectangle.center.x);
        double yDistance = Math.abs(this.center.y - rectangle.center.y);

        if (xDistance <= Math.abs(this.width - rectangle.width) / 2
            && yDistance <= Math.abs(this.height - rectangle.height) / 2) {
            if (this.width > rectangle.width) {
                return true; // System.out.println("rectangle 2 is in rectangle 1");
            } else {
                return !(rectangle.width > this.width);
            }
        } else if (xDistance <= Math.abs(this.width + rectangle.width) / 2
            && yDistance <= Math.abs(this.height + rectangle.height) / 2) {
            return false; // System.out.println("r2 contains r1");
        } else {
            return false; // System.out.println("r2 does not overlap r1");
        }
        // return true;
    }

    public boolean overlaps(Rectangle rectangle) {
        double xDistance = Math.abs(this.center.x - rectangle.center.x);
        double yDistance = Math.abs(this.center.y - rectangle.center.y);

        // Overlap
        return xDistance <= this.width + rectangle.width / 2
            && yDistance <= this.height + rectangle.height / 2;
    }
}
