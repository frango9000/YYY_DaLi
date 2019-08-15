package auxp.ch17.rawedit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lib.Math.NumberConverter;

import javax.swing.*;
import java.io.*;

public class RawEditorPane extends BorderPane {

    private final Tab tabBinary;
    private final Tab tabOctal;
    private final Tab tabDecimal;
    private final Tab tabASCII;
    private final Tab tabHex;
    private FileChooser fileChooser;
    private File file;
    private TextField fileDir;
    private Button browseButton;
    private TextArea textBinary;
    private TextArea textOctal;
    private TextArea textDecimal;
    private TextArea textASCII;
    private TextArea textHex;

    public RawEditorPane() {
        HBox browsePane = getBrowseBox();
        setTop(browsePane);

        TabPane tabs = new TabPane();
        setCenter(tabs);
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabs.setTabDragPolicy(TabPane.TabDragPolicy.FIXED);

        tabBinary = new Tab("Binary");
        tabOctal = new Tab("Octal");
        tabDecimal = new Tab("Decimal");
        tabASCII = new Tab("ASCII");
        tabHex = new Tab("Hex");

        tabBinary.setContent(textBinary = new TextArea());
        tabOctal.setContent(textOctal = new TextArea());
        tabDecimal.setContent(textDecimal = new TextArea());
        tabASCII.setContent(textASCII = new TextArea());
        tabHex.setContent(textHex = new TextArea());

        textBinary.setWrapText(true);
        textOctal.setWrapText(true);
        textDecimal.setWrapText(true);
        textHex.setWrapText(true);

        tabs.getTabs().addAll(tabBinary, tabOctal, tabDecimal, tabASCII, tabHex);

        Button saveButton = new Button("Save and Refresh");
        setBottom(saveButton);
        setAlignment(saveButton, Pos.CENTER);

        browseButton.setOnAction(
                event -> {
                    file = fileChooser.showOpenDialog(new Stage());
                    if (file != null && file.exists()) {
                        fileDir.setText(file.getAbsolutePath());
                        readFile(file);
                    }
                });

        saveButton.setOnAction(event -> saveAction());
    }

    private void saveAction() {
        int[] bytesDecimal = null;
        try {
            if (tabBinary.isSelected()) {
                String[] bytesBin = textBinary.getText().split(" ");
                bytesDecimal = new int[bytesBin.length];
                for (int i = 0; i < bytesBin.length; i++) {
                    bytesDecimal[i] = NumberConverter.binToDec(bytesBin[i]);
                }
            } else if (tabOctal.isSelected()) {
                String[] bytesOctal = textOctal.getText().split(" ");
                bytesDecimal = new int[bytesOctal.length];
                for (int i = 0; i < bytesOctal.length; i++) {
                    bytesDecimal[i] = NumberConverter.octToDec(bytesOctal[i]);
                }
            } else if (tabDecimal.isSelected()) {
                String[] stringsDecimal = textDecimal.getText().split(" ");
                bytesDecimal = new int[stringsDecimal.length];
                for (int i = 0; i < stringsDecimal.length; i++) {
                    bytesDecimal[i] = Integer.parseInt(stringsDecimal[i]);
                }
            } else if (tabASCII.isSelected()) {
                char[] bytesASCII = textASCII.getText().toCharArray();
                bytesDecimal = new int[bytesASCII.length];
                for (int i = 0; i < bytesASCII.length; i++) {
                    bytesDecimal[i] = bytesASCII[i];
                }
            } else if (tabHex.isSelected()) {
                String[] bytesHex = textOctal.getText().split(" ");
                bytesDecimal = new int[bytesHex.length];
                for (int i = 0; i < bytesHex.length; i++) {
                    bytesDecimal[i] = NumberConverter.hexToDec(bytesHex[i]);
                }
            }

            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                for (int nextByte : bytesDecimal) {
                    out.write(nextByte);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            readFile(file);
            JOptionPane.showMessageDialog(null, "Save and Refresh Successful");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private HBox getBrowseBox() {
        fileChooser = new FileChooser();
        fileDir = new TextField();
        fileDir.setPrefColumnCount(40);
        fileDir.setEditable(false);
        browseButton = new Button("Browse");
        HBox browsePane = new HBox(new Label("Pick a File"), fileDir, browseButton);
        browsePane.setSpacing(5);
        browsePane.setAlignment(Pos.BASELINE_LEFT);
        browsePane.setPadding(new Insets(10));
        browsePane.setBorder(
                new Border(
                        new BorderStroke(
                                Color.LIGHTGRAY,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT)));
        return browsePane;
    }

    public void readFile(File file) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            textBinary.setText("");
            textOctal.setText("");
            textDecimal.setText("");
            textASCII.setText("");
            textHex.setText("");

            while (in.available() > 0) {
                int next = in.read();
                textBinary.appendText((NumberConverter.decToBin(next, 8) + " "));
                textOctal.appendText((NumberConverter.decToOct(next) + " "));
                textDecimal.appendText((next + " "));
                textASCII.appendText((char) next + "");
                textHex.appendText((NumberConverter.decToHex(next, 2) + " "));
            }

            textBinary.setText(textBinary.getText().trim());
            textOctal.setText(textOctal.getText().trim());
            textDecimal.setText(textDecimal.getText().trim());
            textHex.setText(textHex.getText().trim());
            textBinary.setText(textBinary.getText().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
