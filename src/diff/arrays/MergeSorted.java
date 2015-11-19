package diff.arrays;

public class MergeSorted {
    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 7, 0, 0, 0, 0, 0};
//        int[] b = {2, 4, 6, 8, 11};

        int[] a = {1, 2, 3, 5, 6, 8, 12, 13, 0};
        int[] b = {4};

        merge(a, b);
        for (int i : a) {
            System.out.printf("%d ", i);
        }
    }

    static void merge(int[] a, int[] b) {
        int mergeLast = a.length - 1;
        int aLast = a.length - b.length - 1;
        int bLast = b.length - 1;

        while (aLast >= 0 && bLast >= 0) {
            if (a[aLast] > b[bLast]) {
                a[mergeLast] = a[aLast];
                aLast--;
                mergeLast--;
            } else {
                a[mergeLast] = b[bLast];
                bLast--;
                mergeLast--;
            }
        }

        while (bLast >= 0) {
            a[mergeLast--] = b[bLast--];
        }
    }
}
