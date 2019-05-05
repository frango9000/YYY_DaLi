import auxp.ch19.GenericStackArray;
import auxp.ch19.GenericStackInheritedList;
import auxp.ch19.MyPair;
import auxp.ch19.MyTriplet;

public abstract class DaLi_19 {

    public static void main(String[] args) {
        ex05();

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
    public static void ex03() {//(MyPair of objects of the same type
        MyPair<Character> pair = new MyPair<>('a', 'z');
        System.out.println(pair.toString());
    }
    public static void ex04() {//Using wildcards
        MyPair<Double> pair = new MyPair<>(3.14, 1.8888);
        System.out.println(pair.toString());
        System.out.println(MyPair.min(pair));
    }
    public static void ex05() {//Inheritance between generic classes
        MyTriplet<Double> triple = new MyTriplet<>(2.1, 3.3333, 99.99999);
        System.out.println(triple.toString());
    }
    public static void ex06() {//Several types
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