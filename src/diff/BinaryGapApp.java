package diff;

public class BinaryGapApp {
    public static void main(String[] args) {
        System.out.println("gap for 1001 is " + maxZeroGap(0b1001));
        System.out.println("gap for 10001100 is " + maxZeroGap(0b10001100));
    }

    private static int maxZeroGap(int n) {
        int max = 0;
        int count = 0;
        int digit = 0;

        while (n > 0) {
            digit = n & 1;
            n = n >> 1;

            if (digit == 0) {
                count++;
            } else {
                max = count > max ? count : max;
                count = 0;
            }
        }

        return max;
    }
}
