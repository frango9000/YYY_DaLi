import lib.Data.ListManip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public abstract class DaLi_21 {

    public static void main(String[] args) {
        ex03();

    }

    public static void ex00() {
    }

    public static void ex01() {//Perform set operations on hash sets
        String[] s1 = {"Chemistry", "Mathematics", "Biology", "English"};
        String[] s2 = {"Biology", "English", "Geography", "Physics"};

        HashSet<String> hs1 = new HashSet<>(Arrays.asList(s1));
        HashSet<String> hs2 = new HashSet<>(Arrays.asList(s2));

        HashSet<String> a1 = new HashSet<>(hs1);
        a1.removeAll(hs2);

        HashSet<String> a2 = new HashSet<>(hs2);
        a2.removeAll(hs1);

        HashSet<String> a3 = new HashSet<>(hs1);
        a3.retainAll(hs2);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
    public static void ex02() {//Display nonduplicate names in ascending order
        HashSet<File> files = new HashSet<>();
        files.add(new File("src/res/txt/Biology.txt"));
        files.add(new File("src/res/txt/Chemistry.txt"));
        files.add(new File("src/res/txt/Geography.txt"));

        HashSet<String> names = new HashSet<>();

        for(File file : files){

            try(Scanner in = new Scanner(new FileInputStream(file))){
                while(in.hasNextLine()){
                    names.add(in.nextLine());
                }
            } catch (IOException ignored) {}
        }
        ListManip.printList(names);
    }
    public static void ex03() {//Checking whether a key exists in a set
    }
    public static void ex04() {//Count consonants and vowels
    }
    public static void ex05() {//Syntax highlighting
    }
    public static void ex06() {//Count the occurrences of words/names
    }
    public static void ex07() {//Revise Listing 21.9, CountOccurrenceOfWords.java
    }
    public static void ex08() {//Count the occurrences of words in a text file
    }
    public static void ex09() {//Guess the capitals using maps
    }
    public static void ex10() {//Count the occurrences of each keyword
    }
    public static void ex11() {//Baby name popularity ranking
    }
    public static void ex12() {//Name for both genders
    }
    public static void ex13() {//Baby name popularity ranking
    }
    public static void ex14() {//Web crawler
    }
    public static void ex15() {//Addition quiz
    }
}