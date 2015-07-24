package diff.bits;

public class MissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4};

        System.out.printf("missing %d \n", missing(numbers, 3));
        System.out.printf("missing %d \n", missingXor(numbers, 3));
    }

    static int missing(int[] a, int n) {
        // n is the actual size of array, that's why n + 1
        // n(n+1)/2
        int total = (n + 1) * (n + 2) / 2;
        for (int i : a)
            total -= i;

        return total;
    }

    static int missingXor(int[] a, int n) {
        // xor elements in array
        int x1 = a[0];
        for (int i = 1; i < a.length; i++)
            x1 = x1 ^ a[i];

        // xor numbers from 1 to n
        int x2 = 1;
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return x1 ^ x2;
    }
}
