package lib.Math;

public class Physics {

    public static double lengthOfSpeedChange(
        float initialSpeed, float finalSpeed, float acceleration) {
        return Math.pow(finalSpeed - initialSpeed, 2) / (2 * acceleration);
    }

    public static float averageAcceleration(float initialSpeed, float finalSpeed, float time) {
        return (finalSpeed - initialSpeed) / time;
    }
}
