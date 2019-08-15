package auxp.ch11;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Object> list = new ArrayList<>();

    public MyStack() {
    }

    public MyStack(ArrayList<Object> list) {
        this.list = list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    public MyStack deepCopy() {
        ArrayList<Object> copy = new ArrayList<>(list.size());
        copy.addAll(list);
        return new MyStack(copy);
    }
}
