import auxp.ch10.MyInteger;
import auxp.ch10.QueueOfIntegers;
import auxp.ch10.StackOfIntegers;
import lib.Geometry.Circle;
import lib.Geometry.Point;
import lib.Geometry.Rectangle;
import lib.Geometry.Triangle;
import lib.Math.Primes;
import lib.Misc.Calendar;
import lib.Misc.Time;

import static lib.Misc.IO.*;

public abstract class DaLi_10 {

    public static void main(String[] args) {
        ex15();

    }

    public static void ex00() {
    }

    public static void ex01() {//The Time class
        Time now = new Time();
        print(now.timeToString());
    }

    public static void ex02() {//The BMI class
    }

    public static void ex03() {//The MyInteger class
        MyInteger i = new MyInteger(5);
        print(i.isPrime());
    }

    public static void ex04() {//The MyPoint class
        Point p1 = new Point(2, 3);
        Point p2 = new Point(6, 8);
        print(p1.distanceBetweenPoints(p2));
    }

    public static void ex05() {//Display the prime factors
        int number = scanInt("Enter a number");

        StackOfIntegers stack = new StackOfIntegers(Primes.getPrimeFactors(number));
        while (!stack.empty()) {
            println(stack.pop());
        }
    }

    public static void ex06() {//Display the prime numbers
        int number = scanInt("Enter a number");

        StackOfIntegers stack = new StackOfIntegers(Primes.listOfPrimesUntil(number));
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

    public static void ex10() {//The Queue class
        int number = scanInt("Enter a number");

        QueueOfIntegers stack = new QueueOfIntegers(Primes.getPrimeFactors(number));
        while (!stack.empty()) {
            println(stack.pop());
        }
    }

    public static void ex11() {//Geometry: the Circle2D class
        Circle c = new Circle(50);
        print(c.radius + " " + c.perimeter() + " " + c.overlaps(c));
    }

    public static void ex12() {//Geometry: the Triangle2D class
        Triangle c = new Triangle(new Point(2, 3), new Point(5, 6), new Point(-15, 8));
        print(c.area() + " " + c.perimeter() + " " + c.contains(new Point(3, 4)));
    }

    public static void ex13() {//Geometry: the MyRectangle2D class
        Rectangle r1 = new Rectangle(2,2,new Point(5.5,4.9));
        System.out.println(r1.contains(new Point(3,3)));
        System.out.println(r1.contains(new Rectangle(3,5,new Point(10.5,3.2))));
        System.out.println(r1.overlaps(new Rectangle(3,5,new Point(2.3,5.4))));
    }

    public static void ex14() {//The MyDate class
        Calendar c = new Calendar(561555550000L);
        print(c.toString());
        c = new Calendar();
        print(c.toString());
    }

    public static void ex15() {//Geometry: the bounding rectangle
        Point p1 = new Point(1,2.5);
        Point p2 = new Point(3,4);
        Point p3 = new Point(5,6);
        Point p4 = new Point(7,8);
        Point p5 = new Point(9,10);

        Rectangle rb = Rectangle.boundingRectangle(p1,p2,p3,p4,p5);
        print(rb.area() + " " + rb.perimeter() + " " + rb.getHeight() + " " + rb.getWidth() + " " + rb.getCenter());
    }

    public static void ex16() {
    }

    public static void ex17() {
    }

    public static void ex18() {
    }

    public static void ex19() {
    }

    public static void ex20() {
    }

    public static void ex21() {
    }

    public static void ex22() {
    }

    public static void ex23() {
    }

    public static void ex24() {
    }

    public static void ex25() {
    }

    public static void ex26() {
    }

    public static void ex27() {
    }

    public static void ex28() {
    }
}