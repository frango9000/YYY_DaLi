package auxp.ch20;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import lib.Data.ListManip;

import java.util.Comparator;
import java.util.LinkedList;

public class LinkedNumbersPane extends BorderPane {
    LinkedList<Integer> numbers = new LinkedList<>();
    TextArea textArea;


    public LinkedNumbersPane() {
        TextField newNumber = new TextField();
        Button add = new Button("+");
        Button rem = new Button("-");

        HBox top = new HBox(new Label("Enter a Number: "), newNumber, add, rem);
        top.setAlignment(Pos.CENTER);

        textArea = new TextArea();

        Button sort = new Button("Sort");
        Button shuffle = new Button("Shuffle");
        Button reverse = new Button("Reverse");

        HBox bot = new HBox(sort, shuffle, reverse);
        bot.setAlignment(Pos.CENTER);

        setTop(top);
        setCenter(textArea);
        setBottom(bot);

        add.setOnAction(event -> {
            int num;
            try {
                num = Integer.parseInt(newNumber.getText());
                if (!numbers.contains(num)) {
                    numbers.add(num);
                    updateListText();
                }
            } catch (NumberFormatException ignored) {
            }
        });
        rem.setOnAction(event -> {
            int num;
            try {
                num = Integer.parseInt(newNumber.getText());
                if (numbers.contains(num)) {
                    numbers.remove((Object) num);
                    updateListText();
                }
            } catch (NumberFormatException ignored) {
            }
        });
        sort.setOnAction(event -> {
            numbers.sort(null);
            updateListText();
        });
        shuffle.setOnAction(event -> {
            ListManip.shuffle(numbers);
            updateListText();
        });
        reverse.setOnAction(event -> {
            numbers.sort(Comparator.reverseOrder());
            updateListText();
        });
    }

    private void updateListText() {
        textArea.setText(numbers.toString());
    }


}
