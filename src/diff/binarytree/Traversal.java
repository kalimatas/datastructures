package diff.binarytree;

import java.util.LinkedList;

public class Traversal {
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) { this.data = data; }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(14);
        root.left.right = new Node(28);

        root.right = new Node(8);
        root.right.right = new Node(64);
        root.right.right.left = new Node(11);

        Node bst = new Node(10);
        bst.left = new Node(5);
        bst.left.left = new Node(3);
        bst.left.right = new Node(7);

        bst.right = new Node(18);
        bst.right.left = new Node(13);

        // ascending
        System.out.printf("Inorder: ");
        inorder(bst);

        // descending
        System.out.printf("%nReverse Inorder: ");
        reverseInorder(bst);

        System.out.printf("%nPreorder: ");
        preorder(root);

        System.out.printf("%nPostorder: ");
        postorder(root);

        System.out.printf("%nLevel: ");
        level(root);
    }

    static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }

    static void reverseInorder(Node node) {
        if (node == null) return;

        reverseInorder(node.right);
        System.out.printf("%d ", node.data);
        reverseInorder(node.left);
    }

    // to copy the tree
    // to get prefix notation
    static void preorder(Node node) {
        if (node == null) return;

        System.out.printf("%d ", node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // to delete the tree
    // to get the postfix
    static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.printf("%d ", node.data);
    }

    // Use BFS
    static void level(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            System.out.printf("%d ", current.data);

            if (current.left != null) queue.addLast(current.left);
            if (current.right != null) queue.addLast(current.right);
        }
    }
}
