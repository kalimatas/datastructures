package redblacktree;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left, right;
        boolean color;

        Node(K k, V v, boolean c) {
            key = k;
            value = v;
            color = c;
        }
    }

    private Node root;

    private boolean isRed(Node node) {
        return node != null && node.color;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)        node.left   = put(node.left, key, value);
        else if (cmp > 0)   node.right  = put(node.right, key, value);
        else                node.value  = value;

        // Red-red conflict with left outside grandchild
        if (isRed(node.left) && isRed(node.left.left)) {
            node.color = RED;           // node could not be RED already
            node.left.color = BLACK;
            node = rotateRight(node);   // return parent (subtree root)
        }

        // ... left-right inside grandchild
        if (isRed(node.left) && isRed(node.left.right)) {
            node.color = RED;
            node.left.right.color = BLACK;      // it was RED
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }

        // ... right outside grandchild
        if (isRed(node.right) && isRed(node.right.right)) {
            node.color = RED;
            node.right.color = BLACK;
            node = rotateLeft(node);
        }

        // ... right-left inside grandchild
        if (isRed(node.right) && isRed(node.right.left)) {
            node.color = RED;
            node.right.left.color = BLACK;
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }

        flipColors(node);
        return node;
    }

    private void flipColors(Node parent) {
        if (!isRed(parent) && isRed(parent.left) && isRed(parent.right)) {
            parent.color = !parent.color;
            parent.left.color = !parent.left.color;
            parent.right.color = !parent.right.color;
        }
    }

    private Node rotateLeft(Node grand) {
        Node parent = grand.right;
        Node parentLeft = parent.left;
        parent.left = grand;
        grand.right = parentLeft;

        return parent;
    }

    private Node rotateRight(Node grand) {
        Node parent = grand.left;
        Node parentRight = parent.right;
        parent.right = grand;
        grand.left = parentRight;

        return parent;
    }
}
