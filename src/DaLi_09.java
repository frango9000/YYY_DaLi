import lib.Data.ArrayManip;
import lib.Data.MatrixManip;
import lib.Geometry.Line;
import lib.Geometry.Point;
import lib.Geometry.Polygon;
import lib.Geometry.Rectangle;
import lib.Misc.Randomizer;
import lib.Misc.StopWatch;

import java.util.Date;
import java.util.GregorianCalendar;

import static lib.Misc.IO.print;
import static lib.Misc.IO.println;

public abstract class DaLi_09 {

    public static void main(String[] args) {
        ex13();
    }

    public static void ex00() {
    }

    public static void ex01() { // The Rectangle class
        Rectangle rect1 = new Rectangle(4, 40);
        Rectangle rect2 = new Rectangle(3.5, 35.9);

        println(
                "%.3f %.3f %.3f %.3f",
                rect1.getWidth(), rect1.getHeight(), rect1.getArea(), rect1.getPerimeter());
        println(
                "%.3f %.3f %.3f %.3f",
                rect2.getWidth(), rect2.getHeight(), rect2.getArea(), rect2.getPerimeter());
    }

    public static void ex02() { // The Stock class
    }

    public static void ex03() { // Use the Date class
        int exp = 18;
        for (int i = 1; i <= exp; i++) {
            Date date = new Date((long) Math.pow(10, i));
        }
    }

    public static void ex04() { // Use the Random class
        ArrayManip.printArray(Randomizer.randomIntsArray(50, 0, 100));
    }

    public static void ex05() { // Use the GregorianCalendar class
        GregorianCalendar gc1 = new GregorianCalendar();
        println(gc1.toString());
        println(
                gc1.get(GregorianCalendar.YEAR)
                        + " "
                        + gc1.get(GregorianCalendar.MONTH)
                        + " "
                        + gc1.get(GregorianCalendar.DAY_OF_MONTH));
        gc1.setTimeInMillis(1234567898765L);
        println(
                gc1.get(GregorianCalendar.YEAR)
                        + " "
                        + gc1.get(GregorianCalendar.MONTH)
                        + " "
                        + gc1.get(GregorianCalendar.DAY_OF_MONTH));
    }

    public static void ex06() { // Stopwatch
        int[][] table = Randomizer.randomIntsTable(400, 400, 100);
        StopWatch sw = new StopWatch();
        MatrixManip.sort(table);
        sw.stop();
        sw.consoleOutElapsedTime();
    }

    public static void ex07() { // The Account class
    }

    public static void ex08() { // Geometry: n-sided regular polygon
        Polygon poli1 = new Polygon(5, 6);
        print(poli1.getArea() + "" + poli1.getPerimeter());
    }

    public static void ex09() { // Algebra: quadratic equations
    }

    public static void ex10() { // Algebra: quadratic equations
    }

    public static void ex11() { // Algebra: 2 * 2 linear equations
    }

    public static void ex12() { // (Geometry: intersecting point
        Line l1 = new Line(new Point(1, 2), new Point(3, 4));
        Line l2 = new Line(new Point(2, 1), new Point(4, 3));

        print(l1.intersect(l2));
    }

    public static void ex13() { // The Location class
    }
}
