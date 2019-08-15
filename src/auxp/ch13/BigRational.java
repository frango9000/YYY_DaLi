package auxp.ch13;

import java.math.BigInteger;

public class BigRational extends Number implements Comparable {
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];

    /**
     * Construct a ratinoal with default properties
     */
    public BigRational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Construct a rational with specifiec numerator and denominator
     */
    public BigRational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        r[0] =
                (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : new BigInteger("-1"))
                        .multiply(numerator.divide(gcd));
        r[1] = denominator.divide(gcd);
    }

    /**
     * Find GCD of two numbers
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n;
        BigInteger n2 = d;
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE;
             k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0;
             k = k.add(BigInteger.ONE)) {
            if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0
                    && n2.remainder(k).compareTo(BigInteger.ZERO) == 0) gcd = k;
        }

        return gcd;
    }

    public static BigRational decimalToRational(String number) {
        String[] decimal = number.split("[.]");
        BigRational r1 = new BigRational(new BigInteger(decimal[0]), BigInteger.ONE);
        BigRational r2 =
                new BigRational(
                        new BigInteger(decimal[1]),
                        new BigInteger(String.valueOf((int) Math.pow(10, decimal[1].length()))));
        return decimal[0].charAt(0) == '-' ? (r1).subtract(r2) : (r1).add(r2);
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return r[0];
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return r[1];
    }

    /**
     * Add a rational number to this rational
     */
    public BigRational add(BigRational secondRational) {
        BigInteger n =
                (r[0].multiply(secondRational.getDenominator()))
                        .add(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new BigRational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public BigRational subtract(BigRational secondRational) {
        BigInteger n =
                (r[0].multiply(secondRational.getDenominator()))
                        .subtract(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new BigRational(n, d);
    }

    /**
     * Mulitply a rational number by this rational
     */
    public BigRational multiply(BigRational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getNumerator());
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new BigRational(n, d);
    }

    /**
     * Divide a rational number by this rational
     */
    public BigRational divide(BigRational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator());
        BigInteger d = r[1].multiply(secondRational.getNumerator());
        return new BigRational(n, d);
    }

    @Override
    public String toString() {
        if (r[1].compareTo(BigInteger.ONE) == 0) return r[0] + "";
        else return r[0] + "/" + r[1];
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        return ((this.subtract((BigRational) (other))).getNumerator()).compareTo(BigInteger.ZERO) == 0;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return this.getNumerator().doubleValue() / this.getDenominator().doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public int compareTo(Object o) {
        BigInteger n = this.subtract((BigRational) o).getNumerator();
        if (n.compareTo(BigInteger.ZERO) > 0) return 1;
        else if (n.compareTo(BigInteger.ZERO) < 0) return -1;
        else return 0;
    }
}
