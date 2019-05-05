package auxp.ch19;

public class MyTriplet<E> {

    E first;
    E second;
    E third;

    public MyTriplet(E first, E second, E third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
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
