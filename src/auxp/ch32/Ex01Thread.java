package auxp.ch32;

public class Ex01Thread extends Thread {

    String name;

    public Ex01Thread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }
}
