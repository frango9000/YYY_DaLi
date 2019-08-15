package lib.Math;

import java.util.Arrays;

public abstract class Algebra {
    public static double[] linear2x2Equation(
            double a, double b, double c, double d, double e, double f) {

        // ax+by=e
        // cx+dy=f
        double discriminant = (a * d) - (b * c);

        if (discriminant == 0) return null;
        double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
        double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
        double[] z = {x, y};
        return z;
    }

    public static double[] quadraticEquation(double a, double b, double c) {
        //
        //
        double[] r;
        double discriminant = (b * b) - (4f * a * c);
        if (discriminant > 0) {
            r = new double[2];
            r[0] = (-b + Math.sqrt(discriminant)) / (2f * a);
            r[1] = (-b - Math.sqrt(discriminant)) / (2f * a);

        } else if (discriminant == 0) {
            r = new double[1];
            r[0] = (-b + Math.sqrt(discriminant)) / (2f * a);
        } else {
            return null;
        }
        return r;
    }

    public static int greatestCommonFactor(int a, int b) {
        int t = 0;
        if (a == b) return a;
        else if (a == 0 || b == 0) return 1;
        else if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        for (int i = a; i > 0; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return -1; // bug
    }

    public static double pi() {
        double PI = 0.0;
        for (int i = 100000; i > 0; i--) PI += Math.pow(-1, i + 1) / (2 * i - 1);
        return PI * 4;
    }

    public static long factorial(int number) {
        long prod = 1;
        for (int i = 1; i <= number; i++) prod = prod * i;
        return prod;
    }

    public static double calcE() {
        double e = 1;
        for (int i = 64; i > 0; i--) e = e + 1 / (double) (factorial(i));
        return e;
    }

    public static int[] listOfDivisors(int number) {
        int[] list = new int[number / 2];
        int count = 0;
        for (int i = 1; i <= number / 2; i++) if (number % i == 0) list[count++] = i;
        return Arrays.copyOf(list, count);
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        int[] divisors = listOfDivisors(number);
        for (int divisor : divisors) sum += divisor;
        return sum == number;
    }

    public static int pentagonalNumber(int index) {
        return index * ((3 * index) - 1) / 2;
    }

    public static long sumOfDigits(long number) {
        int sum = 0;
        int size = String.valueOf(number).length();
        for (int i = 0; i <= size; i++) {
            sum += number % 10;
            number /= 10;
        }
        return sum + number;
    }

    private static int leastCommonMultiple(int a, int b) {
        return a * (b / greatestCommonDivisor(a, b));
    }

    public static int leastCommonMultiple(int... numbers) {
        return Arrays.stream(numbers).reduce(1, (x, y) -> x * (y / greatestCommonDivisor(x, y)));
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        else return (greatestCommonDivisor(b, a % b));
    }

    public static int greatestCommonDivisor(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = greatestCommonDivisor(result, numbers[i]);
        }
        return result;
    }

    public static int min(int... numbers) {
        int min = numbers[0];
        for (int e : numbers) {
            if (e < min) min = e;
        }
        return min;
    }

    public static int max(int... numbers) {
        int max = numbers[0];
        for (int e : numbers) {
            if (e > max) max = e;
        }
        return max;
    }

    public static double min(double... numbers) {
        double min = numbers[0];
        for (double e : numbers) {
            if (e < min) min = e;
        }
        return min;
    }

    public static double max(double... numbers) {
        double max = numbers[0];
        for (double e : numbers) {
            if (e > max) max = e;
        }
        return max;
    }
}
