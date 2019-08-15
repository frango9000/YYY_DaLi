package auxp.ch15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class RunningFan extends StackPane {
    private double startAngle = 15;
    private double speed = 100; // max 100
    private Timeline fan;
    private Pane blades = getBlades();
    private ObservableList<Node> list = blades.getChildren(); // List of arcs

    public RunningFan() {
        getChildren().addAll(getCircle(), blades);
        fan = new Timeline(new KeyFrame(Duration.millis(1000 / speed), event -> spinFan()));
        fan.setRate(speed / 100);
        fan.setCycleCount(Timeline.INDEFINITE);
        fan.play();
    }

    private void spinFan() {
        for (int i = 0; i < list.size(); i++) {
            Arc a = (Arc) list.get(i);
            a.setStartAngle(a.getStartAngle() + startAngle);
        }
    }

    private Pane getBlades() {
        Pane pane = new Pane();
        double angle = 0;
        for (int i = 0; i < 4; i++) {
            Arc arc = new Arc(100, 100, 90, 90, angle + 90, 50);
            arc.setFill(Color.BLACK);
            arc.setType(ArcType.ROUND);
            pane.getChildren().add(arc);
            angle += 90;
        }
        return pane;
    }

    public void pause() {
        fan.pause();
    }

    public void play() {
        fan.play();
    }

    public void reverse() {
        startAngle *= -1;
    }

    public void setSpeed(double speed) {
        speed = Math.min(speed, 100);
        speed = Math.max(0, speed);
        fan.setRate(speed / 100);
    }

    private Circle getCircle() {
        Circle c = new Circle();
        c.setRadius(100);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        return c;
    }
}
