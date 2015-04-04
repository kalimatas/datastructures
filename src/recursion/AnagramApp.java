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
        an.doAnagram(word.length());
    }

    private static String getString() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return bf.readLine();
    }
}

class Anagram {
    private char[] word = new char[100];
    private int size = 0;

    Anagram(String input) {
        for (int i = 0; i < input.length(); i++) {
            word[i] = input.charAt(i);
        }
        size = input.length();
    }

    void doAnagram(int newSize) {
        if (newSize == 1)
            return;
        else {
            for (int i = 0; i < newSize; i++) {
                doAnagram(newSize - 1);
                if (newSize == 2)
                    dispalyWord();
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

    void dispalyWord() {
        for (int i = 0; i < size; i++)
            System.out.print(word[i]);

        System.out.println();
    }
}
