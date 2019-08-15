import static lib.Misc.IO.print;
import static lib.Misc.IO.println;
import static lib.Misc.IO.scanByte;
import static lib.Misc.IO.scanFloat;
import static lib.Misc.IO.scanInt;

import lib.Geometry.Hexagon;
import lib.Geometry.Point;
import lib.Geometry.Triangle;
import lib.Geometry.Tridimensional.Prism;
import lib.Math.Finance;
import lib.Math.Physics;
import lib.Math.Scales;
import lib.Misc.Calendar;
import lib.Misc.IO;
import lib.Misc.Time;

public abstract class DaLi_02 {

    public static void main(String[] args) {

        ex16();
    }

    public static void ex00() {
    }

    public static void ex01() { // Convert mile to kilometer
        print("Enter miles: ");
        float miles = IO.scanFloat();
        println(miles + " miles is " + Scales.mileToKilometer(miles) + " kilometers;");
    }

    public static void ex02() { // Compute the volume of a triangle
        print("Enter length of the sideLength and height of the Equilateral\n" + "triangle: ");
        float sides = IO.scanFloat();
        Prism triangle = new Prism(sides, sides);
        println("Area : " + triangle.getArea());
        println("Volume of prism : " + triangle.volume());
    }

    public static void ex03() { // Convert meters into feet
        print("Enter a value for meter:");
        float meter = IO.scanFloat();
        println(meter + " meters is " + Scales.meterToFeet(meter) + " feet");
    }

    public static void ex04() { // Convert square meter into ping
        print("Enter a number in square meter: ");
        float squareMeters = IO.scanFloat();
        println(squareMeters + " square meters is " + squareMeters * 0.3025f + " pings");
    }

    public static void ex05() { // Financial application: calculate tips
        print("Enter subtotal: ");
        float subtotal = scanFloat();
        print("Enter grat. rate: ");
        float rate = scanFloat();
        float grat = subtotal * (rate / 100);
        println("The gratuity is $" + grat + " and total is $" + (subtotal + grat));
    }

    public static void ex06() { // Multiply the digits in an integer
        print("Enter a number between 0 and 1000: ");
        int number = scanInt();
        int er, mb, nu;
        if (number % 10 == 0) {
            er = 1;
        } else {
            er = number % 10;
        }

        if ((number / 10) % 10 == 0) {
            mb = 1;
        } else {
            mb = (number / 10) % 10;
        }

        if ((number / 100) % 10 == 0) {
            nu = 1;
        } else {
            nu = (number / 100) % 10;
        }

        println((nu * mb * er));
    }

    public static void ex07() { // Find the number of years
        print("Enter value of minutes: ");
        int totalMinutes = scanInt();
        double yearsfloat = Calendar.minutesToYears(totalMinutes);
        int years = (int) Calendar.minutesToYears(totalMinutes);
        int remainingDays = (int) Calendar.yearsToDays(yearsfloat - years);
        println(
            totalMinutes
                + " minutes is approximately "
                + years
                + " years and "
                + remainingDays
                + " days");
    }

    public static void ex08() { // Current time
        print("Enter the time zone offset to GMT: ");
        byte offset = scanByte();
        Time now = new Time();
        println(now.timeToStringM(offset));
        println(now.timeToString());
    }

    public static void ex09() { // Physics: acceleration
        print("Enter V0: ");
        float v0 = scanFloat();

        print("Enter V1: ");
        float v1 = scanFloat();

        print("Enter time: ");
        float time = scanFloat();

        println("The average acceleration is : " + (Physics.averageAcceleration(v0, v1, time)));
    }

    public static void ex10() { // Science: calculating energy
        print("Enter kg of water: ");
        float m = scanFloat();

        print("Enter initial temperature: ");
        float initialTemperature = scanFloat();

        print("Enter final temperature: ");
        float finalTemperature = scanFloat();

        println(
            "The energy needed is : "
                + (m * (finalTemperature - initialTemperature) * 4184f)
                + " joules");
    }

    public static void ex11() { // Population projection
        print("Enter the number of years: ");
        int years = scanInt();

        int secondsInADay = 86400;
        float birthsPerDay = secondsInADay / 7f;
        float deathsPerDay = secondsInADay / 13f;
        float immigrantsPerDay = secondsInADay / 45f;
        float changePerDay = birthsPerDay - deathsPerDay + immigrantsPerDay;
        float changePerYear = changePerDay * 365;
        int startPopulation = 312032486;

        println("Year 0 : " + startPopulation);
        println("Year " + years + " : " + (startPopulation + (int) (changePerYear * years)));
    }

    public static void ex12() { // Physics: finding runway length
        print("Enter Take off speed: ");
        float takeOffSpeed = scanFloat();
        print("Enter Acceleration: ");
        float acceleration = scanFloat();
        println(
            "The minimum runway length for this airplane is "
                + (Physics.lengthOfSpeedChange(0, takeOffSpeed, acceleration)));
    }

