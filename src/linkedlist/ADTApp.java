package linkedlist;

public class ADTApp {
    public static void main(String[] args) throws Exception {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("pop: " + stack.pop());

        QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);

        System.out.println("first in a queue: " + queue.remove());
    }
}
