package diff.linkedlist;

public class LinkedListToBST {
    private static class Node {
        int item;
        Node next;

        Node(int e) { item = e; }
    }

    static Node push(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        return node;
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) { this.data = data; }
    }

    // For recursive call
    private static Node head = null;

    public static void main(String[] args) {
        head = new Node(5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        int n = countNodes();
        TreeNode root = simple(n);

        inorder(root);
    }

    static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }

    static int countNodes() {
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    static TreeNode simple(int n) {
        if (n <= 0) return null;

        // Construct the left subtree
        TreeNode left = simple(n / 2);

        TreeNode root = new TreeNode(head.item);
        root.left = left;

        // Next element in the list
        head = head.next;

        // Construct the right subtree
        root.right = simple(n - n/2 - 1);

        return root;
    }
}
