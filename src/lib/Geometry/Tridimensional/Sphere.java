package lib.Geometry.Tridimensional;

import lib.Geometry.Point;

public class Sphere {
    public double radius;

    public Sphere() {
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    public double distanceBetweenPoints(Point pointA, Point pointB) {
        double x1 = Math.toRadians(pointA.x);
        double y1 = Math.toRadians(pointA.y);
        double x2 = Math.toRadians(pointB.x);
        double y2 = Math.toRadians(pointB.y);

        return radius
                * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
    }
}
