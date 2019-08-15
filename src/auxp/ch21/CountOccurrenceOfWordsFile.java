package auxp.ch21;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrenceOfWordsFile {
    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();

        File file = new File("src/res/txt/Lincoln.txt");

        try (Scanner in = new Scanner(new FileInputStream(file)).useDelimiter("[ ,.;:?'\"()\n]*")) {
            while (in.hasNext()) {
                String next = in.next().toLowerCase();
                if (map.containsKey(next)) {
                    map.replace(next, map.get(next) + 1);
                } else map.put(next, 1);
            }
        } catch (Exception ignored) {
        }
        // Create a TreeMap to hold words as key and count as value

        // Display key and value for each entry
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
