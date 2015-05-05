package heap;

public class Heap {
    private DataItem[] items;
    private int maxSize;
    private int size;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        items = new DataItem[maxSize];
    }

    private void trickleUp(int index) {
        DataItem bottom = items[index];
        int current = index;
        int parent = (index - 1) / 2;

        while (current > 0 && items[parent].compareTo(bottom) < 0) {
            items[current] = items[parent]; // shift down
            current = parent;
            parent = (current - 1) / 2;
        }

        items[current] = bottom;
    }

    private void trickleDown(int index) {
        DataItem top = items[index];
        int current = index;
        int larger, left, right;

        while (current < size / 2) { // while node has at least one child
            left = 2 * current + 1;
            right = left + 1;

            if (right < size && items[left].compareTo(items[right]) < 0)
                larger = right;
            else
                larger = left;

            // moving node is already larger
            if (top.compareTo(items[larger]) >= 0) break;

            // shift up
            items[current] = items[larger];
            current = larger;
        }

        items[current] = top;
    }

    public boolean insert(DataItem elem) {
        if (size == maxSize) return false;

        // insert in the end
        items[size] = elem;
        trickleUp(size++);

        return true;
    }

    public DataItem remove() {
        DataItem top = items[0];

        // move last node to the root
        items[0] = items[--size];
        trickleDown(0);

        return top;
    }

    public boolean update(int index, DataItem value) {
        if (index < 0 || index > size) return false;

        DataItem tmp = items[index];
        items[index] = value;
        if (tmp.compareTo(value) < 0)
            trickleUp(index);
        else
            trickleDown(index);

        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++)
            if (items[i] != null)   System.out.printf("%s ", items[i]);
            else                    System.out.printf("-- ");

        System.out.println();

        int blanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "................................";

        System.out.println(dots + dots);

        while (size > 0) {
            // preceding blanks
            if (column == 0)
                for (int k = 0; k < blanks; k++) System.out.print(' ');

            // display item
            System.out.print(items[j]);

            if (++j == size) break; // done

            // end of row?
            if (++column == itemsPerRow) {
                blanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < blanks * 2 - 2; k++) System.out.print(' ');
        }

        System.out.println("\n" + dots + dots);
    }
}
