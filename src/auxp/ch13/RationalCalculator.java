package auxp.ch13;

import java.util.InputMismatchException;

public class RationalCalculator {

    /**
     * Main method
     */
    public static void main(String argss) throws NumberFormatException, InputMismatchException {
        String[] args = argss.split(" ");

        // Check number of strings passed
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            throw new InputMismatchException();
        }

        char op = args[1].charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new InputMismatchException();
        }

        // The result of the operation
        Rational result = new Rational();

        Rational r1 =
            new Rational(Long.parseLong(args[0].split("/")[0]),
                Long.parseLong(args[0].split("/")[1]));
        Rational r2 =
            new Rational(Long.parseLong(args[2].split("/")[0]),
                Long.parseLong(args[2].split("/")[1]));
        // Determine the operator
        switch (op) {
            case '+':
                result = r1.add(r2);
                break;
            case '-':
                result = r1.subtract(r2);
                break;
            case '*':
                result = r1.multiply(r2);
                break;
            case '/':
                result = r1.divide(r2);
        }
        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }
}
