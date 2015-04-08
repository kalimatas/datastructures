package advancedsorting;

import array.HighArray;

public class Shellsort {
    public static void main(String[] args) {
        ArrayShell arrayShell = new ArrayShell(10);
        arrayShell.insert(8);
        arrayShell.insert(4);
        arrayShell.insert(1);
        arrayShell.insert(7);
        arrayShell.insert(3);
        arrayShell.insert(9);
        arrayShell.insert(2);
        arrayShell.insert(6);
        arrayShell.insert(5);
        arrayShell.insert(10);

        arrayShell.display();

        arrayShell.sort();

        arrayShell.display();
    }
}

class ArrayShell extends HighArray {
    public ArrayShell(int size) {
        super(size);
    }

    void sort() {
        int in, out, temp;

        // initial value
        int h = 1;
        while (h <= size/3) {
            h = h*3 + 1;
        }

        while (h > 0) {
            for (out = h; out < size; out++) {
                temp = items[out];
                in = out;

                while (in > h - 1 && items[in - h] >= temp) {
                    items[in] = items[in - h];
                    in -= h;
                }
                items[in] = temp;
            }

            h = (h - 1) / 3;
        }
    }
}
