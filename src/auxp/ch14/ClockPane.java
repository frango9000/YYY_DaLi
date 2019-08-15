package auxp.ch14;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ClockPane extends Pane {

    Timeline animation;
    private int hour;
    private int minute;
    private int second;
    private boolean detailed = false;
    private double clockRadius;
    private double centerX;
    private double centerY;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;

    /**
     * Construct a default clock with the current time
     */
    public ClockPane() {

        setMinSize(125, 150);
        // Construct a calendar for the current date and time
        setCurrentTime();
    }

    public ClockPane(boolean active) {
        this();
        EventHandler<ActionEvent> eventHandler =
            e -> {
                setCurrentTime();
            };

        // clock.setDetailed(true);
        animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    /**
     * Construct a clock with specified hour, minute, and second
     */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setDetailed(boolean detailed) {
        this.detailed = detailed;
    }

    /**
     * Return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Set a new hour
     */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /**
     * Return minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Set a new minute
     */
    public void setMinute(int minute) {
        this.minute = minute;

        paintClock();
    }

    /**
     * Return second
     */
    public int getSecond() {
        return second;
    }

    /**
     * Set a new second
     */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock(); // Repaint the clock
    }

    /**
     * Paint the clock
     */
    private void paintClock() {

        // Initialize clock parameters
        clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX =
            centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY =
            centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        Text digit =
            new Text(
                centerX - 25,
                centerY + clockRadius + 12,
                String.format("%02d:%02d:%02d", hour, minute, second));

        getChildren().clear();
        getChildren().addAll(circle, digit);
        if (secondHandVisible) {
            getChildren().add(sLine);
        }
        if (minuteHandVisible) {
            getChildren().add(mLine);
        }
        if (hourHandVisible) {
            getChildren().add(hLine);
        }

        if (detailed) {
            int angleH = 360 / 12;
            int angleQ = angleH / 4;
            for (int i = 1; i <= 12; i++) {
                getChildren()
                    .add(
                        new Text(
                            centerX
                                - 3
                                + (clockRadius - 15) * Math
                                .sin(Math.toRadians(-(i * angleH) - 180)),
                            centerY
                                + 5
                                + (clockRadius - 15) * Math
                                .cos(Math.toRadians(-(i * angleH) - 180)),
                            i + ""));
                getChildren()
                    .add(
                        new Line(
                            centerX + clockRadius * Math.sin(Math.toRadians(-(i * angleH) - 180)),
                            centerY + clockRadius * Math.cos(Math.toRadians(-(i * angleH) - 180)),
                            centerX + (clockRadius - 8) * Math
                                .sin(Math.toRadians(-(i * angleH) - 180)),
                            centerY + (clockRadius - 8) * Math
                                .cos(Math.toRadians(-(i * angleH) - 180))));
                for (int j = 1; j <= 3; j++) {
                    int t = j % 2 == 0 ? 5 : 0;
                    getChildren()
                        .add(
                            new Line(
                                centerX
                                    + clockRadius
                                    * Math
                                    .sin(Math.toRadians((-(i * angleH) + (j * angleQ)) - 180)),
                                centerY
                                    + clockRadius
                                    * Math
                                    .cos(Math.toRadians((-(i * angleH) + (j * angleQ)) - 180)),
                                centerX
                                    + (clockRadius - 3 - t)
                                    * Math
                                    .sin(Math.toRadians((-(i * angleH) + (j * angleQ)) - 180)),
                                centerY
                                    + (clockRadius - 3 - t)
                                    * Math
                                    .cos(Math.toRadians((-(i * angleH) + (j * angleQ)) - 180))));
                }
            }
        } else {
            int angle = 360 / 12;
            for (int i = 3; i <= 12; i += 3) {
                getChildren()
                    .add(
                        new Text(
                            centerX - 3 + (clockRadius - 15) * Math
                                .sin(Math.toRadians(-(i * angle) - 180)),
                            centerY + 5 + (clockRadius - 15) * Math
                                .cos(Math.toRadians(-(i * angle) - 180)),
                            i + ""));
            }
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }

    public void playAnimation() {
        animation.play();
    }

    public void stopAnimation() {
    }

    public void pauseAnimation() {
        animation.pause();
    }
}
