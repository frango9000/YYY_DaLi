package lib.Misc;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void reset() {
        start();
        stop();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public String getElapsedFormat() {

        long totalMilliseconds = getElapsedTime();
        long currentMilliseconds = totalMilliseconds % 1000;
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
        return String.format(
                "%02d:%02d:%02d:%03d", currentHour, currentMinute, currentSecond, currentMilliseconds);
    }

    public void consoleOutElapsedTime() {
        System.out.println(getElapsedFormat());
    }
}
