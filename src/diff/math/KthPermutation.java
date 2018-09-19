package diff.math;

import java.util.List;
import java.util.stream.Collectors;

public class KthPermutation {
    public static void main(String[] args) {
        final List<Character> chars = "1234".chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        final var result = new StringBuilder();
        find_kth_permutation(chars, 8, result);
        System.out.println(result.toString());
    }

    private static int factorial(final int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * O(n) time
     * O(n) memory, because of recursion
     */
    private static void find_kth_permutation(final List<Character> v, int k, final StringBuilder result) {
        if (k == 0 || v.isEmpty()) {
            return;
        }

        final int n = v.size();
        final int count = factorial(n - 1);
        final int selected = (k - 1) / count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);
        find_kth_permutation(v, k, result);
    }
}
