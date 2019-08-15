package auxp.ch17.splitter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lib.Misc.FileIO;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class FileSplitPane extends BorderPane {
    private File file;

    private Button browseButton;
    private TextField fileDir;
    private FileChooser fileChooser;

    private TextField newName;
    private TextField newExt;
    private TextField totalSize;
    private TextField numOfPieces;
    private TextField sizeOfPieces;

    private RadioButton pickNumOfPiecesRadio;
    private RadioButton pickSizeOfSplitsRadio;
    private Text finalSizeOfPieces;
    private Text finalNumOfSplits;

    private ArrayList<File> files;

    private Button execButton;

    public FileSplitPane() {
        this(false); // default is join pane
    }

    public FileSplitPane(boolean split) { // false = join pane, true = split pane
        setPadding(new Insets(5));

        HBox browsePane = getBrowseBox();

        GridPane grid = getFieldsGrid();

        HBox bot = getExecButtonBox();

        if (split) {
            pickNumOfPiecesRadio = new RadioButton();
            pickSizeOfSplitsRadio = new RadioButton();

            ToggleGroup pickSplitType = new ToggleGroup();
            pickNumOfPiecesRadio.setToggleGroup(pickSplitType);
            pickSizeOfSplitsRadio.setToggleGroup(pickSplitType);

            finalSizeOfPieces = new Text();
            finalSizeOfPieces.setVisible(false);

            finalNumOfSplits = new Text();
            finalNumOfSplits.setVisible(false);

            grid.addRow(2, pickNumOfPiecesRadio, finalSizeOfPieces);
            grid.addRow(3, pickSizeOfSplitsRadio, finalNumOfSplits);

            execButton.setText("Split");
            setSplitActions();
        } else {
            execButton.setText("Join");
            setJoinActions();
        }

        setTop(browsePane);
        setLeft(grid);
        setBottom(bot);
    }

    private void setSplitActions() {

        numOfPieces
                .textProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            if (!newValue.matches("\\d*")) {
                                numOfPieces.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                            if (numOfPieces.getText().length() > 0) {
                                long pieces = Long.parseLong(numOfPieces.getText());
                                if (pieces > 0) {
                                    newExt.setText(getExtString(pieces));
                                    long bytes = (file.length() / pieces) + (file.length() % pieces == 0 ? 0 : 1);
                                    sizeOfPieces.setText(bytes + "");
                                    finalSizeOfPieces.setText(
                                            FileSplitter.byteSizeFormatter(bytes)
                                                    + " bytes per file"); // if length % n != 0 1 more byte per file.
                                } else finalSizeOfPieces.setText("0 bytes per file");
                            } else finalSizeOfPieces.setText("0 bytes per file");
                        });

        sizeOfPieces
                .textProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            if (!newValue.matches("\\d*")) {
                                sizeOfPieces.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                            if (sizeOfPieces.getText().length() > 0) {
                                long size = Long.parseLong(sizeOfPieces.getText());
                                if (size > 0) {
                                    long pieces =
                                            (file.length() % size == 0
                                                    ? file.length() / size
                                                    : (file.length() / size) + 1);
                                    numOfPieces.setText(pieces + "");
                                    finalNumOfSplits.setText(pieces + " piece(s)");
                                } else finalNumOfSplits.setText("0 piece(s)");
                            } else finalNumOfSplits.setText("0 piece(s)");
                        });
        browseButton.setOnAction(
                event -> {
                    file = fileChooser.showOpenDialog(new Stage());
                    if (file != null) {
                        fileDir.setText(file.getAbsolutePath());

                        newName.setText(file.getName());
                        newExt.setText("000");

                        totalSize.setText(FileSplitter.byteSizeFormatter(file.length()));
                        numOfPieces.setText("1");
                        sizeOfPieces.setText(file.length() + "");

                        numOfPieces.setEditable(true);
                        pickNumOfPiecesRadio.setSelected(true);
                        finalSizeOfPieces.setVisible(true);
                    }
                });
        pickNumOfPiecesRadio.setOnAction(
                event -> {
                    if (file != null && file.exists()) {
                        finalSizeOfPieces.setVisible(true);
                        finalNumOfSplits.setVisible(false);

                        numOfPieces.setEditable(true);
                        sizeOfPieces.setEditable(false);
                    }
                });
        pickSizeOfSplitsRadio.setOnAction(
                event -> {
                    if (file != null && file.exists()) {
                        finalSizeOfPieces.setVisible(false);
                        finalNumOfSplits.setVisible(true);

                        numOfPieces.setEditable(false);
                        sizeOfPieces.setEditable(true);
                    }
                });
        execButton.setOnAction(
                event -> {
                    if (pickNumOfPiecesRadio.isSelected()) {
                        if (numOfPieces.getText().length() > 0) {
                            int piecesValue = Integer.parseInt(numOfPieces.getText());
                            if (piecesValue > 0) {
                                FileSplitter.splitByPieces(file, piecesValue);
                                JOptionPane.showMessageDialog(null, "Success");
                            } else JOptionPane.showMessageDialog(null, "Invalid value");
                        } else JOptionPane.showMessageDialog(null, "Invalid value");

                    } else if (pickSizeOfSplitsRadio.isSelected()) {
                        if (sizeOfPieces.getText().length() > 0) {
                            long sizeValue = Long.parseLong(sizeOfPieces.getText());
                            if (sizeValue > 0) {
                                FileSplitter.splitBySize(file, sizeValue);
                                JOptionPane.showMessageDialog(null, "Success");
                            } else JOptionPane.showMessageDialog(null, "Invalid value");
                        } else JOptionPane.showMessageDialog(null, "Invalid value");

                    } else JOptionPane.showMessageDialog(null, "Invalid option");
                });
    }

    /**
     * returns a string with n * 0 where n = the min digits needed to hold the number of pieces value
     *
     * @param pieces
     * @return
     */
    private String getExtString(long pieces) {
        int digits = (pieces + "").length();
        StringBuilder ext = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            ext.append("0");
        }
        return ext.toString();
    }

    private void setJoinActions() {
        browseButton.setOnAction(
                event -> {
                    file = fileChooser.showOpenDialog(new Stage());
                    if (file == null || !file.exists() || !FileIO.getFileExtension(file).matches("[0-9]*")) {
                        JOptionPane.showMessageDialog(null, "Invalid file");
                    } else {
                        files = FileSplitter.getSplitFiles(file);

                        fileDir.setText(file.getAbsolutePath());
                        newName.setText(FileIO.getCleanName(FileIO.getCleanName(file.getName())) + "-[joint]");
                        newName.setEditable(true);
                        newExt.setText(FileIO.getFileExtension(FileIO.getCleanName(file)));

                        sizeOfPieces.setText(FileSplitter.byteSizeFormatter(file.length()));

                        numOfPieces.setText(files.size() + "");
                        totalSize.setText(FileSplitter.byteSizeFormatter(FileIO.getSizeOfFilesList(files)));
                    }
                });

        execButton.setOnAction(
                event -> {
                    if (files == null) JOptionPane.showMessageDialog(null, "You must pick a file.");
                    else if (files.size() < 1
                            || !file.exists()
                            || !FileIO.getFileExtension(file).matches("[0-9]*"))
                        JOptionPane.showMessageDialog(null, "Invalid file");
                    else if (newName.getText().length() == 0)
                        JOptionPane.showMessageDialog(null, "Invalid filename");
                    else {
                        FileSplitter.join(files, newName.getText() + "." + newExt.getText());
                        JOptionPane.showMessageDialog(null, "Success");
                    }
                });
    }

    private HBox getExecButtonBox() {
        execButton = new Button("GO");
        HBox bot = new HBox(execButton);
        bot.setAlignment(Pos.CENTER);
        return bot;
    }

    private GridPane getFieldsGrid() {
        newName = new TextField();
        newName.setEditable(false);
        newExt = new TextField();
        newExt.setPrefColumnCount(4);
        newExt.setEditable(false);
        totalSize = new TextField();
        totalSize.setEditable(false);
        numOfPieces = new TextField();
        numOfPieces.setEditable(false);
        sizeOfPieces = new TextField();
        sizeOfPieces.setEditable(false);

        HBox nameWithExt = new HBox(newName, new Text("."), newExt);
        nameWithExt.setAlignment(Pos.BASELINE_LEFT);

        GridPane fieldsGrid = new GridPane();
        BorderPane.setMargin(fieldsGrid, new Insets(5));
        fieldsGrid.setHgap(3);
        fieldsGrid.setVgap(5);
        fieldsGrid.addRow(0, new Label("Output Name"), nameWithExt);
        fieldsGrid.addRow(1, new Label("Total Size (bytes)"), totalSize);
        fieldsGrid.addRow(2, new Label("Num of Pieces"), numOfPieces);
        fieldsGrid.addRow(3, new Label("Size of Pieces (bytes)"), sizeOfPieces);
        return fieldsGrid;
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
}
