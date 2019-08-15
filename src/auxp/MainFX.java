package auxp;

import auxp.ch14.MyHangman;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application {

    public static Node pane;

    public MainFX() {
        if (pane == null)
            // pane = new Pane(new Label("Default Pane"));
            pane = new MyHangman();
        // pane = new RawEditorPane();
    }

    public MainFX(Node node) {
        pane = node;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setPane(Node node) {
        pane = node;
    }

    public static void initializeToolkit() {
        Platform.startup(() -> {
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MainFX Test");

        Pane padded = new StackPane(pane);
        padded.setPadding(new Insets(0));
        Scene scene = new Scene(padded);
        // primaryStage.setWidth(400);
        // primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        pane.requestFocus();
        primaryStage.show();
    }

    public void go() {
        launch("");
    }

    public void go(Node node) {
        setPane(node);
        go();
    }
}
