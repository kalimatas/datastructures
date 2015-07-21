package diff.strings;

import java.lang.String;
import java.lang.System;

public class UniqueString {
    public static void main(String[] args) {
        UniqueString m = new UniqueString();

        System.out.println("is unique chars: " + m.isUniqueChars2("hello"));
    }

    boolean isUniqueChars(String str) {
        if (str.length() > 256) return false;

        boolean[] chars = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (chars[c]) {
                return false;
            }
            chars[c] = true;
        }

        return true;
    }

    boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = convertCharToNumber(str.charAt(i));

            System.out.println("unicode: " + str.codePointAt(i));

            System.out.printf("original = %d, val = %d, 1 << val = %d \n", (int)str.charAt(i), val, (1 << val));

            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
            System.out.printf("checker = %d \n", checker);

        }

        return true;
    }

    private int convertCharToNumber(char c) {
        //if (c >= 'A' && c <= 'Z') return c - 'A';
        if (c >= 'a' && c <= 'z') return c - 'a';
        return -1;
    }
}


