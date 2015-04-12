package advancedsorting;

import array.HighArray;

public class Quicksort {
    public static void main(String[] args) {
        ArrQuick arr = new ArrQuick(10);

        arr.insert(14);
        arr.insert(74);
        arr.insert(81);
        arr.insert(22);
        arr.insert(37);
        arr.insert(35);
        arr.insert(54);
        arr.insert(7);
        arr.insert(19);
        arr.insert(90);

        arr.display();

        arr.sort();

        arr.display();
    }
}

class ArrQuick extends HighArray {
    public ArrQuick(int size) {
        super(size);
    }

    void sort() {
        recQuicksort(0, size - 1);
    }

    private void recQuicksort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = items[right];

            int partition = partitionIt(left, right, pivot);
            recQuicksort(left, partition - 1);
            recQuicksort(partition + 1, right);
        }
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right; // do not take the last (pivot) element; it will be just swapped

        while (true) {
            // no check for pointers overlapping, because the pivot is the existing element
            while (items[++leftPtr] < pivot)
                ; // skip elements

            while (rightPtr > 0 && items[--rightPtr] > pivot)
                ; // skip elements

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }

        swap(leftPtr, right); // place pivot in the middle of two subarrays

        return leftPtr;
    }
}
