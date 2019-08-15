package auxp.ch19;

import java.util.Arrays;

public class GenericStackArray<E> {

    private Object[] content;

    public GenericStackArray() {
        this.content = new Object[4];
    }

    public GenericStackArray(int size) {
        this.content = new Object[size];
    }

    public int getSize() {
        int size = 0;
        for (Object o : content) {
            if (o != null) {
                size++;
            } else {
                return size;
            }
        }
        return content.length;
    }

    public E peek() {
        return (E) content[getSize() - 1];
    }

    public void push(E e) {
        if (content.length == getSize()) {
            expandList();
        }
        content[getSize()] = e;
    }

    public E pop() {
        E o = (E) content[getSize() - 1];
        content[getSize() - 1] = null;
        return o;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private void expandList() {
        Object[] newContent = new Object[content.length * 2];
        System.arraycopy(content, 0, newContent, 0, content.length);
        content = newContent;
    }

    @Override
    public String toString() {
        return "GenericStackArray{" + "content=" + Arrays.toString(content) + '}';
    }
}
