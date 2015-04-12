package advancedsorting;

import array.HighArray;

public class QuicksortMeridian {
    public static void main(String[] args) {
        ArrQuickMeridian arr = new ArrQuickMeridian(10);

        arr.insert(14);
        arr.insert(74);
        arr.insert(81);
        arr.insert(22);
        arr.insert(37);
        arr.insert(35);
        arr.insert(54);
        arr.insert(7);
        arr.insert(19);
        arr.insert(36);

        arr.display();

        arr.sort();

        arr.display();
    }
}

class ArrQuickMeridian extends HighArray {
    public ArrQuickMeridian(int size) {
        super(size);
    }

    void sort() {
        recQuicksort(0, size - 1);
    }

    private void recQuicksort(int left, int right) {
        int length = right - left + 1;
        if (length <= 3)
            manualSort(left, right);
        else {
            int pivotMeridian = meridian(left, right);

            int partition = partitionIt(left, right, pivotMeridian);
            recQuicksort(left, partition - 1);
            recQuicksort(partition + 1, right);
        }
    }

    private void manualSort(int left, int right) {
        int length = right - left + 1;
        if (length == 1)
            return;
        else if (length == 2) {
            if (items[left] > items[right])
                swap(left, right);
            return;
        } else {
            // left, center
            if (items[left] > items[left + 1])
                swap(left, left + 1);

            // left, rigth
            if (items[left] > items[right])
                swap(left, right);

            // center, right
            if (items[left + 1] > items[right])
                swap(left + 1, right);
        }
    }

    private int meridian(int left, int right) {
        int center = (left + right) / 2;

        // left, center
        if (items[left] > items[center])
            swap(left, center);

        // left, rigth
        if (items[left] > items[right])
            swap(left, right);

        // center, right
        if (items[center] > items[right])
            swap(center, right);

        // put meridian to the right
        swap(center, right - 1);

        return items[right - 1];
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left; // do not count first element - it's alread sorted
        int rightPtr = right - 1; // do not take the last (pivot) element; it will be just swapped

        while (true) {
            // no check for pointers overlapping, because the pivot is the existing element
            while (items[++leftPtr] < pivot)
                ; // skip elements

            while (items[--rightPtr] > pivot)
                ; // skip elements

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }

        swap(leftPtr, right - 1); // restore pivot

        return leftPtr;
    }
}
