package tree234;

public class Tree234<T extends Comparable<? super T>> {

    private static final int ORDER = 4; // possible number of children

    private class Node {
        private Tree234.Node parent;
        private Tree234.Node children[] = new Tree234.Node[ORDER];
        @SuppressWarnings("unchecked")
        private T items[] = (T[]) new Comparable[ORDER-1]; // ordered array
        private int size;

        private Tree234.Node getParent() { return parent; }

        private int getSize() { return size; }

        private boolean isFull() { return size == ORDER - 1; }

        private boolean isLeaf() { return children[0] == null; }

        private void connectChild(int i, Tree234.Node child) {
            if (child != null) child.parent = this;
            children[i] = child;
        }

        private Tree234.Node disconnectChild(int i) {
            Tree234.Node tmp = children[i];
            children[i] = null;
            return tmp;
        }

        private Tree234.Node getChild(int i) {
            return children[i];
        }

        private T getItem(int i) {
            return items[i];
        }

        private int insertItem(T value) {
            size++;

            for (int i = ORDER - 2; i >= 0; i--) {
                if (items[i] == null) continue;

                if (items[i].compareTo(value) > 0)
                    items[i + 1] = items[i];
                else {
                    items[i + 1] = value;
                    return i + 1;
                }
            }

            items[0] = value;
            return 0;
        }

        // Get the largest item
        private T removeItem() {
            T tmp = items[size - 1];
            items[size - 1] = null;
            size--;
            return tmp;
        }

        private int searchItem(T key) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null)
                    break;
                else if (items[i].compareTo(key) == 0)
                    return i;
            }

            return -1;
        }

        private void display() {
            for (int i = 0; i < size; i++) {
                System.out.printf("/%s", getItem(i));
            }
            System.out.println();
        }
    }
}
