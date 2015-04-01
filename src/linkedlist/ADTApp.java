package linkedlist;

public class ADTApp {
    public static void main(String[] args) throws Exception {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("pop: " + stack.pop());
    }
}
