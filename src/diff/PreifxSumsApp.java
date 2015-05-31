package diff;

public class PreifxSumsApp {
    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 1, 6, 3};

        System.out.printf("   ");
        for (int i : A) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        int[] prefixSums = prefixSums(A);
        for (int i : prefixSums) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
    }

    private static int[] prefixSums(int[] A) {
        int[] sums = new int[A.length + 1];
        sums[0] = 0;

        for (int i = 1; i < A.length + 1; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }

        return sums;
    }
}
