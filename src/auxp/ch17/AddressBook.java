package auxp.ch17;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddressBook extends BorderPane {

    private final int NAME = 32;
    private final int STREET = 32;
    private final int CITY = 20;
    private final int STATE = 2;
    private final int ZIP = 5;
    private File file = new File("src/auxp/ch17/Exercise17_09.dat");
    private long count;

    private TextField nameTF = new TextField();
    private TextField streetTF = new TextField();
    private TextField cityTF = new TextField();
    private TextField stateTF = new TextField();
    private TextField zipTF = new TextField();

    public AddressBook() {

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        // set smaller fields size
        stateTF.setPrefColumnCount(2);
        zipTF.setPrefColumnCount(3);

        // set text fields max length
        nameTF
            .textProperty()
            .addListener(
                observable -> {
                    if (nameTF.getText().length() > NAME) {
                        nameTF.setText(nameTF.getText().substring(0, NAME));
                    }
                });
        streetTF
            .textProperty()
            .addListener(
                observable -> {
                    if (streetTF.getText().length() > STREET) {
                        streetTF.setText(streetTF.getText().substring(0, STREET));
                    }
                });
        cityTF
            .textProperty()
            .addListener(
                observable -> {
                    if (cityTF.getText().length() > CITY) {
                        cityTF.setText(cityTF.getText().substring(0, CITY));
                    }
                });
        stateTF
            .textProperty()
            .addListener(
                observable -> {
                    if (stateTF.getText().length() > STATE) {
                        stateTF.setText(stateTF.getText().substring(0, STATE));
                    }
                });
        zipTF
            .textProperty()
            .addListener(
                observable -> {
                    if (zipTF.getText().length() > ZIP) {
                        zipTF.setText(zipTF.getText().substring(0, ZIP));
                    }
                });

        grid.addRow(0, new Label("Name"), nameTF);
        grid.addRow(1, new Label("Street"), streetTF);
        HBox botFields = new HBox(cityTF, new Label("State"), stateTF, new Label("Zip"), zipTF);
        botFields.setSpacing(5);
        grid.addRow(2, new Label("City"), botFields);

        Button addBT = new Button("Add");
        Button firstBT = new Button("First");
        Button previousBT = new Button("Previous");
        Button nextBT = new Button("Next");
        Button lastBT = new Button("Last");
        Button updateBT = new Button("Update");

        addBT.setOnAction(event -> add());
        firstBT.setOnAction(event -> first());
        previousBT.setOnAction(event -> previous());
        nextBT.setOnAction(event -> next());
        lastBT.setOnAction(event -> last());
        updateBT.setOnAction(event -> update());

        HBox bot = new HBox(addBT, firstBT, previousBT, nextBT, lastBT, updateBT);
        bot.setSpacing(10);
        bot.setAlignment(Pos.CENTER);
        bot.setPadding(new Insets(5, 0, 0, 0));

        setCenter(grid);
        setBottom(bot);
    }

    void add() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            inout.seek(inout.length());
            count = (((int) inout.length()) / 91) + 1;
            write(inout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void first() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            if (inout.length() > 0) {
                inout.seek(0);
                read(inout);
                count = 1;
                System.out.println("Reading address #" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void previous() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            if (count > 1) {
                count--;
            } else {
                count = 1;
            }
            inout.seek((count * 91) - 91);
            read(inout);
            System.out.println("Reading address #" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void next() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            if (count * 91 < inout.length()) {
                inout.seek(count * 91);
                read(inout);
                count++;
                System.out.println("Reading address #" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void last() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            count = ((int) inout.length()) / 91;
            inout.seek((count * 91) - 91);
            read(inout);
            System.out.println("Reading address #" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void update() {
        try (RandomAccessFile inout = new RandomAccessFile(file, "rw")) {
            inout.seek(count * 91 - 91);
            write(inout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read(RandomAccessFile inout) throws IOException {
        int position;
        byte[] name = new byte[NAME];
        position = inout.read(name);
        nameTF.setText(new String(name));

        byte[] street = new byte[STREET];
        position += inout.read(street);
        streetTF.setText(new String(street));

        byte[] city = new byte[CITY];
        position += inout.read(city);
        cityTF.setText(new String(city));

        byte[] state = new byte[STATE];
        position += inout.read(state);
        stateTF.setText(new String(state));

        byte[] zip = new byte[ZIP];
        position += inout.read(zip);
        zipTF.setText(new String(zip));
    }

    void write(RandomAccessFile inout) throws IOException {
        inout.write(fixedLength(nameTF.getText().getBytes(), NAME));
        inout.write(fixedLength(streetTF.getText().getBytes(), STREET));
        inout.write(fixedLength(cityTF.getText().getBytes(), CITY));
        inout.write(fixedLength(stateTF.getText().getBytes(), STATE));
        inout.write(fixedLength(zipTF.getText().getBytes(), ZIP));

        System.out.println("Address #" + count + " saved!");
    }

    /**
     * Return a byte[] of fixed-length
     */
    private byte[] fixedLength(byte[] x, int n) {
        byte[] b = new byte[n];
        for (int i = 0; i < x.length; i++) {
            b[i] = x[i];
        }
        return b;
    }
}
