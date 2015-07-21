package diff.strings;

import java.lang.Math;
import java.lang.String;
import java.lang.System;

public class ConvertBase {
    public static void main(String... args) {
        System.out.println(new ConvertBase().compareBinToHex("1011", "B"));
    }

    private boolean compareBinToHex(String bin, String hex) {
        int n1 = convertToBase(bin, 2);
        int n2 = convertToBase(hex, 16);

        if (n1 < 0 || n2 < 0) {
            return false;
        } else {
            return n1 == n2;
        }
    }

    private int convertToBase(String number, int base) {
        if (base < 2 || (base > 10 && base != 16)) {
            return -1;
        }
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = convertCharToNumber(number.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            value += digit * Math.pow(base, number.length() - 1 - i);
        }

        return value;
    }

    private int convertCharToNumber(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'A' && c <= 'F') return 10 + c - 'A';
        if (c >= 'a' && c <= 'f') return 10 + c - 'a';
        return -1;
    }
}
