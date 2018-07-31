package interview.binarysearch;

public class BinarySearchApp {
    public static void main(String[] args) {
        System.out.println(bin_search(new int[]{1, 4, 8, 9, 10, 42}, 4));
    }

    /**
     * O(logn)
     * O(1) memory
     */
    private static int bin_search(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);

            if (key == a[middle]) {
                return middle;
            }

            if (key > a[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
