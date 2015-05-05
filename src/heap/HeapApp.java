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
    }
}
