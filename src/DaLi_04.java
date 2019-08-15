import lib.Geometry.*;
import lib.Geometry.Tridimensional.Sphere;
import lib.Misc.Asserts;
import lib.Misc.IO;

import java.util.Random;
import java.util.Scanner;

import static lib.Misc.IO.*;
import static lib.Misc.Randomizer.randomInt;

public abstract class DaLi_04 {
    public static void main(String[] args) {

        ex25();
    }

    public static void ex00() {
    }

    public static void ep01() {
        print("Enter x1: ");
        float x1 = scanFloat();
        print("Enter y1: ");
        float y1 = scanFloat();

        print("Enter x2: ");
        float x2 = scanFloat();
        print("Enter y2: ");
        float y2 = scanFloat();

        print("Enter x3: ");
        float x3 = scanFloat();
        print("Enter y3: ");
        float y3 = scanFloat();

        Triangle triangle = new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));

        println(Math.toDegrees(triangle.angleA));
        println(Math.toDegrees(triangle.angleB));
        println(Math.toDegrees(triangle.angleC));
    }

    public static void ep05() {
        Random rand = new Random();
        String lottery = "" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
        println(lottery);
        print("Enter your 3-digit lottery number: ");
        String guess = scanNextLine();

        int prize;
        int matches = ep05matches(lottery, guess);
        if (lottery == guess) prize = 12000;
        else if (matches == 3) prize = 7000;
        else if (matches == 2) prize = 5000;
        else if (matches == 1) prize = 2000;
        else prize = 0;

        println("Winning lottery number is " + lottery);
        println("Your prize is " + prize);
    }

    private static int ep05matches(String a, String b) {
        char[] arrA = ep05array(a);
        char[] arrB = ep05array(b);
        int count = 0;
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrB.length; j++) {
                if (arrA[i] == arrB[j]) count++;
            }
        }
        return count;
    }

    private static char[] ep05array(String string) {
        char[] arr = new char[3];
        arr[0] = string.charAt(0);
        arr[1] = string.charAt(1);
        arr[2] = string.charAt(2);
        return arr;
    }

    public static void ep06() {
        double amount = 12618.98;
        double interestRate = 0.0013;
        double interest = amount * interestRate;
        System.out.printf("Interest is $%4.2f", interest);
    }

    public static void ex01() { // Geometry: getArea of a pentagon
        print("Enter radius: ");
        float r = scanFloat();
        Pentagon pentagon = new Pentagon(r, true);

        IO.print("Area of the pentagon is %4.2f", pentagon.getArea());
    }

    public static void ex02() { // Geometry: great circle distance
        print("Enter x1: ");
        float x1 = scanFloat();
        print("Enter y1: ");
        float y1 = scanFloat();

        print("Enter x2: ");
        float x2 = scanFloat();
        print("Enter y2: ");
        float y2 = scanFloat();

        Sphere sphere = new Sphere(6371.01);

        IO.print(
                "Distance between points is %4.10f",
                sphere.distanceBetweenPoints(new Point(x1, y1), new Point(x2, y2)));
    }

    public static void ex03() { // Geography: estimate areas
        Point charlotte = new Point(35.2270869, -80.8431267);
        Point atlanta = new Point(33.7489954, -84.3879824);
        Point orlando = new Point(28.5383355, -81.3792365);
        Point savannah = new Point(32.0835407, -81.0998342);

        Triangle t1 = new Triangle(charlotte, atlanta, orlando);
        Triangle t2 = new Triangle(charlotte, atlanta, savannah);

        IO.print("Area : %4.8f", (t1.getArea() + t2.getArea()));
    }

    public static void ex04() { // Geometry: getArea of a hexagon
        print("Enter sideLength of hexagon: ");
        float side = scanFloat();

        Hexagon hexagon = new Hexagon(side);
        IO.print("Area is %4.8f", hexagon.getArea());
    }

    public static void ex05() { // Geometry: getArea of a regular polygon
        print("Enter num of sides ");
        int numOfSides = scanInt();

        print("Enter side Length of polygon: ");
        float side = scanFloat();

        Polygon polygon = new Polygon(numOfSides, side);
        IO.print("Area is %4.8f", polygon.getArea());
    }

    public static void ex06() { // Random points on a circle)
        Circle circle = new Circle(40);
        float randomDegree1 = randomInt(35999) / 100f;
        float randomDegree2 = randomInt(35999) / 100f;
        float randomDegree3 = randomInt(35999) / 100f;

        Point point1 = circle.pointOnAngle(randomDegree1);
        Point point2 = circle.pointOnAngle(randomDegree2);
        Point point3 = circle.pointOnAngle(randomDegree3);

        Triangle triangle = new Triangle(point1, point2, point3);
        println(triangle.toString());
    }

    public static void ex07() { // Corner point coordinates
        print("Enter radius of pentagon: ");
        float radius = scanFloat();
        Pentagon pentagon = new Pentagon(radius, true);
        pentagon.setPoints(0);
        println(pentagon.toString());
    }

    public static void ex08() { // Find the character of an ASCII code
        print("Enter a ASCII code: ");
        int code = scanInt();
        IO.print("The character for the ASCII code %d is %s", code, (char) code);
    }

    public static void ex09() { // Find the Unicode of a character
        print("Enter a character: ");
        char character = scanChar();
        IO.print("The Unicode for character %s is %d", character, (int) character);
    }

    public static void ex10() { // Guess birthday
        println("Enter Y for Yes; N for No: ");
        println(Asserts.consoleAssert() ? "Yes" : "No");
    }

    public static void ex11() { // Binary to decimal)
        println("Enter Binary digits: ");
        String binary = scanNext();
        println("In decimal : " + Integer.parseInt(binary, 2));

        println("Enter Decimal digits: ");
        int decimal = scanInt();
        println("In binary : " + Integer.toBinaryString(decimal));
    }

    public static void ex12() { // Hex to binary
        println("Enter Hexadecimal digits: ");
        String binary = scanNext();
        println("In decimal : " + Integer.parseInt(binary, 16));

        println("Enter decimal digits: ");
        int decimal = scanInt();
        println("In Hexadecimal : " + Integer.toHexString(decimal));
    }

    public static void ex13() { // (Vowel or consonant?
        print("Enter a character: ");
        char character = scanChar();
        if (Character.isAlphabetic(character))
            switch (Character.toUpperCase(character)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    println("Vocal");
                    break;
                default:
                    println("Consonant");
                    break;
            }
        else println("Invalid Input.");
    }

    public static void ex14() { // Convert letter grade to number)
        print("Enter a grade: ");
        char grade = scanChar();
        if (Character.isAlphabetic(grade)) {
            switch (Character.toUpperCase(grade)) {
                case 'A':
                    println("5");
                    break;
                case 'B':
                    println("4");
                    break;
                case 'C':
                    println("3");
                    break;
                case 'D':
                    println("2");
                    break;
                case 'F':
                    println("1");
                    break;
                default:
                    println("Invalid Input.");
                    break;
            }
        } else println("Invalid Input.");
    }

    public static void ex15() { // Phone key pads)
        print("Enter a letter: ");
        char letter = scanChar();
        int number = 0;
        number = ex15(letter);
        IO.print("Number is : %d", number);
    }

    public static int ex15(char letter) {
        if (Character.isLetter(letter)) {
            letter = Character.toUpperCase(letter);
            if (letter >= 'W') return 9;
            else if (letter >= 'T') return 8;
            else if (letter >= 'P') return 7;
            else if (letter >= 'M') return 6;
            else if (letter >= 'J') return 5;
            else if (letter >= 'G') return 4;
            else if (letter >= 'D') return 3;
            else if (letter >= 'A') return 2;
            else return -1;
        } else return -1;
    }

    public static void ex16() { // Random character
        // print((char)97 +""+ (char)122); // a - z
        IO.print("Random char is : %c", (char) (randomInt(25) + 97));
    }

    public static void ex17() { // Days of a month
        print("Enter a year: ");
        int year = scanInt();
        print("Enter a month: ");
        String month = scanNext();

        boolean leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        print(month + " " + year + " has ");

        if (month.equals("Jan")
                || month.equals("Mar")
                || month.equals("May")
                || month.equals("Jul")
                || month.equals("Aug")
                || month.equals("Oct")
                || month.equals("Dec")) println(31 + " days");
        else if (month.equals("Apr")
                || month.equals("Jun")
                || month.equals("Sep")
                || month.equals("Nov")) println(30 + " days");
        else println(((leapYear) ? 29 : 28) + " days");
    }

    public static void ex18() { // Student major and status
        print("Enter two characters: ");
        String code = scanNext();

        String string1 = "", string2 = "0";

        switch (code.charAt(0)) {
            case 'I':
                string1 = "Information Management";
                break;
            case 'C':
                string1 = "Computer Science";
                break;
            case 'A':
                string1 = "Accounting";
                break;
        }
        switch ((int) code.charAt(1)) {
            case 49:
                string2 = "freshman";
                break;
            case 50:
                string2 = "sophomore";
                break;
            case 51:
                string2 = "junior";
                break;
            case 52:
                string2 = "senior";
                break;
        }
        println(string1 + " " + string2);
    }

    public static void ex19() { // Business: check ISBN-10
        DaLi_03.ex09();
    }

    public static void ex20() { // Process a string
        print("Enter string: ");
        String code = scanNext();
        IO.print("length %d, %c", code.length(), code.charAt(code.length() - 1));
    }

    public static void ex21() { // Check SSN
        print("Enter string: ");
        String code = scanNext();
        if ((code.charAt(3) != '-' && code.charAt(6) != '-')) {
            print("Invalid format");
        } else {
            print("Valid format");
        }
    }

    public static void ex22() { // Check substring
        print("Enter string: ");
        String code1 = scanNext();

        print("Enter string: ");
        String code2 = scanNext();

        if (code2.contains(code1)) {
            println("1 is substring of 2");
        } else if (code1.contains(code2)) {
            println("2 is substring of 1");
        } else println("no substrings");
    }

    public static void ex23() { // Financial application: payroll
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter payroll inforation
        System.out.print("Enter employee’s name: ");
        String name = input.next();
        System.out.print("Enter number of hours worked in a week: ");
        double hoursWorked = input.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        double hourlyPayRate = input.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        double federalTaxRate = input.nextDouble();
        System.out.print("Enter state tax withholding rate: ");
        double stateTaxRate = input.nextDouble();

        // Display payroll statement
        double grossPay, federal, state, totalDeduction;
        System.out.println(
                "Employee Name: "
                        + name
                        + "\nHours Worked: "
                        + hoursWorked
                        + "\nPay Rate: $"
                        + hourlyPayRate
                        + "\nGross Pay: $"
                        + (grossPay = hoursWorked * hourlyPayRate)
                        + "\nDeductions:\n   Federal Witholding (20.0%): $"
                        + (federal = grossPay * federalTaxRate)
                        + "\n   State Witholding (9.0%): $"
                        + (state = grossPay * stateTaxRate)
                        + "\n   Total Deduction: $"
                        + (totalDeduction = federal + state)
                        + "\nNet Pay: $"
                        + (grossPay - totalDeduction));
    }

    public static void ex24() { // Enter three countries
        print("Enter country 1: ");
        String country1 = scanNext();

        print("Enter country 1: ");
        String country2 = scanNext();

        print("Enter country 1: ");
        String country3 = scanNext();

        if (country1.compareTo(country2) < 0 && country1.compareTo(country3) < 0) {
            println(country1);
            println(
                    ""
                            + (country2.compareTo(country3) < 0
                            ? country2 + country3
                            : country3 + "\n" + country2));
        } else if (country2.compareTo(country1) < 0 && country2.compareTo(country3) < 0) {
            println(country2);
            println(
                    ""
                            + (country3.compareTo(country1) < 0
                            ? country3 + country1
                            : country1 + "\n" + country3));
        } else if (country3.compareTo(country2) < 0 && country3.compareTo(country1) < 0) {
            println(country3);
            println(
                    ""
                            + (country1.compareTo(country2) < 0
                            ? country1 + country2
                            : country2 + "\n" + country1));
        }
    }

    public static void ex25() { // Generate vehicle plate numbers)
        print((char) 65 + "" + (char) 90); // A - Z

        int char1 = randomInt(25) + 65;
        int char2 = randomInt(25) + 65;
        int char3 = randomInt(25) + 65;

        int num = randomInt(10000);

        IO.print("Plate is %s", num + " - " + (char) char1 + (char) char2 + (char) char3);
    }

    public static void ex26() { // Financial application: monetary units
        DaLi_02.ex22();
    }
}
