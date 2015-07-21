package diff.strings;

import java.lang.String;
import java.lang.StringBuffer;
import java.lang.System;

public class ReverseString {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello");

        System.out.println(str);
        new ReverseString().reverse(str);
        System.out.println(str);
    }

    void reverse(StringBuffer str) {
        char temp;
        int from = 0;
        int to = str.length() - 1;

        while (from < to) {
            temp = str.charAt(from);
            str.setCharAt(from, str.charAt(to));
            str.setCharAt(to, temp);
            from++;
            to--;
        }
    }
}
