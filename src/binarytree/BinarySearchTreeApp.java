package binarytree;

public class BinarySearchTreeApp {
    public static void main(String[] args) {
        var tree = getTree();

        // Ascending order
        tree.traverse(BinarySearchTree.TRAVERSE_INORDER);
        System.out.println();

        tree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();

        var node = tree.find(33);
        if (node != null)
            System.out.printf("%d found!\n", 33);
        else
            System.out.printf("%d not found!\n", 33);

        var min = tree.minimum();
        System.out.printf("min: %d - %s\n", min.key, min.value);

        var max = tree.maximum();
        System.out.printf("max: %d - %s\n", max.key, max.value);

        tree = getTree();
        System.out.printf("Delete %d:%c\n", 2, 'D');
        tree.delete(2);
        tree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();

        tree = getTree();
        System.out.printf("Delete %d:%c\n", 20, 'B');
        tree.delete(20);
        tree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();

        var delRootTree = new BinarySearchTree<Integer, Character>();
        delRootTree.insert(10, 'A');
        delRootTree.insert(20, 'B');
        delRootTree.insert(15, 'C');
        delRootTree.insert(25, 'D');
        delRootTree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();
        delRootTree.delete(10);
        delRootTree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();

        var delWithSuccessorTree = new BinarySearchTree<Integer, Character>();
        delWithSuccessorTree.insert(10, 'A');
        delWithSuccessorTree.insert(8, 'Z');
        delWithSuccessorTree.insert(20, 'B');
        delWithSuccessorTree.insert(15, 'C');
        delWithSuccessorTree.insert(25, 'D');
        delWithSuccessorTree.insert(18, 'E');
        delWithSuccessorTree.insert(19, 'H');
        delWithSuccessorTree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();
        delWithSuccessorTree.delete(10);
        delWithSuccessorTree.traverse(BinarySearchTree.TRAVERSE_PREORDER);
        System.out.println();
    }

    private static BinarySearchTree<Integer, Character> getTree() {
        var tree = new BinarySearchTree<Integer, Character>();

        tree.insert(10, 'A');
        tree.insert(20, 'B');
        tree.insert(8, 'C');
        tree.insert(2, 'D');
        tree.insert(42, 'E');
        tree.insert(9, 'F');

        return tree;
    }
}
