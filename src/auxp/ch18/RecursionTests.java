package auxp.ch18;

import java.util.stream.IntStream;

public class RecursionTests {

    public static void main(String[] args) {
//        IntStream.range(0, 20).forEach(i -> System.out.println(factorial(i)));
        System.out.println(isPalindrome("sddadds"));
        System.out.println(isPalindrome("sddadsds"));
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

    static boolean isPalindrome(String string){
        boolean firstAndLastMatch = string.substring(0, 1).equalsIgnoreCase(string.substring(string.length() - 1));
        if(string.length() < 3)
            return firstAndLastMatch;
        else return firstAndLastMatch && isPalindrome(string.substring(1, string.length() - 1));
    }

}
