package auxp;

import auxp.ch17.rawedit.RawEditorPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MainFX Test");


        RawEditorPane pane = new RawEditorPane();


        Pane padded = new StackPane(pane);
        padded.setPadding(new Insets(0));
        Scene scene = new Scene(padded);
        //primaryStage.setWidth(400);
        //primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
