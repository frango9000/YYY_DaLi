package auxp.ch32;

public class Ex04 extends Thread {

    Integer num;

    public Ex04(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            num += 1;
            System.out.println(num);
        }
    }
}
