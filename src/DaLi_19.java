import auxp.ch19.*;
import lib.Data.ListManip;
import lib.Misc.Randomizer;

import java.util.ArrayList;

public abstract class DaLi_19 {

    public static void main(String[] args) {
        ex10();

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
        MyAssociation<Integer,Double> asoc = new MyAssociation<>(1,3.33333);
        MyTransition<Character,String,Integer> trans = new MyTransition<>('A', "Hello", 111);
        System.out.println(asoc.toString());
        System.out.println(trans.toString());
    }
    public static void ex07() {//Sum of an association
        MyTransition<Integer,Double,Integer> trans = new MyTransition<>(1,3.33333,2);
        System.out.println(MyTransition.sum(trans));
    }
    public static void ex08() {//Shuffle ArrayList
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(6);
        ListManip.shuffle(nums);
        ListManip.printList(nums);
    }
    public static void ex09() {//Sort ArrayList
        ArrayList<Integer> nums = Randomizer.randomIntList(20, 100);
        ListManip.printList(nums, true);
        ListManip.sort(nums);
        ListManip.printList(nums, true);
    }
    public static void ex10() {
        ArrayList<Double> nums = Randomizer.randomDoubleList(20, 100);
        ListManip.printList(nums);
        System.out.println("MIN: " + ListManip.min(nums));
        System.out.println("MAX: " + ListManip.max(nums));
    }
    public static void ex11() {
    }
    public static void ex12() {
    }
}