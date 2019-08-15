import auxp.ch07.DeckOfCards;
import auxp.ch07.Hangman;
import lib.Data.ArrayManip;
import lib.Data.StringManip;
import lib.Math.Algebra;
import lib.Math.Extras;
import lib.Math.Statistics;
import lib.Misc.Calendar;
import lib.Misc.IO;

import java.util.Arrays;

import static lib.Misc.IO.*;
import static lib.Misc.Randomizer.*;

public abstract class DaLi_07 {
    public static void main(String[] args) {

        ex37();
    }

    public static void ex00() {
    }

    public static void ex01() { // Assign grades
        byte number = scanByte("Number of students ");
        int[] students = new int[number];
        int best = 0;
        for (int i = 0; i < students.length; i++) {
            students[i] = scanByte("Enter grade for student " + (i + 1));
            if (students[i] > best) best = students[i];
        }
        for (int i = 1; i <= students.length; i++) {
            if (students[i] >= best - 5) IO.print("Student %d grade A", i);
            else if (students[i] >= best - 10) IO.print("Student %d grade B", i);
            else if (students[i] >= best - 15) IO.print("Student %d grade C", i);
            else if (students[i] >= best - 20) IO.print("Student %d grade D", i);
            else IO.print("Student %d grade F", i);
            println("");
        }
    }

    public static void ex02() { // Comparing numbers
        int[] eleven = new int[11];
        for (int i = 0; i < eleven.length; i++) {
            eleven[i] = scanInt("Enter number " + (i + 1) + " ");
        }
        for (int i = 0; i < eleven.length - 1; i++) {
            if (eleven[i] < eleven[10]) println("lesser");
            else if (eleven[i] > eleven[10]) println("greater");
            else println("equal");
        }
    }

