package stackqueue;

public class QueueArray<E> {
    E[] items;
    int front;
    int rear;
    int maxSize;
    int size;

    public QueueArray(int maxSize) {
        items = (E[]) new Object[maxSize];
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

    public E remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        E e = items[front++];
        if (front == maxSize)
            front = 0;
        size--;

        return e;
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return items[front];
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
