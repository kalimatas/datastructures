package diff.numbers;

public class Prime {
    public static void main(String... args) {
        Prime p = new Prime();
        System.out.printf("%d %b\n", 1, p.isPrime(1));
        System.out.printf("%d %b\n", 2, p.isPrime(2));
        System.out.printf("%d %b\n", 10, p.isPrime(10));
        System.out.printf("%d %b\n", 11, p.isPrime(11));
        System.out.printf("%d %b\n", 123456789102299L, p.isPrime(123456789102299L));

        int[] sieve = p.sieve(120);
        for (int i = 2; i <= sieve.length; i++) {
            if (sieve[i] == 1)
                System.out.printf("%d %b\n", i, sieve[i] == 1);
        }
    }

    public boolean isPrime(long n) {
        if ((n % 2 == 0 && n != 2) || n < 2) {
            return false;
        }

        long max = (long)Math.sqrt(n);
        for (long i = 3; i <= max; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int[] sieve(int n) {
        int[] s = new int[n + 1];
        s[1] = 0;
        for (int i = 2; i <= n; i++) {
            s[i] = 1;
        }

        for (int i = 2; i*i <= n; i++) {
            if (s[i] == 1) {
                for (int j = i*i; j <= n; j += i) {
                    s[j] = 0;
                }
            }
        }

        return s;
    }
}
