package auxp.ch20;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.Misc.Randomizer;

public class BouncingBallsPane extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);
        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());
        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);
        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private class MultipleBallPane extends Pane {
        private Timeline animation;

        public MultipleBallPane() {
            // Create an animation for moving the ball
            animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play(); // Start animation
        }

        public void add() {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            Ball ball = new Ball(30, 30, Randomizer.randomInt(2, 21), color);
            getChildren().add(ball);
            ball.setOnMouseClicked(event -> getChildren().remove(ball));
        }

        public void subtract() {
            if (getChildren().size() > 0) {
                getChildren().remove(getChildren().size() - 1);
            }
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }

        public void decreaseSpeed() {
            animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }

        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }

        protected void moveBall() {
            ObservableList<Node> nodes = this.getChildren();
            for (Node node : nodes) {
                Ball ball = (Ball) node;
                // Check boundaries
                if (ball.getCenterX() < ball.getRadius()
                        || ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1; // Change ball move direction
                }
                if (ball.getCenterY() < ball.getRadius()
                        || ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1; // Change ball move direction
                }
                // Adjust ball position
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
            int size = nodes.size();
            for (int i = 0; i < size - 1; i++) {
                Ball ballA = (Ball) nodes.get(i);
                Point2D centerA = new Point2D(ballA.getCenterX(), ballA.getCenterY());
                for (int j = i + 1; j < size; ) {
                    Ball ballB = (Ball) nodes.get(j);
                    Point2D centerB = new Point2D(ballB.getCenterX(), ballB.getCenterY());
                    if (centerA.distance(centerB) < ballA.getRadius() + ballB.getRadius()) {
                        ballA.setRadius(ballA.getRadius() + ballB.getRadius());
                        this.getChildren().remove(ballB);
                        size--;
                    } else j++;
                }
            }
        }
    }

    class Ball extends Circle {
        private double dx = 1, dy = 1;
        private Point2D center = new Point2D(1, 1);

        Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            center = new Point2D(x, y);
            setFill(color); // Set ball color
        }

        public Point2D getBallCenter() {
            return center;
        }

        public void setBallCenter(Point2D center) {
            this.center = center;
        }
    }
}
