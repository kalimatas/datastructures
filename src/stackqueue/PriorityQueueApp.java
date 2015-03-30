package stackqueue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueueArray queue = new PriorityQueueArray(6);

        queue.insert(10);
        queue.insert(20);
        queue.insert(15);
        queue.insert(42);

        System.out.println("size: " + queue.size());

        System.out.println("deleted: " + queue.remove());
        System.out.println("min: " + queue.peekMin());
    }
}
