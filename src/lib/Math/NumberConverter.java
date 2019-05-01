package lib.Math;

public class NumberConverter {


    public static String binToOct(String bin) {
        return decToOct(binToDec(bin));
    }

    public static int binToDec(String bin) throws NumberFormatException {
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != '0' && bin.charAt(i) != '1')
                throw new NumberFormatException("String is not a binary string");
        }
        return Integer.parseInt(bin, 2);
    }

    public static String binToHex(String bin) {
        return decToHex(binToDec(bin));
    }

    public static String decToBin(int dec, int bits) {
        return String.format("%0" + bits + "d", Long.parseLong(decToBin(dec)));
    }

    public static String decToBin(int dec) {
        return Integer.toBinaryString(dec);
    }

    public static String decToOct(int dec) {
        return Integer.toOctalString(dec);
    }

    public static String decToHex(int dec) {
        return Integer.toHexString(dec);
    }

    public static String decToHex(int dec, int bits) {
        StringBuilder hex = new StringBuilder(decToHex(dec));
        while (hex.length() < bits)
            hex.insert(0, 0);
        return hex.toString();
    }


    public static String octToBin(String oct) {
        return decToBin(octToDec(oct));
    }

    public static int octToDec(String oct) throws NumberFormatException {
        for (int i = 0; i < oct.length(); i++) {
            if (oct.charAt(i) < '0' || oct.charAt(i) > '7')
                throw new NumberFormatException("String is not an octal string");
        }
        return Integer.parseInt(oct, 8);
    }

    public static String octToHex(String oct) {
        return decToHex(octToDec(oct));
    }


    public static String hexToBin(String hex) {
        return decToBin(hexToDec(hex));
    }

    public static String hexToOct(String hex) {
        return decToOct(hexToDec(hex));
    }

    public static int hexToDec(String hex) throws NumberFormatException {
        hex = hex.toLowerCase();
        for (int i = 0; i < hex.length(); i++) {
            if (!(hex.charAt(i) >= '0' || hex.charAt(i) <= '9') || !(hex.charAt(i) >= 'a' || hex.charAt(i) <= 'f'))
                throw new NumberFormatException("String is not a hex string");
        }
        return Integer.parseInt(hex, 16);
    }

}
