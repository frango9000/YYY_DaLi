package lib.Geometry;

import static lib.Misc.Randomizer.randomInt;

public class Circle extends GeometricObject {
    public double radius;
    public Point center;

    public Circle(double radius) {
        this.radius = radius;
        this.center = new Point();
    }

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public Circle(Point p1, Point p2, Point p3) {
        double a = ((p1.x * (p2.y - p3.y)) - (p1.y * (p2.x - p3.x)) + (p2.x * p3.y) - (p3.x * p2.y));
        double b =
                ((Math.pow(p1.x, 2) + Math.pow(p1.y, 2)) * (p3.y - p2.y)
                        + (Math.pow(p2.x, 2) + Math.pow(p2.y, 2)) * (p1.y - p3.y)
                        + (Math.pow(p3.x, 2) + Math.pow(p3.y, 2)) * (p2.y - p1.y));
        double c =
                ((Math.pow(p1.x, 2) + Math.pow(p1.y, 2)) * (p2.x - p3.x)
                        + (Math.pow(p2.x, 2) + Math.pow(p2.y, 2)) * (p3.x - p1.x)
                        + (Math.pow(p3.x, 2) + Math.pow(p3.y, 2)) * (p1.x - p2.x));
        double d =
                ((Math.pow(p1.x, 2) + Math.pow(p1.y, 2)) * ((p3.x * p2.y) - (p2.x * p3.y))
                        + (Math.pow(p2.x, 2) + Math.pow(p2.y, 2)) * ((p1.x * p3.y) - (p3.x * p1.y))
                        + (Math.pow(p3.x, 2) + Math.pow(p3.y, 2)) * ((p2.x * p1.y) - (p1.x * p2.y)));

        double x = -(b / (2 * a));
        double y = -(c / (2 * a));
        this.radius = Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2) - (4 * a * d)) / (4 * Math.pow(a, 2)));
        this.center = new Point(x, y);
    }

    public Circle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public boolean contains(Point point) {
        return radius > center.distanceBetweenPoints(point);
    }

    public boolean contains(Circle circle) {
        return center.distanceBetweenPoints(circle.center) + circle.radius <= radius;
    }

    public boolean overlaps(Circle circle) {
        return this.radius + circle.radius > this.center.distanceBetweenPoints(circle.center);
    }

    public boolean tangent(Circle circle) {
        return this.radius + circle.radius == this.center.distanceBetweenPoints(circle.center);
    }

    public Point pointOnAngle(double degrees) {
        double angleInRadians = Math.toRadians(degrees);
        double x = radius * Math.cos(angleInRadians) + center.x;
        double y = radius * Math.sin(angleInRadians) + center.y;

        Point point = new Point(x, y);
        return point;
    }

    public Point randomPoint() {
        float randomDegree = randomInt(35999) / 100f;
        return pointOnAngle(randomDegree);
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", center=" + center.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }
}
