package binarytree;

public class BinaryTree<K extends Comparable<K>, V> {

    public static final int TRAVERSE_INORDER = 1;
    public static final int TRAVERSE_PREORDER = 2;
    public static final int TRAVERSE_POSTORDER = 3;

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

        int cmp;
        while ((cmp = key.compareTo(current.key)) != 0) {
            previous = current;
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

    public boolean delete(K key) {
        if (root == null)
            return false;

        Node<K, V> current = root;
        Node<K, V> previous = root;
        boolean isLeftChild = true;

        // Find a node to delete
        int cmp;
        while ((cmp = key.compareTo(current.key)) != 0) {
            previous = current;
            if (cmp < 0) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            if (current == null) {
                return false;
            }
        }

        // Has no children
        if (current.leftChild == null && current.rightChild == null) {
            // Check root
            if (current == root)
                root = null;
            else if (isLeftChild)
                previous.leftChild = null;
            else
                previous.rightChild = null;
        }
        // Has one child
        else if (current.leftChild == null || current.rightChild == null) {
            Node<K, V> toCopy;
            if (current.leftChild == null)
                toCopy = current.rightChild;
            else
                toCopy = current.leftChild;

            if (current == root)
                root = toCopy;
            else if (isLeftChild)
                previous.leftChild = toCopy;
            else
                previous.rightChild = toCopy;
        }
        // Has two children: find inorder successor and replace it
        else {
            Node<K, V> successor = getSuccessore(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                previous.leftChild = successor;
            else
                previous.rightChild = successor;

            successor.leftChild = current.leftChild;
        }

        return true;
    }

    private Node<K, V> getSuccessore(Node<K, V> toDelete) {
        Node<K, V> successor = toDelete;
        Node<K, V> successorParent = toDelete;
        Node<K, V> current = toDelete.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != toDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = toDelete.rightChild;
        }

        return successor;
    }

    public void traverse(int type) {
        switch (type) {
            case TRAVERSE_INORDER:
                inOrder(root);
                break;
            case TRAVERSE_PREORDER:
                preOrder(root);
                break;
            case TRAVERSE_POSTORDER:
                postOrder(root);
                break;
        }
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
