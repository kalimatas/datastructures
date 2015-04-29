package hashtable;

public class DataItem implements Comparable<DataItem> {
    private int key;

    public DataItem(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String toString() {
        return Integer.toString(key);
    }

    @Override
    public int compareTo(DataItem o) {
        return key - o.getKey();
    }
}
