package diff.arrays;

import java.util.Arrays;

public class MoveZerosToHead {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 0, 3, 0, 5, 8, 0};
        move_zeros_to_left_in_array(A);
        Arrays.stream(A).forEach(e -> System.out.print(e + " "));
    }

    /**
     * O(n) time
     * O(1) memory
     */
    private static void move_zeros_to_left_in_array(int[] A) {
        int reader = A.length - 1, writer = A.length - 1;
        while (reader >= 0) {
            if (A[reader] == 0) {
                reader--;
                continue;
            }

            A[writer] = A[reader];
            reader--;
            writer--;
        }

        while (writer >= 0) {
            A[writer--] = 0;
        }
    }
}
