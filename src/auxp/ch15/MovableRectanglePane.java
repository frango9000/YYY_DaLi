package auxp.ch15;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lib.MyFX.ToolFX;

public class MovableRectanglePane extends BorderPane {

    final int UP = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int RIGHT = 3;
    Rectangle rect;
    Pane pane;
    private double size = 50;

    public MovableRectanglePane() {
        pane = new Pane();
        pane.setMinWidth(size * 2);
        pane.setMinHeight(size * 2);

        rect = new Rectangle(10, 10, size, size);
        ToolFX.setFillStroke(null, Color.BLACK, rect);

        pane.getChildren().add(rect);
        setCenter(pane);

        Button up = new Button("Up");
        up.setOnAction(event -> move(UP));
        Button down = new Button("Down");
        down.setOnAction(event -> move(DOWN));
        Button left = new Button("Left");
        left.setOnAction(event -> move(LEFT));
        Button right = new Button("Right");
        right.setOnAction(event -> move(RIGHT));

        HBox btns = new HBox(left, down, right);
        btns.setAlignment(Pos.CENTER);
        VBox btns0 = new VBox(up, btns);
        btns0.setAlignment(Pos.CENTER);

        setBottom(btns0);
    }

    private void move(int direction) {
        switch (direction) {
            case UP:
                rect.setY(rect.getY() > 10 ? rect.getY() - 5 : 10);
                break;
            case DOWN:
                rect.setY(
                        rect.getY() < pane.getHeight() - size - 10
                                ? rect.getY() + 5
                                : pane.getHeight() - size - 10);
                break;
            case LEFT:
                rect.setX(rect.getX() > 10 ? rect.getX() - 5 : 10);
                break;
            case RIGHT:
                rect.setX(
                        rect.getX() < pane.getWidth() - size - 10
                                ? rect.getX() + 5
                                : pane.getWidth() - size - 10);
                break;
        }
    }
}
