package lib.Misc;

import java.util.Scanner;

public abstract class IO {

    public static void println(Object str){
        System.out.println(str);
    }
    public static void print(Object str){
        System.out.print(str);
    }
    public static Scanner scanner(){
        return new Scanner(System.in);
    }
    public static float scanFloat(){
        return scanner().nextFloat();
    }
    public static int scanInt(){
        return scanner().nextInt();
    }
    public static byte scanByte(){
        return scanner().nextByte();
    }
    public static short scanShort(){
        return scanner().nextShort();
    }

}
