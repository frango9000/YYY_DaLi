package auxp.ch15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SimpleAnimationPane extends Pane {

    private int frame = 1;

    public SimpleAnimationPane() {
        setMinSize(720, 480);
        ImageView[] frames = new ImageView[52];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new ImageView(new Image("res/image/animation/L" + (i + 1) + ".gif"));
        }
        Timeline animation =
            new Timeline(
                new KeyFrame(
                    Duration.millis(100),
                    event -> {
                        getChildren().clear();
                        getChildren().add(frames[frame++]);
                        if (frame == frames.length) {
                            frame = 0;
                        }
                    }));
        animation.setCycleCount(-1);
        animation.play();
    }
}
