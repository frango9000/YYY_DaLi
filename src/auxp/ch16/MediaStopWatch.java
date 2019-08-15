package auxp.ch16;

public class MediaStopWatch {
    private long elapsedTime = 0;
    private long startTime;
    private long endTime;

    public MediaStopWatch() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void pause() {
        elapsedTime += System.currentTimeMillis() - startTime;
    }

    public void reset() {
        start();
        stop();
        elapsedTime = 0;
    }

    public void stop() {
        endTime = System.currentTimeMillis();
        elapsedTime += startTime - endTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public String getElapsedFormat(long elapsed) {
        long totalMilliseconds = elapsed;
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

    public String getElapsedFormat() {
        return getElapsedFormat(elapsedTime);
    }

    public String getLapsedFormat() {
        return getElapsedFormat(elapsedTime + System.currentTimeMillis() - startTime);
    }

    public void consoleOutElapsedTime() {
        System.out.println(getElapsedFormat());
    }
}
