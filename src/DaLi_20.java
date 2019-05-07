import auxp.MainFX;
import auxp.ch20.LinkedNumbersPane;
import lib.Data.ListManip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DaLi_20 {

    public static void main(String[] args) {
        MainFX.initializeToolkit();//JavaFX toolkit init

        ex02();

    }

    public static void ex00() {
    }
    public static void ex01() {//Display words in descending alphabetical order
        File lorem = new File("src/res/txt/lorem.txt");
        ArrayList<String> words = new ArrayList<>();

        try(Scanner scan = new Scanner(lorem).useDelimiter("[ .,:;\n]")){
            while(scan.hasNext()){
                String newWord = scan.next().trim();
                if(!(newWord.length()<1 || " ".equals(newWord)))
                    words.add(newWord);
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
        words.sort((o1,o2) -> Integer.compare(0, o1.compareTo(o2)));
        ListManip.printList(words);
    }
    public static void ex02() {//Store numbers in a linked list
        MainFX ui = new MainFX(new LinkedNumbersPane());
        ui.go();
    }
    public static void ex03() {//Guessing the capitals
    }
    public static void ex04() {//Implement Comparable
    }
    public static void ex05() {//Combine colliding bouncing balls
    }
    public static void ex06() {//Use iterators on ArrayList
    }
    public static void ex07() {//Game: hangman
    }
    public static void ex08() {//Game: lottery
    }
    public static void ex09() {//Remove the largest ball first
    }
    public static void ex10() {//Perform set operations on priority queues
    }
    public static void ex11() {//Remove Consecutive Integers
    }
    public static void ex12() {//Create Stack from list
    }
    public static void ex13() {//Postfix notation
    }
    public static void ex14() {//Postfix notation
    }
    public static void ex15() {//Game: the 24-point card game
    }
    public static void ex16() {//Game: the 24-point card game
    }
    public static void ex17() {//Game: the 24-point card game
    }
    public static void ex18() {//Directory size
    }
    public static void ex19() {//Use Comparator
    }
    public static void ex20() {//Nonrecursive Tower of Hanoi
    }
    public static void ex21() {//Use Comparator
    }
    public static void ex22() {//Nonrecursive Tower of Hanoi
    }
    public static void ex23() {//Evaluate expression
    }
}