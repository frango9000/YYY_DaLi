package auxp.ch19;

public class MyTriplet<E> extends MyPair<E> {

    E third;

    public MyTriplet(E first, E second, E third) {
        super(first, second);
        this.third = third;
    }

    public E getThird() {
        return third;
    }

    public void setThird(E third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "MyTriplet{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
