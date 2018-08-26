package diff.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumPairs {
    public static void main(String[] args) {
        sumPairs(new int[]{-2, -4, 3, 4, 5, 7, 17, -8, 11, 13}, 9);
    }

    /**
     * O(n logn) time
     * O(1) memory
     */
    static void sumPairs(int[] a, int s) {
        Arrays.sort(a);
        int first = 0;
        int last = a.length - 1;
        int sum;

        while (first < last) {
            sum = a[first] + a[last];
            if (sum == s) {
                System.out.printf("%d + %d = %s%n", a[first], a[last], sum);
                first++;
                last--;
            } else if (sum < s) {
                first++;
            } else {
                last--;
            }
        }
    }

    /**
     * O(n) time
     * O(n) memory
     */
    static boolean sumPairsSet(int[] A, int s) {
        Set<Integer> values = new HashSet<>();
        for (int a : A) {
            if (values.contains(s - a)) {
                return true;
            }
            values.add(a);
        }
        return false;
    }
}
