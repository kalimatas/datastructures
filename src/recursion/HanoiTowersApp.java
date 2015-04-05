package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTowersApp {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter n: ");
        int n = getInt();

        HanoiTowers.doTowers(n, 'A', 'B', 'C');
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

class HanoiTowers {
    static void doTowers(int n, char from, char inter, char to) {
        if (n == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {

            // Move subtree n - 1 from S to I
            doTowers(n - 1, from, to, inter); // from -> inter

            // Move the remaining (largest) disk from S to D
            System.out.println("Disk " + n + " from " + from + " to " + to);

            // Move the subtree from I to D
            doTowers(n - 1, inter, from, to); // inter -> to
        }
    }
}
