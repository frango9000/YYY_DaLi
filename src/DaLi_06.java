import lib.Data.CharManip;
import lib.Data.StringManip;
import lib.Geometry.Pentagon;
import lib.Geometry.Polygon;
import lib.Geometry.Triangle;
import lib.Math.Algebra;
import lib.Math.Extras;
import lib.Math.Primes;
import lib.Math.Scales;
import lib.Misc.Calendar;
import lib.Misc.IO;
import lib.Misc.Time;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import static lib.Misc.IO.*;
import static lib.Misc.Randomizer.randomInt;

public abstract class DaLi_06 {
    public static void main(String[] args) {

        ex38();
    }

    public static void ex00() {
    }

    public static void ex01() { // Math: pentagonal numbers
        for (int i = 0; i < 100; i++) {
            IO.print("%7d", Algebra.pentagonalNumber(i));
            if (i % 10 == 9) println("");
        }
    }

    public static void ex02() { // Sum the digits in an integer
        println(Algebra.sumOfDigits(225416222));
    }

    public static void ex03() { // Palindrome integer
        println(Extras.isPalindrome(12321));
        println(Extras.isPalindrome(1421));
    }

    public static void ex04() { // Display an integer reversed
        println(Extras.reverse(1234));
    }

    public static void ex05() { // Sort three numbers
        println((int) Extras.max(5, 6, 7));
    }

