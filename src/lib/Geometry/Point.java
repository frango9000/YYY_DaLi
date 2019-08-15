package lib.Geometry;

import java.util.HashMap;

public class Point {
    public double x;
    public double y;
    public double z;

    public double[] point;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        buildPoint();
    }

    public Point() {
        this(0, 0, 0);
        buildPoint();
    }

    public Point(double x, double y) {
        this(x, y, 0);
        buildPoint();
    }

    public Point(double[] point) {
        this.x = point[0];
        this.y = point[1];
        this.z = point.length >= 3 ? point[2] : 0;
        buildPoint();
    }

    public static Point[] toPointsArray(double[][] points) {
        Point[] array = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            array[i] = new Point(points[i][0], points[i][1], points[i].length >= 3 ? points[i][2] : 0);
        }
        return array;
    }

    public static double distanceBetweenPoints(
            double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow(z2 - z1, 2));
    }

    public static double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return distanceBetweenPoints(x1, y1, 0, x2, y2, 0);
    }

    public static double distanceBetweenPoints(Point p1, Point p2) {
        return distanceBetweenPoints(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z);
    }

    public static double[] middlePoint(
            double x1, double y1, double z1, double x2, double y2, double z2) {
        return new double[]{(x1 + x2) / 2, (y1 + y2) / 2, (z1 + z2) / 2};
    }

    public static Point middlePoint(Point p1, Point p2) {
        double[] mp = middlePoint(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z);
        return new Point(mp[0], mp[1], mp[2]);
    }

    public static double[] middlePoint(double x1, double y1, double x2, double y2) {
        return middlePoint(x1, y1, 0, x2, y2, 0);
    }

    public static int[] closestPointsIndex(Point... points) {
        int p1 = 0, p2 = 1;
        double shortestDistance = distanceBetweenPoints(points[p1], points[p2]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distanceBetweenPoints(points[i], points[j]);
                if (shortestDistance > distance) {
                    p1 = i;
                    p2 = j;
                    shortestDistance = distance;
                }
            }
        }
        return new int[]{p1, p2};
    }

    public static double closestPointsDistance(Point... points) {
        return distanceBetweenPoints(
                points[closestPointsIndex(points)[0]], points[closestPointsIndex(points)[1]]);
    }

    public static HashMap<Point, Point> closestPoints(Point... points) {
        HashMap<Point, Point> list = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (distanceBetweenPoints(points[i], points[j]) == closestPointsDistance(points)) {
                    list.put(points[i], points[j]);
                }
            }
        }
        return list;
    }

    public Point middlePoint(Point p2) {
        double[] mp = middlePoint(this.x, this.y, this.z, p2.x, p2.y, p2.z);
        return new Point(mp[0], mp[1], mp[2]);
    }

    private void buildPoint() {
        point = new double[]{x, y, z};
    }

    public double distanceBetweenPoints(Point point) {
        return distanceBetweenPoints(this, point);
    }

    public String toString() {
        return "( " + x + ", " + y + " )";
    }

    public String toString3() {
        return "( " + x + ", " + y + ", " + z + " )";
    }
}
