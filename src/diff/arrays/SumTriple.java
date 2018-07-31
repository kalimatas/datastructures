package diff.arrays;

import java.util.Arrays;

public class SumTriple {
    public static void main(String[] args) {
        if (sumTripleNotThatBad(new int[]{3, 7, 1, 2, 8, 4, 5}, 20)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    /**
     * O(n^2 logn)
     */
    static boolean sumTripleNotThatBad(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i+1; j < a.length - 1; j++) {
                int remainingSum = s - a[i] - a[j];
                int k = Arrays.binarySearch(a, remainingSum);
                if (k > 0 && k != i && k != j) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * O(n^2)
     */
    static boolean sumTripleBetter(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int remainingSum = s - a[i];
            if (sumPairs(a, remainingSum, i + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean sumPairs(int[] a, int s, int startIndex) {
        for (int i = startIndex, j = a.length - 1; i < j;) {
            int sum = a[i] + a[j];
            if (sum == s) {
                return true;
            } else if (sum < s) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
