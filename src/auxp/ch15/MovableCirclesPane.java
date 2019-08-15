package auxp.ch15;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lib.Geometry.Point;

public class MovableCirclesPane extends Pane {

    Circle c1;
    Circle c2;

    Pane labelPane;

    public MovableCirclesPane() {

        c1 = new Circle(40, 40, 10, Color.GRAY);
        c2 = new Circle(120, 150, 10, Color.GRAY);
        Group circles = new Group(c1, c2);

        labelPane = new Pane();
        updateLabelPane();

        getChildren().addAll(labelPane, circles);
        setMinSize(600, 600);
        setPadding(new Insets(5));
        c1.setOnMouseDragged(new MoveCircleHandler());
        c2.setOnMouseDragged(new MoveCircleHandler());
    }

    private void updateLabelPane() {
        labelPane.getChildren().clear();
        Point middlePoint1 =
                new lib.Geometry.Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY())
                        .middlePoint();
        double length1 =
                new lib.Geometry.Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY())
                        .getLength();
        Text label1 = new Text(middlePoint1.x, middlePoint1.y, String.format("%.1f", length1));
        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        line.setStroke(Color.BLACK);
        labelPane.getChildren().addAll(label1, line);
    }

    private class MoveCircleHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            Circle c = (Circle) event.getSource();
            c.setCenterX(event.getX());
            c.setCenterY(event.getY());
            updateLabelPane();
        }
    }
}
