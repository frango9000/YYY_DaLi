package lib.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import lib.Math.Algebra;
import lib.Misc.Randomizer;

public abstract class ArrayManip {

    public static int[] arrayOfDuplicateElements(int[] array, int num) {
        int size = countRepeated(array, num);
        int[] j = new int[size];
        int h = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                j[h] = i;
                h++;
            }
        }
        return j;
    }

    public static int[] appendNewElement(int[] array, int indice, int elemento) {
        int[] nuevoArray = new int[array.length + 1];
        for (int i = 0; i < nuevoArray.length; i++) {
            if (i < indice) {
                nuevoArray[i] = array[i];
            } else if (i == indice) {
                nuevoArray[i] = elemento;
            } else {
                nuevoArray[i] = array[i - 1];
            }
        }
        return nuevoArray;
    }

    public static int countRepeated(int[] array, int num) {
        int j = 0;
        for (int i1 : array) {
            if (i1 == num) {
                j++;
            }
        }
        return j;
    }

    public static int[] removeFromArray(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }

    public static boolean isSorted(int[] array) {
        return isSortedAsc(array) || isSortedDesc(array);
    }

    public static boolean isSortedAsc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] bubbleSort(int... array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    public static double[] bubbleSort(double... array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    public static String[] bubbleSort(String... array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSortIndex(int[] array) {
        int[] indexes = new int[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[indexes[i]] > array[indexes[j]]) {
                    int aux = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = aux;
                }
            }
        }
        return indexes;
    }

    public static int[] bubbleSortIndex(double[] array) {
        int[] indexes = new int[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[indexes[i]] > array[indexes[j]]) {
                    int aux = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = aux;
                }
            }
        }
        return indexes;
    }

    public static boolean isSortedDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] bubbleSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    public static double[] bubbleSortDesc(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    double aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSortIndexDesc(int[] array) {
        int[] indexes = new int[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[indexes[i]] < array[indexes[j]]) {
                    int aux = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = aux;
                }
            }
        }
        return indexes;
    }

    public static int[] bubbleSortIndexDesc(double[] array) {
        int[] indexes = new int[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[indexes[i]] < array[indexes[j]]) {
                    int aux = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = aux;
                }
            }
        }
        return indexes;
    }

    public static boolean isSortedConstantInterval(int[] array) {
        if (isSortedAsc(array) || isSortedDesc(array)) {
            int constant = Math
                .abs(Algebra.max(array[0], array[1]) - Algebra.min(array[0], array[1]));
            for (int i = 0; i < array.length - 1; i++) {
                if ((Math
                    .abs(Algebra.max(array[i], array[i + 1]) - Algebra.min(array[i], array[i + 1])))
                    != constant) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void printArray(double[] array) {
        for (double v : array) {
            System.out.println(v);
        }
    }

    public static void printArray(double[] array, int decimals, int spacing) {
        for (double v : array) {
            System.out.printf("%" + spacing + "." + decimals + "f%n", v);
        }
    }

    public static void printArray(double[] array, int decimals) {
        printArray(array, decimals, 1);
    }

    public static void printArray(int[] array) {
        for (int i1 : array) {
            System.out.println(i1);
        }
    }

    public static void printArray(int[] array, int spacing) {
        for (int il : array) {
            System.out.printf("%" + spacing + "d", il);
        }
    }

    public static void printArray(char[] array) {
        for (char c : array) {
            System.out.println(c);
        }
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i1 : array) {
            if (i1 > max) {
                max = i1;
            }
        }
        return max;
    }

    public static int indexOfMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public static double max(double[] array) {
        double max = array[0];
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static int indexOfMax(double[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public static double min(double[] array) {
        double min = array[0];
        for (double v : array) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public static int indexOfMin(double[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            reversed[i] = array[j];
            reversed[j] = array[i];
        }
        return reversed;
    }

    public static int getRandom(int... numbers) {
        return numbers[Randomizer.randomInt(numbers.length - 1)];
    }

    public static boolean contains(int[] array, int number) {
        for (int i1 : array) {
            if (i1 == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] array, char character) {
        for (char c : array) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }

    public static int[] removeDuplicates(int[] array) {
        int count = 0;
        int[] unique = new int[array.length];
        for (int i1 : array) {
            if (!(contains(unique, i1))) {
                unique[count] = i1;
                count++;
            }
        }
        return Arrays.copyOfRange(unique, 0, count);
    }

    public static int linearSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String[] array, String match) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(match)) {
                return i;
            }
        }
        return -1;
    }

    public static int[] linearSearchAll(int[] array, int number) {
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                matches.add(i);
            }
        }
        int[] ret = new int[matches.size()];
        Iterator<Integer> it = matches.listIterator();
        int count = 0;
        while (it.hasNext()) {
            ret[count++] = it.next();
        }
        return ret;
    }

    public static int[] linearSearchAll(char[] array, char character) {
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == character) {
                matches.add(i);
            }
        }
        int[] ret = new int[matches.size()];
        Iterator<Integer> it = matches.listIterator();
        int count = 0;
        while (it.hasNext()) {
            ret[count++] = it.next();
        }
        return ret;
    }

    public static int binarySearch(int[] array, int number) {
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (number < array[mid]) {
                high = mid - 1;
            } else if (number == array[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] array, String find) {
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (find.compareTo(array[mid]) < 0) {
                high = mid - 1;
            } else if (find.compareTo(array[mid]) == 0) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i1 : array) {
            sum += i1;
        }
        return sum;
    }

    public static int[] indieClone(int[] array) {
        int[] clone = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            clone[i] = array[i];
        }
        return clone;
    }

    public static boolean isStrictIdentical(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentical(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        boolean[] hasValueOnIndex = new boolean[array1.length];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j] && !hasValueOnIndex[j]) {
                    hasValueOnIndex[j] = true;
                }
            }
        }
        return isAllTrue(hasValueOnIndex);
    }

    public static boolean isAllTrue(boolean[] marks) {
        for (int i = 0; i < marks.length; i++) {
            if (!marks[i]) {
                return false;
            }
        }
        return true;
    }
}
