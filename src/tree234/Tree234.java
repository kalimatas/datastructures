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

    private Node root = new Node();

    public void display() {
        recDispaly(root, 0, 0);
    }

    private void recDispaly(Node node, int level, int childNumber) {
        System.out.println("level " + level + ", childNumber " + childNumber);
        node.display();

        for (int i = 0; i < node.getSize() + 1; i++) {
            Node n = node.getChild(i);
            if (n != null)
                recDispaly(n, level + 1, i);
            else
                break;
        }
    }

    public int find(T key) {
        Node current = root;
        int num;

        while (true) {
            if ((num = current.searchItem(key)) != -1)
                return num;
            else if (current.isLeaf())
                return -1;
            else
                current = getNextChild(current, key);
        }
    }

    public void insert(T value) {
        Node current = root;

        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();

                current = getNextChild(current, value);
            } else if (current.isLeaf())
                break;
            else
                current = getNextChild(current, value);
        }

        current.insertItem(value);
    }

    private void split(Node node) {
        T B, C;
        Node parent, child2, child3;

        C = node.removeItem();
        B = node.removeItem();
        child2 = node.disconnectChild(2);
        child3 = node.disconnectChild(3);

        Node newRight = new Node();

        if (node == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, node);
        } else {
            parent = node.getParent();
        }

        // deal with parent
        int index = parent.insertItem(B);
        int n = parent.getSize();

        // move parent's connections one child to the right
        for (int j = n - 1; j > index; j--) {
            Node tmp = parent.disconnectChild(j);
            parent.connectChild(j + 1, tmp);
        }

        // connect right child to parent
        parent.connectChild(index + 1, newRight);

        // deal with new right
        newRight.insertItem(C);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    private Node getNextChild(Node node, T value) {
        int i;
        for (i = 0; i < node.getSize(); i++)
            if (node.getItem(i).compareTo(value) > 0)
                return node.getChild(i);

        return node.getChild(i);
    }
}
