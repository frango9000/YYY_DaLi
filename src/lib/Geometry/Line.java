package lib.Geometry;

import lib.Math.Algebra;

public class Line {
    public Point pointA;
    public Point pointB;

    public double a;
    public double b;
    public double c;

    public double slope;
    public double yIntercept;
    public double xIntercept;

    public Line() {
    }

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.a = a();
        this.b = b();
        this.c = c();
        this.slope = slope();
        yIntercept = yIntercept();
        xIntercept = xIntercept();
    }

    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point pointA, float slope) {
        this.pointA = pointA;
        this.slope = slope;
        yIntercept = yIntercept();
        xIntercept = xIntercept();
    }

    public static double[] intersect(Line line1, Line line2) {
        return Algebra.linear2x2Equation(line1.a, line1.b, line2.a, line2.b, line1.c, line2.c);
    }

    public static double getAngle(Line line1, Line line2) {
        return line1.getAngle(line2);
    }

    public double slope() {
        return (pointB.y - pointA.y) / (pointB.x - pointA.x);
    }

    public double yIntercept() {
        return pointA.y - (slope() * pointA.x);
    }

    public double xIntercept() { // ??
        return pointA.x - ((1 / slope()) * pointA.y);
    }

    public double a() {
        return pointA.y - pointB.y;
    }

    public double b() {
        return -(pointA.x - pointB.x);
    }

    public double c() {
        return (pointA.y - pointB.y) * pointA.x - (pointA.x - pointB.x) * pointA.y;
    }

    public double squaredLength() {
        return (pointB.x - pointA.x) * (pointB.x - pointA.x)
                + (pointB.y - pointA.y) * (pointB.y - pointA.y);
    }

    public double[] intersect(Line line) {
        return Algebra.linear2x2Equation(this.a, this.b, line.a, line.b, this.c, line.c);
    }

    public boolean isOnLine(Point point) {
        return this.crossProduct(point) == 0;
    }

    public double crossProduct(Point point) {
        return ((pointB.x - pointA.x) * (point.y - pointA.y)
                - (point.x - pointA.x) * (pointB.y - pointA.y));
    }

    public double crossProduct(double x, double y) {
        return crossProduct(new Point(x, y));
    }

    public double[] crossProduct(Point... points) {
        double[] crosss = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            crosss[i] = crossProduct(points[i]);
        }
        return crosss;
    }

    public double dotProduct(Point point) {
        return ((pointB.x - pointA.x) * (point.x - pointA.x)
                - (point.y - pointA.y) * (pointB.y - pointA.y));
    }

    public boolean isOnSegment(Point point) {
        return !((crossProduct(point) > 0)
                || (crossProduct(point) < 0)
                || (point.x < pointA.x)
                || (point.y < pointA.y)
                || (point.x > pointB.x)
                || (point.y > pointB.y));
    }

    public Point middlePoint() {
        return pointA.middlePoint(pointB);
    }

    public double getLength() {
        return pointA.distanceBetweenPoints(pointB);
    }

    public double getAngle() { // 0 degrees @ east
        if (pointA.x >= pointB.x) {
            if (pointA.y <= pointB.y) {
                return -(Math.toDegrees(Math.atan(slope)));
            } else return 360 - (Math.toDegrees(Math.atan(slope)));
        } else return 180 - (Math.toDegrees(Math.atan(slope)));
    }

    public double getAngle(Line line) {
        return Math.abs(getAngle() - line.getAngle());
    }
}
