package lib.Misc;

import lib.Data.ArrayManip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIn {

    public static String fileToString(File file) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) content.append(scan.nextLine()).append("\n");
        }
        return content.toString();
    }

    public static String[] fileToArray(File file) throws FileNotFoundException {
        return fileToString(file).split("\n");
    }

    public static int indexOfFirstOccurrence(File file, String line) throws FileNotFoundException {
        int lineNumber = 1;
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                if (scan.nextLine().equals(line)) return lineNumber;
                else lineNumber++;
            }
        }
        return -1;
    }

    public static int binarySearch(File file, String line) throws FileNotFoundException {
        String[] fileS = fileToArray(file);
        return ArrayManip.binarySearch(fileS, line);
    }

    /**
     * Recursive method to find al child Files
     *
     * @param file
     * @param list
     * @return
     */
    public static ArrayList<File> allSubFiles(File file, ArrayList<File> list) {
        if (!file.isDirectory()) {
            list.add(file);
        } else {
            File[] contents = file.listFiles();
            assert contents != null;
            for (File content : contents) {
                allSubFiles(content, list);
            }
        }
        return list;
    }
}