    public static void ex13() { // Financial application: compound value
        float monthlyRate = 1.003125f;
        print("Enter monthly ammount: ");
        float monthlyAmount = scanFloat();
        int monthsToShow = 6;
        int month = 0;
        float value = monthlyAmount * monthlyRate;
        do {

            println("After the " + ++month + " month, value: " + value);
            value = (value + monthlyAmount) * monthlyRate;
            monthsToShow--;
        } while (monthsToShow > 0);
    }

    public static void ex14() { // Health application: computing BMI
        print("Enter weight in pounds: ");
        float weight = scanFloat();

        print("Enter height in inches: ");
        float height = scanFloat();

        double bmi = Scales.poundToKilogram(weight) / Math.pow(Scales.inchToMeter(height), 2);
        println("BMI is : " + bmi);
    }

    public static void ex15() { // Geometry: distance of two points
        print("x1: ");
        float x1 = scanFloat();

        print("y1: ");
        float y1 = scanFloat();

        print("x2: ");
        float x2 = scanFloat();

        print("y2: ");
        float y2 = scanFloat();

        println(
            "The distance between the two points is :" + Point
                .distanceBetweenPoints(x1, y1, x2, y2));
    }

    public static void ex16() { // Geometry: getArea of a hexagon
        print("Enter the length of the hexagon side length: ");
        float sideLength = scanFloat();

        Hexagon hexagon = new Hexagon(sideLength);
        println("The getArea of the hexagon is " + hexagon.getArea());
    }

    public static void ex17() { // Science: wind-chill temperature
        print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        float temp = scanFloat();
        print("Enter the wind speed (>= 2) in miles per hour: ");
        float windSpeed = scanFloat();

        double windChill =
            35.74
                + (0.6215 * temp)
                - (35.75 * Math.pow(windSpeed, 0.16))
                + (0.4275 * temp * Math.pow(windSpeed, 0.16));
        println("The wind chill index is " + windChill);
    }

    public static void ex18() { // Print a table
        ex18PrintMiddlePoint(0, 0, 2, 1);
        ex18PrintMiddlePoint(1, 4, 4, 2);
        ex18PrintMiddlePoint(2, 7, 6, 3);
        ex18PrintMiddlePoint(3, 9, 10, 5);
        ex18PrintMiddlePoint(4, 11, 12, 7);
    }

    private static void ex18PrintMiddlePoint(double ax, double ay, double bx, double by) {
        double[] mp = Point.middlePoint(ax, ay, bx, by);
        double mx = mp[0], my = mp[1];
        println(
            "( "
                + ax
                + ", "
                + ay
                + " )      ( "
                + bx
                + ", "
                + by
                + " )      ( "
                + mx
                + ", "
                + my
                + " )");
    }

    public static void ex19() { // Geometry: getArea of a triangle
        print("Enter point 1 x: ");
        float ax = scanFloat();
        print("Enter point 1 y: ");
        float ay = scanFloat();
        print("Enter point 2 x: ");
        float bx = scanFloat();
        print("Enter point 2 y: ");
        float by = scanFloat();
        print("Enter point 3 x: ");
        float cx = scanFloat();
        print("Enter point 3 y: ");
        float cy = scanFloat();

        Triangle triangle = new Triangle(new Point(ax, ay), new Point(bx, by), new Point(cx, cy));
        println("Area is : " + triangle.getArea());
    }

    public static void ex20() { // Financial application: calculate interest
        print("Enter balance: ");
        float balance = scanFloat();
        print("Enter interest rate: ");
        float interestRate = scanFloat();
        println("The interest is : " + Finance.getInterest(balance, interestRate));
    }

    public static void ex21() { // Financial application: calculate future investment value
        print("Enter investment amount: ");
        float investment = scanFloat();
        print("Enter annual interest rate in percentage: ");
        float anualInterestRate = scanFloat();
        print("Enter number of years: ");
        float years = scanFloat();
        println(
            "Future value is "
                + Finance.getFutureInvestmentValue(investment, anualInterestRate, years));
    }

    public static void ex22() { // Financial application: monetary units
        print("Enter amount: ");
        float amount = scanFloat();

        int remainingAmount = (int) (amount * 100);

        int numberOfOneDolars = remainingAmount / 100;
        remainingAmount %= 100;

        int numberOfQuarters = remainingAmount / 25;
        remainingAmount %= 25;

        int numberOfDimes = remainingAmount / 10;
        remainingAmount %= 10;

        int numberOfNickels = remainingAmount / 5;
        remainingAmount %= 5;

        int numberOfPennies = remainingAmount;
        println("Your amount " + amount + " consists of");
        println(" " + numberOfOneDolars + " dollars");
        println(" " + numberOfQuarters + " quarters ");
        println(" " + numberOfDimes + " dimes");
        println(" " + numberOfNickels + " nickels");
        println(" " + numberOfPennies + " pennies");
    }

    public static void ex23() { // Cost of driving
        print("Enter the driving distance: ");
        float distance = scanFloat();
        print("Enter miles per gallon: ");
        float milesPerGallon = scanFloat();
        print("Enter price per gallon: ");
        float pricePerGalon = scanFloat();
        println("The cost of driving is " + ((distance / milesPerGallon) * pricePerGalon));
    }
}
