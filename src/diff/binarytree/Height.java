package diff.binarytree;

public class Height {
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

        System.out.printf("%d%n", height(root));
    }

    static int height(Node root) {
        return heightRec(root, 0);
    }

    private static int heightRec(Node node, int height) {
        if (node == null) return height;

        int heightLeft = heightRec(node.left, height+1);
        int heightRight = heightRec(node.right, height+1);

        return Math.max(heightLeft, heightRight);
    }
}
