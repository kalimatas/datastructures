package stackqueue;

public class StackArray<E> {
    Object items[];
    int maxSize;
    int top;

    public StackArray(int size) {
        items = new Object[size];
        maxSize = size;
        top = -1;
    }

    public void push (E elem) {
        if (isFull())
            throw new IllegalStateException("Stack if full");

        items[++top] = elem;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return (E) items[top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return (E) items[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
