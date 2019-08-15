package lib.Math;

public class Finance {
    public static float getInterest(float balance, float anualInterestRate) {
        return (balance * (anualInterestRate / 1200));
    }

    public static double getFutureInvestmentValue(
            float amount, float anualInterestRate, float years) {
        return amount * Math.pow((1 + (anualInterestRate / 12)), years);
    }
}
