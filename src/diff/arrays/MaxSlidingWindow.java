package diff.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        var a = new int[]{1, 2, 3, 4, 3, 2, 1, 2, 5};
        findMaxSlidingWindow(a, 3).forEach(System.out::println);
    }

    private static List<Integer> findMaxSlidingWindow(int[] array,
                                                      int windowSize) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();
        if (array.length < windowSize) {
            return result;
        }

        for (var i = 0; i < windowSize; i++) {
            // remove all elements from tail less than current
            if (!window.isEmpty() && array[window.peekLast()] <= array[i]) {
                window.removeLast();
            }
            window.addLast(i);
        }

        result.add(array[window.peekFirst()]);

        for (var i = windowSize; i < array.length; i++) {
            // remove all elements from tail less than current
            if (!window.isEmpty() && array[window.peekLast()] <= array[i]) {
                window.removeLast();
            }

            // out of window
            if (!window.isEmpty() && window.peekFirst() <= i - windowSize) {
                window.removeFirst();
            }

            window.addLast(i);
            result.add(array[window.peekFirst()]);
        }

        return result;
    }
}
