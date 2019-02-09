package lib.Misc;

import java.util.Random;
import java.util.Scanner;

public abstract class IO {

    public static void println(Object str) {
        System.out.println(str);
    }
    public static void print(Object str) {
        System.out.print(str);
    }
    public static void printf(String format, Object... args) {
        System.out.format(format, args);
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static float scanFloat() {
        return scanner().nextFloat();
    }
    public static double scanDouble() {
        return scanner().nextDouble();
    }
    public static int scanInt() {
        return scanner().nextInt();
    }
    public static long scanLong() {
        return scanner().nextLong();
    }
    public static byte scanByte() {
        return scanner().nextByte();
    }
    public static short scanShort() {
        return scanner().nextShort();
    }
    public static String scanNext() {
        return scanner().next();
    }
    public static String scanNextLine() {
        return scanner().nextLine();
    }
    public static char scanChar() {
        return scanNext().charAt(0);
    }

    public static float scanFloat(String message) {
        print(message);
        return scanFloat();
    }
    public static double scanDouble(String message) {
        print(message);
        return scanDouble();
    }
    public static int scanInt(String message) {
        print(message);
        return scanInt();
    }
    public static long scanLong(String message) {
        print(message);
        return scanLong();
    }
    public static byte scanByte(String message) {
        print(message);
        return scanByte();
    }
    public static short scanShort(String message) {
        print(message);
        return scanShort();
    }
    public static String scanNext(String message) {
        print(message);
        return scanNext();
    }
    public static String scanNextLine(String message) {
        print(message);
        return scanNextLine();
    }
    public static char scanChar(String message) {
        print(message);
        return scanChar();
    }

    public static byte scanByte(String message, Object... args) {
        printf(message,args);
        return scanByte();
    }
    public static short scanShort(String message, Object... args) {
        printf(message,args);
        return scanShort();
    }
    public static int scanInt(String message, Object... args) {
        printf(message,args);
        return scanInt();
    }
    public static long scanLongF(String message, Object... args) {
        printf(message,args);
        return scanLong();
    }
    public static float scanFloatF(String message, Object... args) {
        printf(message,args);
        return scanFloat();
    }
    public static double scanDouble(String message, Object... args) {
        printf(message, args);
        return scanDouble();
    }
    public static char scanChar(String message, Object... args) {
        printf(message,args);
        return scanChar();
    }
    public static String scanNext(String message, Object... args) {
        printf(message,args);
        return scanNext();
    }
    public static String scanNextLine(String message, Object... args) {
        printf(message,args);
        return scanNextLine();
    }

}
