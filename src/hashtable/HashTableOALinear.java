package hashtable;

public class HashTableOALinear {
    private static final int DELETED_KEY = -1;

    private int size;
    private DataItem[] items;
    private DataItem deleted = new DataItem(DELETED_KEY);

    public HashTableOALinear(int size) {
        this.size = size;
        items = new DataItem[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(DataItem item) {
        int hash = hash(item.getKey());
        DataItem current = items[hash];

        while (current != null && current.getKey() != DELETED_KEY) {
            ++hash;
            hash %= size;
            current = items[hash];
        }

        items[hash] = item;
    }

    public DataItem find(int key) {
        int hash = hash(key);
        DataItem current = items[hash];

        while (current != null) {
            if (current.getKey() == key) return current;
            ++hash;
            hash %= size;
            current = items[hash];
        }

        return null;
    }

    public DataItem delete(int key) {
        int hash = hash(key);
        DataItem current = items[hash];

        while (current != null) {
            if (current.getKey() == key) {
                items[hash] = deleted;
                return current;
            }
            ++hash;
            hash %= size;
            current = items[hash];
        }

        return null;
    }
}
