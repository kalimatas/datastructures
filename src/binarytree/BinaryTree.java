package binarytree;

public class BinaryTree<K extends Comparable<K>, V> {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> leftChild;
        Node<K, V> rightChild;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> root = null;

    public Node<K, V> find(K key) {
        if (root == null)
            return null;

        Node<K, V> current = root;

        while (true) {
            int cmp = key.compareTo(current.key);

            if (cmp == 0)
                return current;
            else if (cmp < 0)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }
    }

    public void insert(K key, V value) {
        Node<K, V> newNode = new Node<K, V>(key, value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<K, V> current = root;
        Node<K, V> previous;

        while (true) {
            previous = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.leftChild;
                if (current == null) {
                    previous.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    previous.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public void traverseInorder() {
        inOrder(root);
    }

    public void traversePreorder() {
        preOrder(root);
    }

    public void traversePostorder() {
        postOrder(root);
    }

    private void inOrder(Node<K, V> node) {
        if (node == null)
            return;

        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }

    private void preOrder(Node<K, V> node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    private void postOrder(Node<K, V> node) {
        if (node == null)
            return;

        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public Node<K, V> minimum() {
        Node<K, V> current = root;
        while (true) {
            if (current.leftChild == null)
                return current;

            current = current.leftChild;
        }
    }

    public Node<K, V> maximum() {
        Node<K, V> current = root;
        while (true) {
            if (current.rightChild == null)
                return current;

            current = current.rightChild;
        }
    }
}
