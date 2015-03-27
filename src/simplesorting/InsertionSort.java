package simplesorting;

import array.HighArray;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayInsertion arr = new ArrayInsertion(10);

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

class ArrayInsertion extends HighArray {
    public ArrayInsertion(int size) {
        super(size);
    }

    void sort() {
        int out, in, tmp;

        for (out = 1; out < size; out++) {
            // mark the element
            tmp = items[out];

            // shift bigger elements to the right
            in = out;
            while (in > 0 && items[in - 1] >= tmp) {
                items[in] = items[in - 1];
                --in;
            }

            // insert marked element
            items[in] = tmp;
        }
    }
}
