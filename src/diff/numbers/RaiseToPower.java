package diff.numbers;

public class RaiseToPower {
    public static void main(String[] args) {
        int x = 2;
        int y = 4;
        System.out.printf("%d to the power of %d is %d%n", x, y, power(x, y));
    }

    static int power(int x, int y) {
        if (y == 0)
            return 1;

        int tmp = power(x, y/2);

        if (y % 2 == 0)
            return  tmp * tmp;
        else
            return x * tmp * tmp;
    }
}
