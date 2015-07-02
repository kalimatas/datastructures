package stackqueue;

public class QueueArray<E> {
    Object[] items;
    int front;
    int rear;
    int maxSize;
    int size;

    public QueueArray(int maxSize) {
        items = new Object[maxSize];
        this.maxSize = maxSize;
        front = 0;
        rear = -1;
        size = 0;
    }

    public void insert(E e) {
        if (isFull())
            throw new IllegalStateException("Queue is full");

        if (rear == maxSize - 1)
            rear = -1;

        items[++rear] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        Object e = items[front++];
        if (front == maxSize)
            front = 0;
        size--;

        return (E) e;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return (E) items[front];
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
