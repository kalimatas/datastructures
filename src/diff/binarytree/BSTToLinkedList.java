package diff.binarytree;

public class BSTToLinkedList {
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

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(10);
        bst.left = new TreeNode(5);
        bst.left.left = new TreeNode(3);
        bst.left.right = new TreeNode(7);

        bst.right = new TreeNode(18);
        bst.right.left = new TreeNode(13);
    }

    static Node BSTToList(TreeNode root) {
        return null;
    }
}
