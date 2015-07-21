package diff.numbers;

public class NumberOfBitsToChange {
    public static void main(String[] args) {
        //System.out.println(numberOfBitsToChange(0b1111001, 0b1010101)); // 3
        System.out.println(numberOfBitsToChange2(0b1111001, 0b1010101)); // 3
    }

    static int numberOfBitsToChange(int i1, int i2) {
        int result = 0;

        while (i1 > 0 && i2 > 0) {
            if (((i1 & 1) ^ (i2 & 1)) == 1) result++;

            i1 = i1 >> 1;
            i2 = i2 >> 1;
        }

        result += countOnes(i1);
        result += countOnes(i2);

        return result;
    }

    static int countOnes(int n) {
        int result = 0;
        while (n > 0) {
            if ((n & 1) == 1) result++;
            n = n >> 1;
        }
        return result;
    }

    static int numberOfBitsToChange2(int i1, int i2) {
        int result = 0;
        for (int n = i1 ^ i2; n > 0; n = n >> 1) {
            result += n & 1;
        }
        return result;
    }
}
