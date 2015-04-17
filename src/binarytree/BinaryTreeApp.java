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

        // Ascending order
        tree.traverseInorder();
        System.out.println();

        BinaryTree.Node<Integer, Character> node = tree.find(33);
        if (node != null)
            System.out.printf("%d found!\n", 33);
        else
            System.out.printf("%d not found!\n", 33);


    }
}
