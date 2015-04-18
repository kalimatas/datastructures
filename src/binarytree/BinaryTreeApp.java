package binarytree;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree<Integer, Character> tree = getTree();

        // Ascending order
        tree.traverseInorder();
        System.out.println();

        tree.traversePreorder();
        System.out.println();

        BinaryTree.Node<Integer, Character> node = tree.find(33);
        if (node != null)
            System.out.printf("%d found!\n", 33);
        else
            System.out.printf("%d not found!\n", 33);

        BinaryTree.Node<Integer, Character> min = tree.minimum();
        System.out.printf("min: %d - %s\n", min.key, min.value);

        BinaryTree.Node<Integer, Character> max = tree.maximum();
        System.out.printf("max: %d - %s\n", max.key, max.value);

        tree = getTree();
        System.out.printf("Delete %d:%c\n", 2, 'D');
        tree.delete(2);
        tree.traversePreorder();
        System.out.println();

        tree = getTree();
        System.out.printf("Delete %d:%c\n", 20, 'B');
        tree.delete(20);
        tree.traversePreorder();
        System.out.println();

        BinaryTree<Integer, Character> delRootTree = new BinaryTree<Integer, Character>();
        delRootTree.insert(10, 'A');
        delRootTree.insert(20, 'B');
        delRootTree.insert(15, 'C');
        delRootTree.insert(25, 'D');
        delRootTree.traversePreorder();
        System.out.println();
        delRootTree.delete(10);
        delRootTree.traversePreorder();
        System.out.println();

        BinaryTree<Integer, Character> delWithSuccessorTree = new BinaryTree<Integer, Character>();
        delWithSuccessorTree.insert(10, 'A');
        delWithSuccessorTree.insert(8, 'Z');
        delWithSuccessorTree.insert(20, 'B');
        delWithSuccessorTree.insert(15, 'C');
        delWithSuccessorTree.insert(25, 'D');
        delWithSuccessorTree.insert(18, 'E');
        delWithSuccessorTree.insert(19, 'H');
        delWithSuccessorTree.traversePreorder();
        System.out.println();
        delWithSuccessorTree.delete(10);
        delWithSuccessorTree.traversePreorder();
        System.out.println();
    }

    private static BinaryTree<Integer, Character>  getTree() {
        BinaryTree<Integer, Character> tree = new BinaryTree<Integer, Character>();

        tree.insert(10, 'A');
        tree.insert(20, 'B');
        tree.insert(8, 'C');
        tree.insert(2, 'D');
        tree.insert(42, 'E');
        tree.insert(9, 'F');

        return tree;
    }
}
