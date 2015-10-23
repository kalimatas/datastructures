package diff.arrays;

import java.util.Arrays;

public class SumPairs {
    public static void main(String[] args) {
        sumPairs(new int[]{-2, -4, 3, 4, 5, 7, 17, -8, 11, 13}, 9);
    }

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
}
