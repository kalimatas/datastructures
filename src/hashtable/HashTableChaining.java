package hashtable;

import linkedlist.SortedList;

public class HashTableChaining {
    private int size;
    private SortedList<DataItem>[] items;

    public HashTableChaining(int size) {
        this.size = size;
        items = new SortedList[size];
        for (int i = 0; i < size; i++) {
            items[i] = new SortedList<DataItem>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (!items[i].isEmpty())
                items[i].display();
            else
                System.out.println("- - -");
        }
    }

    public void insert(DataItem item) {
        int hash = hash(item.getKey());
        items[hash].insert(item);
    }

    public DataItem find(int key) {
        int hash = hash(key);
        return items[hash].find(new DataItem(key));
    }

    public void delete(int key) {
        int hash = hash(key);
        items[hash].delete(new DataItem(key));
    }
}
