import auxp.ch11.MyStack;
import auxp.ch13.BigRational;
import auxp.ch13.Complex;
import auxp.ch13.Rational;
import auxp.ch13.RationalCalculator;
import lib.Data.ListManip;
import lib.Geometry.*;
import lib.Misc.Calendar;
import lib.Misc.Randomizer;

import java.util.ArrayList;

import static lib.Misc.IO.print;
import static lib.Misc.IO.println;

public abstract class DaLi_13 {

    public static void main(String[] args) {
        ex19();
    }

    public static void ex00() {
    }

    public static void ex01() {
    }

    public static void ex02() { // Average ArrayList
        ArrayList<Integer> list = Randomizer.randomIntList(10, 100);
        double sum = ListManip.sum(list);
        double avg = (float) sum / list.size();
        print(avg);
    }

    public static void ex03() { // Sort ArrayList
        ArrayList<Integer> list = Randomizer.randomIntList(10, 100);
        ListManip.sort(list);
        print(list.toString());
    }

    public static void ex04() { // Display calendars
        print(Calendar.consoleCalendar(2019, 3));
    }

    public static void ex05() { // Enable GeometricObject comparable
        Circle circle = new Circle(5);
        Square square = new Square(10);

        print(circle.compareTo(square));
    }

    public static void ex06() { // The ComparableCircle class
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(6);
        print(circle.compareTo(circle2));
        print(circle2.compareTo(circle));
    }

    public static void ex07() { // The Colorable interface
    }

    public static void ex08() { // Revise the MyStack class
        MyStack ms = new MyStack();
        ms.push("hi");
        MyStack m2 = ms.deepCopy();
        println(ms);
        println(m2);
    }

    public static void ex09() { // Enable Circle comparable
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(6);
        print(circle.equals(circle2));
    }

    public static void ex10() { // Enable Rectangle comparable
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 20);
        println(r1.equals(r2));
    }

    public static void ex11() { // The Octagon class
        Octagon o1 = new Octagon(10);
        Octagon o2 = (Octagon) o1.clone();
        println(o1.equals(o2));
    }

    public static void ex12() { // Sum the areas of geometric objects
        Circle c1 = new Circle(5);
        Rectangle r1 = new Rectangle(10, 20);
        Octagon o1 = new Octagon(10);

        GeometricObject[] objects = {c1, r1, o1};
        println(GeometricObject.sumAreas(objects));
    }

    public static void ex13() {
    }

    public static void ex14() { // Demonstrate the benefits of encapsulation
        Rational rt = new Rational(10, 20);
    }

    public static void ex15() { // Use BigInteger for the Rational class
    }

    public static void ex16() { // Create a rational-number calculator
        RationalCalculator.main("5/2 * 4/3");
        // 5/2 * 4/3 = 10/3
    }

    public static void ex17() { // Math: The Complex class
        Complex num = new Complex(1, 2);
        print(num.abs());
    }

    public static void ex18() { // Use the Rational class
        int c = 1;
        Rational sum = new Rational();
        while (c < 50) {
            sum = sum.add(new Rational(c, c + 1));
            c += 2;
        }
        print(sum.toString());
    }

    public static void ex19() { // Convert decimals to fractions
        BigRational br = BigRational.decimalToRational("2.75");
        print(br.toString());
    }

    public static void ex20() {
    }

    public static void ex21() { // Algebra: vertex form equations
    }

    public static void ex22() {
    }
}
