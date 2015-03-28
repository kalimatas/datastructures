package stackqueue;

public class StackArray<E> {
    E items[];
    int maxSize;
    int top;

    public StackArray(int size) {
        items = (E[]) new Object[size];
        maxSize = size;
        top = -1;
    }

    public void push (E elem) {
        if (isFull())
            throw new IllegalStateException("Stack if full");

        items[++top] = elem;
    }

    public E pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return items[top--];
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
