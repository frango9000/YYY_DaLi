package auxp.ch19;

public class MyPair<E> {
    E first;
    E second;

    public MyPair(E first, E second) {
        this.first = first;
        this.second = second;
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

    @Override
    public String toString() {
        return "MyPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static double min(MyPair<? extends Number> pair) {
        if (pair.first.doubleValue() < pair.second.doubleValue()) {
            return pair.first.doubleValue();
        } else return pair.second.doubleValue();
    }
}
