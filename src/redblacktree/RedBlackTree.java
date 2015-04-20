package redblacktree;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node leftChild, rightChild;
        boolean color;
    }

    private Node root;

    public V find(K key) {
        // todo
        return null;
    }

    public void insert(K key, V value) {

    }
}
