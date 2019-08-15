package auxp.ch11;

import java.util.Arrays;

public class QueueOfIntegers {

    public static final int DEFAULT_CAPACITY = 8;
    private int[] elements;
    private int size;

    /**
     * Construct a stack with the default capacity 16
     */
    public QueueOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct a stack with the specified maximum capacity
     */
    public QueueOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public QueueOfIntegers(int[] elements) {
        this.elements = elements;
        size = elements.length;
    }

    /**
     * Push a new integer to the top of the stack
     */
    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }

    /**
     * Return and remove the top element from the stack
     */
    public int pop() {
        int pop = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return pop;
    }

    /**
     * Return the top element from the stack
     */
    public int peek() {
        return elements[0];
    }

    /**
     * Test whether the stack is empty
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Return the number of elements in the stack
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "StackOfIntegers{" + "elements=" + Arrays.toString(elements) + '}';
    }
}
