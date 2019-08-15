import static lib.Misc.IO.print;
import static lib.Misc.IO.println;
import static lib.Misc.IO.scanByte;
import static lib.Misc.IO.scanDouble;
import static lib.Misc.IO.scanFloat;
import static lib.Misc.IO.scanInt;
import static lib.Misc.IO.scanNextLine;
import static lib.Misc.Randomizer.randomInt;

import java.util.Arrays;
import lib.Math.Algebra;
import lib.Math.Primes;
import lib.Math.Scales;
import lib.Math.Statistics;
import lib.Misc.Calendar;
import lib.Misc.IO;

public abstract class DaLi_05 {

    public static void main(String[] args) {

        ex51();
    }

    public static void ex00() {
    }

    public static void ex01() { // Pass or fail
        int n = 0;
        while (n != -1) {
            print("Enter Your Grade:");
            n = scanInt();
            println("You" + (n > 50 ? " " : " did not ") + "pass.");
        }
    }

    public static void ex02() { // Repeat multiplications
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int a = randomInt(100), b = randomInt(100), t = 0;
            if (a < b) {
                t = a;
            }
            a = b;
            b = t;
            IO.print("\n%d : Enter result of %d - %d", count++, a, b);
            int result = scanInt();
            if (result == a - b) {
                print("You win.");
            } else {
                IO.print("You lose: %d - %d = %d", a, b, (a - b));
            }
        }
        IO.print("\nCorrect answers = %d", count);
    }

    public static void ex03() { // Conversion from Cº to Fº
        IO.print("%s %19s", "Celsius", "Fahrenheit");
        for (int i = 0; i <= 100; i += 2) {
            IO.print("\n%s %25s", i, Scales.celsiusToFahrenheit(i));
        }
    }

    public static void ex04() { // Conversion from inch to centimeter
        IO.print("%3s %19s", "Inches", "Centimeter");
        for (int i = 0; i <= 100; i++) {
            IO.print("\n%3d %20.2f", i, Scales.inchToMeter(i) * 100);
        }
    }

    public static void ex05() { // Conversion from Cº to Fº and Fº to Cº
        IO.print("%s %14s    |    %10s %11s", "Celsius", "Fahrenheit", "Fahrenheit", "Celsius");
        for (int i = 0; i <= 100; i++) {
            IO.print(
                "\n%3d %18.2f    |    %3d %18.2f",
                i * 2, Scales.celsiusToFahrenheit(i * 2), i * 5, Scales.fahrenheitToCelsius(i * 5));
        }
    }

    public static void ex06() { // Conversion from square meter to ping
        IO.print("%s %17s    |    %12s %9s", "Ping", "Square Meter", "Square Meter", "Ping");
        for (int i = 10; i <= 80; i += 5) {
            IO.print(
                "\n%3d %18.2f    |    %3d %18.2f",
                i, Scales.pingToSquareMeter(i), i + 20, Scales.fahrenheitToCelsius(i + 20));
        }
    }

    public static void ex07() { // Financial application: compute future tuition
        float initialV = 10000f;
        float deltaV = 1.06f; // 6%
        float totalCost = 0f;

        for (int i = 1; i <= 10; i++) {
            IO.print("\nYear %2d: %13.2f", i, initialV);
            totalCost += initialV;
            initialV = initialV * deltaV;
        }
        print("\nTotal Cost : " + totalCost);
    }

    public static void ex08() { // (Find the highest score
        print("Enter num of students: ");
        int numOfStudents = scanInt();
        String bestName = "";
        int bestGrade = 0;
        for (int i = 1; numOfStudents > 0; numOfStudents--, i++) {
            IO.print("Enter name of student %d: ", i);
            String thisName = scanNextLine();

            IO.print("Enter grade of student %s: ", i);
            int thisGrade = scanInt();
            if (thisGrade > bestGrade) {
                bestGrade = thisGrade;
                bestName = thisName;
            }
        }
        IO.print("Best student is %s with grade %d", bestName, bestGrade);
    }

    public static void ex09() { // Find the two lowest scores)
        print("Enter num of students: ");
        int numOfStudents = scanInt();
        String worstName1 = "", worstName2 = "";
        int worstGrade1 = 12, worstGrade2 = 12;
        for (int i = 1; numOfStudents > 0; numOfStudents--, i++) {
            IO.print("Enter name of student %d: ", i);
            String thisName = scanNextLine();

            IO.print("Enter grade of student %s: ", i);
            int thisGrade = scanInt();
            if (thisGrade < worstGrade1) {
                worstGrade2 = worstGrade1;
                worstName2 = worstName1;
                worstGrade1 = thisGrade;
                worstName1 = thisName;
            } else if (thisGrade < worstGrade2) {
                worstGrade2 = thisGrade;
                worstName2 = thisName;
            }
        }
        IO.print("Worst student is %s with grade %d\n", worstName1, worstGrade1);
        IO.print("2nd Worst student is %s with grade %d", worstName2, worstGrade2);
    }

    public static void ex10() { // Find numbers divisible by 3 and 4
        String log = "";
        int count = 0;
        for (int i = 1; count < 100; i++) {
            if (i % 12 == 0) {
                log += String.format("%6d", i);
                if (++count % 10 == 0) {
                    log += "\n";
                }
            }
        }
        print(log);
    }

    public static void ex11() { // Find numbers divisible by 3 or 4, but not both
        String log = "";
        int count = 0;
        for (int i = 1; count < 100; i++) {
            if ((i % 3 == 0 || i % 4 == 0) && !(i % 3 == 0 && i % 4 == 0)) {
                log += String.format("%6d", i);
                if (++count % 10 == 0) {
                    log += "\n";
                }
            }
        }
        print(log);
    }

    public static void ex12() { // Find the smallest n such that n3 7 12,000
        int i;
        for (i = 0; !(i * i * i > 1200); i++) {
        }
        IO.print("Answer : %d", i);
    }

    public static void ex13() { // Find the largest n such that n2
        int i;
        for (i = 0; i * i < 1200; i++) {
        }
        IO.print("Answer : %d", i);
    }

    public static void ex14() { // Compute the greatest common divisor
        print("Enter num 1");
        int n1 = scanInt();
        print("Enter num 2");
        int n2 = scanInt();
        IO.print("GCD %d %d = %d\n", n1, n2, Algebra.greatestCommonFactor(n1, n2));
        for (int i = 0; i < 100; i++) {
            IO.print("GCD %d %d = %d", n1, i, Algebra.greatestCommonFactor(n1, i));
            IO.print("GCD %d %d = %d\n", n1, i, Algebra.greatestCommonFactor(n2, i));
        }
    }

    public static void ex15() { // Display the ASCII character table
        int lineCount = 0;
        for (int i = '!'; i <= '~'; i++) {
            IO.print("%2c", (char) i);
            if (++lineCount % 10 == 0) {
                println("");
            }
        }
    }

    public static void ex16() { // Find the factors of an integer
        for (int i = 120; i < 130; i++) {
            println(i + " : " + Arrays.toString(Primes.getPrimeFactors(i)));
        }

        for (int i = 2; i < 1500000; i *= 2) {
            println(i + " : " + Arrays.toString(Primes.getPrimeFactors(i)));
        }
    }

    public static void ex17() { // Display pyramid
        int number = 9;
        while (number > 0) {
            for (int i = -number; i <= number; i++) {
                IO.print("%3d", Math.abs(i));
                if (i == -1) {
                    i += 2;
                }
            }
            println("");
            number--;
        }
    }

    public static void ex18() { // Display four patterns using loops
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j <= i) {
                    print(" $ ");
                }
            }
            println("");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= i) {
                    print(" $ ");
                }
            }
            println("");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j <= i) {
                    print(" $ ");
                } else {
                    print("   ");
                }
            }
            println("");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= i) {
                    print(" $ ");
                } else {
                    print("   ");
                }
            }
            println("");
        }
    }

    public static void ex19() { // Display numbers in a pyramid pattern
        int lines = 15;

        for (int i = 0; i <= lines; i++) {
            for (int j = 0; j < lines - i; j++) {
                IO.print("%6s", "");
            }
            for (int j = 0; j < (i) + 1; j++) {
                IO.print("%6d", (int) Math.pow(3, j));
            }
            for (int k = i; k > 0; k--) {
                IO.print("%6d", (int) Math.pow(3, k - 1));
            }
            println("");
        }
    }

    public static void ex20() { // Display prime numbers between 2 and 1,200
        print(Arrays.toString(Primes.arrayOfPrimes(1200)));
    }

    public static void ex21() { // Financial application: compare loans with various interest rates)
        double loan = scanDouble("Loan Amount: ");
        int years = scanInt("Years: ");

        IO.print("%s %5s %5s\n", "Interest Rate", "Monthly Payment", "Total Payment");
        for (double i = 5.0; i <= 10; i += 0.25) {
            double monthlyInterestRate = i / 1200.0;
            double monthlyPayment =
                (loan * monthlyInterestRate / (1 - 1 / Math
                    .pow(1 + monthlyInterestRate, years * 12)));
            IO.print(
                "%5.2f     %5.2f          %8.2f\n", i, monthlyPayment,
                (monthlyPayment * 12) * years);
        }
    }

    public static void ex22() { // Financial application: loan amortization schedule)
        double loanAmount = scanDouble("Loan Amount: ");
        int years = scanInt("Number of Years: ");
        double annualRate = scanDouble("Annual Interest Rate: ");

        double monthlyRate = annualRate / 1200;

        double monthlyPayment =
            loanAmount * monthlyRate / (1 - 1 / Math.pow(1 + monthlyRate, years * 12));

        IO.print("Monthly Payment: %.2f\n", monthlyPayment);
        IO.print("Total Payment: %.2f\n", (monthlyPayment * 12) * years);

        double balance = loanAmount, principal, interest;
        println("Payment#     Interest     Principal     Balance");
        for (int i = 1; i <= years * 12; i++) {
            interest = monthlyRate * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;
            IO.print("%-13d%-13.2f%-13.2f%.2f\n", i, interest, principal, balance);
        }
    }

    public static void ex23() { // Demonstrate cancellation errors
        double num = 1;
        for (int i = 1; i < 20; i++) {
            num = num + (num / i);
        }
        println(num);

        num = 1;
        for (int i = 19; i > 0; i--) {
            num += (num / i);
        }
        println(num);
    }

    public static void ex24() { // Sum a series
        println(Algebra.pi());
        println(Math.PI);
    }

    public static void ex25() { // Compute p
        println(Algebra.calcE());
        print(Math.E);
    }

    public static void ex26() { // Compute e)
        int count = 0;
        for (int i = 2014, l = 1; i <= 2114; i++) {
            if (Calendar.isLeapYear(i)) {
                IO.print("%5d", i);
                if (++l > 10) {
                    println("");
                    l = 1;
                }
                count++;
            }
        }
        println("\nTotal: " + count);
    }

    public static void ex27() { // Display leap years
        int year = scanInt("Enter year: ");
        for (int i = 1; i < 13; i++) {
            IO.print(
                "%9s 1, %d is %s\n", Calendar.monthName(i), year,
                Calendar.dayOfWeekString(year, i, 1));
        }
    }

    public static void ex28() { // Display the first days of each month
        for (int i = 1; i <= 12; i++) {
            print(Calendar.consoleCalendar(2019, i));
        }
    }

    public static void ex29() { // Display calendars
        float amount = scanFloat("Enter amount ");
        float anualRate = scanFloat("Enter annual interest rate ");
        int months = scanInt("Enter months ");
        float cumulative = 0;
        for (int i = 0; i < months; i++) {
            cumulative = cumulative + amount * (1 + (anualRate / 100) / 12);
            println((i + 1) + ":" + cumulative);
        }
    }

    public static void ex30() { // Financial application: compound value
        float amount = scanFloat("Enter amount ");
        float yield = scanFloat("Enter percentage yield ");
        int months = scanInt("Enter months ");
        for (int i = 0; i < months; i++) {
            amount += amount * ((yield / 100) / 12);
            println((i + 1) + ":" + amount);
        }
    }

    public static void ex31() { // Financial application: compute CD value
        int number = scanInt("Enter your number ");
        int lotteryA = randomInt(9);
        int lotteryB = lotteryA;
        while (lotteryB == lotteryA) {
            lotteryB = randomInt(9);
        }
        if (number == (Integer.parseInt(lotteryA + "" + lotteryB))) {
            print("You win");
        } else {
            print("You lose. Winner is " + lotteryA + "" + lotteryB);
        }
    }

    public static void ex32() { // Game: lottery
        println(Arrays.toString(Algebra.listOfDivisors(28)));
    }

    public static void ex33() { // Perfect number
        for (int i = 0; i < 100000; i++) {
            if (Algebra.isPerfectNumber(i)) {
                println(i);
            }
        }
    }

    public static void ex34() { // Game: scissor, rock, paper
        String results = "XXX";
        while (!("AAA".equals(results)) && !("HHH".equals(results))) {
            print("0 rock\n1 paper\n2 scissor\n");
            int player = scanInt();
            int ai = randomInt(3);

            println("You chose " + DaLi_03.ex17string(player));
            println("AI chose " + DaLi_03.ex17string(ai));

            String reply;
            if (player == ai) {
                reply = "draw";
                results = ("" + results.charAt(1) + results.charAt(2) + "D");
            } else {
                if ((ai == 0 && player == 1) || (ai == 1 && player == 2) || (ai == 2
                    && player == 0)) {
                    reply = "win";
                    results = ("" + results.charAt(1) + results.charAt(2) + "H");
                } else {
                    reply = "lose";
                    results = ("" + results.charAt(1) + results.charAt(2) + "A");
                }
            }
            println("You " + reply);
        }
    }

    public static void ex35() { // Summation
        double sum = 0;
        for (int i = 1000; i > 0; i--) {
            sum += 1 / (Math.sqrt(i) + Math.sqrt(i - 1));
        }
        println(sum);
        sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += 1 / (Math.sqrt(i) + Math.sqrt(i - 1));
        }
        println(sum);
    }

    public static void ex36() { // Business application: checking ISBN
        DaLi_03.ex09();
    }

    public static void ex37() { // Decimal to binary
        int number = scanInt("Enter decimal ");
        println("In binary " + Integer.toBinaryString(scanInt()));
    }

    public static void ex38() { // Decimal to octal
        int number = scanInt("Enter decimal ");
        println("In octal " + Integer.toOctalString(scanInt()));
    }

    public static void ex39() { // Financial application: find the sales amount
        final double COMMISSION_SOUGHT = 30000;
        double salesAmount, // Sales amount
            commission, // Employee commission
            balance; // Sales balance
        salesAmount = 0; // Initialize accumulator to 0
        do {
            balance = commission = 0; // Set balance and commission to 0
            salesAmount += 0.01; // Increase sales amount by $0.01

            // If sales amount is $10,000.01 and above commission rate is 12%
            if (salesAmount > 10000) {
                commission += (balance = salesAmount - 10000) * 0.12;
            }

            // If sales amount is $5,000.01-$10,000 commission rate is 10%
            if (salesAmount > 5000) {
                commission += (balance -= balance - 5000) * 0.10;
            }

            // If sales amount is $0.01-$5,000 commission rate is 8%
            if (salesAmount > 0) {
                commission += balance * 0.08;
            }

            // While commission is less than commission sought loop
        } while (commission < COMMISSION_SOUGHT);

        // Display results
        System.out.printf("Minimum sales to earn $30,000: $%.0f\n", salesAmount / 10);
    }

    public static void ex40() { // Simulation: heads or tails
        int heads = 0, tails = 0;
        for (int i = 0; i < 2000000; i++) {
            int coin = randomInt(2);
            if (coin == 0) {
                heads++;
            } else {
                tails++;
            }
        }
        IO.print("%d Heads\n%d Tails", heads, tails);
    }

    public static void ex41() { // Occurrence of max numbers
        int max = 0, maxCount = 0, newNumber;
        do {
            newNumber = scanInt("Enter a number ");
            if (newNumber > max) {
                max = newNumber;
                maxCount = 1;
            } else if (newNumber == max) {
                maxCount++;
            }
        } while (newNumber != 0);
        IO.print("max number is %d, repeated %d times.", max, maxCount);
    }

    public static void ex42() { // Financial application: find the sales amount
        final double COMMISSION_SOUGHT = 30000;
        double salesAmount, // Sales amount
            commission = 0, // Employee commission
            balance; // Sales balance
        salesAmount = 0; // Initialize accumulator to 0
        while (commission < COMMISSION_SOUGHT) {
            balance = commission = 0; // Set balance and commission to 0
            salesAmount += 0.01; // Increase sales amount by $0.01

            // If sales amount is $10,000.01 and above commission rate is 12%
            if (salesAmount > 10000) {
                commission += (balance = salesAmount - 10000) * 0.12;
            }

            // If sales amount is $5,000.01-$10,000 commission rate is 10%
            if (salesAmount > 5000) {
                commission += (balance -= balance - 5000) * 0.10;
            }

            // If sales amount is $0.01-$5,000 commission rate is 8%
            if (salesAmount > 0) {
                commission += balance * 0.08;
            }

            // While commission is less than commission sought loop
        }

        // Display results
        System.out.printf("Minimum sales to earn $30,000: $%.0f\n", salesAmount / 10);
    }

    public static void ex43() { // Math: combinations
        int count = 0;
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                IO.print("%d, %d\n", i, j);
                count++;
            }
        }
        println(count);
    }

    public static void ex44() { // Computer architecture: bit-level operations
        byte number = scanByte("Enter a number ");
        String bits = "";
        for (int i = 0; i < 8; i++) {
            bits = (number & 1) + bits;
            number >>= 1;
        }
        IO.print("Bits are %s", bits);
    }

    public static void ex45() { // Statistics: compute mean and standard deviation
        double[] numbers = {1, 2, 3, 4.5, 5.6, 6, 7, 8, 9, 10};
        println(Statistics.mean(numbers));
        println(Statistics.standardDeviation(numbers));
    }

    public static void ex46() { // Reverse a string
        print(new StringBuilder(scanNextLine("Enter string ")).reverse());
    }

    public static void ex47() { // Business: check ISBN-13
        String isbn13string = scanNextLine("Enter the first 12 digits of an ISBN-13 as a string: ");
        int checksum = 0;
        if (isbn13string.length() == 12) {
            for (int i = 0; i < 12; i++) {
                checksum +=
                    (i % 2 == 1)
                        ? Integer.parseInt(Character.toString(isbn13string.charAt(i)))
                        : 3 * Integer.parseInt(Character.toString(isbn13string.charAt(i)));
            }
            checksum = 10 - (checksum % 10);
            IO.print("The ISBN-13 number is %s%d", isbn13string, checksum == 10 ? 0 : checksum);
        } else {
            println("Invalid input");
        }
    }

    public static void ex48() { // Process string
        String string = scanNextLine("Enter a string ");
        StringBuilder oddChars = new StringBuilder();
        for (int i = 0; i < string.length(); i += 2) {
            oddChars.append(string.charAt(i));
        }
        print(oddChars);
    }

    public static void ex49() { // Count vowels and consonants
        String string = scanNextLine("Enter a string ");
        int vocal = 0, consonant = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                switch (Character.toUpperCase(string.charAt(i))) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        vocal++;
                        break;
                    default:
                        consonant++;
                        break;
                }
            }
        }
        IO.print("%d vocals %d consonants", vocal, consonant);
    }

    public static void ex50() { // Print multiplication table
        int table = 0;
        while (++table < 10) {
            for (int i = 1; i < 10; i++) {
                IO.print("%d x %d = %d  ", table, i, (i * table));
            }
            println("");
        }
    }

    public static void ex51() { // Longest common prefix
        String stringA = scanNextLine("Enter string A ");
        String stringB = scanNextLine("Enter string B ");
        int index = 0;
        StringBuilder prefix = new StringBuilder();
        while (stringA.charAt(index) == stringB.charAt(index)) {
            prefix.append(stringA.charAt(index++));
        }
        IO.print("Prefix : %s", prefix);
    }
}
