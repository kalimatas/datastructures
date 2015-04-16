package binarytree;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree<Integer, Character> tree = new BinaryTree<Integer, Character>();

        tree.insert(10, 'A');
        tree.insert(20, 'B');
        tree.insert(8, 'C');
        tree.insert(2, 'D');
        tree.insert(42, 'E');
        tree.insert(9, 'F');

        BinaryTree.Node<Integer, Character> node = tree.find(33);
        if (node != null)
            System.out.println("Found!");
        else
            System.out.println("Not found!");
    }
}
