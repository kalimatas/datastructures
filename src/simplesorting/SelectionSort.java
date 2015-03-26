package simplesorting;

import array.HighArray;

public class SelectionSort {
    public static void main(String[] args) {
        ArraySelection arr = new ArraySelection(10);

        arr.insert(4);
        arr.insert(2);
        arr.insert(8);
        arr.insert(6);
        arr.insert(1);
        arr.insert(5);

        arr.display();

        arr.sort();

        arr.display();
    }
}

class ArraySelection extends HighArray {
    public ArraySelection(int size) {
        super(size);
    }

    void sort() {
        int min;

        for (int left = 0; left < size - 1; left++) {
            min = left;

            for (int in = left + 1; in < size; in++) {
                if (items[in] < items[min]) {
                    min = in;
                }
            }

            if (min != left) {
                swap(left, min);
            }
        }
    }
}
