package recursion;

import array.HighArray;

public class MergeSort {
    public static void main(String[] args) {
        MergeArray arr = new MergeArray(10);

        arr.insert(10);
        arr.insert(9);
        arr.insert(8);
        arr.insert(7);
        arr.insert(6);
        arr.insert(5);

        arr.display();

        arr.sort();

        arr.display();
    }
}

class MergeArray extends HighArray {
    public MergeArray(int size) {
        super(size);
    }

    public void sort() {
        int[] workspace = new int[size];
        mergeSort(workspace, 0, size - 1);
    }

    private void mergeSort(int[] workspace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound) / 2;

            mergeSort(workspace, lowerBound, mid);
            mergeSort(workspace, mid + 1, upperBound);

            merge(workspace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workspace, int lowPtr, int highPtr, int upperBound) {
        int i = 0;
        int lowerBound = lowPtr; // save for future insertion
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (items[lowPtr] < items[highPtr])
                workspace[i++] = items[lowPtr++];
            else
                workspace[i++] = items[highPtr++];
        }

        // Remaining items in lower part
        while (lowPtr <= mid)
            workspace[i++] = items[lowPtr++];

        // Remaining items in higher part
        while (highPtr <= upperBound)
            workspace[i++] = items[highPtr++];

        // Copy sorted elements into original array
        for (i = 0; i < n; i++)
            items[lowerBound + i] = workspace[i];
    }
}
