package diff.strings;

import java.lang.String;
import java.lang.System;
import java.util.Arrays;

public class IsPermutation {
    public static void main(String[] args) {
        IsPermutation m = new IsPermutation();

        System.out.println(m.permutation2("one", "two"));
        System.out.println(m.permutation2("hello", "holle"));
    }

    String sort(String str) {
        char[] contents = str.toCharArray();
        Arrays.sort(contents);
        return new String(contents);
    }

    boolean permutation(String one, String two) {
        if (one.length() != two.length()) return false;

        return sort(one).equals(sort(two));
    }

    boolean permutation2(String one, String two) {
        if (one.length() != two.length()) return false;

        int[] letters = new int[256];

        char[] chars = one.toCharArray();
        for (char c : chars) {
            letters[c]++;
        }

        for (int i = 0; i < two.length(); i++) {
            if (--letters[(int) two.charAt(i)] < 0) return false;
        }

        return true;
    }
}
