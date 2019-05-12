import auxp.ch21.CountOccurrenceOfWords;
import auxp.ch21.CountOccurrenceOfWordsFile;
import lib.Data.ListManip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static lib.Misc.IO.println;
import static lib.Misc.IO.scanNext;

public abstract class DaLi_21 {

    public static void main(String[] args) {
        ex09();

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
    public static HashMap<String, Integer> ex03() {//Checking whether a key exists in a set
        HashSet<File> files = new HashSet<>();
        files.add(new File("src/res/txt/Biology.txt"));
        files.add(new File("src/res/txt/Chemistry.txt"));
        files.add(new File("src/res/txt/Geography.txt"));

        HashMap<String, Integer> names = new HashMap<>();

        for(File file : files){

            try(Scanner in = new Scanner(new FileInputStream(file))){
                while(in.hasNextLine()){
                    String name = in.nextLine();
                    if(names.containsKey(name)){
                        names.replace(name, names.get(name)+1);
                    }else{
                        names.put(name, 1);
                    }
                }
            } catch (IOException ignored) {}
        }
        //ListManip.printMap(names);
        return names;
    }
    public static void ex04() {//Count consonants and vowels
        File text = new File("src/res/txt/Lincoln.txt");
        HashSet<Character> vocals = new HashSet<>();
        vocals.add('a');
        vocals.add('e');
        vocals.add('i');
        vocals.add('o');
        vocals.add('u');

        int cNum=0;
        int vNum=0;

        try(InputStreamReader in = new InputStreamReader(new FileInputStream(text))){

            int int2char;
            while((int2char = in.read()) != -1){
                char c = (char)int2char;
                if(c >= 'a' && c<='z'){
                    if(vocals.contains(c))
                        vNum++;
                    else cNum++;
                }
            }
        }catch(Exception ignored){
            System.out.println("eerrr");
        }
        System.out.println(vNum + " vocals");
        System.out.println(cNum + " consonants");
    }
    public static void ex05() {//Syntax highlighting
    }
    public static void ex06() {//Count the occurrences of words/names
        TreeMap<String, Integer> names = new TreeMap<>(ex03());
        names.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
    public static void ex07() {//Revise Listing 21.9, CountOccurrenceOfWords.java
        CountOccurrenceOfWords.main(null);
    }
    public static void ex08() {//Count the occurrences of words in a text file
        CountOccurrenceOfWordsFile.main(null);
    }
    public static void ex09() {//Guess the capitals using maps
        HashMap<String,String> states = new HashMap<>();
        states.put("Alabama", "Montgomery");
        states.put("Alaska", "Juneau");
        states.put("Arizona", "Phoenix");
        int count = 0;
            for (Map.Entry<String,String> entries : states.entrySet()){

                String answer = scanNext("What is the capital of %s?", entries.getKey());
                if (answer.equalsIgnoreCase(entries.getValue())) {
                    println("Your answer is correct");
                    count++;
                } else println("Correct answer is %s", entries.getValue());
            }
        println("Correct count is %d", count);
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