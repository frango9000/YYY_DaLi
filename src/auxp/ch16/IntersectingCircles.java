package auxp.ch16;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class IntersectingCircles extends VBox {

    Circle c1 = new Circle(100, 100, 50);
    Circle c2 = new Circle(200, 100, 75);
    Label bool = new Label(isIntersect() + "");

    public IntersectingCircles() {
        Label title = new Label("2 Circles intersect?");
        HBox top = new HBox(title, bool);
        top.setAlignment(Pos.CENTER);
        c1.setStyle("-fx-fill: rgba(0,255,255,0.5);");
        c2.setStyle("-fx-fill: rgba(255,0,4,0.5);");
        Pane pane = new Pane(c1, c2);
        pane.setMinSize(400, 300);

        Label circleTitle01 = new Label("Enter circle 1 info:");
        GridPane grid1 = new GridPane();
        Label c1xt = new Label("Center X");
        TextField c1x = new TextField("" + c1.getCenterX());
        grid1.addRow(0, c1xt, c1x);
        Label c1yt = new Label("Center Y");
        TextField c1y = new TextField("" + c1.getCenterY());
        grid1.addRow(1, c1yt, c1y);
        Label c1rt = new Label("Radius");
        TextField c1r = new TextField("" + c1.getRadius());
        grid1.addRow(2, c1rt, c1r);
        VBox circV1 = new VBox(circleTitle01, grid1);
        circV1.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label circleTitle02 = new Label("Enter circle 2 info:");
        GridPane grid2 = new GridPane();
        Label c2xt = new Label("Center X");
        TextField c2x = new TextField("" + c2.getCenterX());
        grid2.addRow(0, c2xt, c2x);
        Label c2yt = new Label("Center Y");
        TextField c2y = new TextField("" + c2.getCenterY());
        grid2.addRow(1, c2yt, c2y);
        Label c2rt = new Label("Radius");
        TextField c2r = new TextField("" + c2.getRadius());
        grid2.addRow(2, c2rt, c2r);
        VBox circV2 = new VBox(circleTitle02, grid2);
        circV2.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        HBox circles = new HBox(circV1, circV2);
        circles.setSpacing(8);
        circles.setPadding(new Insets(5));

        Button redraw = new Button("Redraw");

        redraw.setOnAction(
                event -> {
                    c1.setCenterX(Double.parseDouble(c1x.getText()));
                    c1.setCenterY(Double.parseDouble(c1y.getText()));
                    c1.setRadius(Double.parseDouble(c1r.getText()));
                    c2.setCenterX(Double.parseDouble(c2x.getText()));
                    c2.setCenterY(Double.parseDouble(c2y.getText()));
                    c2.setRadius(Double.parseDouble(c2r.getText()));

                    bool.setText(isIntersect() + "");
                });
        c1.setOnMouseDragged(
                e -> {
                    if (c1.contains(e.getX(), e.getY())) {
                        c1.setCenterX(e.getX());
                        c1.setCenterY(e.getY());
                        c1x.setText(c1.getCenterX() + "");
                        c1y.setText(c1.getCenterY() + "");
                        bool.setText(isIntersect() + "");
                    }
                });

        c2.setOnMouseDragged(
                e -> {
                    if (c2.contains(e.getX(), e.getY())) {
                        c2.setCenterX(e.getX());
                        c2.setCenterY(e.getY());
                        c2x.setText(c2.getCenterX() + "");
                        c2y.setText(c2.getCenterY() + "");
                        bool.setText(isIntersect() + "");
                    }
                });

        getChildren().addAll(top, pane, circles, redraw);
    }

    private boolean isIntersect() {
        return Math.sqrt(
                Math.pow(c1.getCenterX() - c2.getCenterX(), 2)
                        + Math.pow(c1.getCenterY() - c2.getCenterY(), 2))
                <= c1.getRadius() + c2.getRadius();
    }
}
