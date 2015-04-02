package linkedlist;

public class DoublyLinkedList<E extends Comparable<E>> {

    private static class Link<E> {
        E item;
        Link<E> prev;
        Link<E> next;

        Link(E elem) {
            item = elem;
        }

        void display() {
            System.out.print("{" + item + "} ");
        }
    }

    Link<E> first;
    Link<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(E elem) {
        Link<E> newLink = new Link<E>(elem);

        if (isEmpty())
            last = newLink;
        else
            first.prev = newLink;

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(E elem) {
        Link<E> newLink = new Link<E>(elem);

        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;

        newLink.prev = last;
        last = newLink;
    }

    public boolean insertAfter(E after, E elem) {
        if (isEmpty())
            return false;

        Link<E> newLink = new Link<E>(elem);
        Link<E> current = first;
        while (!current.item.equals(after)) {
            current = current.next;
            if (current == null)
                return false;
        }

        if (current == last) {
            last = newLink;
        } else {
            current.next.prev = newLink;
        }

        newLink.next = current.next;
        newLink.prev = current;
        current.next = newLink;

        return true;
    }

    public E deleteFirst() {
        if (isEmpty())
            return null;

        Link<E> tmp = first;
        if (first.next == null)
            last = null;
        else
            first.next.prev = null;

        first = first.next;
        return tmp.item;
    }

    public E deleteLast() {
        if (isEmpty())
            return null;

        Link<E> tmp = last;
        if (first.next == null)
            first = null;
        else
            last.prev.next = null;

        last = last.prev;
        return tmp.item;
    }

    public boolean deleteKey(E elem) {
        if (isEmpty())
            return false;

        Link<E> current = first;
        while (!current.item.equals(elem)) {
            if (current.next == null)
                return false;

            current = current.next;
        }

        if (current == first) {
            first = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current == last) {
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayForward() {
        Link<E> current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Link<E> current = last;
        while (current != null) {
            current.display();
            current = current.prev;
        }
        System.out.println();
    }
}
