package auxp.ch15;

import auxp.ch16.MediaStopWatch;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import lib.Misc.Randomizer;
import lib.MyFX.ToolFX;

public class CreatePointPane extends Pane {

    final double radius = 10;
    Group circles = new Group();
    Rectangle rectangle = new Rectangle();
    boolean boundingRectangle = false;
    int tries;

    public CreatePointPane() {
        setMinSize(600, 600);
        setPadding(new Insets(5));
        getChildren().addAll(circles, rectangle);
        ToolFX.setFillStroke(null, Color.BLACK, rectangle);

        setOnMouseClicked(event -> handle(event));
    }

    public CreatePointPane(int trie) {
        setMinSize(600, 600);
        setPadding(new Insets(5));
        this.tries = trie - 1;
        Text text = new Text(300, 50, "Click to start");
        Text time = new Text(500, 50, "00:00:00");
        Circle c = new Circle(Randomizer.randomInt(600), Randomizer.randomInt(600), radius, Color.GRAY);
        c.setVisible(false);
        MediaStopWatch sw = new MediaStopWatch();

        Pane p = new Pane();
        p.setMinSize(600, 600);

        text.setOnMouseClicked(
                event -> {
                    if (!c.isVisible()) {
                        sw.start();
                        c.setVisible(true);
                        text.setVisible(false);
                    }
                });

        c.setOnMouseClicked(
                event -> {
                    c.setCenterY(Randomizer.randomInt(600));
                    c.setCenterX(Randomizer.randomInt(600));

                    if (tries > 0) {
                        tries--;
                    } else {
                        sw.stop();
                        c.setVisible(false);
                        text.setVisible(true);
                        time.setText(sw.getElapsedFormat());
                        tries = trie - 1;
                    }
                    System.out.println(tries);
                });
        getChildren().addAll(text, time, c);
    }

    void setBoundingRectangle() {
        ObservableList<Node> list = circles.getChildren();
        if (list.size() > 0) {
            rectangle.setVisible(true);
            double minX, maxX, minY, maxY;
            minX = minY = 10000;
            maxX = maxY = 0;
            for (int i = 0; i < list.size(); i++) {
                double x = ((Circle) list.get(i)).getCenterX();
                double y = ((Circle) list.get(i)).getCenterY();

                minX = minX <= x ? minX : x;
                maxX = maxX >= x ? maxX : x;
                minY = minY <= y ? minY : y;
                maxY = maxY >= y ? maxY : y;
            }

            rectangle.setX((minX) - 10);
            rectangle.setY((minY) - 10);
            rectangle.setWidth(maxX - minX + 20);
            rectangle.setHeight(maxY - minY + 20);
        } else {
            rectangle.setVisible(false);
        }
    }

    public void activateBoundingRectangle(boolean bool) {
        boundingRectangle = bool;
    }

    private void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            Circle c = new Circle(event.getX(), event.getY(), radius, Color.GRAY);
            circles.getChildren().add(c);
        } else {
            if (circles.contains(event.getX(), event.getY())) {
                ObservableList<Node> list = circles.getChildren();
                for (int i = 0; i < list.size(); ) {
                    if (list.get(i).contains(event.getX(), event.getY())) list.remove(i);
                    else i++;
                }
            }
        }
        if (boundingRectangle) setBoundingRectangle();
    }
}
