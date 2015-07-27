package diff;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        QueueWithStack queue = new QueueWithStack();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);

        System.out.printf("%d \n", queue.deQueue());
        System.out.printf("%d \n", queue.deQueue());
    }

    // enQueue is costly
    // requires two moves of all elements: from s1 to s2 and back

    // deQueue is costly
    private static class QueueWithStack {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        void enQueue(int e) {
            stack1.push(e);
        }

        int deQueue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.err.printf("Q is empty");
                System.exit(1);
            }

            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());

            return stack2.pop();
        }
    }
}