    public static void ex06(int lines) { // Display patterns
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                IO.print("%3d", j);
            }
            println("");
        }
    }

    public static void ex07() { // Financial application: compute the future investment value
        DaLi_02.ex21();
    }

    public static void ex08() { // Conversions between mile and kilometer
        IO.print("%s %s %s %s %s\n", "Miles", "Kilometers", "|", "Kilometers", "Miles");
        for (int i = 1, k = 20; i <= 10; i++, k += 5) {
            IO.print(
                    "%-8d %-7.3f %s %-10d %.3f\n",
                    i, Scales.mileToKilometer(i), "|", k, Scales.kilometerToMile(k));
        }
    }

    public static void ex09() { // Conversions between pounds and kilograms
        IO.print("%s %s %3s %s %5s\n", "Kilogram", "Pound", "|", "Pound", "Kilogram");
        for (int k = 1, p = 20; k <= 10; k += 2, p += 5) {
            IO.print(
                    "%-8d %-7.3f %s %-5d %.3f\n",
                    k, Scales.kilogramToPound(k), "|", p, Scales.poundToKilogram(p));
        }
    }

    public static void ex10(int number) { // Use the isPrime Method
        print(Arrays.toString(Primes.arrayOfPrimes(number)));
    }

    public static void ex11() { // Financial application: compute commissions
        // Display table
        System.out.println("\n SalesAmount     Commission");
        System.out.println("-----------------------------");
        for (double salesAmount = 10000; salesAmount <= 100000; salesAmount += 5000) {
            System.out.printf(" %-16.0f", salesAmount);
            System.out.printf("%8.1f\n", ex11computeCommission(salesAmount));
        }
    }

    public static double ex11computeCommission(double salesAmount) {
        double balance, // Holds the balance
                commission; // Employee commission
        balance = commission = 0.0; // Initialize balance and commission to 0

        // If sales amount is $10.000.01 and above commission rate is 12%
        if (salesAmount >= 10000.01) commission += (balance = salesAmount - 10000) * 0.12;

        // If sales amount is $5,000.01 to $10,000 commissin rate is 10%
        if (salesAmount >= 5000.01) commission += (balance -= balance - 5000) * 0.10;

        // If sales amount is $0.01 to $5,000.01 commissin rate is 8%
        if (salesAmount >= 0.01) commission += balance * 0.08;

        return commission;
    }

    public static void ex12(int num1, int num2, int numbersPerLine) { // Display numbers
        for (int i = num1, j = 0; i <= num2; i++) {
            IO.print("%3d", i);
            if (j++ % numbersPerLine == numbersPerLine - 1) println("");
        }
    }

    public static void ex13(int i) { // Sum series
        float sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j / (j + 2f);
            IO.print("%-4d %f %n", j, sum);
        }
    }

    public static void ex14() { // Estimate p
        for (int i = 1; i < 1000; i += 100) {
            IO.print("%-6d %.5f%n", i, ex14pi(i));
        }
    }

    public static double ex14pi(int precision) {
        double PI = 0.0;
        for (int i = precision; i > 0; i--) PI += Math.pow(-1, i + 1) / (2 * i - 1);
        return PI * 4;
    }

    private static void ex15() { // Financial application: print a tax table
        // Print tax table
        double from = 50000; // Start table taxable income range at $50,000
        double to = 60000; // End table taxable income range at $60,000
        double interval = 50; // Increase each row by $50

        // Print header
        System.out.println(
                "\nTaxable      Single      Married Joint       Married        Head of\n"
                        + "Income                   or Qualifying       Separate       a House\n"
                        + "                         Widow(er)\n"
                        + "---------------------------------------------------------------------");
        // Print Data
        for (double taxableIncome = from; taxableIncome <= to; taxableIncome += interval) {
            System.out.printf("%-13.0f", taxableIncome);
            System.out.printf("%-12d", Math.round(ex15computeTax(0, taxableIncome)));
            System.out.printf("%-20d", Math.round(ex15computeTax(1, taxableIncome)));
            System.out.printf("%-15d", Math.round(ex15computeTax(2, taxableIncome)));
            System.out.printf("%-10d\n", Math.round(ex15computeTax(3, taxableIncome)));
        }
    }

    public static double ex15computeTax(int status, double taxableIncome) {
        double tax, // Total tax
                taxRate, // Tax rate
                incomeTaxed, // Taxed income
                incomeUntaxed, // Untaxed income
                taxAt15Pecent, // Minimum marginal amount of 15% tax bracket
                taxAt25Pecent, // Minimum marginal amount of 25% tax bracket
                taxAt28Pecent, // Minimum marginal amount of 28% tax bracket
                taxAt33Pecent, // Minimum marginal amount of 33% tax bracket
                taxAt35Pecent; // Minimum marginal amount of 35% tax bracket

        // Initialize variables to 0
        taxAt15Pecent =
                taxAt25Pecent =
                        taxAt28Pecent = taxAt33Pecent = taxAt35Pecent = incomeUntaxed = taxRate = tax = 0.0;

        switch (status) { // Get minimum taxableIncome for tax brackets
            case 0: // Single
                taxAt15Pecent = 8351;
                taxAt25Pecent = 33951;
                taxAt28Pecent = 82251;
                taxAt33Pecent = 171551;
                taxAt35Pecent = 372951;
                break;

            case 1: // Married Joint or Qualifying Widow(er)
                taxAt15Pecent = 16701;
                taxAt25Pecent = 67901;
                taxAt28Pecent = 137051;
                taxAt33Pecent = 208851;
                taxAt35Pecent = 372951;
                break;

            case 2: // Married Filing Separately
                taxAt15Pecent = 8351;
                taxAt25Pecent = 33951;
                taxAt28Pecent = 68526;
                taxAt33Pecent = 104426;
                taxAt35Pecent = 186476;
                break;

            case 3: // Head of house
                taxAt15Pecent = 11951;
                taxAt25Pecent = 45501;
                taxAt28Pecent = 117451;
                taxAt33Pecent = 190201;
                taxAt35Pecent = 372951;
        }

        // Compute tax
        while (taxableIncome >= taxAt15Pecent) {

            // Compute tax rate and untaxed income
            if (taxableIncome >= taxAt35Pecent) {
                taxRate = 0.35;
                incomeUntaxed = taxAt35Pecent - 1;
            } else if (taxableIncome >= taxAt33Pecent) {
                taxRate = 0.33;
                incomeUntaxed = taxAt33Pecent - 1;
            } else if (taxableIncome >= taxAt28Pecent) {
                taxRate = 0.28;
                incomeUntaxed = taxAt28Pecent - 1;
            } else if (taxableIncome >= taxAt25Pecent) {
                taxRate = 0.25;
                incomeUntaxed = taxAt25Pecent - 1;
            } else if (taxableIncome >= taxAt15Pecent) {
                taxRate = 0.15;
                incomeUntaxed = taxAt15Pecent - 1;
            }

            // Accumulate tax for income above the 10% tax bracket
            tax += (incomeTaxed = taxableIncome - incomeUntaxed) * taxRate;
            taxableIncome -= incomeTaxed; // Update taxable income
        }

        // Accumulate tax for income in the 10% tax bracket
        return tax += taxableIncome * 0.10;
    }

    public static void ex16() { // Number of days in a year
        int sum = 0;
        for (int year = 2014; year <= 2034; year++) {
            sum += Calendar.daysInYear(year);
        }
        print(sum);
    }

    public static void ex17(int n) { // Display matrix of 0s and 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                IO.print("%3d", randomInt(2));
            }
            println("");
        }
    }

    public static void ex18() { // Check password
        String password =
                scanNext(
                        "Enter Password\n   at least 10 chars\n   only letters and digits\n   at least 3 digits \n");
        if (StringManip.countDigits(password) >= 3
                && StringManip.countLetters(password) >= 10
                && (StringManip.countDigits(password) + StringManip.countLetters(password)
                == password.length())) {
            print("Valid");
        } else print("Invalid");
    }

    public static void ex19() { // Triangles
        print(Triangle.isValidTriangle(5, 6, 2));
    }

    public static void ex20() { // Count the letters in a string
        print(StringManip.countLetters("Hello 01"));
    }

    public static void ex21() { // Phone keypads
        String string = scanNext("Enter a string ");
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (DaLi_04.ex15(string.charAt(i)) != -1) {
                number.append(DaLi_04.ex15(string.charAt(i)));
            } else number.append(string.charAt(i));
        }
        print(number);
    }

    public static void ex22() { // Math: approximate the square root
        print(Extras.babylonianSquareRoot(9));
    }

    public static void ex23() { // Occurrences of a specified character
        print(ex23("Hello", 'l'));
    }

    public static int ex23(String string, char character) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) count++;
        }
        return count;
    }

    public static void ex24() { // Display current date and time
        GregorianCalendar gc = new GregorianCalendar();
        println(gc.get(1));
        println(gc.get(2));
        println(gc.get(5));
    }

    public static void ex25() { // Convert milliseconds to hours, minutes, and seconds
        println(Time.millisToTimeString(555550000));
    }

    public static void ex26() { // Palindromic prime
        for (long i = 1, j = 1; j <= 150; i++) {
            if (Primes.isPrime(i) && Extras.isPalindrome(i)) {
                IO.print("%8d", i);
                if (j++ % 10 == 0) println("");
            }
        }
    }

    public static void ex27() { // Emirp
        for (int i = 1, j = 1; j <= 120; i++) {
            if (Extras.isEmirP(i)) {
                IO.print("%8d", i);
                if (j++ % 10 == 0) println("");
            }
        }
    }

    public static void ex28() { // Mersenne prime
        for (int i = 1; i <= 31; i++) {
            if (Primes.mersennePrime(i) != 0) {
                IO.print("%8d %8d %n", i, Primes.mersennePrime(i));
            }
        }
    }

    public static void ex29() { // Twin primes
        for (int i = 1; i < 1200; i++) {
            if (Primes.isPrime(i) && Primes.isPrime(i + 2)) {
                IO.print("( %d , %d )%n", i, i + 2);
            }
        }
    }

    public static boolean ex30() { // Game: craps
        int roll = ex30rolls();
        switch (roll) {
            case 2:
            case 3:
            case 12:
                println("You lose");
                return false;
            case 7:
            case 11:
                println("You win");
                return true;
            default:
                IO.print("Point is %d\n", roll);
                if (ex30rolls() == roll) {
                    println("You win");
                    return true;
                } else {
                    println("You lose");
                    return false;
                }
        }
    }

    public static int ex30rolls() {
        int dice1 = randomInt(6) + 1;
        int dice2 = randomInt(6) + 1;
        IO.print("You rolled %d + %d = %d\n", dice1, dice2, dice1 + dice2);
        return dice1 + dice2;
    }

    public static void ex31() { // Financial: credit card number validation
        long number = scanLong("Enter a credit card number as a long integer: ");

        println(number + " is " + (auxp.ch06.CreditCard.isValid(number) ? "valid" : "invalid"));
    }

    public static void ex32() { // Game: chance of winning at craps
        int wins = 0;
        for (int i = 0; i < 15000; i++) {
            if (ex30()) wins++;
        }
        println(wins);
    }

    public static void ex33() { // Current date and time
        Date date = new Date(System.currentTimeMillis());
        println(date.toString());
    }

    public static void ex34() { // Print calendar
        println("Day of week is " + Calendar.dayOfWeekString(2019, 2, 4));
    }

    public static void ex35() { // Geometry: getArea of a pentagon
        Pentagon pentagon = new Pentagon(5.5);
        print(pentagon.getArea());
    }

    public static void ex36() { // Geometry: getArea of a regular polygon
        Polygon polygon = new Polygon(5, 6.5);
        print(polygon.getArea());
    }

    public static void ex37() { // Format an integer
        println(StringManip.formatInt(6, 34));
    }

    public static void ex38() { // Generate random characters
        for (int i = 1; i <= 200; i++) {
            IO.print("%c", CharManip.getRandomUpperCaseLetter());
            if (i % 10 == 0) println("");
        }
        println("");
        for (int i = 1; i <= 200; i++) {
            IO.print("%c", CharManip.getRandomDigitCharacter());
            if (i % 10 == 0) println("");
        }
    }

    public static void ex39() { // Geometry: point position
        DaLi_03.ex32();
    }
}
