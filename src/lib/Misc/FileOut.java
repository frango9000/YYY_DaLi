package lib.Misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import lib.Data.ArrayManip;

public class FileOut {

    public static void printOnFile(File file, String string) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(string);
        }
    }

    public static void printOnFile(File file, String[] strings) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            for (String string : strings) {
                pw.println(string);
            }
        }
    }

    public static int addToSortedFile(File file, String string) throws FileNotFoundException {
        String[] f = FileIn.fileToArray(file);
        int i = ArrayManip.binarySearch(f, string);
        if (i > -1) {
            return i;
        }
        String[] g = new String[f.length + 1];
        System.arraycopy(f, 0, g, 0, f.length);
        g[f.length] = string;
        ArrayManip.bubbleSort(g);
        FileOut.printOnFile(file, g);
        return ArrayManip.binarySearch(g, string);
    }

    public static void appendOnFile(File file, String string) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.println(string);
        }
    }

    public static void appendOnFile(File file, String[] strings) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            for (String string : strings) {
                pw.println(string);
            }
        }
    }

    public static void prependOnFile(File file, String string) throws IOException {
        String fileStr = FileIn.fileToString(file);
        FileOut.printOnFile(file, string);
        FileOut.appendOnFile(file, fileStr);
    }

    public static void prependOnFile(File file, String[] strings) throws IOException {
        String[] array = FileIn.fileToArray(file);
        FileOut.printOnFile(file, strings);
        FileOut.appendOnFile(file, array);
    }
}
