package linkedlist;

import sun.plugin.dom.exception.InvalidStateException;

public class SortedList<E extends Comparable<E>> {

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

    public SortedList() {
        first = null;
    }

    public void insert(E element) {
        Link<E> newLink = new Link<E>(element);
        Link<E> previous = null;
        Link<E> current = first;

        while (current != null && current.item.compareTo(element) < 0) {
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = newLink; // beginning
        else
            previous.next = newLink; // middle

        newLink.next = current;
    }

    public E remove() {
        if (isEmpty())
            throw new InvalidStateException("Linked list is empty");

        Link<E> tmp = first;
        first = first.next;

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
