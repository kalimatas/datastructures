package diff.strings;

public class FirstUniqueCharacter {
    private static class CountPair {
        int count;
        int index;
    }

    public static void main(String[] args) {
        String input = "GeeksforGeeks";

        // first version: requires to scan the input again
        /*
        int uniquePos = firstUnique(input);
        if (uniquePos == -1) {
            System.out.println("No unique characters of string is empty");
        } else {
            System.out.printf("First non-repeating character is %c \n", input.charAt(uniquePos));
        }
        */

        // second version
        int uniquePos = firstUniqueV2(input);
        if (uniquePos == -1) {
            System.out.println("No unique characters of string is empty");
        } else {
            System.out.printf("First non-repeating character is %c \n", input.charAt(uniquePos));
        }
    }

    static int firstUnique(String input) {
        if (input.isEmpty()) return -1;

        int[] charsCount = getCharsCount(input);
        int pos = -1;

        for (int i = 0; i < input.length(); i++) {
            if (charsCount[input.charAt(i)] == 1) {
                pos = i;
                break;
            }
        }

        return pos;
    }

    private static int[] getCharsCount(String input) {
        int[] counts = new int[256];
        for (int i = 0; i < input.length(); i++) {
            counts[input.charAt(i)]++;
        }

        return counts;
    }

    // ---------------------------------------------------

    static int firstUniqueV2(String input) {
        if (input.isEmpty()) return -1;

        CountPair[] charCounts = getCharsCountV2(input);
        int pos = Integer.MAX_VALUE;

        for (CountPair charCount : charCounts) {
            if (charCount != null && charCount.count == 1 && pos > charCount.index)
                pos = charCount.index;
        }

        return pos;
    }

    private static CountPair[] getCharsCountV2(String input) {
        CountPair[] counts = new CountPair[256];
        for (int i = 0; i < input.length(); i++) {
            if (counts[input.charAt(i)] == null) {
                counts[input.charAt(i)] = new CountPair();
            }

            CountPair current = counts[input.charAt(i)];
            current.count++;
            if (current.count == 1) current.index = i;
        }

        return counts;
    }
}
