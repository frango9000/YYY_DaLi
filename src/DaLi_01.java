import lib.Geometry.Circle;
import lib.Geometry.Rectangle;
import lib.Math.Algebra;
import lib.Math.Scales;
import lib.Misc.Calendar;

import static lib.Misc.IO.println;

public abstract class DaLi_01 {

    public static void main(String[] args) {
        ex13();
    }

    public static void ex00() {
    }

    public static void ex01() { // Display three messages
        println("Welcome to Java");
    }

    public static void ex02() { // Display five message
        println("I Love Java");
        println("I Love Java");
        println("I Love Java");
        println("I Love Java");
        println("I Love Java");
    }

    public static void ex03() { // Display a pattern
        println("J");
        println("J aaa v vaaa");
        println("J J aa v v a a");
        println("J aaaa v aaaa");
    }

    public static void ex04() { // Print a table
        println("a      a^2     a^3     a^4");
        println(1 + "   " + 1 + "   " + 1 + "   " + 1);
        println(2 + "   " + 2 * 2 + "   " + 2 * 2 * 2 + "   " + 2 * 2 * 2 * 2);
        println(3 + "   " + 3 * 3 + "   " + 3 * 3 * 3 + "   " + 3 * 3 * 3 * 3);
        println(4 + "   " + 4 * 4 + "   " + 4 * 4 * 4 + "   " + 4 * 4 * 4 * 4);
    }

    public static void ex05() { // Compute expressions
        println("result: " + (7.5 * 6.5 - 4.5 * 3) / (47.5 - 5.5));
    }

    public static void ex06() { // Summation of a series
        println("result: " + (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
    }

    public static void ex07() { // Approximate p
        final double PI_a = 4 * (1.0 - (1 / 3) + (1 / 5) - (1 / 7) + (1 / 9) - (1 / 11));
        final double PI_b = 4 * (1.0 - (1 / 3) + (1 / 5) - (1 / 7) + (1 / 9) - (1 / 11) + (1 / 13));
        println(PI_a);
        println(PI_b);
    }

    public static void ex08() { // Area and getPerimeter of a circle
        Circle circle = new Circle(6.5f);
        println("Circle Perimeter: " + circle.getPerimeter());
        println("Circle Area: " + circle.getArea());
    }

    public static void ex09() { // Area and getPerimeter of a rectangle
        Rectangle rectangle = new Rectangle(5.3f, 8.6f);
        println("Rectangle Perimeter: " + rectangle.getPerimeter());
        println("Rectangle Area: " + rectangle.getArea());
    }

    public static void ex10() { // Average speed in miles
        println("Average Speed: " + (Scales.kilometerToMile(15f) / (50.5f / 60f)) + "miles per hour.");
    }

    public static void ex11() { // Population projection
        int secondsInADay = 86400;
        float birthsPerDay = secondsInADay / 7f;
        float deathsPerDay = secondsInADay / 13f;
        float immigrantsPerDay = secondsInADay / 45f;
        float changePerDay = birthsPerDay - deathsPerDay + immigrantsPerDay;
        float changePerYear = changePerDay * 365;
        int startPopulation = 312032486;

        println("Year 0 : " + startPopulation);
        println("Year 1 : " + (startPopulation + (int) changePerYear));
        println("Year 2 : " + (startPopulation + (int) (changePerYear * 2)));
        println("Year 3 : " + (startPopulation + (int) (changePerYear * 3)));
        println("Year 4 : " + (startPopulation + (int) (changePerYear * 4)));
        println("Year 5 : " + (startPopulation + (int) (changePerYear * 5)));
    }

    public static void ex12() { // Average speed in kilometers
        println(
                "Average Speed: "
                        + (Scales.mileToKilometer(24f)
                        / (1f + Calendar.minutesToHours(40) + Calendar.secondsToHours(35)))
                        + " km per hour.");
    }

    public static void ex13() { // Algebra: solve 2 * 2 linear equations
        double[] xy = Algebra.linear2x2Equation(3.4f, 50.2f, 2.1f, 0.55f, 44.5f, 5.9f);
        println("x: " + xy[0] + "\ny: " + xy[1]);
    }
}
