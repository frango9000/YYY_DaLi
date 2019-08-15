import auxp.ch14.ClockPane;
import auxp.ch15.CarPane;
import auxp.ch15.RunningFan;
import auxp.ch16.AnimationPane;
import auxp.ch16.ColorSliders;
import auxp.ch16.IntersectingCircles;
import auxp.ch16.IntersectingSquares;
import auxp.ch16.MediaDemo;
import auxp.ch16.MediaStopWatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.Data.ArrayManip;
import lib.Math.NumberConverter;
import lib.Math.Scales;
import lib.MyFX.ToolFX;

public class DaLi_16 extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static Pane ex00() {
        return new Pane();
    }

    public static Pane ex01() { // Use radio buttons
        Text text = new Text(75, 150, "Welcome to Java");

        RadioButton redButton = new RadioButton("Red");
        RadioButton yellowButton = new RadioButton("Yellow");
        RadioButton blackButton = new RadioButton("Black");
        RadioButton orangeButton = new RadioButton("Orange");
        RadioButton greenButton = new RadioButton("Green");

        ToggleGroup tg = new ToggleGroup();
        redButton.setToggleGroup(tg);
        yellowButton.setToggleGroup(tg);
        blackButton.setToggleGroup(tg);
        orangeButton.setToggleGroup(tg);
        greenButton.setToggleGroup(tg);

        redButton.setOnAction(event -> text.setFill(Color.RED));
        yellowButton.setOnAction(event -> text.setFill(Color.YELLOW));
        blackButton.setOnAction(event -> text.setFill(Color.BLACK));
        orangeButton.setOnAction(event -> text.setFill(Color.ORANGE));
        greenButton.setOnAction(event -> text.setFill(Color.GREEN));

        HBox colors = new HBox(redButton, yellowButton, blackButton, orangeButton, greenButton);
        Pane center = new Pane(text);
        center.setMinHeight(300);
        center.setStyle("-fx-border-color: black");

        Button leftButton = new Button("<");
        Button rightButton = new Button(">");
        leftButton.setOnAction(event -> text.setX(text.getX() - 10 >= 0 ? text.getX() - 10 : 0));
        rightButton.setOnAction(
            event ->
                text.setX(
                    text.getX() + 10 <= center.getWidth() - 50
                        ? text.getX() + 10
                        : center.getWidth() - 50));
        HBox btns = new HBox(leftButton, rightButton);
        btns.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setBottom(btns);
        pane.setCenter(center);
        pane.setTop(colors);

        return pane;
    }

    public static Pane ex02() { // Select geometric figures
        StackPane figures = new StackPane();
        figures.setMinSize(400, 500);

        RadioButton circle = new RadioButton("Circle");
        RadioButton square = new RadioButton("Square");
        RadioButton ellipse = new RadioButton("Ellipse");
        CheckBox fill = new CheckBox("Fill");

        ToggleGroup tg = new ToggleGroup();
        circle.setToggleGroup(tg);
        square.setToggleGroup(tg);
        ellipse.setToggleGroup(tg);

        circle.setOnAction(
            event -> {
                figures.getChildren().clear();
                figures.getChildren().add(new Circle(100, Color.BLACK));
            });
        square.setOnAction(
            event -> {
                figures.getChildren().clear();
                figures.getChildren().add(new Rectangle(100, 100, Color.BLACK));
            });
        ellipse.setOnAction(
            event -> {
                figures.getChildren().clear();
                figures.getChildren().add(new Ellipse(120, 80));
            });
        fill.setOnAction(
            event -> {
                if (((CheckBox) event.getSource()).isSelected()) {
                    ((Shape) figures.getChildren().get(0)).setFill(Color.BLACK);
                } else {
                    ((Shape) figures.getChildren().get(0)).setFill(null);
                }
            });

        HBox options = new HBox(circle, square, ellipse, fill);
        return new VBox(figures, options);
    }

    public static Pane ex03() { // Traffic lights
        Rectangle rect = new Rectangle(300, 200, null);
        rect.setStroke(Color.BLACK);
        Circle red = new Circle(50, 100, 25, null);
        Circle yellow = new Circle(150, 100, 25, null);
        Circle green = new Circle(250, 100, 25, null);
        ToolFX.setFillStroke(null, Color.BLACK, red, yellow, green);

        Pane stack = new Pane(rect, red, green, yellow);

        RadioButton redbtn = new RadioButton("Red");
        RadioButton yelbtn = new RadioButton("Yellow");
        RadioButton grebtn = new RadioButton("Green");

        HBox btns = new HBox(redbtn, yelbtn, grebtn);
        redbtn.setOnAction(
            event -> {
                red.setFill(Color.RED);
                green.setFill(null);
                yellow.setFill(null);
            });

        grebtn.setOnAction(
            event -> {
                red.setFill(null);
                green.setFill(Color.GREEN);
                yellow.setFill(null);
            });
        yelbtn.setOnAction(
            event -> {
                red.setFill(null);
                green.setFill(null);
                yellow.setFill(Color.YELLOW);
            });

        ToggleGroup tg = new ToggleGroup();
        redbtn.setToggleGroup(tg);
        yelbtn.setToggleGroup(tg);
        grebtn.setToggleGroup(tg);

        return new VBox(stack, btns);
    }

    public static Pane ex04() { // Create a Celsius/Fahrenheit converter
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.add(new Label("Celcius"), 0, 0);
        grid.add(new Label("Farenheit"), 0, 1);

        TextField ctext = new TextField();
        TextField ftext = new TextField();
        grid.add(ctext, 1, 0);
        grid.add(ftext, 1, 1);

        ctext.setOnAction(
            event -> {
                ftext.setText("" + Scales.celsiusToFahrenheit(Double.parseDouble(ctext.getText())));
            });
        ftext.setOnAction(
            event -> {
                ctext.setText("" + Scales.fahrenheitToCelsius(Double.parseDouble(ftext.getText())));
            });
        return grid;
    }

    public static Pane ex05() { // Convert numbers
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.add(new Label("Decimal"), 0, 0);
        grid.add(new Label("Hex"), 0, 1);
        grid.add(new Label("Binary"), 0, 2);

        TextField dtxt = new TextField();
        TextField htxt = new TextField();
        TextField btxt = new TextField();
        grid.add(dtxt, 1, 0);
        grid.add(htxt, 1, 1);
        grid.add(btxt, 1, 2);

        dtxt.setOnAction(
            event -> {
                htxt.setText("" + NumberConverter.decToHex(Integer.parseInt(dtxt.getText())));
                btxt.setText("" + NumberConverter.decToBin(Integer.parseInt(dtxt.getText())));
            });
        htxt.setOnAction(
            event -> {
                dtxt.setText("" + NumberConverter.hexToDec(dtxt.getText()));
                btxt.setText("" + NumberConverter.hexToBin(dtxt.getText()));
            });
        btxt.setOnAction(
            event -> {
                dtxt.setText("" + NumberConverter.binToDec(dtxt.getText()));
                htxt.setText("" + NumberConverter.binToHex(dtxt.getText()));
            });
        return grid;
    }

    public static Pane ex06() { // Demonstrate TextField properties
        Label label = new Label("Text Field");
        TextField tf = new TextField("JavaFX");
        HBox h1 = new HBox(label, tf);

        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        RadioButton right = new RadioButton("Right");
        ToggleGroup tg = new ToggleGroup();
        left.setToggleGroup(tg);
        center.setToggleGroup(tg);
        right.setToggleGroup(tg);
        Label colsize = new Label("Column Size");
        TextField cols = new TextField("12");

        left.setOnAction(event -> tf.setAlignment(Pos.CENTER_LEFT));
        center.setOnAction(event -> tf.setAlignment(Pos.CENTER));
        right.setOnAction(event -> tf.setAlignment(Pos.CENTER_RIGHT));
        cols.setOnAction(event -> tf.setPrefColumnCount(Integer.parseInt(cols.getText())));

        return new VBox(h1, new HBox(left, center, right, colsize, cols));
    }

    public static Pane ex07() { // Set clock time
        BorderPane bp = new BorderPane();
        ClockPane clock = new ClockPane();
        bp.setCenter(clock);

        Label hourLbl = new Label("Hour");
        Label minuteLbl = new Label("Minute");
        Label secondLbl = new Label("Second");

        TextField htxt = new TextField();
        htxt.setPrefColumnCount(2);
        TextField mtxt = new TextField();
        mtxt.setPrefColumnCount(2);
        TextField stxt = new TextField();
        stxt.setPrefColumnCount(2);

        htxt.setOnAction(
            event -> {
                clock.setHour(Integer.parseInt(htxt.getText()));
            });
        mtxt.setOnAction(
            event -> {
                clock.setMinute(Integer.parseInt(mtxt.getText()));
            });
        stxt.setOnAction(
            event -> {
                clock.setSecond(Integer.parseInt(stxt.getText()));
            });

        HBox bot = new HBox(hourLbl, htxt, minuteLbl, mtxt, secondLbl, stxt);
        bp.setBottom(bot);
        return bp;
    }

    public static Pane ex08() { // Geometry: two circles intersect?
        return new IntersectingCircles();
    }

    public static Pane ex09() { // Geometry: two rectangles intersect?
        return new IntersectingSquares();
    }

    public static Pane ex10() { // Text viewer
        BorderPane bp = new BorderPane();
        TextArea text = new TextArea();
        bp.setCenter(text);

        Label label = new Label("Filename");
        TextField filenameInput = new TextField();
        Button entrButton = new Button("View");
        HBox bot = new HBox(label, filenameInput, entrButton);
        bot.setAlignment(Pos.CENTER);
        bp.setBottom(bot);

        entrButton.setOnAction(
            event -> {
                File f = new File(filenameInput.getText());
                if (f.exists()) {
                    try (Scanner scan = new Scanner(f)) {
                        StringBuilder builder = new StringBuilder();
                        while (scan.hasNextLine()) {
                            builder.append(scan.nextLine());
                        }
                        text.setText(builder.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        return bp;
    }

    public static Pane ex11() { // Create a histogram for occurrences of letters
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        yAxis.setLabel("Appereances");
        xAxis.setLabel("Letter");

        int[] counts = new int['z' - 'a' + 1];
        File file = new File("C:/audio.log");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char ch = Character.toLowerCase(line.charAt(i));
                    if (ch >= 'a' && ch <= 'z') {
                        counts[ch - 'a']++;
                    }
                }
            }
            ArrayManip.printArray(counts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XYChart.Series s1 = new XYChart.Series();
        s1.setName("Chars");
        for (int i = 0; i < counts.length; i++) {
            s1.getData().add(new XYChart.Data<String, Number>("" + (char) (i + 'a'), counts[i]));
        }
        bc.getData().add(s1);

        return new Pane(bc);
    }

    public static Pane ex12() { // Demonstrate TextArea properties
        BorderPane bp = new BorderPane();
        TextArea text = new TextArea();
        bp.setCenter(text);

        CheckBox edit = new CheckBox("Editable");
        edit.setOnAction(event -> text.setEditable(((CheckBox) event.getSource()).isSelected()));
        CheckBox wrap = new CheckBox("Wrap");
        wrap.setOnAction(event -> text.setWrapText(((CheckBox) event.getSource()).isSelected()));
        HBox bot = new HBox(edit, wrap);
        bot.setAlignment(Pos.CENTER);
        bp.setBottom(bot);

        return bp;
    }

    public static Pane ex13() { // Compare loans with various interest rates
        Label amtLbl = new Label("Loan Amount");
        TextField amtTxt = new TextField();
        Label yrsLbl = new Label("Number of years");
        TextField yrsTxt = new TextField();
        Button show = new Button("Show");
        HBox top = new HBox(amtLbl, amtTxt, yrsLbl, yrsTxt, show);

        TextArea text = new TextArea();
        text.setPrefColumnCount(30);

        show.setOnAction(
            event -> {
                text.appendText(
                    String.format("%s %5s %5s\n", "Interest Rate", "Monthly Payment",
                        "Total Payment"));
                for (double i = 5.0; i <= 10; i += 0.25) {
                    double monthlyInterestRate = i / 1200.0;
                    double monthlyPayment =
                        (Double.parseDouble(amtTxt.getText())
                            * monthlyInterestRate
                            / (1
                            - 1
                            / Math.pow(
                            1 + monthlyInterestRate, Integer.parseInt(yrsTxt.getText()) * 12)));
                    text.appendText(
                        String.format(
                            "%5.2f %5.2f %8.2f\n",
                            i, monthlyPayment,
                            (monthlyPayment * 12) * Integer.parseInt(yrsTxt.getText())));
                }
            });

        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setCenter(text);
        return bp;
    }

    public static Pane ex14() { // Select a font
        Text text = new Text("Programming is Fun.");

        Label fontNameLbl = new Label("Font Name");
        ObservableList<String> fitems = FXCollections.observableArrayList(Font.getFontNames());
        ComboBox<String> fonts = new ComboBox<>(fitems);

        Label fontSizeLbl = new Label("Font Size");
        String[] sitems = {"10", "12", "14", "16", "18", "20", "22", "24", "26"};
        ComboBox<String> sizes = new ComboBox<>(FXCollections.observableArrayList(sitems));

        HBox top = new HBox(fontNameLbl, fonts, fontSizeLbl, sizes);
        top.setSpacing(5);

        StackPane pane = new StackPane(text);
        pane.setMinSize(400, 300);

        CheckBox boldCh = new CheckBox("Bold");
        CheckBox italicCh = new CheckBox("Italic");
        HBox bot = new HBox(boldCh, italicCh);
        bot.setSpacing(5);
        bot.setAlignment(Pos.CENTER);
        fonts.setValue(fitems.get(0));
        sizes.setValue("10");

        fonts.setOnAction(event -> text.setFont(Font.font(fonts.getValue())));
        sizes.setOnAction(event -> text.setFont(Font.font(Integer.parseInt(sizes.getValue()))));

        boldCh.setOnAction(
            event ->
                text.setFont(
                    Font.font(
                        fonts.getValue(),
                        boldCh.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL,
                        italicCh.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR,
                        Integer.parseInt(sizes.getValue()))));
        italicCh.setOnAction(
            event ->
                text.setFont(
                    Font.font(
                        fonts.getValue(),
                        boldCh.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL,
                        italicCh.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR,
                        Integer.parseInt(sizes.getValue()))));

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(8));
        bp.setTop(top);
        bp.setCenter(pane);
        bp.setBottom(bot);
        return bp;
    }

    public static Pane ex15() { // Demonstrate Label properties
        String[] contents = {"TOP", "BOTTOM", "LEFT", "RIGHT"};
        ObservableList<String> fcontents = FXCollections.observableArrayList(contents);
        ComboBox<String> positions = new ComboBox<>(fcontents);
        Label top1 = new Label("contentDiplay:", positions);
        top1.setContentDisplay(ContentDisplay.RIGHT);

        TextField gap = new TextField();
        Label top2 = new Label("graphicTextGap:", gap);
        top2.setContentDisplay(ContentDisplay.RIGHT);

        HBox top = new HBox(top1, top2);

        ImageView grapeimg = new ImageView("res/image/grapes.gif");
        Label grape = new Label("Grapes", grapeimg);
        grape.setMinHeight(200);

        positions.setOnAction(
            event -> {
                switch (positions.getValue()) {
                    case "TOP":
                        grape.setContentDisplay(ContentDisplay.TOP);
                        break;
                    case "BOTTOM":
                        grape.setContentDisplay(ContentDisplay.BOTTOM);
                        break;
                    case "LEFT":
                        grape.setContentDisplay(ContentDisplay.LEFT);
                        break;
                    case "RIGHT":
                        grape.setContentDisplay(ContentDisplay.RIGHT);
                        break;
                }
            });

        gap.setOnAction(event -> grape.setGraphicTextGap(Double.parseDouble(gap.getText())));

        BorderPane bp = new BorderPane(grape);
        bp.setTop(top);
        bp.setPadding(new Insets(10));
        return bp;
    }

    public static Pane ex16() { // Use ComboBox and ListView
        String[] options = {"Single", "Multiple"};
        ComboBox<String> opt = new ComboBox<>(FXCollections.observableArrayList(options));
        Label top = new Label("Selecction Mode:", opt);
        top.setContentDisplay(ContentDisplay.RIGHT);

        String[] flagTitles = {
            "Canada",
            "China",
            "Denmark",
            "France",
            "Germany",
            "India",
            "Norway",
            "United Kingdom",
            "United States of America"
        };
        ListView<String> countrieslist = new ListView<>(
            FXCollections.observableArrayList(flagTitles));

        opt.setOnAction(
            event -> {
                switch (opt.getValue()) {
                    case "Single":
                        countrieslist.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                        break;
                    case "Multiple":
                        countrieslist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                        break;
                }
            });

        return new VBox(top, countrieslist);
    }

    public static Pane ex17() { // Use ScrollBar and Slider
        return new ColorSliders();
    }

    public static BorderPane ex18() { // Simulation: a running fan
        Button pause = new Button("Pause");
        Button play = new Button("Play");
        Button reverse = new Button("reverse");

        HBox controls = new HBox(pause, play, reverse);
        controls.setAlignment(Pos.CENTER);

        RunningFan fan = new RunningFan();
        pause.setOnAction(e -> fan.pause());
        play.setOnAction(event -> fan.play());
        reverse.setOnAction(event -> fan.reverse());

        ScrollBar bar = new ScrollBar();
        bar.setValue(100);
        bar.valueProperty().addListener(observable -> fan.setSpeed(bar.getValue()));

        BorderPane bp = new BorderPane(fan);
        bp.setPadding(new Insets(3));
        bp.setTop(controls);
        bp.setBottom(bar);
        return bp;
    }

    public static Pane ex19() { // Control a group of fans
        BorderPane fan1 = ex18();
        fan1.setStyle("-fx-border-color: black;");
        BorderPane fan2 = ex18();
        fan2.setStyle("-fx-border-color: black;");
        BorderPane fan3 = ex18();
        fan3.setStyle("-fx-border-color: black;");
        HBox fans = new HBox(fan1, fan2, fan3);
        fans.setSpacing(5);
        fans.setPadding(new Insets(5));

        Button startall = new Button("Start all");
        Button stopall = new Button("Stop all");
        HBox bot = new HBox(startall, stopall);
        bot.setAlignment(Pos.CENTER);

        startall.setOnAction(
            event -> {
                ((RunningFan) fan1.getCenter()).play();
                ((RunningFan) fan2.getCenter()).play();
                ((RunningFan) fan3.getCenter()).play();
            });
        stopall.setOnAction(
            event -> {
                ((RunningFan) fan1.getCenter()).pause();
                ((RunningFan) fan2.getCenter()).pause();
                ((RunningFan) fan3.getCenter()).pause();
            });

        return new VBox(fans, bot);
    }

    public static Pane ex20() { // Count-up stopwatch
        Text time = new Text("00:00:00:000");
        time.setStyle("-fx-font-size: 30;");
        StackPane pane = new StackPane(time);

        Button start = new Button("Start");
        Button clear = new Button("Clear");
        HBox buttons = new HBox(start, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        MediaStopWatch mediaStopWatch = new MediaStopWatch();
        Timeline timeline =
            new Timeline(
                new KeyFrame(
                    Duration.millis(10), event -> time.setText(mediaStopWatch.getLapsedFormat())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        start.setOnAction(
            event -> {
                switch (start.getText()) {
                    case "Start":
                        timeline.play();
                        mediaStopWatch.start();
                        start.setText("Pause");
                        break;
                    case "Pause":
                        timeline.pause();
                        mediaStopWatch.pause();
                        time.setText(mediaStopWatch.getElapsedFormat());
                        start.setText("Resume");
                        break;
                    case "Resume":
                        timeline.play();
                        mediaStopWatch.start();
                        start.setText("Pause");
                        break;
                }
            });
        clear.setOnAction(
            event -> {
                mediaStopWatch.reset();
                mediaStopWatch.stop();
                timeline.stop();
                time.setText("00:00:00:000");
                start.setText("Start");
            });
        VBox vPane = new VBox(pane, buttons);
        vPane.setPadding(new Insets(10));
        return vPane;
    }

    public static Pane ex21() { // Count-down stopwatch
        TextField countdown = new TextField("30");
        Timeline counting = new Timeline();
        counting.setCycleCount(Timeline.INDEFINITE);
        MediaPlayer mp =
            new MediaPlayer(
                new Media(new File("src/res/audio/front-desk-bells.mp3").toURI().toString()));
        // MediaPlayer mp = new MediaPlayer(new
        // Media("file:///D:/NarF/Documents/IdeaProjects/YYY_DaLi/src/res/audio/front-desk-bells.mp3"));

        KeyFrame key =
            new KeyFrame(
                Duration.millis(999),
                event -> {
                    int num = (Integer.parseInt(countdown.getText()));
                    if (num != 0) {
                        countdown.setText((num - 1) + "");
                    } else {
                        mp.play();
                        counting.pause();
                    }
                });
        counting.getKeyFrames().add(key);
        countdown.setOnAction(
            event -> {
                if (counting.getStatus() == Animation.Status.PAUSED
                    || counting.getStatus() == Animation.Status.STOPPED) {
                    counting.play();
                } else {
                    counting.pause();
                }
            });
        return new Pane(countdown);
    }

    public static Pane ex22() { // Play, loop, and stop a sound clip
        AudioClip audio = new AudioClip(new File("src/res/audio/denmark.mp3").toURI().toString());

        Button play = new Button("Play");
        play.setOnAction(event -> audio.play());
        Button loop = new Button("Loop");
        loop.setOnAction(event -> audio.setCycleCount(Timeline.INDEFINITE));
        Button stop = new Button("Stop");
        stop.setOnAction(event -> audio.stop());

        HBox h = new HBox(play, loop, stop);
        h.setPadding(new Insets(10));
        h.setSpacing(3);
        return h;
    }

    public static Pane ex23() { // Create an image animator with audio
        return new AnimationPane();
    }

    public static Pane ex24() { // Revise Listing 16.14 MediaDemo.java
        return new MediaDemo();
    }

    public static Pane ex25() { // Racing cars
        TextField c1 = new TextField("1");
        TextField c2 = new TextField("2");
        TextField c3 = new TextField("4");
        TextField c4 = new TextField("8");
        Button go = new Button("Go");

        HBox top =
            new HBox(
                new Label("Car 1"),
                c1,
                new Label("Car 2"),
                c2,
                new Label("Car 3"),
                c3,
                new Label("Car 4"),
                c4,
                go);

        CarPane car1 = new CarPane();
        CarPane car2 = new CarPane();
        CarPane car3 = new CarPane();
        CarPane car4 = new CarPane();

        go.setOnAction(
            event -> {
                car1.setSpeed(Integer.parseInt(c1.getText()));
                car2.setSpeed(Integer.parseInt(c2.getText()));
                car3.setSpeed(Integer.parseInt(c3.getText()));
                car4.setSpeed(Integer.parseInt(c4.getText()));
            });

        return new VBox(top, car1, car2, car3, car4);
    }

    public static Pane ex26() { // Simulation: raise flag and play anthem
        Pane pane = new Pane();
        pane.setMinSize(600, 600);

        ImageView flag = new ImageView(new Image("res/image/denmark.gif"));

        AudioClip anthem = new AudioClip(new File("src/res/audio/denmark.mp3").toURI().toString());

        Line line = new Line(100, 500, 100, 50);
        PathTransition pt = new PathTransition(Duration.millis(10000), line, flag);
        pt.play();
        anthem.play();

        pane.getChildren().add(flag);
        return pane;
    }

    public static void ex27() { // Display country flag and flag description
    }

    public static void ex28() { // Slide show
    }

    public static void ex29() { // Display a calendar
    }

    public static void ex30() { // Pattern recognition: consecutive four equal numbers
    }

    public static void ex31() { // Game: connect four
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("C16");

        Pane pane = ex26();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }
}
