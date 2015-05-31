package diff;

import java.util.Stack;

public class StoneWallApp {
    public static void main(String[] args) {
        System.out.println("block: " + stonewall(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

    private static int stonewall(int[] wall) {
        Stack<Integer> stack = new Stack<>();
        int count = 1;

        stack.push(wall[0]);

        for (int i = 1; i < wall.length; i++) {
            if (stack.isEmpty() || wall[i] > stack.peek()) {
                stack.push(wall[i]);
                count++;
            }

            while (wall[i] < stack.peek()) {
                stack.pop();
                if (stack.isEmpty() || wall[i] > stack.peek()) {
                    stack.push(wall[i]);
                    count++;
                }
            }
        }

        return count;
    }
}
