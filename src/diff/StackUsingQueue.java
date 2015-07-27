package diff;

import java.util.LinkedList;

public class StackUsingQueue {
    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.printf("%d \n", stack.pop());
        System.out.printf("%d \n\n", stack.pop());

        StackWithQueueV2 stackV2 = new StackWithQueueV2();
        stackV2.push(10);
        stackV2.push(20);
        stackV2.push(42);

        System.out.printf("%d \n", stackV2.pop());
        System.out.printf("%d \n\n", stackV2.pop());
    }

    // push is costly
    private static class StackWithQueue {
        private LinkedList<Integer> queue = new LinkedList<>();
        private LinkedList<Integer> tmpQueue = new LinkedList<>();

        void push(int e) {
            tmpQueue.addLast(e);
            while (!queue.isEmpty())
                tmpQueue.addLast(queue.removeFirst());

            // copy elements back
            while (!tmpQueue.isEmpty())
                queue.addLast(tmpQueue.removeFirst());
        }

        int pop() {
            return queue.removeFirst();
        }
    }

    // pop is costly
    private static class StackWithQueueV2 {
        private LinkedList<Integer> queue = new LinkedList<>();
        private LinkedList<Integer> tmpQueue = new LinkedList<>();

        void push(int e) {
            queue.addLast(e);
        }

        int pop() {
            while (queue.size() != 1)
                tmpQueue.addLast(queue.removeFirst());

            int result = queue.removeFirst();

            // copy elements back
            while (!tmpQueue.isEmpty())
                queue.addLast(tmpQueue.removeFirst());

            return result;
        }
    }
}
