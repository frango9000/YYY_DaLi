import auxp.ch10.MyLoan;
import auxp.ch17.AddressBook;
import auxp.ch17.splitter.FileSplitter;
import auxp.ch17.splitter.SplitterTabbedPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class DaLi_17 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("C17");


        Pane pane = ex13();


        pane.setPadding(new Insets(5));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        ex12();
        //Application.launch(args);
    }

    public static void ex00() {
    }

    public static void ex01() {//Create a text file
        File file = new File("src/auxp/ch17/Exercise17_01.txt");
        try (PrintWriter filewriter = new PrintWriter(new FileWriter(file,true))) {
            for (int i = 0; i < 50; i++) {
                filewriter.print((int) (Math.random() * 100) + " ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static void ex02() {//Create a binary data file
        File file = new File("src/auxp/ch17/Exercise17_02.dat");
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < 50; i++) {
                out.writeDouble(((int)(Math.random()*10000))/100);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ex03() {//Sum all the floating points in a binary data file
        File file = new File("src/auxp/ch17/Exercise17_02.dat");
        try(DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            double sum = 0;
            while(in.available() != 0){
                sum += in.readDouble();
            }
            System.out.println("Sum is : " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ex04() {//Convert a text file into UTF
        File textfile = new File("src/auxp/ch12/e24data.txt");
        File binfile = new File("src/auxp/ch17/Exercise17_04.dat");
        try(
                Scanner in = new Scanner(textfile);
                DataOutputStream out = new DataOutputStream(new FileOutputStream(binfile))
        ){
            while(in.hasNextLine()){
                out.writeUTF(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Text size = " + textfile.length());
        System.out.println("Bin copy size = " + binfile.length());
    }
    public static void ex05() {//Store objects and arrays in a file
        int[] nums = {1,2,3,4,5,6};
        Date date = new Date(System.currentTimeMillis());
        double dbl = 10.5;
        File file = new File("src/auxp/ch17/Exercise17_05.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(nums);
            out.writeObject(date);
            out.writeDouble(dbl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ex06() {//Store Loan objects
        File file = new File("src/auxp/ch17/Exercise17_06.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < 5; i++) {
                out.writeObject(new MyLoan(5,i+1,10000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ex07() {//Restore objects from a file
        File file = new File("src/auxp/ch17/Exercise17_06.dat");
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            MyLoan loan;
            while( (loan = (MyLoan)in.readObject()) != null){
                System.out.println(loan.getTotalPayment());
            }
        } catch(EOFException ex){
            System.out.println("EOF");
        } catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }
    public static void ex08() {//Update count
        File file = new File("src/auxp/ch17/Exercise17_08.dat");
        int count = 0;
        try(DataInputStream in = new DataInputStream( new FileInputStream(file))){
            count = in.readInt();
            System.out.println(count);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        try( DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            out.writeInt(++count);
            System.out.println("Runned " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Pane ex09() {//Address book
        return new AddressBook();
    }
    public static void ex10() {//Split files
        FileSplitter.splitByPieces(new File("src/auxp/ch17/Exercise17_08.dat"),2);
    }
    public static Pane ex11() {//Split files GUI
        return  new Pane(new SplitterTabbedPane());
    }
    public static void ex12() {//Combine files
        FileSplitter.join((new File("src/auxp/ch17/Exercise17_08.dat.0")));
    }
    public static Pane ex13() {//Combine files GUI
        return  new Pane(new SplitterTabbedPane());
    }
    public static void ex14() {//Encrypt files
    }
    public static void ex15() {//Decrypt files
    }
    public static void ex16() {//Frequency of characters
    }
    public static void ex17() {//BitOutputStream
    }
    public static void ex18() {//View bits
    }
    public static void ex19() {//View hex
    }
    public static void ex20() {//Binary editor
    }
    public static void ex21() {//Hex editor
    }
}