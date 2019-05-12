package auxp.ch21;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class BabyNamesPane extends BorderPane {

    private TreeMap<String, Integer>[] males;
    private TreeMap<String, Integer>[] females;

    private ObservableList<Integer> years = FXCollections.observableArrayList(2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010);

    public BabyNamesPane() {
        setPadding(new Insets(5));
        getNames();

        ComboBox<Integer> year = new ComboBox<>(years);
        ComboBox<String> gender = new ComboBox<>(FXCollections.observableArrayList("Male", "Female"));
        TextField name = new TextField();
        Button find = new Button("Find");


        GridPane form = new GridPane();
        form.addRow(0, new Label("Select a Year:"), year);
        form.addRow(1, new Label("Gender:"), gender);
        form.addRow(2, new Label("Name:"), name);
        form.addRow(3, new Label(), find);

        Text text = new Text();

        setCenter(form);
        setBottom(text);

        find.setOnAction(event -> {
            int y = year.getValue() - 2001;
            boolean boy = gender.getValue().equals("Male");
            String query = name.getText();

            TreeMap<String, Integer>[] selectedGender = boy ? males : females;
            TreeMap<String, Integer> selectedYear = selectedGender[y];

            try {
                int position = selectedYear.get(query);
                text.setText((boy ? "Boy" : "Girl") + " name " + query + " is ranked #" + position + " in year " + (y + 2001));
            } catch (NullPointerException e) {
                text.setText("Name not found with given parameters");
            }

        });

    }

    private void getNames() {
        males = new TreeMap[10];
        females = new TreeMap[10];


        File[] files = new File[10];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File("src/res/txt/babynamesranking20" + String.format("%02d", i + 1) + ".txt");
        }
        int year = 0;
        for (File file : files) {
            try (Scanner scan = new Scanner(file).useDelimiter("[\n\t]")) {

                males[year] = new TreeMap<String, Integer>();
                females[year] = new TreeMap<String, Integer>();
                while (scan.hasNextLine()) {
                    int place = Integer.parseInt(scan.next().trim());
                    males[year].put(scan.next().trim(), place);
                    scan.next();
                    females[year].put(scan.next().trim(), place);
                    scan.next();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            year++;
        }
    }
}
