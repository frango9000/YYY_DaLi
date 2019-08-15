package auxp.ch14;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import lib.Misc.Randomizer;

public class RandArrow extends Pane {

    double x1, x2, y1, y2;
    private double width;
    private double height;

    public void paint() {
        width = getWidth();
        height = getHeight();
        x1 = Randomizer.randomDouble(width);
        y1 = Randomizer.randomDouble(height);

        x2 = Randomizer.randomDouble(width);
        y2 = Randomizer.randomDouble(height);

        Line main = new Line(x1, y1, x2, y2);
        lib.Geometry.Line angled = new lib.Geometry.Line(x1, y1, x2, y2);

        double length = angled.getLength() * 0.25;
        double angle = angled.getAngle();

        Line l =
            new Line(
                x1,
                y1,
                (x1 + (length * Math.sin(Math.toRadians(angle + 180 + 90 - 15)))),
                (y1 + (length * Math.cos(Math.toRadians(angle + 180 + 90 - 15)))));
        Line r =
            new Line(
                x1,
                y1,
                (x1 + (length * Math.sin(Math.toRadians(angle - 75)))),
                (y1 + (length * Math.cos(Math.toRadians(angle - 75)))));

        getChildren().clear();
        getChildren().addAll(main, l, r);
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
