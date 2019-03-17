import auxp.ch11.MyStack;
import lib.Data.ListManip;
import lib.Geometry.Circle;
import lib.Geometry.Rectangle;
import lib.Geometry.Square;
import lib.Misc.Calendar;
import lib.Misc.Randomizer;

import java.util.ArrayList;

import static lib.Misc.IO.print;
import static lib.Misc.IO.println;

public abstract class DaLi_13 {

    public static void main(String[] args) {
        ex10();

    }

    public static void ex00() {
    }
    public static void ex01() {
    }
    public static void ex02() {//Average ArrayList
        ArrayList<Integer> list = Randomizer.randomIntList(10, 100);
        int sum = ListManip.sum(list);
        double avg = (float) sum / list.size();
        print(avg);
    }
    public static void ex03() {//Sort ArrayList
        ArrayList<Integer> list = Randomizer.randomIntList(10, 100);
        ListManip.sort(list);
        print(list.toString());
    }
    public static void ex04() {//Display calendars
        print(Calendar.consoleCalendar(2019, 3));
    }
    public static void ex05() {//Enable GeometricObject comparable
        Circle circle = new Circle(5);
        Square square = new Square(10);

        print(circle.compareTo(square));
    }
    public static void ex06() {//The ComparableCircle class
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(6);
        print(circle.compareTo(circle2));
        print(circle2.compareTo(circle));
    }
    public static void ex07() {//The Colorable interface
    }
    public static void ex08() {//Revise the MyStack class
        MyStack ms = new MyStack();
        ms.push("hi");
        MyStack m2 = ms.deepCopy();
        println(ms);
        println(m2);
    }
    public static void ex09() {//Enable Circle comparable
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(6);
        print(circle.equals(circle2));
    }
    public static void ex10() {
    }
    public static void ex11() {
    }
    public static void ex12() {
    }
    public static void ex13() {
    }
    public static void ex14() {
    }
    public static void ex15() {
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
}