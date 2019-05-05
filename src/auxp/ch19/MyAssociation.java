package auxp.ch19;

public class MyAssociation<E,F> {

    E first;
    F second;

    public MyAssociation(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public F getSecond() {
        return second;
    }

    public void setSecond(F second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "MyAssociation{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static double sum(MyAssociation<? extends Number, ? extends Number> asoc){
        return asoc.first.doubleValue() + asoc.second.doubleValue();
    }
}
