import static lib.Misc.IO.println;
import static lib.Misc.IO.scanNext;

import auxp.MainFX;
import auxp.ch14.MyHangman;
import auxp.ch20.BouncingBallsPane;
import auxp.ch20.CalendarComparator;
import auxp.ch20.LinkedNumbersPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import javafx.application.Application;
import lib.Data.ListManip;
import lib.Misc.Randomizer;
import lib.Misc.StopWatch;

public abstract class DaLi_20 {

    public static void main(String[] args) {

        ex10();
    }

    public static void ex00() {
    }

    public static void ex01() { // Display words in descending alphabetical order
        File lorem = new File("src/res/txt/lorem.txt");
        ArrayList<String> words = new ArrayList<>();

        try (Scanner scan = new Scanner(lorem).useDelimiter("[ .,:;\n]")) {
            while (scan.hasNext()) {
                String newWord = scan.next().trim();
                if (!(newWord.length() < 1 || " ".equals(newWord))) {
                    words.add(newWord);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //        words.sort(new Comparator<String>() {
        //            @Override
        //            public int compare(String o1, String o2) {
        //                return Integer.compare(0, o1.compareTo(o2));
        //
        //            }
        //        });
        words.sort((o1, o2) -> Integer.compare(0, o1.compareTo(o2)));
        ListManip.printList(words);
    }

    public static void ex02() { // Store numbers in a linked list
        MainFX.initializeToolkit(); // JavaFX toolkit init
        MainFX ui = new MainFX(new LinkedNumbersPane());
        ui.show();
    }

    public static void ex03() { // Guessing the capitals
        ArrayList<String> states = new ArrayList<>();
        states.add("Alabama");
        states.add("Alaska");
        states.add("Arizona");
        ArrayList<String> capitals = new ArrayList<>();
        capitals.add("Montgomery");
        capitals.add("Juneau");
        capitals.add("Phoenix");
        ArrayList<Integer> shuffled = new ArrayList<>();
        for (String state : states) {
            shuffled.add(states.indexOf(state));
        }
        ListManip.shuffle(shuffled);
        int count = 0;
        for (int i = 0; i < shuffled.size(); i++) {
            String answer = scanNext("What is the capital of %s?", states.get(shuffled.get(i)));
            if (answer.equalsIgnoreCase(capitals.get(shuffled.get(i)))) {
                println("Your answer is correct");
                count++;
            } else {
                println("Correct answer is %s", capitals.get(shuffled.get(i)));
            }
        }
        println("Correct count is %d", count);
    }

    public static void ex04() { // Implement Comparable
        ArrayList<GregorianCalendar> calendars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(Math.abs(Randomizer.randomLong()));
            calendars.add(gc);
        }
        calendars.sort(new CalendarComparator());
        for (GregorianCalendar calendar : calendars) {
            System.out.printf(
                "%d-%d-%d%n",
                calendar.get(GregorianCalendar.DAY_OF_MONTH),
                calendar.get(GregorianCalendar.MONTH) + 1,
                calendar.get(GregorianCalendar.YEAR));
        }
    }

    public static void ex05() { // Combine colliding bouncing balls
        Application.launch(BouncingBallsPane.class, "");
    }

    public static void ex06() { // Use iterators on ArrayList
        int size = 10000000;
        StopWatch sw0 = new StopWatch();
        ArrayList<Integer> millions = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            millions.add(i);
        }
        sw0.stop();

        StopWatch sw1 = new StopWatch();
        millions.get(size - 1);
        sw1.stop();

        Iterator<Integer> it = millions.iterator();
        StopWatch sw2 = new StopWatch();
        int number;
        while (it.hasNext()) {
            it.next();
        }
        sw2.stop();

        StopWatch sw3 = new StopWatch();
        ListIterator<Integer> it2 = millions.listIterator();
        try {
            while (true) {
                it2.next();
            }
        } catch (NoSuchElementException ignored) {
        }
        it2.previous();
        sw3.stop();

        System.out.println(sw0.getElapsedFormat());
        System.out.println(sw1.getElapsedFormat());
        System.out.println(sw2.getElapsedFormat());
        System.out.println(sw3.getElapsedFormat());
    }

    public static void ex07() { // Game: hangman
        MainFX.initializeToolkit(); // JavaFX toolkit init
        MainFX ui = new MainFX(new MyHangman());
        ui.show();
    }

    public static void ex08() { // Game: lottery
    }

    public static void ex09() { // Remove the largest ball first
        Application.launch(BouncingBallsPane.class, "");
    }

    public static void ex10() { // Perform set operations on priority queues
        Stack<String> s1 = new Stack<>();
        s1.push("Chemistry");
        s1.push("Mathematics");
        s1.push("Biology");
        s1.push("English");

        Stack<String> s2 = new Stack<>();
        s2.push("Biology");
        s2.push("English");
        s2.push("Geography");
        s2.push("Physics");

        for (String string : s1) {
            if (!s2.contains(string)) {
                System.out.println(string);
            }
        }

        System.out.println();

        for (String string : s2) {
            if (s1.contains(string)) {
                System.out.println(string);
            }
        }
        System.out.println();

        for (String string : s2) {
            if (!s1.contains(string)) {
                System.out.println(string);
            }
        }
    }

    public static void ex11() { // Remove Consecutive Integers
    }

    public static void ex12() { // Create Stack from list
    }

    public static void ex13() { // Postfix notation
    }

    public static void ex14() { // Postfix notation
    }

    public static void ex15() { // Game: the 24-point card game
    }

    public static void ex16() { // Game: the 24-point card game
    }

    public static void ex17() { // Game: the 24-point card game
    }

    public static void ex18() { // Directory size
    }

    public static void ex19() { // Use Comparator
    }

    public static void ex20() { // Nonrecursive Tower of Hanoi
    }

    public static void ex21() { // Use Comparator
    }

    public static void ex22() { // Nonrecursive Tower of Hanoi
    }

    public static void ex23() { // Evaluate expression
    }
}
