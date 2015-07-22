package diff.io;

import java.io.Console;

public class ConsoleCommandLine {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) System.exit(1);

        read(console);
    }

    static void read(Console console) {
        String s = console.readLine("Enter some line: ");
        char[] p = console.readPassword("Enter password: ");

        System.out.printf("string: %s\n", s);
        System.out.printf("password: %s\n", String.valueOf(p));
    }
}
