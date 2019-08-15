package lib.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import lib.Data.ArrayManip;

public abstract class Randomizer {

    public static Random random() {
        return new Random();
    }

    public static int randomInt() {
        return random().nextInt();
    }

    public static int randomInt(int highBound) { // high bound is exclusive, low bound is 0
        return random().nextInt(highBound);
    }

    public static int randomInt(int lowBound, int highBound) {
        return lowBound + random().nextInt(highBound - lowBound);
    }

    public static long randomLong() {
        return random().nextLong();
    }

    public static double randomDouble() {
        return random().nextDouble();
    }

    public static double randomDouble(double highBound) {
        return randomDouble(0, highBound);
    }

    public static double randomDouble(double lowBound, double highBound) {
        double random = random().nextDouble();
        return lowBound + (random * (highBound - lowBound));
    }

    public static int[] randomIntsArray(
        int elements, int lowBound, int highBound) { // high bound is exclusive
        int range = highBound - lowBound;
        int[] randoms = new int[elements];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = randomInt(range) + lowBound;
        }
        return randoms;
    }

    public static int[] randomIntsArray(int elements, int highBound) {
        return randomIntsArray(elements, 0, highBound);
    }

    public static int[] randomIntsArray(int elements) {
        return randomIntsArray(elements, Integer.MAX_VALUE);
    }

    public static int[][] randomIntsTable(int rows, int columns, int lowBound, int highBound) {
        int[][] table = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            table[i] = randomIntsArray(columns, lowBound, highBound);
        }
        return table;
    }

    public static int[][] randomIntsTable(int rows, int columns, int highBound) {
        return randomIntsTable(rows, columns, 0, highBound);
    }

    public static int[][] randomIntsTable(int rows, int columns) {
        return randomIntsTable(rows, columns, 0, Integer.MAX_VALUE);
    }

    public static int[] randomUniqueIntsArray(int elements, int lowBound, int highBound) {
        int range = highBound - lowBound + 1;
        if (range >= elements) {
            int[] randoms = new int[elements];
            Arrays.fill(randoms, Integer.MAX_VALUE);
            for (int i = 0; i < randoms.length; ) {
                int randomCandidate = randomInt(range) + lowBound;
                if (!ArrayManip.contains(randoms, randomCandidate)) {
                    randoms[i] = randomCandidate;
                    i++;
                }
            }
            return randoms;
        } else {
            return null;
        }
    }

    public static int[] randomUniqueIntsArray(int elements, int highBound) {
        return randomUniqueIntsArray(elements, 0, highBound);
    }

    public static int[] randomUniqueIntsArray(int elements) {
        return randomUniqueIntsArray(elements, Integer.MAX_VALUE);
    }

    public static double[] randomDoublesArray(int elements, double lowBound, double highBound) {
        int precision = 100000000;
        double range = (highBound - lowBound) * precision;
        double[] randoms = new double[elements];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = (randomInt((int) range) + (precision * lowBound)) / precision;
        }
        return randoms;
    }

    public static double[] randomDoublesArray(int elements, double highBound) {
        return randomDoublesArray(elements, 0, highBound);
    }

    public static double[] randomDoublesArray(int elements) {
        return randomDoublesArray(elements, elements);
    }

    public static double[][] randomDoublesTable(int rows, int columns, int lowBound,
        int highBound) {
        double[][] table = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            table[i] = randomDoublesArray(columns, lowBound, highBound);
        }
        return table;
    }

    public static double[][] randomDoublesTable(int rows, int columns, int highBound) {
        return randomDoublesTable(rows, columns, 0, highBound);
    }

    public static double[][] randomDoublesTable(int rows, int columns) {
        return randomDoublesTable(rows, columns, 0, rows * columns);
    }

    public static ArrayList<Integer> randomIntList(int elements, int lowBound, int highBound) {
        ArrayList<Integer> list = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            list.add(randomInt(lowBound, highBound));
        }
        return list;
    }

    public static ArrayList<Integer> randomIntList(int elements, int highBound) {
        return randomIntList(elements, 0, highBound);
    }

    public static ArrayList<Integer> randomIntList(int elements) {
        return randomIntList(elements, 0, Integer.MAX_VALUE);
    }

    public static ArrayList<Double> randomDoubleList(
        int elements, double lowBound, double highBound) {
        ArrayList<Double> list = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            list.add(randomDouble(lowBound, highBound));
        }
        return list;
    }

    public static ArrayList<Double> randomDoubleList(int elements, double highBound) {
        return randomDoubleList(elements, 0, highBound);
    }

    public static ArrayList<Double> randomDoubleList(int elements) {
        return randomDoubleList(elements, 0, Double.MAX_VALUE);
    }
}
