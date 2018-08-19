package diff.arrays;

import java.util.Arrays;
import java.util.List;

public class FindLowHighIndex {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0, 1, 2, 2, 2, 2, 2, 6);
        int key = 2;

        System.out.println(find_low_index(arr, key));
        System.out.println(find_high_index(arr, key));
    }

    private static int find_low_index(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);

            if (key > arr.get(middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (arr.get(low) == key) {
            return low;
        }

        return -1;
    }

    private static int find_high_index(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);

            if (key >= arr.get(middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (key == arr.get(high)) {
            return high;
        }

        return -1;
    }
}
