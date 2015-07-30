package diff.binarytree;

public class BinaryTreeToDLL {
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) { this.data = data; }
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.printf("%d ", root.data);
        inorder(root.right);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.printf("%d ", head.data);
            head = head.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right = new Node(18);
        root.right.left = new Node(13);

        inorder(root);
        System.out.println();

        Node head = toList(root);
        printList(head);
    }

    private static Node prev = null;

    static Node toList(Node root) {
        // Set the previous pointer
        prev = null;
        fixPrevPtr(root);

        // Set the next pointer and return head of DLL
        prev = null;
        return fixNextPtr(root);
    }

    private static void fixPrevPtr(Node root) {
        if (root == null) return;

        fixPrevPtr(root.left);
        root.left = prev;
        prev = root;
        fixPrevPtr(root.right);
    }

    private static Node fixNextPtr(Node root) {
        // Find the right most node in BT or last node in DLL
        while (root != null && root.right != null) root = root.right;

        // Start from the rightmost node, traverse back using left pointers.
        // While traversing, change right pointer of nodes.
        while (root != null && root.left != null) {
            prev = root;
            root = root.left;
            root.right = prev;
        }

        return root;
    }
}
