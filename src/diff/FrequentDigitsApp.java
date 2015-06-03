package diff;

import java.util.*;

public class FrequentDigitsApp {
    public static void main(String[] args) {
        String s = "123244216";
        int k = 2;
        mostFrequentItems(s, k);
    }

    static void mostFrequentItems(String s, int k) {
        Map freqTable = buildFrequencyTable(s);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o1.getValue() < o2.getValue()) ? 1 : (o1.getValue().equals(o2.getValue()) ? 0 : -1);
            }
        });

        maxHeap.addAll(freqTable.entrySet());

        Map.Entry<Character, Integer> item;
        while (k-- > 0) {
            item = maxHeap.remove();
            System.out.printf("%c: %d\n", item.getKey(), item.getValue());
        }
    }

    static Map buildFrequencyTable(String s) {
        Map<Character, Integer> freqTable = new HashMap<>();
        int freq;

        for (Character c : s.toCharArray()) {
            freq = 0;
            if (freqTable.containsKey(c)) {
                freq = freqTable.get(c);
            }
            freqTable.put(c, ++freq);
        }

        return freqTable;
    }
}
