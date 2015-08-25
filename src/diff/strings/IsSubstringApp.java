package diff.strings;

public class IsSubstringApp {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bacdabced";
        System.out.printf("%s is substring of %s: %s", s1, s2, isSubstring(s1, s2));
    }

    private static boolean isSubstring(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s2.length() && j < s1.length()) {
            if (s2.charAt(i) == s1.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            i++;
        }

        return j == s1.length();
    }
}
