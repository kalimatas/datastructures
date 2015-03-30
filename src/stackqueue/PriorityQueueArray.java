package stackqueue;

public class PriorityQueueArray {
    long[] items;
    int maxSize;
    int size;

    public PriorityQueueArray(int maxSize) {
        this.maxSize = maxSize;
        items = new long[maxSize];
        size = 0;
    }

    public void insert(long elem) {
        if (isFull())
            throw new IllegalStateException("Queue is full");

        if (size == 0) {
            items[size++] = elem;
        } else {
            // Find a place to insert. Lower elements are at higher indexes.
            int i;
            for (i = size - 1; i >= 0; i--) {
                if (elem > items[i]) {
                    items[i + 1] = items[i];
                } else {
                    break;
                }
            }

            // Insert new element
            items[i + 1] = elem;
            size++;
        }
    }

    public long remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return items[--size];
    }

    public long peekMin() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return items[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == maxSize - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
