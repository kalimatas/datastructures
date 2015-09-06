package diff.strings;

public class IsRotation {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "lohel";
        System.out.printf("%s is a rotation of %s: %s%n", s2, s1, isRotation(s1, s2));
    }

    static boolean isRotation(String s1, String s2) {
        if (s1.length() > 0 && s1.length() == s2.length()) {
            return isSubstring(s1 + s1 , s2);
        }

        return false;
    }

    static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
