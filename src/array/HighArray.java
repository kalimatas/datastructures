package array;

public class HighArray {
    private int[] items;
    private int size = 0;

    public HighArray(int size) {
        items = new int[size];
    }

    public void insert(int newItem) {
        items[size++] = newItem;
    }

    public int find(int searchKey) {
        for (int i = 0; i < size; i++) {
            if (items[i] == searchKey) {
                return i;
            }
        }

        return -1;
    }

    public boolean delete(int searchKey) {
        int pos = find(searchKey);
        if (pos != -1) {
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