    public static void ex03() { // Count occurrence of numbers
        int[] numbers = new int[100];
        int num = -1;
        for (int i = 0; num != 0; i++) {
            num = scanInt("Enter numbers; 0 to break;");
            if (num > 0 && num < 101) numbers[num]++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0)
                IO.print(" number %d appears %d time%s\n", i, numbers[i], numbers[i] > 1 ? "s" : "");
        }
    }

    public static void ex04() { // Analyze scores
        int[] numbers = new int[100];
        int num = -1;
        int count = 0;
        for (int i = 0; num != 0; i++) {
            num = scanInt("Enter numbers; 0 to break;");
            if (num > 0 && num < 101) {
                count++;
                numbers[num]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * i;
        }
        float average = sum / (float) count;
        int above = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (i >= average && numbers[i] > 0) {
                above += numbers[i];
            }
        }
        IO.print("average: %f,%n above avg count:%d", average, above);
    }

    public static void ex05() { // The number of even numbers and odd numbers
        int[] nums = randomIntsArray(20, 1, 9);
        int odd = 0, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) even++;
            else odd++;
        }
        IO.print("%d odds%n%d evens", odd, even);
    }

    public static void ex06() { // The Sieve of Eratosthenes
        boolean[] primes = new boolean[50];
        Arrays.fill(primes, true);
        for (int i = 2; i < primes.length; i++)
            for (int j = i + 1; j < primes.length; j++) if (j % i == 0) primes[j] = false;
        for (int i = 0; i < primes.length; i++) if (primes[i]) IO.print("%d is prime\n", i);
    }

    public static void ex07() { // Count single digits
        int[] rands = randomIntsArray(200, 9);
        int[] counts = new int[10];
        for (int i = 0; i < rands.length; i++) {
            counts[rands[i]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            IO.print("%d %d\n", i, counts[i]);
        }
    }

    public static void ex08() { // Average an array
        print(Statistics.mean(randomDoublesArray(5, 0, 5)));
    }

    public static void ex09() { // Find the largest element
        print(ArrayManip.max(randomDoublesArray(5, 0, 5)));
    }

    public static void ex10() { // Find the index of the largest element
        print(ArrayManip.indexOfMax(randomDoublesArray(50, 0, 5)));
    }

    public static void ex11() { // Statistics: compute deviation
        double[] rands = randomDoublesArray(10, 0, 10);
        println(Statistics.mean(rands));
        println(Statistics.standardDeviation(rands));
        println(Statistics.standardDeviationAlt(rands));
    }

    public static void ex12() { // Reverse an array
        int[] rands = randomIntsArray(10, 10);
        ArrayManip.printArray(rands);
        ArrayManip.printArray(ArrayManip.reverseArray(rands));
    }

    public static void ex13() { // Random number selector
        int[] rands = randomIntsArray(10, 10);
        ArrayManip.printArray(rands);
        IO.print("%n%d", ArrayManip.getRandom(rands));
    }

    public static void ex14() { // Computing lcm
        int[] rands = randomIntsArray(10, 5, 100);
        ArrayManip.printArray(rands);
        IO.print("%n%d", Algebra.greatestCommonDivisor(rands));
        IO.print("%n%d", Algebra.leastCommonMultiple(rands));
    }

    public static void ex15() { // Eliminate duplicates
        int[] rands = randomIntsArray(10, 5, 9);
        ArrayManip.printArray(rands);
        println("");
        rands = ArrayManip.removeDuplicates(rands);
        ArrayManip.printArray(rands);
    }

    public static void ex16() { // Execution time
        int[] array = new int[100000000];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        long startTime, endTime, totalTime;
        int search, index;
        int[] searches = {1, 25000000, 50000000, 75000000, 10000000};

        for (int i = 0; i < searches.length; i++) {

            search = searches[i];
            startTime = System.nanoTime();
            index = ArrayManip.linearSearch(array, search);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            IO.print(
                    "Linear search of number %d took %dns found in index %d%n", search, totalTime, index);

            startTime = System.nanoTime();
            index = ArrayManip.binarySearch(array, search);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            IO.print(
                    "Binary search of number %d took %dns found in index %d%n%n", search, totalTime, index);
        }
    }

    public static void ex17() { // Sort students
        int numberOfStudents = scanInt("Enter number of students: ");
        int[] grades = new int[numberOfStudents];
        String[] names = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            grades[i] = scanInt("Enter Grade of student %d:", (i + 1));
            names[i] = scanNext("Enter Name of student %d:", (i + 1));
        }
        int[] sortedIndexes = ArrayManip.bubbleSortIndex(grades);

        for (int i = 0; i < sortedIndexes.length; i++) {
            print("%d Name: %s grade: %d%n", i, names[sortedIndexes[i]], grades[sortedIndexes[i]]);
        }
    }

    public static void ex18() { // Bubble sort
        int[] rands = randomIntsArray(10, 0, 50);
        ArrayManip.bubbleSort(rands);
        ArrayManip.printArray(rands);
    }

    public static void ex19() { // Sorted?
        int[] rands = randomIntsArray(10, 0, 50);
        ArrayManip.bubbleSort(rands);
        ArrayManip.printArray(rands);
        println(ArrayManip.isSortedAsc(rands));
        println(ArrayManip.isSortedDesc(rands));

        ArrayManip.bubbleSortDesc(rands);
        println(ArrayManip.isSortedAsc(rands));
        println(ArrayManip.isSortedDesc(rands));
    }

    public static void ex20() { // Descending Bubble Sort
        ex19();
    }

    public static void ex21() { // Normalizing integers
        int[] rands = randomIntsArray(10, 0, 50);
        int max = rands[ArrayManip.indexOfMax(rands)];

        for (int i = 0; i < rands.length; i++) {
            println(Extras.map(rands[i], 0, max, 0, 1));
        }
    }

    public static void ex22() { // Count the number of vowels in a string
        String string = scanNext("Enter string ");
        int countHigh = 0, countLow = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') countHigh++;
            else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') countLow++;
        }
        print("%d Uppercases,%n%d Lowercases.", countHigh, countLow);
    }

    public static void ex23() { // Game: locker puzzle
        boolean[] lockers = new boolean[100];

        for (int student = 1; student <= 100; student++) {
            for (int locker = 0; locker < lockers.length; locker++) {
                if ((locker + 1) % student == 0) lockers[locker] = !(lockers[locker]);
            }
        }
        for (int locker = 0; locker < lockers.length; locker++) {
            print("Locker %d is %s%n", locker + 1, lockers[locker] ? "open" : "closed");
        }
    }

    public static void ex24() { // Simulation: coupon collector’s problem
        DeckOfCards.main();
    }

    public static void ex25() { // Algebra: solve quadratic equations
        DaLi_03.ex01();
    }

    public static void ex26() { // Check whether array is sorted
        ex19();
    }

    public static void ex27() { // Check whether the array is sorted with constant interval
        int[] rands = randomIntsArray(10, 0, 50);
        println(ArrayManip.isSortedConstantInterval(rands));
        ArrayManip.bubbleSortDesc(rands);
        println(ArrayManip.isSortedConstantInterval(rands));

        int[] constants = {-1, -3, -5, -7, -9};
        println(ArrayManip.isSortedConstantInterval(constants));
    }

    public static void ex28() { // Math: permutations
        int[] rands = randomUniqueIntsArray(4, 0, 10);
        ArrayManip.printArray(rands);
        for (int i = 0; i < rands.length; i++) {
            for (int j = 0; j < rands.length; j++) {
                if (i != j) println(rands[i] + " " + rands[j]);
            }
        }
    }

    public static void ex29() { // Game: dice
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == 9) print("Dice 1: %d | Dice 2: %d | Dice 3: %d = 9%n", i, j, k);
                }
            }
        }
    }

    public static void ex30() { // Pattern recognition: consecutive four equal numbers
        int[] numbers = {2, 5, 4, 7, 8, 9, 6, 5, 4, 1, 2, 3, 5, 8, 7, 4, 2, 5, 3, 4, 1, 1, 1, 1};
        print(ex30isConsecutiveFour(numbers));
    }

    public static boolean ex30isConsecutiveFour(int[] array) {
        for (int i = 0; i < array.length - 3; i++)
            if (array[i] == array[i + 1] && array[i] == array[i + 2] && array[i] == array[i + 3])
                return true;
        return false;
    }

    public static void ex31() { // Merge two sorted lists
        int[] numbers1 = {5, 1, 5, 16, 61, 111};
        int[] numbers2 = {4, 2, 4, 5, 6};
        ArrayManip.printArray(ex31merge(numbers1, numbers2));
    }

    public static int[] ex31merge(int[] list1, int[] list2) {
        list1 = ArrayManip.bubbleSort(ArrayManip.removeDuplicates(list1));
        list2 = ArrayManip.bubbleSort(ArrayManip.removeDuplicates(list2));
        int[] merged = new int[list1.length + list2.length];

        for (int i = 0, j = 0, k = 0; i < merged.length; i++) {
            if (i < list1.length) {
                merged[i] = list1[j];
                j++;
            } else {
                merged[i] = list2[k];
                k++;
            }
        }
        return ArrayManip.bubbleSort(merged);
    }

    public static void ex32() { // Partition of a list
        int[] numbers = {5, 2, 9, 3, 6, 8};
        ArrayManip.printArray(numbers);
        println(ex32partition(numbers));
        ArrayManip.printArray(numbers);
    }

    public static int ex32partition(int[] array) {
        int pivot = array[0];
        ArrayManip.bubbleSort(array);
        return ArrayManip.binarySearch(array, pivot);
    }

    public static void ex33() { // Month name
        int month = scanInt("Enter month number ");
        print(Calendar.monthName(month));
    }

    public static void ex34() { // Sort characters in a string
        String unsorted = scanNextLine("Enter string to sort ");
        print(StringManip.sort(unsorted));
    }

    public static void ex35() { // Game: hangman
        Hangman.startGame(null);
    }

    public static void ex36() { // Game: Eight Queens
        String[] table = new String[8];
        for (int row = 0; row < table.length; row++) {
            StringBuilder insertNext = new StringBuilder();
            for (int col = 0; col < table.length; col++) {
                insertNext.append((row == col) ? "|Q" : "| ");
            }
            table[row] = insertNext.toString();
        }
        int[] randoms = randomUniqueIntsArray(8, 7);
        for (int i = 0; i < randoms.length; i++) {
            println(table[randoms[i]]);
        }
    }

    public static void ex37() { // Game: bean machine
        int[] slots = new int[8];
        int balls = 10;
        for (int i = 0; i < balls; i++) {
            int slot = 0;
            String randomPath = Integer.toBinaryString(randomInt(-1 + (int) Math.pow(2, slots.length)));
            while (randomPath.length() != slots.length) randomPath = "0" + randomPath;
            println(randomPath);

            for (int j = 0; j < randomPath.length(); j++) {
                if (randomPath.charAt(j) == '1') slot++;
            }
            slots[slot]++;
        }
        ArrayManip.printArray(slots);
    }
}
