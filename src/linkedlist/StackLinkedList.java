package linkedlist;

public class StackLinkedList<E> {
    LinkedList<E> items = new LinkedList<E>();
    int size = 0;

    public void push(E element) {
        items.insertFirst(element);
        size++;
    }

    public E pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        size--;
        return items.deleteFirst();
    }

    public E peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        return items.getFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return size;
    }

    public void display() {
        items.display();
    }
}
