package auxp.ch18;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class RecursionTests {

    public static void main(String[] args) {
//        IntStream.range(0, 20).forEach(i -> System.out.println(factorial(i)));
//        System.out.println(isPalindrome("sddadds"));
//        System.out.println(isPalindrome("sddadsds"));

//        int[] randomInts = IntStream.generate(() -> (int)(Math.random()*100)).limit(20).toArray();
//        System.out.println(Arrays.toString(randomInts));
//        sort(randomInts);
//        System.out.println(Arrays.toString(randomInts));

//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        System.out.println(binarySearch(nums, 4));

        File file = new File("C:/xampp/php");
        System.out.println(file + ": " + recursiveFolderSize(file) + " bytes");

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

    static int tailRecursiveFactorial(int num){
        return tailRecursiveFactorial(num, 1);
    }
    static int tailRecursiveFactorial(int num, int result){
        if(num == 0)
            return result;
        else return tailRecursiveFactorial(num-1, num*result);
    }


//  Inefficient new string on each call

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
    public static int binarySearch(int[] list, int search){
        return binarySearch(list, search, 0, list.length);
    }

    private static int binarySearch(int[] list, int search, int start, int end){//both are inclusives
        if(start>end)
            return -start-1;
        int mid = start+end/2;
        if(search < list[mid])
            return binarySearch(list, search, start, mid-1);
        else if(search == list[mid])
            return mid;
        else
            return binarySearch(list, search, mid+1, end);

    }

    public static long recursiveFolderSize(File file){
        long sum  = 0;
        if(file.isDirectory()) {
           File[] files = file.listFiles();
            assert files != null;
            for(File subFile : files){
                sum += recursiveFolderSize(subFile);
            }
        }
        else sum += file.length();
        return sum;
    }
}
