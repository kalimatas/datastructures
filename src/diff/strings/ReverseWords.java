package diff.strings;

public class ReverseWords {
    public static void main(String[] args) {
        reverse_words("Hello World!\0".toCharArray());
    }

    private static void reverse_words(char[] sentence) {
        if (sentence == null || sentence.length == 0 || sentence[0] == '\0') {
            return;
        }

        reverse_string(sentence, 0, sentence.length - 2);
        int from = 0, to;
        for (;;) {
            while (sentence[from] == ' ') {
                from++;
            }

            if (sentence[from] == '\0') {
                break;
            }

            to = from + 1;
            while (sentence[to] != '\0' && sentence[to] != ' ') {
                to++;
            }

            // reverse found word
            reverse_string(sentence, from, to - 1);
            from = to;
        }

        display(sentence);
    }

    private static void reverse_string(char[] str, int from, int to) {
        while (from < to) {
            char tmp = str[from];
            str[from] = str[to];
            str[to] = tmp;
            from++;
            to--;
        }
    }

    private static void display(char[] str) {
        int i = 0;
        while (str[i] != '\0') {
            System.out.print(str[i++]);
        }
    }
}
