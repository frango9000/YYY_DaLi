package lib.Geometry;

public class SimplestTriangle {

    private int base = 0;
    private int altura = 0;

    public SimplestTriangle() {
    }

    public SimplestTriangle(int base, int altura) {
        this.base   = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "SimplestTriangle{" +
               "base=" + base +
               ", altura=" + altura +
               '}';
    }

    public double getArea() {
        return (base * altura) / 2f;
    }
}
