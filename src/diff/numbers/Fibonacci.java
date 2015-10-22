package diff.numbers;

public class Fibonacci {
    public static void main(String... args) {
        Fibonacci f = new Fibonacci();
        f.print(20);

        System.out.println();
    }

    protected void print(int n) {
        long x = 0;
        long y = 1;
        long z;

        System.out.print(x + " ");
        System.out.print(y + " ");

        int c = 1;
        while (c++ <= n) {
            z = x + y;
            x = y;
            y = z;

            System.out.print(z + " ");
        }
    }
}
