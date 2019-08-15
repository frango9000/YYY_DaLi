package auxp.ch16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.io.File;

public class AnimationPane extends VBox {

    Pane anim = new Pane();
    ImageView[] frames = new ImageView[52];

    int step = 0;

    int speedVal = 200;
    String prefix = "L";
    int steps = 24;
    String audio = "D:/NarF/Documents/IdeaProjects/YYY_DaLi/src/res/audio/denmark.mp3";

    public AnimationPane() {
        Button start = new Button("Start Animation");
        anim.setMinSize(500, 500);
        AudioClip audioF = new AudioClip(new File("src/res/audio/denmark.mp3").toURI().toString());
        GridPane grid = new GridPane();
        String[] tags = {
                "Enter info for animation",
                "Animation speed in ms",
                "Image file prefix",
                "Number of images",
                "Audio file url"
        };
        for (int i = 0; i < tags.length; i++) {
            grid.add(new Label(tags[i]), 0, i);
        }
        TextField speedF = new TextField(speedVal + "");
        speedF.setPrefColumnCount(50);
        TextField filePrefix = new TextField(prefix);
        filePrefix.setPrefColumnCount(50);
        TextField numOfImgs = new TextField(steps + "");
        numOfImgs.setPrefColumnCount(50);
        TextField audioURL = new TextField(audio);
        audioURL.setPrefColumnCount(50);
        grid.add(speedF, 1, 1);
        grid.add(filePrefix, 1, 2);
        grid.add(numOfImgs, 1, 3);
        grid.add(audioURL, 1, 4);

        for (int i = 0; i < frames.length; i++) {
            frames[i] =
                    new ImageView(
                            new Image("res/image/animation/" + filePrefix.getText() + (i + 1) + ".gif"));
        }

        Timeline animation = new Timeline();
        animation.setCycleCount(-1);

        start.setOnAction(
                event -> {
                    speedVal = (int) Double.parseDouble(speedF.getText());
                    prefix = filePrefix.getText();
                    steps = (int) Double.parseDouble(numOfImgs.getText());
                    audio = audioURL.getText();
                    animation.stop();
                    animation.getKeyFrames().clear();
                    animation.getKeyFrames().add(recreateFrame());
                    animation.play();
                    audioF.play();
                });

        getChildren().addAll(start, anim, grid);
    }

    private void animate() {
        anim.getChildren().clear();
        anim.getChildren().add(frames[step]);
        if (++step == steps) step = 0;
    }

    private KeyFrame recreateFrame() {
        return new KeyFrame(Duration.millis(speedVal), event -> animate());
    }
}
