package diff.binarytree;

public class IsBST {
    private static Node prev = null;

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) { this.data = data; }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        prev = null;
        System.out.printf("%s%n", isBST(root));

        Node bst = new Node(10);
        bst.left = new Node(5);
        bst.left.left = new Node(3);
        bst.left.right = new Node(7);

        bst.right = new Node(18);
        bst.right.left = new Node(13);

        prev = null;
        System.out.printf("%s%n", isBST(bst));
    }

    // Inorder traversal should be in ascending order
    static boolean isBST(Node node) {
        if (node != null) {
            // chech left subtree
            if (!isBST(node.left)) return false;

            // check the node
            if (prev != null && node.data <= prev.data) return false;

            prev = node;

            // check right subtree
            return isBST(node.right);
        }

        return true;
    }
}
