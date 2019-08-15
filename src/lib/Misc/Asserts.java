package lib.Misc;

public abstract class Asserts {

    public static Boolean consoleAssert() {
        switch ((int) IO.scanChar()) {
            case 121: // 'y'
            case 89: // 'Y'
                return true;
            case 110: // 'n'
            case 78: // 'N'
                return false;
        }
        return null;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
