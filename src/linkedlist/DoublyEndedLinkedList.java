package linkedlist;

import sun.plugin.dom.exception.InvalidStateException;

public class DoublyEndedLinkedList<E> {

    private static class Link<E> {
        E item;
        Link<E> next;

        Link(E element) {
            item = element;
        }

        void display() {
            System.out.print("{" + item + "} ");
        }
    }

    Link<E> first;
    Link<E> last;

    public DoublyEndedLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(E element) {
        Link<E> newLink = new Link<E>(element);

        if (isEmpty())
            last = newLink;

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(E element) {
        Link<E> newLink = new Link<E>(element);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }

        last = newLink;
    }


    public E deleteFirst() {
        if (isEmpty())
            throw new InvalidStateException("Linked list is empty");

        Link<E> tmp = first;
        first = first.next;
        if (first == null) {
            last = null;
        }

        return tmp.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void display() {
        Link<E> current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}
