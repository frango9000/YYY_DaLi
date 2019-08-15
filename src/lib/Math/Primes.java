/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.Math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author NarF
 */
public class Primes {

    public static boolean debug = false;
    public static long calcsDone = 0L;

    public static boolean isPrime(long number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number > 2 && isEven(number)) {
            return false;
        }
        if (number > 3 && isDivisible3(number)) {
            return false;
        }
        if (number > 5 && isDivisible5(number)) {
            return false;
        }
        return countDivisors(number) == 0;
    }

    public static int countDivisors(long bNum) {
        int count = 0;
        for (int f = 3; f <= bNum / 3; f += 2) {
            calcsDone++;
            if (bNum % f == 0) {
                return ++count;
            }
        }
        return count;
    }

    public static boolean hasDivisors(long bNum) {
        for (int f = 3; f <= bNum / 3; f += 2) {
            if (bNum % f == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEven(long n) {
        return (n % 2 == 0);
    }

    public static boolean isDivisible3(long n) {
        return (n % 3 == 0);
    }

    public static boolean isDivisible5(long n) {
        return (n % 5 == 0);
    }

    public static int[] arrayOfPrimes(int highBound) { // obsolete
        ArrayList<Integer> list = Primes.listOfPrimes(highBound);
        int[] primes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            primes[i] = list.get(i);
        }
        return primes;
    }

    public static ArrayList<Integer> listOfPrimes(
        int lowBound, int highBound) { // inclusive bounds min = 2
        lowBound = Math.max(lowBound, 2);
        ArrayList<Integer> list = new ArrayList<>();

        while (lowBound <= highBound) {
            if (isPrime(lowBound)) {
                list.add(lowBound);
            }
            lowBound++;
        }
        return list;
    }

    public static ArrayList<Integer> listOfPrimes(int highBound) {
        return listOfPrimes(0, highBound);
    }

    public static ArrayList<Integer> listOfNPrimes(int lowBound, int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        lowBound = Math.max(0, lowBound);
        int count = 0;
        while (count < n) {
            if (isPrime(++lowBound)) {
                list.add(lowBound);
                count++;
            }
        }
        return list;
    }

    public static ArrayList<Integer> listOfNPrimes(int n) {
        return listOfNPrimes(0, n);
    }

    public static int[] getPrimeFactors(int number) {
        if (Primes.isPrime(number)) {
            return new int[]{number};
        }

        int[] array = new int[(int) Math.round(Math.sqrt(number))];
        int[] primes = arrayOfPrimes((number));
        int count = 0, tempValue = number;

        for (int i = 0; tempValue != 1; i++) {
            for (int j = 0; j < primes.length; j++) {
                if (tempValue % primes[j] == 0) {
                    tempValue /= primes[j];
                    array[i] = primes[j];
                    count++;
                    break;
                }
            }
        }

        // System.out.println(number+":"+Arrays.toString(Arrays.copyOf(array, count)));
        return Arrays.copyOf(array, count);
    }

    public static int mersennePrime(int index) {
        int mersenne = (int) (Math.pow(2, index) - 1);
        return isPrime(mersenne) ? mersenne : 0;
    }

    public static boolean isPrime(BigInteger n) {
        for (BigInteger d = new BigInteger("2");
            d.compareTo(n.divide(new BigInteger("2"))) <= 0;
            d = d.add(new BigInteger("1"))) {
            if (n.remainder(d).compareTo(new BigInteger("0")) == 0) {
                return false;
            }
        }
        return true;
    }
}
