package auxp.ch13;

public class Complex implements Comparable<Complex>, Cloneable {
    private final double I = Math.sqrt(-1);
    private int a;
    private int b;

    public Complex() {
        this(0, 0);
    }

    public Complex(int a) {
        this(a, 0);
    }

    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getRealPart() {
        return a;
    }

    public int getImaginaryPart() {
        return b;
    }

    public Complex add(Complex secondComplex) { // a + bi + c + di = (a + c) + (b + d)i
        return new Complex((this.a + secondComplex.a), (this.b + secondComplex.b));
    }

    public Complex substract(Complex secondComplex) { // a + bi - (c + di) = (a - c) + (b - d)i
        return new Complex((this.a - secondComplex.a), (this.b - secondComplex.b));
    }

    public Complex multiply(Complex secondComplex) { // (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
        return new Complex(
                ((this.a * secondComplex.a) - (b * secondComplex.b)),
                ((this.b * secondComplex.a) + (this.a * secondComplex.b)));
    }

    public Complex divide(
            Complex secondComplex) { // (a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
        return new Complex(
                (((this.a * secondComplex.a) + (this.b * secondComplex.b))
                        / (((int) Math.pow(secondComplex.a, 2)) + (int) Math.pow(secondComplex.b, 2))),
                ((this.b * secondComplex.a) - (this.a * secondComplex.b))
                        / (((int) Math.pow(secondComplex.a, 2)) + (int) Math.pow(secondComplex.b, 2)));
    }

    public double abs() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public int compareTo(Complex o) {
        return 0;
    }
}
