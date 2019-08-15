package auxp.ch15;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import lib.MyFX.ToolFX;

public class AnimatedPendulum extends Pane {
    PathTransition pt;
    FadeTransition ft;

    public AnimatedPendulum() {
        this(false);
    }

    public AnimatedPendulum(boolean canFade) {
        Arc arc = new Arc(200, 50, 200, 200, 230, 80);
        ToolFX.setFillStroke(null, Color.BLACK, arc);
        arc.setType(ArcType.OPEN);
        Circle base = new Circle(arc.getCenterX(), arc.getCenterY(), 10, Color.DARKGREY);
        Circle circle =
                new Circle(arc.getCenterX(), arc.getCenterY() + arc.getRadiusY(), 20, Color.BLACK);

        pt = new PathTransition(Duration.millis(1000), arc, circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        ft = new FadeTransition(Duration.millis(500), circle);
        if (canFade) {
            ft.setFromValue(1);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }

        Line line =
                new Line(arc.getCenterX(), arc.getCenterY(), circle.getCenterX(), circle.getCenterY());

        line.endXProperty().bind(circle.centerXProperty().add(circle.translateXProperty()));
        line.endYProperty().bind(circle.centerYProperty().add(circle.translateYProperty()));

        getChildren().addAll(line, circle, base);

        setOnMousePressed(event -> pauseAnimation());
        setOnMouseReleased(event -> playAnimation());
        setMinWidth(400);
    }

    public void increaseSpeed() {
        pt.setRate(pt.getRate() + 1);
        ft.setRate(ft.getRate() + 1);
    }

    public void decreaseSpeed() {
        pt.setRate(pt.getRate() > 0 ? pt.getRate() - 1 : 0);
        ft.setRate(ft.getRate() > 0 ? ft.getRate() - 1 : 0);
    }

    public void playAnimation() {
        pt.play();
        ft.play();
    }

    public void stopAnimation() {
        pt.stop();
        ft.stop();
    }

    public void pauseAnimation() {
        pt.pause();
        ft.pause();
    }
}
