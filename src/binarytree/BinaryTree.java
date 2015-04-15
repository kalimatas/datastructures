package binarytree;

public class BinaryTree<K extends Comparable<K>, V> {

    private static class Node<K, V> {
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
        Node<K, V> current = root;

        if (current == null)
            return null;

        int cmp = key.compareTo(current.key);
        while (cmp != 0) {
            if (cmp < 0)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }

        return current;
    }
}
