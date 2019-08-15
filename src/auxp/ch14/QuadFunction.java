package auxp.ch14;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

public class QuadFunction extends Pane {

    public void paint() {
        Pane pane1 = new Pane();
        pane1.setRotate(180);
        pane1.setPadding(new Insets(72, 0, 0, 75));
        Polyline polyline = new Polyline();
        polyline.setFill(null);
        polyline.setStroke(Color.BLACK);
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for (int x = -100; x <= 100; x++) {
            list.add(x + 200.0);
            list.add(scaleFactor * x * x);
        }
        pane1.getChildren().add(polyline);

        // Create two lines
        Line lineX = new Line(10, 200, 350, 200);
        Line lineY = new Line(lineX.getEndX() / 2, 250, lineX.getEndX() / 2, 30);

        Text textX = new Text(lineX.getEndX() - 10, lineX.getEndY() - 20, "X");
        Text textY = new Text(lineY.getEndX() + 20, lineY.getEndY() + 10, "Y");
        getChildren().addAll(textX, textY, lineX, lineY);

        getChildren().addAll(pane1);
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
