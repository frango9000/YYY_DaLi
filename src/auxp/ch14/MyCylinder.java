package auxp.ch14;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class MyCylinder extends Pane {

    public MyCylinder() {
        setHeight(200);
        setWidth(100);
        setMinHeight(100.0);
        setMinWidth(10.0);
    }

    public void paint() {
        double centerX = getWidth() / 2;
        double radiusX = getWidth() * 0.8 / 2;
        double centerY = getHeight() / 2;
        double radiusY = radiusX * 0.25;

        double length = getHeight() * 0.8 / 2;

        setPadding(new Insets(5));
        Ellipse ellipse = new Ellipse(centerX, centerY - length + radiusY, radiusX, radiusY);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        Arc arc1 = new Arc(centerX, centerY + length - radiusY, radiusX, radiusY, 180, 180);
        arc1.setFill(null);
        arc1.setStroke(Color.BLACK);

        Arc arc2 = new Arc(centerX, centerY + length - radiusY, radiusX, radiusY, 0, 180);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);
        arc2.setFill(null);
        arc2.setStroke(Color.BLACK);

        Line lineL =
            new Line(
                centerX - radiusX,
                centerY + radiusY - length,
                centerX - radiusX,
                centerY - radiusY + length);
        Line lineR =
            new Line(
                centerX + radiusX,
                centerY + radiusY - length,
                centerX + radiusX,
                centerY - radiusY + length);

        getChildren().clear();
        getChildren().addAll(ellipse, arc1, arc2, lineL, lineR);
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
