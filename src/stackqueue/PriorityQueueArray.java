package stackqueue;

public class PriorityQueueArray {
    protected Comparable[] items;
    protected int maxSize;
    protected int size;

    public PriorityQueueArray(int maxSize) {
        this.maxSize = maxSize;
        items = new Comparable[maxSize];
        size = 0;
    }

    public void insert(Comparable elem) {
        if (isFull())
            throw new IllegalStateException("Queue is full");

        if (size == 0) {
            items[size++] = elem;
        } else {
            // Find a place to insert. Lower elements are at higher indexes.
            int i;
            for (i = size - 1; i >= 0; i--) {
                //noinspection unchecked
                if (elem.compareTo(items[i]) > 0) {
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

    public Comparable remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return items[--size];
    }

    public Comparable peekMin() {
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
