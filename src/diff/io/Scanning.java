package diff.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Scanning {
    private static final String file = "src/diff/io/test.txt";

    public static void main(String[] args) throws IOException {
        //scan();
        scanString();
    }

    static void scan() throws IOException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
            //scanner = new Scanner(new File(file));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.printf("%d ", scanner.nextInt());
                } else {
                    scanner.next();
                }
            }

        } finally {
            if (scanner != null) scanner.close();
        }
    }

    static void scanString() {
        String s = "hello 42 and some 10 other digit 1 n";
        Scanner scanner = null;

        try {
            scanner = new Scanner(s);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    System.out.printf("%d ", scanner.nextInt());
                else
                    scanner.next();
            }

        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
