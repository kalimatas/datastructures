package stackqueue;

public class StackApp {
    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>(5);

        stack.push(13);
        stack.push(20);

        System.out.println("top element: " + stack.peek());
    }
}
