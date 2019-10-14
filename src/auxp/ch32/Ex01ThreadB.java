package auxp.ch32;

public class Ex01ThreadB extends Thread {

    int max = 100;

    public Ex01ThreadB() {
    }

    public Ex01ThreadB(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 0; i <= max; i++) {
            System.out.print(i);
        }
    }
}
