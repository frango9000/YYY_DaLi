package auxp.ch14;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lib.Data.ArrayManip;
import lib.Geometry.Point;
import lib.Misc.Randomizer;
import lib.MyFX.ToolFX;

import java.util.Arrays;

public class MyHangman extends Pane {
    String[] words = {"inheritance", "recursion", "polymorphism"};
    String gameWord;
    char[] hiddenLetters;
    boolean[] pressedLetters;

    Circle head;
    Line body, lArm, rArm, lLeg, rLeg;
    Group hangman = new Group();

    Text word = new Text();
    Text notification = new Text();
    final int TRIES = 7;
    int trie = 0;

    boolean gameOver = false;


    public MyHangman() {

        paint();
        resetGame();

        setOnKeyTyped(event -> {
            if(!gameOver) {
                notification.setText("");
                char pressed = Character.toLowerCase(event.getCharacter().charAt(0));
                if (ArrayManip.contains(hiddenLetters, pressed) || pressedLetters[pressed - 'a']) {
                    notification.setText("letter already pressed");

                } else if (ArrayManip.contains(gameWord.toCharArray(), pressed)) {
                    int[] positions = ArrayManip.linearSearchAll(gameWord.toCharArray(), pressed);
                    for (int i = 0; i < positions.length; i++) {
                        hiddenLetters[positions[i]] = pressed;
                        pressedLetters[pressed - 'a'] = true;
                        word.setText(String.valueOf(hiddenLetters));
                    }
                } else {
                    pressedLetters[pressed - 'a'] = true;
                    switch (++trie) {
                        case 1:
                            head.setVisible(true);
                            break;
                        case 2:
                            body.setVisible(true);
                            break;
                        case 3:
                            lArm.setVisible(true);
                            break;
                        case 4:
                            rArm.setVisible(true);
                            break;
                        case 5:
                            lLeg.setVisible(true);
                            break;
                        case 6:
                            rLeg.setVisible(true);
                            break;
                        case TRIES:
                            notification.setText("Game Over");
                            gameOver = true;
                            break;

                    }

                }
            }
        });
        setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER)
                resetGame();
        });
    }

    public void paint() {
        Point node1, node2, node3;
        node1 = new Point(100, 33);
        node2 = new Point(100, 400);
        node3 = new Point(300, 33);

        Point hang1, hang2;
        hang1 = new Point(300, 100);
        hang2 = new Point(300, 250);

        Line frame1, frame2, frame3;
        frame1 = new Line(node1.x, node1.y, node2.x, node2.y);
        frame2 = new Line(node1.x, node1.y, node3.x, node3.y);
        frame3 = new Line(node3.x, node3.y, hang1.x, hang1.y);
        Arc arc = new Arc(node2.x, node2.y + 1, 75, 50, 0, 180);

        head = new Circle(hang1.x, hang1.y, 30);
        body = new Line(hang1.x, hang1.y, hang2.x, hang2.y);
        lArm = new Line(hang1.x, hang1.y, hang1.x - 75, hang1.y + 75);
        rArm = new Line(hang1.x, hang1.y, hang1.x + 75, hang1.y + 75);
        lLeg = new Line(hang2.x, hang2.y, hang2.x - 50, hang2.y + 50);
        rLeg = new Line(hang2.x, hang2.y, hang2.x + 50, hang2.y + 50);
        hangman.getChildren().addAll(head, body, lArm, lLeg, rArm, rLeg);

        word.setX(hang1.x-100);
        word.setY(hang2.y+100);
        notification.setX(word.getX());
        notification.setY(word.getY()+20);
        ToolFX.setFillStroke(Color.WHITE, Color.BLACK, arc, head);
        getChildren().addAll(frame1, frame2, frame3, arc, body, lArm, lLeg, rArm, rLeg,head,word,notification);

    }

    public void resetGame(){
        gameOver=false;
        head.setVisible(false);
        body.setVisible(false);
        lArm.setVisible(false);
        lLeg.setVisible(false);
        rArm.setVisible(false);
        rLeg.setVisible(false);
        notification.setText("");

        pressedLetters = new boolean['z'+1-'a'];
        gameWord = words[Randomizer.randomInt(3)];
        hiddenLetters = new char[gameWord.length()];
        Arrays.fill(hiddenLetters, '_');
        word.setText(String.valueOf(hiddenLetters));
        gameWord = words[Randomizer.randomInt(3)];

        trie = 0;

    }

}
