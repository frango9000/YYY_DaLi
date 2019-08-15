package auxp.ch14;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import lib.Geometry.Point;
import lib.Geometry.TriangleEquilateral;
import lib.Math.Algebra;

public class UglySmiley extends Pane {

    public UglySmiley() {
    }

    public void paint() {
        setPadding(new Insets(5));
        double centerX = Algebra.max(getWidth(), 30) / 2;
        double centerY = Algebra.max(getHeight(), 30) / 2;
        double radiusX;
        double radiusY = radiusX = Algebra.max(Algebra.min(getWidth(), getHeight()), 10) * 0.8 / 2;

        Circle face = new Circle(centerX, centerY, (radiusX + radiusY) / 2, null);
        face.setStroke(Color.BLACK);

        Ellipse eyeL =
            new Ellipse(
                centerX - radiusX * 0.3, centerY - radiusY * 0.3, radiusX * 0.2, radiusY * 0.15);
        eyeL.setFill(null);
        eyeL.setStroke(Color.BLACK);
        Ellipse eyeR =
            new Ellipse(
                centerX + radiusX * 0.3, centerY - radiusY * 0.3, radiusX * 0.2, radiusY * 0.15);
        eyeR.setFill(null);
        eyeR.setStroke(Color.BLACK);

        Circle cL =
            new Circle(centerX - radiusX * 0.3, centerY - radiusY * 0.3, radiusX * 0.1,
                Color.BLACK);
        Circle cR =
            new Circle(centerX + radiusX * 0.3, centerY - radiusY * 0.3, radiusX * 0.1,
                Color.BLACK);

        TriangleEquilateral triangle = new TriangleEquilateral(radiusX * 0.2, true);
        triangle.setCenter(new Point(centerX, centerY + radiusY * 0.1));
        triangle.setPoints(0);
        Point[] ps = triangle.getPoints();
        Line n1 = new Line(ps[0].x, ps[0].y, ps[1].x, ps[1].y);
        n1.setStroke(Color.BLACK);
        Line n2 = new Line(ps[1].x, ps[1].y, ps[2].x, ps[2].y);
        n2.setStroke(Color.BLACK);

        Arc mouth = new Arc(centerX, centerY + radiusY * 0.35, radiusX * 0.6, radiusY * 0.3, 180,
            180);
        mouth.setType(ArcType.OPEN);
        mouth.setFill(null);
        mouth.setStroke(Color.BLACK);

        getChildren().clear();
        getChildren().addAll(face, eyeL, eyeR, cL, cR, n1, n2, mouth);
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
