package diff.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TransformString {
    public static void main(String[] args) {
        HashSet<String> d = new HashSet<>();
        d.add("abcd");
        d.add("abed");
        d.add("abeg");
        d.add("abef");
        d.add("aheg");
        d.add("xheg");

        System.out.printf("%s to %s: %d%n", "abcd", "xheg", transform("abcd", "xheg", d));
    }

    private static class Pair {
        String s;
        int c;

        Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    private static int transform(final String s, final String t, HashSet<String> d) {
        Queue<Pair> q = new LinkedList<>();
        d.remove(s);
        q.add(new Pair(s, 0));

        while (!q.isEmpty()) {
            Pair p = q.peek();
            if (p.s.equals(t)) {
                return p.c;
            }

            StringBuilder str = new StringBuilder(p.s);
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    str.setCharAt(i, (char) ('a' + j));
                    String tmp = str.toString();
                    if (d.contains(tmp)) {
                        d.remove(tmp);
                        q.add(new Pair(tmp, p.c + 1));
                    }
                }

                str.setCharAt(i, p.s.charAt(i));
            }

            q.remove();
        }

        return -1;
    }
}
