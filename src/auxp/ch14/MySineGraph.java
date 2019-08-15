package auxp.ch14;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MySineGraph extends Pane {

    boolean showSine = true;
    boolean showCosine = true;
    boolean showTan = false;
    boolean showSineAnimation = true;
    PathTransition ptSin;
    boolean showCosineAnimation = true;
    PathTransition ptCos;
    private double width;
    private double height;

    public MySineGraph() {
        setMinSize(300, 200);
    }

    public void paint() {
        width = getWidth();
        height = getHeight();

        setOnMousePressed(
                event -> {
                    if (showSineAnimation) ptSin.pause();
                    if (showCosineAnimation) ptCos.pause();
                });
        setOnMouseReleased(
                event -> {
                    if (showSineAnimation) ptSin.play();
                    if (showCosineAnimation) ptCos.play();
                });

        getChildren().clear();
        getChildren().add(base(1260));
        if (showSine) getChildren().add(sin(1260));
        if (showCosine) getChildren().add(cos(1260));
        if (showTan) getChildren().add(tan(1260));
    }

    private Pane base(int bound) {
        Pane pane = new Pane();
        double centerX = width / 2;
        double centerY = height / 2;
        Line y = new Line(centerX, 0, centerX, height);
        Line x = new Line(0, centerY, width, centerY);

        Text textX = new Text(x.getEndX() - 10, x.getEndY() - 20, "X");
        Text textY = new Text(y.getEndX() + 20, y.getEndY() - 10, "Y");
        pane.setPadding(new Insets(10));

        double hBound = (width / bound);
        Text pi, pi2, npi, npi2, zero, oneP, oneN;
        zero = new Text(centerX, centerY, "0");
        pi = new Text(centerX + (180.0 * (hBound)), centerY, "" + '\u03c0');
        pi2 = new Text(centerX + (360 * (hBound)), centerY, "2" + '\u03c0');
        npi = new Text(centerX - (180.0 * (hBound)), centerY, "-" + '\u03c0');
        npi2 = new Text(centerX - (360 * (hBound)), centerY, "-2" + '\u03c0');

        oneP = new Text(centerX + 10, (centerY) - (height / 3), "1");
        oneN = new Text(centerX + 10, (centerY) + (height / 3), "-1");
        pane.getChildren().clear();
        pane.getChildren().addAll(x, y, textX, textY, pi, pi2, npi, npi2, zero, oneP, oneN);
        return pane;
    }

    private Pane sin(int bound) {
        Pane pane = new Pane();
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        for (int x = -(bound / 2); x <= bound / 2; x++) {
            list.add((x + (bound / 2)) * (width / bound));
            list.add(height / 2 - height / 3 * Math.sin(Math.toRadians(x)));
        }
        polyline.setStroke(Color.BLUE);
        if (showSineAnimation) {
            Circle circle = new Circle(-10, -10, 8, Color.GREY);
            pane.getChildren().add(circle);
            ptSin = new PathTransition(Duration.millis(5000), polyline, circle);
            ptSin.setCycleCount(Timeline.INDEFINITE);
            ptSin.setAutoReverse(false);
            ptSin.play();
        }

        pane.getChildren().add(polyline);
        return pane;
    }

    private Pane cos(int bound) {
        Pane pane = new Pane();
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        for (int x = -(bound / 2); x <= bound / 2; x++) {
            list.add((x + (bound / 2)) * (width / bound));
            list.add(height / 2 - height / 3 * Math.cos(Math.toRadians(x)));
        }
        polyline.setStroke(Color.RED);
        if (showCosineAnimation) {
            Circle circle = new Circle(-10, -10, 8, Color.GREY);
            pane.getChildren().add(circle);
            ptCos = new PathTransition(Duration.millis(5000), polyline, circle);
            ptCos.setCycleCount(Timeline.INDEFINITE);
            ptCos.setAutoReverse(false);
            ptCos.play();
        }
        pane.getChildren().add(polyline);
        return pane;
    }

    private Pane tan(int bound) {
        Pane pane = new Pane();
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        for (int x = -(bound / 2); x <= bound / 2; x++) {
            list.add((x + (bound / 2)) * (width / bound));
            list.add(height / 2 - height / 3 * Math.tan(Math.toRadians(x)));
        }
        polyline.setStroke(Color.YELLOW);
        pane.getChildren().add(polyline);
        return pane;
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
