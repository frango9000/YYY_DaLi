package auxp.ch14;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Rectanguloid extends Pane {

    public void paint() {
        double angle = 45;
        double depth = 150;
        double width = getWidth() - (depth * Math.sin(Math.toRadians(angle)));
        double height = getHeight() - (depth * Math.cos(Math.toRadians(angle)));

        Rectangle r1 = new Rectangle(0, depth * Math.cos(Math.toRadians(angle)), width, height);
        Rectangle r2 = new Rectangle(depth * Math.sin(Math.toRadians(angle)), 0, width, height);

        r1.setFill(null);
        r2.setFill(null);

        r1.setStroke(Color.BLACK);
        r2.setStroke(Color.BLACK);

        Line lineTL =
            new Line(
                0, depth * Math.cos(Math.toRadians(angle)), depth * Math.sin(Math.toRadians(angle)),
                0);
        Line lineTR = new Line(width, depth * Math.cos(Math.toRadians(angle)), getWidth(), 0);

        Line lineBL = new Line(0, getHeight(), depth * Math.sin(Math.toRadians(angle)), height);
        Line lineBR = new Line(width, getHeight(), getWidth(), height);

        getChildren().clear();
        if (width > 0 && height > 0) {
            getChildren().addAll(r1, r2, lineTL, lineTR, lineBL, lineBR);
        }
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paint();
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paint();
    }
}
