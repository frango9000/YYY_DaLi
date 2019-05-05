import auxp.ch19.GenericStackArray;
import auxp.ch19.GenericStackInheritedList;

public abstract class DaLi_19 {

    public static void main(String[] args) {
        ex02();

    }

    public static void ex00() {
    }
    public static void ex01() {//Revising Listing 19.1
        GenericStackArray<Integer> numbers = new GenericStackArray<>();
        numbers.push(4);
        numbers.push(3);
        numbers.push(2);
        System.out.println(numbers.toString());

        GenericStackArray<String> names = new GenericStackArray<>();
        names.push("N1");
        names.push("N2");
        names.push("N1");
        System.out.println(names.toString());
    }
    public static void ex02() {//Implement GenericStack using inheritance
        GenericStackInheritedList<Double> numbers = new GenericStackInheritedList<>();
        numbers.push(6.98);
        numbers.push(2.01);
        numbers.push(7.45);
        System.out.println(numbers.toString());
    }
    public static void ex03() {
    }
    public static void ex04() {
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
}