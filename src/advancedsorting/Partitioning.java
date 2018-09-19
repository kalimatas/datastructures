package advancedsorting;

import array.HighArray;

public class Partitioning {
    public static void main(String[] args) {
        ArrayPartitioning arr = new ArrayPartitioning(10);
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

        arr.partition(0, arr.size() - 1, 37);

        arr.display();
    }

    private static class ArrayPartitioning extends HighArray {
        ArrayPartitioning(int size) {
            super(size);
        }

        void partition(int left, int right, int pivot) {
            int leftPtr = left - 1;
            int rightPtr = right + 1;

            while (true) {
                while (leftPtr < rightPtr && items[++leftPtr] < pivot)
                    ; // skip elements

                while (rightPtr > leftPtr && items[--rightPtr] > pivot)
                    ; // skip elements

                if (leftPtr >= rightPtr)
                    break;
                else
                    swap(leftPtr, rightPtr);
            }
        }
    }
}



