package tree234;

public class Tree234App {
    public static void main(String[] args) {
        Tree234<Integer> tree = new Tree234<Integer>();

        tree.insert(26);
        tree.insert(49);
        tree.insert(72);

        tree.insert(9);
        tree.insert(13);

        tree.insert(75);
        tree.insert(50);

        tree.display();

        tree.insert(52);

        tree.display();
    }
}
