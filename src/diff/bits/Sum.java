package diff.bits;

public class Sum {
    public static void main(String[] args) {
        System.out.printf("2 + 15 = %d%n", sum(2, 15));
    }

    static int sum(int a, int b) {
        if (b == 0) return a;

        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sum(sum, carry);
    }
}
