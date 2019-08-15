package lib.Geometry;

public class Triangle extends GeometricObject {

    public final int numOfSides = 3;
    public Point pointA;
    public Point pointB;
    public Point pointC;
    public double sideAB;
    public double sideBC;
    public double sideCA;
    public double angleA; // In radians
    public double angleB;
    public double angleC;

    public Triangle() {
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        sideAB = Point.distanceBetweenPoints(pointA, pointB);
        sideBC = Point.distanceBetweenPoints(pointB, pointC);
        sideCA = Point.distanceBetweenPoints(pointC, pointA);

        angleA = angle(sideBC, sideCA, sideAB);
        angleB = angle(sideCA, sideBC, sideAB);
        angleC = angle(sideAB, sideCA, sideBC);
    }

    public Triangle(double sideAB, double sideBC, double sideCA) {
        if (isValidTriangle(sideAB, sideBC, sideCA)) {
            this.sideAB = sideAB;
            this.sideBC = sideBC;
            this.sideCA = sideCA;
        }
    }

    public Triangle(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(0, 0));
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    public static double getArea(Point pointA, Point pointB, Point pointC) {
        return Math.abs(
            pointA.x * (pointB.y - pointC.y)
                + pointB.x * (pointC.y - pointA.y)
                + pointC.x * (pointA.y - pointB.y))
            / 2;
    }

    public static boolean isValidTriangle(double sideAB, double sideBC, double sideCA) {
        return (((sideAB + sideBC) > sideCA)
            && ((sideBC + sideCA) > sideAB)
            && ((sideCA + sideAB) > sideBC));
    }

    public static double angle(double a, double b, double c) { // in radians
        return Math.acos((a * a - b * b - c * c) / (-2 * b * c));
    }

    public double getArea() {
        double s = (sideAB + sideBC + sideCA) / 2;
        return Math.sqrt(s * (s - sideAB) * (s - sideBC) * (s - sideCA));
    }

    public double getPerimeter() {
        return sideAB + sideBC + sideCA;
    }

    public boolean contains(Point point) {
        double ABC = getArea(pointA, pointB, pointC);
        double ABP = getArea(pointA, pointB, point);
        double APC = getArea(pointA, point, pointC);
        double PBC = getArea(point, pointB, pointC);
        return ABP + APC + PBC == ABC;
    }

    public boolean contains(Triangle triangle) {
        return contains(triangle.pointA) && contains(triangle.pointB) && contains(triangle.pointC);
    }

    @Override
    public String toString() {
        String string =
            "Triangle{\n"
                + " pointA="
                + (pointA != null ? pointA.toString() : "")
                + ",\n pointB="
                + (pointB != null ? pointB.toString() : "")
                + ",\n pointC="
                + (pointC != null ? pointA.toString() : "")
                + ",\n sideAB="
                + sideAB
                + ", sideBC="
                + sideBC
                + ", sideCA="
                + sideCA
                + ",\n angleA="
                + Math.toDegrees(angleA)
                + ", angleB="
                + Math.toDegrees(angleB)
                + ", angleC="
                + Math.toDegrees(angleC)
                + "\n getArea="
                + getArea()
                + "\n getPerimeter="
                + getPerimeter()
                + '}';
        return string;
    }

    @Override
    public int compareTo(GeometricObject o) {
        return 0;
    }
}
