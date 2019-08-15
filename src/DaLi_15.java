import auxp.ch14.ClockPane;
import auxp.ch14.MyCylinder;
import auxp.ch14.MySineGraph;
import auxp.ch14.StopPane;
import auxp.ch15.AnimatedPendulum;
import auxp.ch15.CarPane;
import auxp.ch15.CreatePointPane;
import auxp.ch15.MovableCirclesPane;
import auxp.ch15.MovableRectanglePane;
import auxp.ch15.RunningFan;
import auxp.ch15.SimpleAnimationPane;
import auxp.ch15.TaggedTrianglePane;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.Misc.Asserts;
import lib.Misc.Randomizer;
import lib.MyFX.ToolFX;

public class DaLi_15 extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void ex00() {
    }

    public static Pane ex01() { // Pick four cards
        HBox cards = new HBox();
        final int elements = 4;
        for (int i = 0; i < elements; i++) {
            int rand = Randomizer.randomInt(1, 53);
            Image img = new Image("res/image/card/" + (rand + 1) + ".png");
            ImageView iv = new ImageView(img);
            cards.getChildren().add(iv);
        }

        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(
            e -> {
                cards.getChildren().clear();
                for (int i = 0; i < elements; i++) {
                    int rand = Randomizer.randomInt(1, 53);
                    Image img = new Image("res/image/card/" + (rand + 1) + ".png");
                    ImageView iv = new ImageView(img);
                    cards.getChildren().add(iv);
                }
            });
        BorderPane bp = new BorderPane();
        bp.setCenter(cards);
        bp.setBottom(refreshBtn);
        BorderPane.setAlignment(refreshBtn, Pos.CENTER);
        return bp;
    }

    public static Pane ex02() { // Rotate an Ellipse
        Ellipse ellipse = new Ellipse(150, 100);
        ToolFX.setFillStroke(null, Color.BLACK, ellipse);

        Button rtBtnL = new Button("Rotate C-CW (Left)");
        rtBtnL.setOnAction(e -> ellipse.setRotate(ellipse.getRotate() - 5));
        Button rtBtnR = new Button("Rotate CW (Right)");
        rtBtnR.setOnAction(event -> ellipse.setRotate(ellipse.getRotate() + 5));

        BorderPane bp = new BorderPane();
        bp.setCenter(ellipse);
        HBox btns = new HBox(rtBtnL, rtBtnR);
        btns.setAlignment(Pos.CENTER);
        bp.setBottom(btns);
        BorderPane.setAlignment(btns, Pos.CENTER);

        stage.setMinHeight(ellipse.getRadiusY() * 3);
        stage.setMinWidth(ellipse.getRadiusX() * 2.5);

        ellipse.centerXProperty().bind(bp.widthProperty().divide(2));
        ellipse.centerYProperty().bind(bp.heightProperty().divide(2));
        return bp;
    }

    public static Pane ex03() { // Move the rectangle
        return new MovableRectanglePane();
    }

    public static Pane ex04() { // Create a simple calculator

        Text n1 = new Text("N1:");
        TextField t1 = new TextField();
        t1.setMaxWidth(60);
        Text n2 = new Text("N2:");
        TextField t2 = new TextField();
        t2.setMaxWidth(60);
        Text n3 = new Text("N3:");
        TextField t3 = new TextField();
        t3.setMaxWidth(80);
        t3.setEditable(false);
        HBox values = new HBox(n1, t1, n2, t2, n3, t3);
        values.setAlignment(Pos.CENTER);
        values.setSpacing(5);

        Button add = new Button("Add");
        Button sub = new Button("Subtract");
        Button mult = new Button("Multiply");
        Button divi = new Button("Divide");
        HBox buttons = new HBox(add, sub, mult, divi);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        add.setOnAction(
            event -> {
                if (Asserts.isDouble(t1.getText()) && Asserts.isDouble(t2.getText())) {
                    t3.setText(
                        (Double.parseDouble(t1.getText()) + Double.parseDouble(t2.getText())) + "");
                } else {
                    t3.setText("N/A");
                }
            });

        sub.setOnAction(
            event -> {
                if (Asserts.isDouble(t1.getText()) && Asserts.isDouble(t2.getText())) {
                    t3.setText(
                        (Double.parseDouble(t1.getText()) - Double.parseDouble(t2.getText())) + "");
                } else {
                    t3.setText("N/A");
                }
            });

        mult.setOnAction(
            event -> {
                if (Asserts.isDouble(t1.getText()) && Asserts.isDouble(t2.getText())) {
                    t3.setText(
                        (Double.parseDouble(t1.getText()) * Double.parseDouble(t2.getText())) + "");
                } else {
                    t3.setText("N/A");
                }
            });

        divi.setOnAction(
            event -> {
                if (Asserts.isDouble(t1.getText()) && Asserts.isDouble(t2.getText())) {
                    t3.setText(
                        (Double.parseDouble(t1.getText()) / Double.parseDouble(t2.getText())) + "");
                } else {
                    t3.setText("N/A");
                }
            });
        VBox vb = new VBox(values, buttons);
        vb.setPadding(new Insets(10));
        vb.setSpacing(5);
        return vb;
    }

    public static Pane ex05() { // Calculate final velocity

        GridPane grid = new GridPane();

        grid.add(new Text("Initial Speed"), 0, 0);
        TextField tx1 = new TextField();
        grid.add(tx1, 1, 0);

        grid.add(new Text("Acceleration"), 0, 1);
        TextField tx2 = new TextField();
        grid.add(tx2, 1, 1);

        grid.add(new Text("Time"), 0, 2);
        TextField tx3 = new TextField();
        grid.add(tx3, 1, 2);

        grid.add(new Text("Final Speed"), 0, 3);
        TextField tx4 = new TextField();
        tx4.setEditable(false);
        grid.add(tx4, 1, 3);

        Button result = new Button("Result");
        result.setOnAction(
            event -> {
                if (Asserts.isDouble(tx1.getText())
                    && Asserts.isDouble(tx2.getText())
                    && Asserts.isDouble(tx3.getText())) {
                    tx4.setText(
                        (Double.parseDouble(tx1.getText())
                            + (Double.parseDouble(tx2.getText()) * Double
                            .parseDouble(tx3.getText())))
                            + "");
                } else {
                    tx4.setText("N/A");
                }
            });
        grid.add(result, 1, 4);

        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5));
        return grid;
    }

    public static Pane ex06() { // Alternate two messages
        String s1 = "Welcome to Java";
        String s2 = "LearningJavaFX";
        Text text = new Text(s1);

        text.setOnMouseClicked(
            event -> {
                text.setText((s1.equals(text.getText())) ? s2 : s1);
            });

        StackPane pane = new StackPane(text);
        pane.setPadding(new Insets(30));
        return pane;
    }

    public static Pane ex07() { // Change color using a mouse
        Circle circle = new Circle(80, Color.BLUE);

        circle.setOnMousePressed(event -> circle.setFill(Color.GREEN));
        circle.setOnMouseReleased(event -> circle.setFill(Color.BLUE));

        StackPane pane = new StackPane(circle);
        pane.setPadding(new Insets(30));
        return pane;
    }

    public static Pane ex08() { // Display the mouse position
        Pane pane = new Pane();
        pane.setMinSize(400, 400);

        // pane.setOnMouseClicked(event -> pane.getChildren().add(new Text(event.getX(), event.getY(),
        // String.format("(%.1f, %.1f)", event.getX(), event.getY()))));

        pane.setOnMousePressed(
            event ->
                pane.getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY(),
                            String.format("(%.1f, %.1f)", event.getX(), event.getY()))));
        pane.setOnMouseReleased(event -> pane.getChildren().clear());

        return pane;
    }

    public static Pane ex09() { // Draw lines using the arrow keys
        Pane pane = new Pane();
        pane.setMinSize(400, 400);

        pane.setOnKeyPressed(
            event -> {
                double x, y;
                if (pane.getChildren().size() == 0) {
                    x = 100.0;
                    y = 100.0;
                } else {
                    x = ((Line) (pane.getChildren().get(pane.getChildren().size() - 1))).getEndX();
                    y = ((Line) (pane.getChildren().get(pane.getChildren().size() - 1))).getEndY();
                }
                Line line = new Line();
                line.setStartX(x);
                line.setStartY(y);
                double eX = x, eY = y;
                switch (event.getCode()) {
                    case UP:
                        eY = y - 10;
                        break;
                    case DOWN:
                        eY = y + 10;
                        break;
                    case LEFT:
                        eX = x - 10;
                        break;
                    case RIGHT:
                        eX = x + 10;
                        break;
                }
                line.setEndX(eX);
                line.setEndY(eY);
                line.setStroke(Color.BLACK);
                pane.getChildren().add(line);
            });
        return pane;
    }

    public static Pane ex10() { // Enter and display a string
        Text text = new Text("Text");
        StackPane pane = new StackPane(text);
        pane.setPadding(new Insets(10));

        StringBuilder sb = new StringBuilder();

        pane.setOnKeyPressed(
            event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    text.setText(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(event.getText());
                }
            });
        return pane;
    }

    public static Pane ex11() { // Move a circle using keys
        Circle circ = new Circle(100, 100, 70, null);
        circ.setStroke(Color.BLACK);

        Pane pane = new Pane(circ);
        pane.setMinSize(600, 600);
        pane.setPadding(new Insets(5));

        pane.setOnKeyPressed(
            event -> {
                switch (event.getCode()) {
                    case UP:
                        circ.setCenterY(
                            circ.getCenterY() - circ.getRadius() - 10 < 0
                                ? circ.getRadius() + 5
                                : circ.getCenterY() - 5);
                        break;
                    case DOWN:
                        circ.setCenterY(
                            circ.getCenterY() + circ.getRadius() + 10 > pane.getHeight()
                                ? pane.getWidth() - circ.getRadius() - 5
                                : circ.getCenterY() + 5);
                        break;
                    case LEFT:
                        circ.setCenterX(
                            circ.getCenterX() - circ.getRadius() - 10 < 0
                                ? circ.getRadius() + 5
                                : circ.getCenterX() - 5);
                        break;
                    case RIGHT:
                        circ.setCenterX(
                            circ.getCenterX() + circ.getRadius() + 10 > pane.getWidth()
                                ? pane.getWidth() - circ.getRadius() - 5
                                : circ.getCenterX() + 5);
                        break;
                }
            });
        return pane;
    }

    public static Pane ex12() { // Geometry: inside a circle?
        Circle circ = new Circle(100, 60, 50, Color.GRAY);
        circ.setStroke(Color.BLACK);
        Pane labels = new Pane();

        Pane pane = new Pane(circ, labels);
        pane.setMinSize(600, 600);
        pane.setPadding(new Insets(5));

        pane.setOnMouseMoved(
            event -> {
                labels.getChildren().clear();
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY() - 10,
                            String.format("(%.1f, %.1f)", event.getX(), event.getY())));
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY(),
                            "The point is "
                                + ((circ.contains(event.getX(), event.getY()) ? "inside "
                                : "outside "))
                                + "the circle."));
            });
        return pane;
    }

    public static Pane ex13() { // Geometry: inside a rectangle?
        Rectangle rectangle = new Rectangle(80, 50, 100, 30);
        rectangle.setStroke(Color.BLACK);
        Pane labels = new Pane();

        Pane pane = new Pane(rectangle, labels);
        pane.setMinSize(600, 600);
        pane.setPadding(new Insets(5));

        pane.setOnMouseMoved(
            event -> {
                labels.getChildren().clear();
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY() - 10,
                            String.format("(%.1f, %.1f)", event.getX(), event.getY())));
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY(),
                            "The point is "
                                + ((rectangle.contains(event.getX(), event.getY())
                                ? "inside "
                                : "outside "))
                                + "the rectangle."));
            });
        return pane;
    }

    public static Pane ex14() { // Geometry: inside a polygon?
        Polygon polygon = new Polygon(30, 10, 60, 30, 50, 70, 35, 35, 10, 50);
        polygon.setStroke(Color.BLACK);
        Pane labels = new Pane();

        Pane pane = new Pane(polygon, labels);
        pane.setMinSize(600, 600);
        pane.setPadding(new Insets(5));

        pane.setOnMouseMoved(
            event -> {
                labels.getChildren().clear();
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY() - 10,
                            String.format("(%.1f, %.1f)", event.getX(), event.getY())));
                labels
                    .getChildren()
                    .add(
                        new Text(
                            event.getX(),
                            event.getY(),
                            "The point is "
                                + ((polygon.contains(event.getX(), event.getY())
                                ? "inside "
                                : "outside "))
                                + "the polygon."));
            });
        return pane;
    }

    public static Pane ex15() { // Geometry: add and remove points
        return new CreatePointPane();
    }

    public static Pane ex16() { // Two movable vertices and their distances
        return new MovableCirclesPane();
    }

    public static Pane ex17() { // Geometry: find the bounding rectangle
        CreatePointPane pane = new CreatePointPane();
        pane.activateBoundingRectangle(true);
        return pane;
    }

    public static Pane ex18() { // Move a rectangle using mouse
        Rectangle r = new Rectangle(100, 100, 100, 100);
        Pane pane = new Pane(r);
        r.setOnMouseDragged(
            event -> {
                r.setX(event.getX() - r.getWidth() / 2);
                r.setY(event.getY() - r.getHeight() / 2);
            });
        pane.setMinSize(600, 600);
        pane.setPadding(new Insets(5));
        return pane;
    }

    public static Pane ex19() { // Game: eye–hand coordination
        return new CreatePointPane(3);
    }

    public static Pane ex20() { // Geometry: display angles
        return new TaggedTrianglePane();
    }

    public static Pane ex21() { // Drag points
        return new TaggedTrianglePane(true);
    }

    public static Pane ex22() { // Auto resize cylinder
        return new MyCylinder();
    }

    public static Pane ex23() { // Auto resize slow sign
        return new StopPane();
    }

    public static Pane ex24() { // Animation: pendulum swing
        return new AnimatedPendulum();
    }

    public static Pane ex25() { // Animation: ball on curve
        return new MySineGraph();
    }

    public static Pane ex26() { // Change opacity
        return new AnimatedPendulum(true);
    }

    public static Pane ex27() { // Control a moving text marquee
        Text text = new Text(600, 300, "Welcome to Java");
        Line line = new Line(-60, 300, 750, 300);
        PathTransition pt = new PathTransition(Duration.millis(3000), line, text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        Pane pane = new Pane(text);
        pane.setMinSize(600, 600);
        return pane;
    }

    public static Pane ex28() { // Display a running fan
        RunningFan fan = new RunningFan();

        Button pause = new Button("Pause");
        Button play = new Button("Play");
        Button reverse = new Button("reverse");

        pause.setOnAction(e -> fan.pause());
        play.setOnAction(event -> fan.play());
        reverse.setOnAction(event -> fan.reverse());
        return new VBox(fan, new HBox(pause, play, reverse));
    }

    public static Pane ex29() { // Racing car
        CarPane cp = new CarPane();
        cp.setOnKeyPressed(
            event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    cp.pause();
                }
            });
        cp.setOnKeyReleased(
            event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    cp.play();
                }
            });
        cp.setOnKeyPressed(
            event -> {
                if (event.getCode() == KeyCode.UP) {
                    cp.increaseSpeed();
                } else if (event.getCode() == KeyCode.DOWN) {
                    cp.decreaseSpeed();
                }
            });
        return cp;
    }

    public static Pane ex30() { // Slide show
        return new SimpleAnimationPane();
    }

    public static Pane ex31() { // Geometry: pendulum
        AnimatedPendulum pendu = new AnimatedPendulum();
        pendu.setOnKeyPressed(
            event -> {
                if (event.getCode() == KeyCode.UP) {
                    pendu.increaseSpeed();
                } else if (event.getCode() == KeyCode.DOWN) {
                    pendu.decreaseSpeed();
                } else if (event.getCode() == KeyCode.S) {
                    pendu.stopAnimation();
                } else if (event.getCode() == KeyCode.P) {
                    pendu.playAnimation();
                }
            });
        return pendu;
    }

    public static Pane ex32() { // Control a clock
        ClockPane cp = new ClockPane(true);
        Button stop = new Button("Stop");
        stop.setOnAction(event -> cp.pauseAnimation());
        Button play = new Button("Play");
        play.setOnAction(event -> cp.playAnimation());
        HBox btns = new HBox(stop, play);
        return new VBox(cp, btns);
    }

    public static void ex33() { // Game: bean-machine animation
    }

    public static void ex34() { // Simulation: self-avoiding random walk
    }

    public static void ex35() { // Animation: self-avoiding random walk
    }

    public static void ex36() { // Simulation: self-avoiding random walk
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("C15");
        // stage.setHeight(500);
        // stage.setWidth(500);

        Pane pane = ex32();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }
}
