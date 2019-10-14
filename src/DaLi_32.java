import auxp.ch32.Ex01Thread;
import auxp.ch32.Ex01ThreadB;
import auxp.ch32.Ex04;

public abstract class DaLi_32 {

    public static void main(String[] args) {
        ex04();
    }

    public static void ex00() {
    }

    public static void ex01() {
        Ex01Thread t1 = new Ex01Thread("A");
        Ex01Thread t2 = new Ex01Thread("B");
        Ex01ThreadB t3 = new Ex01ThreadB();
        t1.start();
        t2.start();
        t3.start();
    }

    public static void ex02() {
    }

    public static void ex03() {
    }

    public static void ex04() {
        Integer num = 1;

        for (int i = 0; i < 1000; i++) {
            Ex04 t = new Ex04(num);
            t.start();
        }

    }

    public static void ex05() {
    }

    public static void ex06() {
    }

    public static void ex07() {
    }

    public static void ex08() {
    }

    public static void ex09() {
    }

    public static void ex10() {
    }

    public static void ex11() {
    }

    public static void ex12() {
    }

    public static void ex13() {
    }
}
