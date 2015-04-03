package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangularApp {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter n: ");
        int n = getInt();

        System.out.println("Nth number is: " + triangular(n));
    }

    public static int triangular(int n) {
        if (n == 1)
            return 1;
        else
            return n + triangular(n - 1);
    }

    private static String getString() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return bf.readLine();
    }

    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
