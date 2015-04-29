package hashtable;

public class HashTableOADoubleHashing {
    private static final int DELETED_KEY = -1;

    private int size;
    private DataItem[] items;
    private DataItem deleted = new DataItem(DELETED_KEY);

    public HashTableOADoubleHashing(int size) {
        this.size = size;
        items = new DataItem[size];
    }

    private int hash(int key) {
        return key % size;
    }

    private int hashSecond(int key) {
        // prime, less than array size
        return 5 - (key % 5);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (items[i] != null)
                System.out.printf("%d ", items[i].getKey());
            else
                System.out.print("_ ");
        }
        System.out.println();
    }

    public void insert(DataItem item) {
        int hash = hash(item.getKey());
        int step = hashSecond(item.getKey());
        DataItem current = items[hash];

        while (current != null && current.getKey() != DELETED_KEY) {
            hash += step;
            hash %= size;
            current = items[hash];
        }

        items[hash] = item;
    }

    public DataItem find(int key) {
        int hash = hash(key);
        int step = hashSecond(key);
        DataItem current = items[hash];

        while (current != null) {
            if (current.getKey() == key) return current;
            hash += step;
            hash %= size;
            current = items[hash];
        }

        return null;
    }

    public DataItem delete(int key) {
        int hash = hash(key);
        int step = hashSecond(key);
        DataItem current = items[hash];

        while (current != null) {
            if (current.getKey() == key) {
                items[hash] = deleted;
                return current;
            }
            hash += step;
            hash %= size;
            current = items[hash];
        }

        return null;
    }
}
