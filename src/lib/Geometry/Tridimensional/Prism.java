package lib.Geometry.Tridimensional;

import lib.Geometry.Triangle;

public class Prism extends Triangle {

    public double length;

    public Prism(float sides, float length) {
        this.sideAB = sides;
        this.sideBC = sides;
        this.sideCA = sides;
        this.length = length;
    }

    public double volume() {
        return getArea() * length;
    }
}
