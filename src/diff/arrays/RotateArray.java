package diff.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        displayList(l1);
        //rotateCopy(l1, 2);
        //displayList(l1);

        rotateReverse(l1, 2);
        displayList(l1);
    }

    /**
     * O(n) time and memory
     */
    private static void rotateCopy(List<Integer> arr, int n) {
        int len = arr.size();

        n = n % len;
        if (n < 0) {
            n = n + len;
        }

        // copy tail to temp
        List<Integer> temp = new ArrayList<>();
        for (int i = n; i < arr.size(); i++) {
            temp.add(arr.get(i));
        }

        // move head to tail
        for (int i = arr.size() - n, j = 0; i < arr.size(); i++, j++) {
            arr.set(i, arr.get(j));
        }

        // copy to head from temp
        for (int i = 0; i < temp.size(); i++) {
            arr.set(i, temp.get(i));
        }
    }

    /**
     * O(n) time
     * O(1) memory
     */
    private static void rotateReverse(List<Integer> arr, int n) {
        int len = arr.size();

        n = n % len;
        if (n < 0) {
            n = n + len;
        }

        // reverse all
        reverse(arr, 0, arr.size() - 1);

        // reverse head
        reverse(arr, 0, n - 1);

        // reverse tail
        reverse(arr, n, arr.size() - 1);
    }

    private static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            ++start;
            --end;
        }
    }

    private static void displayList(List<Integer> l) {
        l.forEach(e -> System.out.print(String.format("%d ", e)));
        System.out.println();
    }
}
