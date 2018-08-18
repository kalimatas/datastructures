package diff.arrays;

public class SearchRotated {
    public static void main(String[] args) {
        System.out.println(searchRotatted(new int[]{42, 56, 72, 1, 4, 8, 9, 10}, 42));
    }

    /**
     * O(logn)
     * O(1) memory
     */
    private static int searchRotatted(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (key == a[middle]) {
                return middle;
            }

            if (a[low] <= a[middle] && (key >= a[low] && key <= a[middle])) {
                high = middle - 1;
            } else if (a[middle] < a[high] && (key > a[middle] && key <= a[high])) {
                low = middle + 1;
            } else if (a[low] > a[middle]) {
                high = middle - 1;
            } else if (a[middle] > a[high]) {
                low = middle + 1;
            }
        }

        return -1;
    }
}
