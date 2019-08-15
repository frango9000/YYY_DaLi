package lib.Geometry;

public abstract class GeometricObject implements Comparable<GeometricObject>, Cloneable {

    public static double sumAreas(GeometricObject[] objects) {
        double sum = 0;
        for (GeometricObject object : objects) {
            sum += object.getArea();
        }
        return sum;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        double dif = getArea() - o.getArea();
        if (dif > 0) {
            return 1;
        } else if (dif < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeometricObject go = (GeometricObject) obj;
        return Double.compare(go.getArea(), getArea()) == 0;
    }
}
