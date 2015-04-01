package linkedlist;

import sun.plugin.dom.exception.InvalidStateException;

public class LinkedList<E> {

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

    public LinkedList() {
        first = null;
    }

    public void insertFirst(E element) {
        Link<E> newLink = new Link<E>(element);
        newLink.next = first;
        first = newLink;
    }

    public E deleteFirst() {
        if (isEmpty())
            throw new InvalidStateException("Linked list is empty");

        Link<E> tmp = first;
        first = first.next;

        return tmp.item;
    }

    public boolean delete(E element) {
        if (isEmpty())
            return false;

        Link<E> current = first;
        Link<E> previous = first;
        while (!current.item.equals(element)) {
            if (current.next == null)
                return false;

            previous = current;
            current = current.next;
        }

        if (current == first)
            first = first.next;
        else
            previous.next = current.next;

        return true;
    }

    public boolean contains(E element) {
        if (isEmpty())
            return false;

        Link<E> current = first;
        while (current != null) {
            if (current.item.equals(element))
                return true;

            current = current.next;
        }

        return false;
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
