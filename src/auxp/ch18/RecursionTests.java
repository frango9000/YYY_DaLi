package auxp.ch18;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RecursionTests {

    public static void main(String[] args) {
//        IntStream.range(0, 20).forEach(i -> System.out.println(factorial(i)));
        System.out.println(isPalindrome("sddadds"));
        System.out.println(isPalindrome("sddadsds"));

        int[] randomInts = IntStream.generate(() -> (int)(Math.random()*10)).limit(10).toArray();

        System.out.println(Arrays.toString(randomInts));
        sort(randomInts);
        System.out.println(Arrays.toString(randomInts));
    }



    static int fib(int index) {
        if (index == 0)
            return 0;
        else if (index == 1)
            return 1;
        else
            return fib(index - 2) + fib(index - 1);
    }

    static int factorial(int num) {
        if (num == 0)
            return 1;
        else
            return num * factorial(num - 1);
    }

//    static boolean isPalindrome(String string){
//        boolean firstAndLastMatch = string.substring(0, 1).equalsIgnoreCase(string.substring(string.length() - 1));
//        if(string.length() < 3)
//            return firstAndLastMatch;
//        else return firstAndLastMatch && isPalindrome(string.substring(1, string.length() - 1));
//    }

    public static boolean isPalindrome(String string){
        return isPalindrome(string, 0, string.length()-1);
    }

    private static boolean isPalindrome(String string, int start, int end) {
        if(end<=start)
            return true;
        else if (string.charAt(start) != string.charAt(end))
            return false;
        else return isPalindrome(string,start+1, end-1);
    }

    public static void sort(int[] list){
        sort(list, 0);
    }

    private static void sort(int[] list, int start) {
        if(start<list.length-1){
            int minIndex = start;
            for (int i = minIndex+1; i < list.length; i++) {
                if (list[i] < list[minIndex])
                    minIndex = i;
            }
            if(minIndex!= start){
                int temp = list[start];
                list[start]= list[minIndex];
                list[minIndex] = temp;
            }
            sort(list, start+1);
        }
    }
}
