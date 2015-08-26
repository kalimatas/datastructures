package diff.strings;

/**
 * Convert "aabeeea" to "a2b1e3a1" if compressed string is shorter
 */
public class CompressString {
    public static void main(String[] args) {
        String s = "aaabeeeeeea";
        System.out.printf("%s: %s%n", s, compress(s));
    }

    static String compress(String str) {
        int size = countCompression(str);
        if (size >= str.length()) return str;

        StringBuilder compressed = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;

        for (int index = 1; index < str.length(); index++) {
            if (str.charAt(index) == last) {
                count++;
            } else {
                compressed.append(last);
                compressed.append(count);
                last = str.charAt(index);
                count = 1;
            }
        }

        compressed.append(last);
        compressed.append(count);

        return compressed.toString();
    }

    static int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0;

        int size = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int index = 1; index < str.length(); index++) {
            if (str.charAt(index) == last) {
                count++;
            } else {
                size = size + 1 + String.valueOf(count).length(); // two-digit value
                last = str.charAt(index);
                count = 1;
            }
        }

        return size + 1 + String.valueOf(count).length();
    }
}
