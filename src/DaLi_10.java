import auxp.ch10.MyInteger;
import auxp.ch10.MyString;
import auxp.ch11.QueueOfIntegers;
import auxp.ch11.StackOfIntegers;
import lib.Geometry.Circle;
import lib.Geometry.Point;
import lib.Geometry.Rectangle;
import lib.Geometry.Triangle;
import lib.Math.Primes;
import lib.Misc.Calendar;
import lib.Misc.Time;

import java.math.BigInteger;
import java.util.ArrayList;

import static lib.Misc.IO.*;

public abstract class DaLi_10 {

    public static void main(String[] args) {
        ex24();
    }

    public static void ex00() {
    }

    public static void ex01() { // The Time class
        Time now = new Time();
        print(now.timeToString());
    }

    public static void ex02() { // The BMI class
    }

    public static void ex03() { // The MyInteger class
        MyInteger i = new MyInteger(5);
        print(i.isPrime());
    }

    public static void ex04() { // The MyPoint class
        Point p1 = new Point(2, 3);
        Point p2 = new Point(6, 8);
        print(p1.distanceBetweenPoints(p2));
    }

    public static void ex05() { // Display the prime factors
        int number = scanInt("Enter a number");

        StackOfIntegers stack = new StackOfIntegers(Primes.getPrimeFactors(number));
        while (!stack.empty()) {
            println(stack.pop());
        }
    }

    public static void ex06() { // Display the prime numbers
        int number = scanInt("Enter a number");

        StackOfIntegers stack = new StackOfIntegers(Primes.arrayOfPrimes(number));
        while (!stack.empty()) {
            println(stack.pop());
        }
    }

    public static void ex07() {
    }

    public static void ex08() {
    }

    public static void ex09() {
    }

    public static void ex10() { // The Queue class
        int number = scanInt("Enter a number");

        QueueOfIntegers stack = new QueueOfIntegers(Primes.getPrimeFactors(number));
        while (!stack.empty()) {
            println(stack.pop());
        }
    }

    public static void ex11() { // Geometry: the Circle2D class
        Circle c = new Circle(50);
        print(c.radius + " " + c.getPerimeter() + " " + c.overlaps(c));
    }

    public static void ex12() { // Geometry: the Triangle2D class
        Triangle c = new Triangle(new Point(2, 3), new Point(5, 6), new Point(-15, 8));
        print(c.getArea() + " " + c.getPerimeter() + " " + c.contains(new Point(3, 4)));
    }

    public static void ex13() { // Geometry: the MyRectangle2D class
        Rectangle r1 = new Rectangle(2, 2, new Point(5.5, 4.9));
        System.out.println(r1.contains(new Point(3, 3)));
        System.out.println(r1.contains(new Rectangle(3, 5, new Point(10.5, 3.2))));
        System.out.println(r1.overlaps(new Rectangle(3, 5, new Point(2.3, 5.4))));
    }

    public static void ex14() { // The MyDate class
        Calendar c = new Calendar(561555550000L);
        print(c.toString());
        c = new Calendar();
        print(c.toString());
    }

    public static void ex15() { // Geometry: the bounding rectangle
        Point p1 = new Point(1, 2.5);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        Point p5 = new Point(9, 10);

        Rectangle rb = Rectangle.boundingRectangle(p1, p2, p3, p4, p5);
        print(
                rb.getArea()
                        + " "
                        + rb.getPerimeter()
                        + " "
                        + rb.getHeight()
                        + " "
                        + rb.getWidth()
                        + " "
                        + rb.getCenter());
    }

    public static void ex16() { // Divisible by 2 or 3 BigInteger

        int count = 0;
        BigInteger n = new BigInteger("10000000000000000000000000000000000000000000000000");
        BigInteger z = new BigInteger("0");

        while (count < 10) {
            if (z.compareTo(n.remainder(new BigInteger("2"))) == 0
                    || z.compareTo(n.remainder(new BigInteger("3"))) == 0) {
                println(n);
                count++;
            }
            n = n.add(new BigInteger("1"));
        }
    }

    public static void ex17() { // Square numbers
        long l = Long.MAX_VALUE;
        println(l);
        long minsq = (long) Math.sqrt(l);
        minsq++;

        int count = 0;

        while (count < 10) {
            BigInteger bg = new BigInteger(String.valueOf(minsq)).pow(2);
            println(bg.toString() + " " + minsq++);
            count++;
        }
    }

    public static void ex18() { // Large prime numbers

        int count = 0;
        BigInteger n = new BigInteger(Long.MAX_VALUE + "");

        while (count < 5) {
            n = n.add(new BigInteger("1"));
            if (Primes.isPrime(n)) {
                count++;
                println(n);
            }
        }
    }

    public static void ex19() { // Mersenne prime
        ArrayList<Integer> list = Primes.listOfNPrimes(100);
        for (int i = 0; i < 100; i++) {
            BigInteger mrsp = new BigInteger("2").pow(list.get(i));
            println("%3d %30s", list.get(i), mrsp.toString());
        }
    }

    public static void ex20() {
    }

    public static void ex21() {
    }

    public static void ex22() { // Implement the String class
        MyString ms = new MyString("String blt");
        ms.print();
    }

    public static void ex23() { // Implement the String class
        MyString ms = new MyString("String alt");
        ms.print();
    }

    public static void ex24() { // Implement the Character class
    }

    public static void ex25() { // New string split method
    }

    public static void ex26() { // Calculator
        auxp.ch10.Calculator.main("2 + 2");
    }

    public static void ex27() {
    }

    public static void ex28() {
    }
}
