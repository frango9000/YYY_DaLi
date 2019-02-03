package lib.Math;

public abstract class Statistics {

    public static double mean(double[] numbers){
        double mean = 0;
        for (int i = 0; i < numbers.length; i++) {
            mean+=numbers[i];
        }
        return mean/numbers.length;
    }
    public static double standardDeviation(double[] numbers){
        double deviation = 0;
        for (int i = 0; i < numbers.length; i++) {
            deviation+=Math.pow(numbers[i],2);
        }
        return Math.sqrt((deviation - (Math.pow(mean(numbers)*numbers.length, 2) / numbers.length)) / (numbers.length - 1));
    }
}
