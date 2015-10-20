package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter word: ");
        String word = getString();

        Anagram an = new Anagram(word);

        System.out.println();
        System.out.println("Anagrams");
        an.doAnagram();
    }

    private static String getString() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return bf.readLine();
    }
}

class Anagram {
    private char[] word;
    private int size = 0;

    Anagram(String input) {
        word = input.toCharArray();
        size = input.length();
    }

    void doAnagram() {
        doAnagramRec(size);
    }

    private void doAnagramRec(int newSize) {
        if (newSize == 1)
            return;
        else {
            for (int i = 0; i < newSize; i++) {
                doAnagramRec(newSize - 1);
                if (newSize == 2)
                    System.out.printf("%s%n", String.valueOf(word));
                rotate(newSize);
            }
        }
    }

    void rotate(int newSize) {
        int i;
        int pos = size - newSize;
        char tmp = word[pos];
        for (i = pos + 1; i < size; i++)
            word[i - 1] = word[i];

        word[i - 1] = tmp;
    }
}
