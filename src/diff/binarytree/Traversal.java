package diff.binarytree;

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

        System.out.printf("Inorder: ");
        inorder(root);

        System.out.printf("%nPreorder: ");
        preorder(root);

        System.out.printf("%nPostorder: ");
        postorder(root);
    }

    static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
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
}
