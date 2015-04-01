package linkedlist;

public class QueueLinkedList<E> {
    DoublyEndedLinkedList<E> items = new DoublyEndedLinkedList<E>();
    int size = 0;

    public void insert(E element) {
        items.insertLast(element);
        size++;
    }

    public E remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        size--;
        return items.deleteFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return size;
    }
}
