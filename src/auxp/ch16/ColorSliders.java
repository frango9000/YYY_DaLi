package auxp.ch16;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ColorSliders extends VBox {
    protected Slider redSlide;
    protected Slider greenSlide;
    protected Slider blueSlide;
    protected Slider opacSlide;
    protected Text text = new Text("Show Colors");

    public ColorSliders() {
        StackPane top = new StackPane(text);
        top.setMinSize(300, 300);

        redSlide = new Slider(0.0, 1.0, 1.0);
        Label redL = new Label("Red");
        greenSlide = new Slider(0.0, 1.0, 1.0);
        Label greenL = new Label("Green");
        blueSlide = new Slider(0.0, 1.0, 1.0);
        Label blueL = new Label("Blue");
        opacSlide = new Slider(0.0, 1.0, 1.0);
        Label opacL = new Label("Opacity");

        redSlide.valueProperty().addListener(observable -> setColor());
        greenSlide.valueProperty().addListener(observable -> setColor());
        blueSlide.valueProperty().addListener(observable -> setColor());
        opacSlide.valueProperty().addListener(observable -> setColor());

        GridPane grid = new GridPane();
        grid.addRow(0, redL, redSlide);
        grid.addRow(1, greenL, greenSlide);
        grid.addRow(2, blueL, blueSlide);
        grid.addRow(3, opacL, opacSlide);
        // redSlide.setOn

        getChildren().addAll(top, grid);
    }

    private void setColor() {
        text.setFill(
                new Color(
                        redSlide.getValue(),
                        greenSlide.getValue(),
                        blueSlide.getValue(),
                        opacSlide.getValue()));
    }
}
