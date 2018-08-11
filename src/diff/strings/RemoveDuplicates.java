package diff.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates("abbcccdeccf\0".toCharArray());
    }

    // another O(n^2) variant: scan already scanned string to see, if it has
    // the same elements
    private static void removeDuplicates(char[] str) {
        Set<Character> chars = new HashSet<>();
        int read = 0, write = 0;

        while (str[read] != '\0') {
            char c = str[read];
            if (chars.add(c)) {
                str[write++] = c;
            }
            read++;
        }

        str[write] = '\0';
        display(str);
    }

    private static void display(char[] str) {
        int i = 0;
        while (str[i] != '\0') {
            System.out.print(str[i++]);
        }
    }
}
