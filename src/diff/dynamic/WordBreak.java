package diff.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    private static Set<String> dictionary = new HashSet<>();

    static {
        String[] words = {"mobile","samsung","sam","sung","man","mango", "icecream", "and", "go", "i","like","ice","cream"};
        dictionary.addAll(Arrays.asList(words));
    }

    public static void main(String[] args) {
        if (wordBreakDynamic("imanmobile"))
            System.out.println("yes");
        else
            System.out.println("no");
    }

    static boolean wordBreak(String str) {
        int size = str.length();
        // base case
        if (size == 0) return true;

        // search for the prefix
        for (int i = 1; i <= size; i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(i, size);

            if (dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i, size)))
                return true;
        }

        return false;
    }

    static boolean wordBreakDynamic(String str) {
        int size = str.length();
        if (size == 0) return true;

        // The value wb[i] is true if str[0..i-1] can be segmented
        boolean[] wb = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            String prefix = str.substring(0, i);

            if (!wb[i] && dictionary.contains(str.substring(0, i)))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i]) {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    String suffix = str.substring(i, j);

                    if (!wb[j] && dictionary.contains(str.substring(i, j)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j])
                        return true;
                }
            }
        }

        return false;
    }
}
