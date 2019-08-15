package auxp.ch16;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lib.Misc.Time;

public class MediaDemo extends BorderPane {
    private static final String MEDIA_URL = "http://liveexample.pearsoncmg.com/common/sample.mp4";

    public MediaDemo() {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        Button playButton = new Button(">");
        Text timeLbl = new Text("00:00:00");
        Text totalTimeLbl = new Text("00:00:00");
        playButton.setOnAction(
                e -> {
                    if (playButton.getText().equals(">")) {
                        totalTimeLbl.setText(new Time(mediaPlayer.getTotalDuration()).toString());
                        mediaPlayer.play();
                        playButton.setText("||");
                    } else {
                        mediaPlayer.pause();
                        playButton.setText(">");
                    }
                });
        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        Slider slTime = new Slider();
        slTime.setPrefWidth(150);
        slTime.setMaxWidth(Region.USE_PREF_SIZE);
        slTime.setMinWidth(30);

        slTime.setOnMouseDragged(
                event ->
                        mediaPlayer.seek(
                                Duration.millis(
                                        slTime.getValue() * (mediaPlayer.getTotalDuration().toMillis() / 100))));
        slTime.setOnMouseClicked(
                event ->
                        mediaPlayer.seek(
                                Duration.millis(
                                        slTime.getValue() * (mediaPlayer.getTotalDuration().toMillis() / 100))));
        mediaPlayer
                .currentTimeProperty()
                .addListener(
                        observable -> {
                            timeLbl.setText(new Time(mediaPlayer.getCurrentTime()).toString());
                            slTime.setValue(
                                    (mediaPlayer.getCurrentTime().toMillis()
                                            / mediaPlayer.getTotalDuration().toMillis())
                                            * 100);
                        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren()
                .addAll(
                        playButton,
                        rewindButton,
                        new Label("Time"),
                        slTime,
                        timeLbl,
                        new Label("/"),
                        totalTimeLbl,
                        new Label("Volume"),
                        slVolume);

        Pane pane = new Pane(mediaView);
        pane.setMinSize(720, 480);
        setCenter(pane);
        setBottom(hBox);
    }
}
