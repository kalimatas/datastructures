package diff.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    private static class Tuple<T, TT> {
        T x;
        TT y;

        Tuple(T x, TT y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ArrayList<Tuple<Integer, Integer>> input = new ArrayList<>();
        input.add(new Tuple<>(1, 5));
        input.add(new Tuple<>(3, 7));
        input.add(new Tuple<>(4, 6));
        input.add(new Tuple<>(6, 8));

        List<Tuple<Integer, Integer>> merged  = merge_intervals(input);

        for (var i : merged) {
            System.out.printf("(%d, %d) ", i.x, i.y);
        }
    }

    static ArrayList<Tuple<Integer, Integer>> merge_intervals(ArrayList<Tuple<Integer, Integer>> v1) {
        if (v1 == null || v1.isEmpty()) {
            return null;
        }

        ArrayList<Tuple<Integer, Integer>> result = new ArrayList<>();

        int lastIndex = 0;
        Tuple<Integer, Integer> last = v1.get(lastIndex);
        result.add(last);

        for (int i = 1; i < v1.size(); i++) {
            Tuple<Integer, Integer> current = v1.get(i);
            if (current.x <= last.y && current.y >= last.x) {
                last = new Tuple<>(Math.min(last.x, current.x), current.y);
                result.set(lastIndex, last);
            } else {
                last = current;
                result.add(last);
                ++lastIndex;
            }
        }

        return result;
    }
}
