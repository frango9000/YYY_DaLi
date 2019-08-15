package auxp.ch15;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lib.Geometry.Triangle;
import lib.MyFX.ToolFX;

public class TaggedTrianglePane extends Pane {
    private Text angle1, angle2, angle3;
    private Circle c1, c2, c3, superC;

    private boolean visibleCircle;

    public TaggedTrianglePane() {
        this(false);
    }

    public TaggedTrianglePane(boolean visibleCircle) {
        this.visibleCircle = visibleCircle;
        setMinSize(600, 600);
        superC = new Circle();
        ToolFX.setFillStroke(null, Color.BLACK, superC);
        c1 = new Circle(50, 50, 15, Color.BLACK);
        c1.setOnMouseDragged(new AngleMover());
        c2 = new Circle(300, 50, 15, Color.BLACK);
        c2.setOnMouseDragged(new AngleMover());
        c3 = new Circle(50, 300, 15, Color.BLACK);
        c3.setOnMouseDragged(new AngleMover());
        Group circles = new Group(c1, c2, c3, superC);

        angle1 = new Text();
        angle1.xProperty().bind(c1.centerXProperty().add(25));
        angle1.yProperty().bind(c1.centerYProperty().subtract(10));
        angle2 = new Text();
        angle2.xProperty().bind(c2.centerXProperty().add(25));
        angle2.yProperty().bind(c2.centerYProperty().subtract(10));
        angle3 = new Text();
        angle3.xProperty().bind(c3.centerXProperty().add(25));
        angle3.yProperty().bind(c3.centerYProperty().subtract(10));
        updateAngles();
        Group labels = new Group(angle1, angle2, angle3);

        Line sideA = new Line();
        sideA.startXProperty().bind(c1.centerXProperty());
        sideA.startYProperty().bind(c1.centerYProperty());
        sideA.endXProperty().bind(c2.centerXProperty());
        sideA.endYProperty().bind(c2.centerYProperty());
        Line sideB = new Line();
        sideB.startXProperty().bind(c2.centerXProperty());
        sideB.startYProperty().bind(c2.centerYProperty());
        sideB.endXProperty().bind(c3.centerXProperty());
        sideB.endYProperty().bind(c3.centerYProperty());
        Line sideC = new Line();
        sideC.startXProperty().bind(c3.centerXProperty());
        sideC.startYProperty().bind(c3.centerYProperty());
        sideC.endXProperty().bind(c1.centerXProperty());
        sideC.endYProperty().bind(c1.centerYProperty());
        Group lines = new Group(sideA, sideB, sideC);

        getChildren().addAll(circles, labels, lines);
    }

    private void updateAngles() {
        Triangle triangle =
                new Triangle(
                        c1.getCenterX(),
                        c1.getCenterY(),
                        c2.getCenterX(),
                        c2.getCenterY(),
                        c3.getCenterX(),
                        c3.getCenterY());
        angle1.setText(String.format("%.2f", Math.toDegrees(triangle.angleA)));
        angle2.setText(String.format("%.2f", Math.toDegrees(triangle.angleB)));
        angle3.setText(String.format("%.2f", Math.toDegrees(triangle.angleC)));

        if (visibleCircle) {
            lib.Geometry.Circle tcirc =
                    new lib.Geometry.Circle(
                            c1.getCenterX(),
                            c1.getCenterY(),
                            c2.getCenterX(),
                            c2.getCenterY(),
                            c3.getCenterX(),
                            c3.getCenterY());
            superC.setCenterX(tcirc.center.x);
            superC.setCenterY(tcirc.center.y);
            superC.setRadius(tcirc.radius);
        }
    }

    private class AngleMover implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            Circle circle = (Circle) event.getSource();
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
            updateAngles();
        }
    }
}
