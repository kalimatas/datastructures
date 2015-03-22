package array;

public class OrderedArray {
    private int[] items;
    private int size = 0;

    public OrderedArray(int size) {
        items = new int[size];
    }

    public int size() {
        return size;
    }

    public void insert(int newItem) {
        int i;

        // find a position to insert
        for (i = 0; i < size; i++) {
            if (items[i] > newItem) break;
        }

        // shift bigger elements up
        for (int j = size; j > i; j--) {
            items[j] = items[j-1];
        }

        items[i] = newItem;
        size++;
    }

    public int find(int searchKey) {
        int currentPosition;
        int lowerBound = 0;
        int upperBound = size - 1;

        while (true) {
            currentPosition = (lowerBound + upperBound) / 2;

            if (items[currentPosition] == searchKey) {
                return currentPosition;
            } else if (lowerBound > upperBound) {
                return size;
            } else {
                // left part
                if (searchKey < items[currentPosition]) {
                    upperBound = currentPosition - 1;
                }
                // right part
                else {
                    lowerBound = currentPosition + 1;
                }
            }
        }
    }

    public boolean delete(int searchKey) {
        int pos = find(searchKey);
        if (pos != size) {
            for (int i = pos; i < size; i++) {
                items[i] = items[i+1];
            }
            size--;
            return true;
        }

        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", items[i]);
        }
        System.out.println();
    }
}
