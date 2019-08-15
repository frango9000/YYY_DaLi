import static lib.Misc.IO.scanInt;
import static lib.Misc.Randomizer.randomInt;

import auxp.ch14.Chart1;
import auxp.ch14.Chart2;
import auxp.ch14.ClockPane;
import auxp.ch14.MyCylinder;
import auxp.ch14.MyGrid;
import auxp.ch14.MyHangman;
import auxp.ch14.MySineGraph;
import auxp.ch14.QuadFunction;
import auxp.ch14.RandArrow;
import auxp.ch14.Rectanguloid;
import auxp.ch14.StopPane;
import auxp.ch14.UglySmiley;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Geometry.Point;
import lib.Misc.Randomizer;
import lib.MyFX.ToolFX;

public class DaLi_14 extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void appendToTitle(String str) {
        stage.setTitle(stage.getTitle() + "_" + str);
    }

    public static void ex00() {
    }

    public static Pane ex01() { // Display images
        appendToTitle("E01");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        String[] images = {
            "res/image/flag5.gif", "res/image/4.jpg", "res/image/china.gif", "res/image/flag1.gif"
        };
        Group g = new Group();
        for (int i = 0; i < images.length; i++) {
            Image f = new Image(images[i]);
            ImageView iv = new ImageView(f);

            int HEIGHT = 600;
            iv.setFitHeight(HEIGHT / 2);
            int WIDTH = 1000;
            iv.setFitWidth(WIDTH / 2);

            switch (i) {
                case 0:
                    pane.add(iv, 0, 0);
                    break;
                case 1:
                    pane.add(iv, 0, 1);
                    break;
                case 2:
                    pane.add(iv, 1, 0);
                    break;
                case 3:
                    pane.add(iv, 1, 1);
                    break;
            }
        }
        return pane;
    }

    public static Pane ex02() { // Tic-tac-toe board
        appendToTitle("E02");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        String[] images = {"res/image/o.gif", "res/image/x.gif"};
        for (int row = 0, col = 0, kt = 1; kt < 10; kt++) {

            int random = Randomizer.randomInt(3);

            switch (random) {
                case 0:
                    pane.add(new ImageView(images[0]), col, row);
                    break;
                case 1:
                    pane.add(new ImageView(images[1]), col, row);
                    break;
                case 2:
                    pane.add(new Pane(), col, row);
                    break;
            }
            col++;
            if (col == 3) {
                row++;
                col = 0;
            }
        }
        return pane;
    }

    public static Pane ex03() { // Display three tile
        appendToTitle("E03");
        Pane pane = new HBox();

        int elements = 3;

        while (elements > 0) {
            int rand = Randomizer.randomInt(1, 53);
            Image i = new Image("res/image/card/" + (rand + 1) + ".png");
            ImageView iv = new ImageView(i);
            pane.getChildren().add(iv);
            elements--;
        }
        return pane;
    }

    public static Pane ex04() { // Color and font
        appendToTitle("E04");
        HBox pane = new HBox(0);
        pane.setMinHeight(100);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));

        for (int i = 0; i < 5; i++) {
            Text text = new Text("JavaFX");
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
            text.setRotate(90);
            text.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(text);
        }
        return pane;
    }

    public static Pane ex05() { // Characters around circle
        appendToTitle("E05");
        Pane pane = new Pane();

        pane.setMinWidth(200);
        pane.setMinHeight(200);

        char[] title = "Learning JavaFX ".toCharArray();
        int anglePerChar = 360 / title.length + 1;
        int radius = 70;
        int centerX = 95, centerY = 100;

        int angle = 0;
        for (char c : title) {
            Text ch = new Text(c + "");
            ch.setX(centerX + (radius * Math.sin(Math.toRadians(90 - angle))));
            ch.setY(centerY + (radius * Math.cos(Math.toRadians(90 - angle))));
            ch.setRotate(90 + angle);
            ch.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));

            angle += anglePerChar;
            pane.getChildren().add(ch);
        }
        return pane;
    }

    public static Pane ex06() { // Game: display a checkerboard
        appendToTitle("E06");
        VBox checkers = new VBox();
        for (int i = 0; i < 4; i++) {
            HBox h1 = new HBox();
            HBox h2 = new HBox();
            for (int j = 0; j < 17; j++) {
                if (j == 8) {
                    continue;
                }
                Color w = new Color(1, 1, 1, 1);
                Color b = new Color(0, 0, 0, 1);
                Rectangle r = new Rectangle(40, 40, (j % 2 == 0) ? w : b);
                if (j < 8) {
                    h1.getChildren().add(r);
                } else {
                    h2.getChildren().add(r);
                }
            }
            checkers.getChildren().addAll(h1, h2);
        }
        return checkers;
    }

    public static Pane ex07() { // Display random 0 or 1
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(3));
        vb.setSpacing(2);
        for (int i = 0; i < 10; i++) {
            HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            hb.setSpacing(2);
            for (int j = 0; j < 10; j++) {
                StackPane sp = new StackPane();
                sp.setAlignment(Pos.CENTER);
                Rectangle r = new Rectangle(20, 20);
                r.setFill(null);
                Text n = new Text(Randomizer.randomInt(2) == 0 ? "0" : "1");
                r.setArcHeight(10);
                r.setArcWidth(10);
                r.setStroke(Color.GRAY);
                sp.getChildren().addAll(r, n);
                hb.getChildren().add(sp);
            }
            vb.getChildren().add(hb);
        }
        return vb;
    }

    public static Pane ex08() { // Display 54 cards
        GridPane gp = new GridPane();
        LinkedList<ImageView> ll = new LinkedList<>();

        for (int i = 0; i < 54; i++) {
            ll.offer(new ImageView(new Image("res/image/card/" + (i + 1) + ".png")));
        }

        for (int row = 0; ll.peek() != null; row++) {
            for (int col = 0; ll.peek() != null && col < 13; col++) {
                gp.add(ll.poll(), col, row);
            }
        }
        return gp;
    }

    public static Pane ex09() { // Create four taichi
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(3, 4, 5, 2));
        gp.setVgap(3);
        gp.setHgap(3);
        gp.setAlignment(Pos.CENTER);

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                Pane stack = new Pane();

                javafx.scene.shape.Circle c = new javafx.scene.shape.Circle(50, 50, 45);
                c.setFill(null);
                c.setStroke(Color.BLACK);
                int startAngle = 30;
                for (int i = 0; i < 4; i++) {
                    startAngle += 90;
                    Arc arc = new Arc(50, 50, 35, 35, startAngle, 35);
                    arc.setFill(Color.BLUE);
                    arc.setType(ArcType.ROUND);
                    stack.getChildren().add(arc);
                }

                stack.getChildren().add(c);
                gp.add(stack, col, row);
            }
        }
        return gp;
    }

    public static Pane ex10() { // Display a cylinder
        return new MyCylinder();
    }

    public static Pane ex11() { // Paint a smiley fac
        stage.setMinHeight(150);
        stage.setMinWidth(100);
        stage.setHeight(150);
        stage.setWidth(100);
        return new UglySmiley();
    }

    public static Pane ex12() { // Display a bar chart
        return new Chart1();
    }

    public static Pane ex13() { // Display a pie chart
        return new Chart2();
    }

    public static Pane ex14() { // Display a rectanguloid
        Pane b = new StackPane(new Rectanguloid());
        b.setPrefSize(600, 600);
        b.setMinSize(200, 200);
        b.setPadding(new Insets(50));
        return b;
    }

    public static Pane ex15() { // Display a STOP sign
        return new StopPane();
    }

    public static Pane ex16() { // Display a 4 * 4 grid
        return new MyGrid(4);
    }

    public static Pane ex17() { // Game: hangman
        return new MyHangman();
    }

    public static Pane ex18() { // Plot the cube function
        return new QuadFunction();
    }

    public static Pane ex19() { // Plot the sine and tangent functions
        return new MySineGraph();
    }

    public static Pane ex20() { // Draw an arrow line
        return new RandArrow();
    }

    public static Pane ex21() { // Two circles and their distance
        Pane pane = new Pane();
        double x1 = Randomizer.randomDouble(stage.getWidth());
        double y1 = Randomizer.randomDouble(stage.getHeight());

        double x2 = Randomizer.randomDouble(stage.getWidth());
        double y2 = Randomizer.randomDouble(stage.getHeight());

        Line l = new Line(x1, y1, x2, y2);
        javafx.scene.shape.Circle c1 = new javafx.scene.shape.Circle(x1, y1, 15);
        javafx.scene.shape.Circle c2 = new javafx.scene.shape.Circle(x2, y2, 15);

        double distance = new Point(x1, y1).distanceBetweenPoints(new Point(x2, y2));
        Point mp = new Point(x1, y1).middlePoint(new Point(x2, y2));
        Text t = new Text(mp.x, mp.y, String.format("%.3f", distance));

        pane.getChildren().addAll(c1, c2, l, t);
        return pane;
    }

    public static Pane ex22() { // Connect two circles
        Pane pane = new Pane();
        double x1 = Randomizer.randomDouble(stage.getWidth());
        double y1 = Randomizer.randomDouble(stage.getHeight());

        double x2 = Randomizer.randomDouble(stage.getWidth());
        double y2 = Randomizer.randomDouble(stage.getHeight());

        Line l = new Line(x1, y1, x2, y2);
        javafx.scene.shape.Circle c1 = new javafx.scene.shape.Circle(x1, y1, 15);
        javafx.scene.shape.Circle c2 = new javafx.scene.shape.Circle(x2, y2, 15);
        ToolFX.setFillStroke(Color.WHITE, Color.BLACK, c1, c2);

        Text t1 = new Text(x1, y1, "1");
        Text t2 = new Text(x2, y2, "2");

        pane.getChildren().addAll(l, c1, c2, t1, t2);
        return pane;
    }

    public static Pane ex23() { // Geometry: two rectangles
        int x1 = scanInt("x1: ");
        int y1 = scanInt("y1: ");
        int w1 = scanInt("w1: ");
        int h1 = scanInt("h1: ");

        int x2 = scanInt("x2: ");
        int y2 = scanInt("y2: ");
        int w2 = scanInt("w2: ");
        int h2 = scanInt("h2: ");

        Rectangle r1 = new Rectangle(x1, y1, w1, h1);
        Rectangle r2 = new Rectangle(x2, y2, w2, h2);

        lib.Geometry.Rectangle rr1 = new lib.Geometry.Rectangle(w1, h1, new Point(x1, y1));
        lib.Geometry.Rectangle rr2 = new lib.Geometry.Rectangle(w2, h2, new Point(x2, y2));

        Text label = new Text(300, 400, "");

        if (rr1.contains(rr2)) {
            label.setText("r1 contains r2");
        } else if (rr1.overlaps(rr2)) {
            label.setText("r1 overlaps r2");
        } else {
            label.setText("r1 not in r2");
        }
        ToolFX.setFillStroke(null, Color.BLACK, r1, r2);
        return new Pane(r1, r2, label);
    }

    public static Pane ex24() { // Geometry: Inside a polygon?
        double[] points = new double[8];
        Pane pane = new Pane();
        for (int i = 0; i < points.length; i += 2) {
            points[i] = scanInt("x" + i / 2 + ": ");
            points[i + 1] = scanInt("y" + i / 2 + ": ");
        }
        double x = scanInt("x: ");
        double y = scanInt("y: ");

        Polygon polygon = new Polygon(points);
        ToolFX.setFillStroke(null, Color.BLACK, polygon);
        javafx.scene.shape.Circle point = new javafx.scene.shape.Circle(x, y, 5, Color.BLACK);

        pane.getChildren().addAll(polygon, point);
        Text text =
            new Text(
                "The point is " + (polygon.contains(x, y) ? "" : "not ") + "inside the polygon  ");
        text.setTranslateY(400);
        pane.getChildren().add(text);
        return pane;
    }

    public static Pane ex25() { // Random points on a circle
        lib.Geometry.Circle circle = new lib.Geometry.Circle(100, new Point(150, 150));
        ArrayList<Double> angles = new ArrayList<>();
        for (int i = 0; angles.size() < 5; i++) {
            double randomDegree3 = randomInt(35999) / 100f;
            if (!angles.contains(randomDegree3)) {
                angles.add(randomDegree3);
            }
        }

        java.util.Collections.sort(angles);
        double[] points = new double[10];
        for (int i = 0, j = 0; i < points.length; i += 2) {
            Point p = circle.pointOnAngle(angles.get(j++));
            points[i] = p.x;
            points[i + 1] = p.y;
        }

        javafx.scene.shape.Circle circleFX = new javafx.scene.shape.Circle(150, 150, 100, null);
        Polygon polygon = new Polygon(points);
        ToolFX.setFillStroke(null, Color.BLACK, circleFX, polygon);
        return new Pane(circleFX, polygon);
    }

    public static Pane ex26() { // Use the ClockPane class
        Pane pane = new HBox();
        ClockPane c1 = new ClockPane(4, 20, 45);
        StackPane p1 = new StackPane(c1);
        p1.setMinSize(100, 100);
        ClockPane c2 = new ClockPane(22, 46, 15);
        StackPane p2 = new StackPane(c2);
        p2.setMinSize(100, 100);

        pane.getChildren().addAll(p1, p2);
        return pane;
    }

    public static Pane ex27() { // Draw a detailed clock
        ClockPane cp = new ClockPane();
        cp.setDetailed(true);
        return cp;
    }

    public static Pane ex28() { // Random time
        ClockPane cp = new ClockPane();
        cp.setDetailed(true);
        cp.setSecondHandVisible(false);
        return cp;
    }

    public static void ex29() { // Game: bean machine
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setHeight(500);
        stage.setWidth(500);
        primaryStage.setTitle("C14");

        Pane pane = ex10();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
