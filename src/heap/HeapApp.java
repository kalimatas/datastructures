package heap;

public class HeapApp {
    public static void main(String[] args) {
        Heap heap = new Heap(15);

        heap.insert(new DataItem(70));
        heap.insert(new DataItem(40));
        heap.insert(new DataItem(50));
        heap.insert(new DataItem(20));
        heap.insert(new DataItem(60));
        heap.insert(new DataItem(100));
        heap.insert(new DataItem(80));
        heap.insert(new DataItem(30));
        heap.insert(new DataItem(10));
        heap.insert(new DataItem(90));

        heap.display();

        DataItem max = heap.remove();
        if (max != null) System.out.println("max: " + max.getKey());

        heap.display();

        heap.update(5, new DataItem(82));

        heap.display();

        System.out.println("Heap sort");

        int size = 13;
        int j;

        HeapSort heapSort = new HeapSort(size);
        for (j = 0; j < size; j++) {
            heapSort.insertAt(j, new DataItem((int) (Math.random() * 100)));
            heapSort.incrementSize();
        }

        heapSort.displayArray();

        for (j = size/2 - 1; j >= 0; j--)
            heapSort.trickleDown(j);

        heapSort.displayArray();
        heapSort.display();

        for (j = size - 1; j >= 0; j--) {
            DataItem biggest = heapSort.remove();
            heapSort.insertAt(j, biggest);
        }


        heapSort.displayArray();
    }
}
