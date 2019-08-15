package auxp.ch14;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import lib.Geometry.Point;
import lib.Geometry.Polygon;
import lib.Math.Algebra;

public class MyPolygonOutline extends Pane {

    public void paint() {
        double radius = Algebra.min(getHeight(), getWidth()) * 0.8 / 2;
        Polygon base = new Polygon(20, radius, true);
        base.setCenter(new Point(getWidth() / 2, getHeight() / 2));

        // base.setVertexOnTop();
        base.setTopHorizontal();

        Point[] ps = base.getPoints();

        getChildren().clear();
        for (int point = 0; point < ps.length - 1; point++) {
            Line l = new Line(ps[point].x, ps[point].y, ps[point + 1].x, ps[point + 1].y);
            getChildren().add(l);
        }
        Line l = new Line(ps[0].x, ps[0].y, ps[ps.length - 1].x, ps[ps.length - 1].y);
        getChildren().add(l);
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
