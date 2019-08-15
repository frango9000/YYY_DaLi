package lib.MyFX;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class ToolFX {

    public static void setFillStroke(Paint fill, Paint stroke, Shape... shapes) {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].setFill(fill);
            shapes[i].setStroke(stroke);
        }
    }
}
