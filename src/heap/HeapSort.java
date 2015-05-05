package heap;

public class HeapSort extends Heap {
    public HeapSort(int maxSize) {
        super(maxSize);
    }

    public void insertAt(int index, DataItem elem) {
        items[index] = elem;
    }

    public void incrementSize() {
        size++;
    }

    public void displayArray() {
        for (int i = 0; i < maxSize; i++)
            System.out.printf("%s ", items[i]);

        System.out.println();
    }
}
