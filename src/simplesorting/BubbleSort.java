package simplesorting;

import array.HighArray;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayBub arr = new ArrayBub(10);

        arr.insert(2);
        arr.insert(8);
        arr.insert(12);
        arr.insert(4);
        arr.insert(6);
        arr.insert(3);

        arr.display();

        arr.sort();

        arr.display();
    }
}

class ArrayBub extends HighArray {
    ArrayBub(int size) {
        super(size);
    }

    void sort() {
        for (int outer = size - 1; outer > 1; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (items[inner] > items[inner+1]) {
                    swap(inner, inner+1);
                }
            }
        }
    }
}
