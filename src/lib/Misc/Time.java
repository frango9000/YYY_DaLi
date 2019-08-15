package lib.Misc;

import javafx.util.Duration;

public class Time {

    long totalMilliseconds;
    long totalSeconds;
    long currentSecond;
    long totalMinutes;
    long currentMinute;
    long totalHours;
    long currentHour;

    long totalDays;
    long currentDay;

    public Time() {
        this(System.currentTimeMillis());
    }

    public Time(long totalMilliseconds) {
        // Obtain the total milliseconds
        this.totalMilliseconds = totalMilliseconds;
        // Obtain the total seconds
        totalSeconds = totalMilliseconds / 1000;
        // Compute the current second in the minute in the hour
        currentSecond = totalSeconds % 60;
        // Obtain the total minutes
        totalMinutes = totalSeconds / 60;
        // Compute the current minute in the hour
        currentMinute = totalMinutes % 60;
        // Obtain the total hours
        totalHours = totalMinutes / 60;
        // Compute the current hour
        currentHour = totalHours % 24;
        // Obtain the total days
        totalDays = totalHours / 24;
        // Compute the current day
        currentDay = totalHours % 365;
    }

    public Time(Duration fxduration) {
        this((long) fxduration.toMillis());
    }

    public static String millisToTimeString(long millis) {
        long totalMilliseconds = millis;
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        return totalHours + ":" + currentMinute + ":" + currentSecond;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", totalHours, currentMinute, currentSecond);
    }

    public long getCurrentSecond() {
        return currentSecond;
    }

    public void setCurrentSecond(long currentSecond) {
        this.currentSecond = currentSecond;
    }

    public long getCurrentMinute() {
        return currentMinute;
    }

    public void setCurrentMinute(long currentMinute) {
        this.currentMinute = currentMinute;
    }

    public long getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(long currentHour) {
        this.currentHour = currentHour;
    }

    public void setTime() {
        long totalMilliseconds = System.currentTimeMillis();
    }

    public String timeToString() {
        return ("Current time is "
            + currentHour
            + ":"
            + currentMinute
            + ":"
            + currentSecond
            + " GMT: ");
    }

    public String timeToStringM(byte offset) {
        long offsetHour = currentHour + offset;
        if (offsetHour >= 24) {
            offsetHour -= 24;
        }
        return ("Current time is "
            + offsetHour
            + ":"
            + currentMinute
            + ":"
            + currentSecond
            + " GMT: "
            + offset);
    }

    public String timeToString(byte offset) {
        long offsetHour = currentHour + offset;
        String post = "AM";
        if (offsetHour >= 24) {
            offsetHour -= 24;
        }
        if (offsetHour > 12) {
            offsetHour -= 12;
            post = "PM";
        }
        return ("Current time is "
            + offsetHour
            + ":"
            + currentMinute
            + ":"
            + currentSecond
            + " "
            + post
            + " GMT: "
            + offset);
    }
}
