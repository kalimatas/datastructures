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
        if (wordBreak("imanmobile"))
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
}
