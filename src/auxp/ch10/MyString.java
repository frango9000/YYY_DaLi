package auxp.ch10;

import lib.Math.Algebra;

import java.util.Arrays;

import static lib.Misc.IO.println;

public class MyString {

    char[] string;

    public MyString() {
    }

    public MyString(char[] string) {
        this.string = string;
    }

    public MyString(String s) {
        string = new char[s.length()];
        for (int i = 0; i < string.length; i++) {
            string[i] = s.charAt(i);
        }
    }

    public static MyString valueOf(int i) {
        return new MyString(i + "");
    }

    public int compare(String s) {
        return Arrays.compare(string, s.toCharArray());
    }

    public boolean equals(MyString compare) {
        return compare.compare(this.toString()) == 0;
    }

    public MyString substring(int begin, int end) {
        StringBuilder sb = new StringBuilder();
        for (; begin < end; begin++) {
            sb.append(string[begin]);
        }
        return new MyString(sb.toString());
    }

    public MyString substring(int begin) {
        return substring(begin, string.length);
    }

    public MyString toUpperCase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            sb.append(Character.toUpperCase(string[i]));
        }
        return new MyString(sb.toString());
    }

    public MyString toLowerCase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            sb.append(Character.toLowerCase(string[i]));
        }
        return new MyString(sb.toString());
    }

    public char[] toChars() {
        return string;
    }

    public void print() {
        println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            sb.append(string[i]);
        }
        return sb.toString();
    }

    public char charAt(int index) {
        index = Algebra.max(index, 0);
        index = Algebra.min(index, string.length - 1);
        return string[index];
    }

    public int length() {
        return string.length;
    }
}
