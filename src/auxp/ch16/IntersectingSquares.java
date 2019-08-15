package auxp.ch16;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class IntersectingSquares extends VBox {

    Rectangle sq1 = new Rectangle(100, 100, 50, 70);
    Rectangle sq2 = new Rectangle(200, 100, 70, 50);
    Label bool = new Label(isIntersect() + "");

    public IntersectingSquares() {
        Label title = new Label("2 Squares intersect?");
        HBox top = new HBox(title, bool);
        top.setAlignment(Pos.CENTER);
        sq1.setStyle("-fx-fill: rgba(0,255,255,0.5);");
        sq2.setStyle("-fx-fill: rgba(255,0,4,0.5);");
        Pane pane = new Pane(sq1, sq2);
        pane.setMinSize(400, 300);

        Label circleTitle01 = new Label("Enter square 1 info:");
        GridPane grid1 = new GridPane();
        Label c1xt = new Label("Center X");
        TextField c1x = new TextField("" + sq1.getX());
        grid1.addRow(0, c1xt, c1x);
        Label c1yt = new Label("Center Y");
        TextField c1y = new TextField("" + sq1.getY());
        grid1.addRow(1, c1yt, c1y);
        Label c1wt = new Label("Width");
        TextField c1w = new TextField("" + sq1.getWidth());
        grid1.addRow(2, c1wt, c1w);
        Label c1ht = new Label("Height");
        TextField c1h = new TextField("" + sq1.getHeight());
        grid1.addRow(3, c1ht, c1h);
        VBox circV1 = new VBox(circleTitle01, grid1);
        circV1.setBorder(
            new Border(
                new BorderStroke(
                    Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));

        Label circleTitle02 = new Label("Enter square 1 info:");
        GridPane grid2 = new GridPane();
        Label c2xt = new Label("Center X");
        TextField c2x = new TextField("" + sq2.getX());
        grid2.addRow(0, c2xt, c2x);
        Label c2yt = new Label("Center Y");
        TextField c2y = new TextField("" + sq2.getY());
        grid2.addRow(1, c2yt, c2y);
        Label c2wt = new Label("Width");
        TextField c2w = new TextField("" + sq2.getWidth());
        grid2.addRow(2, c2wt, c2w);
        Label c2ht = new Label("Height");
        TextField c2h = new TextField("" + sq2.getHeight());
        grid2.addRow(3, c2ht, c2h);
        VBox circV2 = new VBox(circleTitle02, grid2);
        circV2.setBorder(
            new Border(
                new BorderStroke(
                    Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));

        HBox circles = new HBox(circV1, circV2);
        circles.setSpacing(8);
        circles.setPadding(new Insets(5));

        Button redraw = new Button("Redraw");

        redraw.setOnAction(
            event -> {
                sq1.setX(Double.parseDouble(c1x.getText()));
                sq1.setX(Double.parseDouble(c1y.getText()));
                sq1.setWidth(Double.parseDouble(c1w.getText()));
                sq1.setHeight(Double.parseDouble(c1h.getText()));
                sq2.setX(Double.parseDouble(c2x.getText()));
                sq2.setX(Double.parseDouble(c2y.getText()));
                sq2.setWidth(Double.parseDouble(c2w.getText()));
                sq2.setHeight(Double.parseDouble(c2h.getText()));

                bool.setText(isIntersect() + "");
            });
        sq1.setOnMouseDragged(
            e -> {
                if (sq1.contains(e.getX(), e.getY())) {
                    sq1.setX(e.getX() - (sq1.getWidth() / 2));
                    sq1.setY(e.getY() - (sq1.getHeight() / 2));
                    sq1.setX((e.getX() - (sq1.getWidth() / 2)));
                    sq1.setY((e.getY() - (sq1.getHeight() / 2)));
                    c1x.setText(sq1.getX() + "");
                    c1y.setText(sq1.getY() + "");
                    bool.setText(isIntersect() + "");
                }
            });

        sq2.setOnMouseDragged(
            e -> {
                if (sq2.contains(e.getX(), e.getY())) {
                    sq2.setX(e.getX() - (sq2.getWidth() / 2));
                    sq2.setY(e.getY() - (sq2.getHeight() / 2));
                    sq2.setX((e.getX() - (sq2.getWidth() / 2)));
                    sq2.setY((e.getY() - (sq2.getHeight() / 2)));
                    c2x.setText(sq2.getX() + "");
                    c2y.setText(sq2.getY() + "");
                    bool.setText(isIntersect() + "");
                }
            });

        getChildren().addAll(top, pane, circles, redraw);
    }

    private boolean isIntersect() {
        return
            (getDistance(sq2.getX(), sq1.getX() + sq1.getWidth()) < sq1.getWidth() + sq2.getWidth()
                && (getDistance(sq2.getY(), sq1.getY() + sq1.getHeight())
                < sq1.getHeight() + sq2.getHeight()))
                && (getDistance(sq1.getX(), sq2.getX() + sq2.getWidth()) < sq1.getWidth() + sq2
                .getWidth()
                && (getDistance(sq1.getY(), sq2.getY() + sq2.getHeight())
                < sq1.getHeight() + sq2.getHeight()));
    }

    private double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }
}
