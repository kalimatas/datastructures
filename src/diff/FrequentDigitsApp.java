package diff;

import java.util.*;

public class FrequentDigitsApp {
    public static void main(String[] args) {
        String s = "1232442168888";
        int k = 2;
        mostFrequentItems(s, k);
    }

    static void mostFrequentItems(String s, int k) {
        HashMap<Character, Integer> freqTable = buildFrequencyTable(s);
        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map.Entry<Character, Integer> top;
        for (Map.Entry<Character, Integer> digit : freqTable.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(digit);
            } else {
                top = minHeap.peek();
                if (digit.getValue().compareTo(top.getValue()) > 0) {
                    minHeap.remove();
                    minHeap.add(digit);
                }
            }
        }

        Map.Entry<Character, Integer> item;
        while (!minHeap.isEmpty()) {
            item = minHeap.remove();
            System.out.printf("%c: %d\n", item.getKey(), item.getValue());
        }
    }

    static HashMap<Character, Integer> buildFrequencyTable(String s) {
        HashMap<Character, Integer> freqTable = new HashMap<>();
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
