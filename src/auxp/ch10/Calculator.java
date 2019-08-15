package auxp.ch10;

import java.util.InputMismatchException;
import lib.Misc.Asserts;

public class Calculator {

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
        if (!Asserts.isInteger(args[0]) || !Asserts.isInteger(args[2])) {
            throw new NumberFormatException();
        }

        char op = args[1].charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new InputMismatchException();
        }

        // The result of the operation
        int result = 0;
        // Determine the operator
        switch (op) {
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '−':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case '.':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        }
        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }
}
