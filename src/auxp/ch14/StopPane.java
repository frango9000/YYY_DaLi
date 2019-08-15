package auxp.ch14;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lib.Geometry.Octagon;
import lib.Geometry.Point;
import lib.Math.Algebra;

public class StopPane extends StackPane {

    public StopPane() {
        paint();
    }

    public void paint() {
        double radius = Algebra.min(getHeight(), getWidth()) * 0.8 / 2;
        Octagon base = new Octagon(radius, true);
        base.setCenter(new Point(getWidth() / 2, getHeight() / 2));
        Point[] ps = base.setTopHorizontal();

        Polygon sign = new Polygon(base.getRawPoints());
        sign.setFill(Color.RED);

        Text stop = new Text("STOP");
        stop.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, radius / 2));
        stop.setFill(Color.WHITE);

        getChildren().clear();
        getChildren().addAll(sign, stop);
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
