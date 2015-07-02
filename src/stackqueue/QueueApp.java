package stackqueue;

public class QueueApp {
    public static void main(String[] args) {
        QueueArray<Integer> queue = new QueueArray<>(5);

        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);

        System.out.println("size: " + queue.size());

        System.out.println("deleted: " + queue.remove());
        System.out.println("deleted: " + queue.remove());
        System.out.println("deleted: " + queue.remove());

        queue.insert(45);
        queue.insert(55);
        queue.insert(65);

        System.out.println("size: " + queue.size());
        System.out.println("peek: " + queue.peek());
    }
}
