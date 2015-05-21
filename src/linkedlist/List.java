package linkedlist;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<E> implements Iterable<E> {

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

    private class LinkedListIterator implements Iterator<E> {
        private Link<E> current;

        public LinkedListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            Link<E> tmp = current;
            current = current.next;
            return tmp.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    Link<E> first;

    public List() {
        first = null;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public void insertFirst(E element) {
        Link<E> newLink = new Link<E>(element);
        newLink.next = first;
        first = newLink;
    }

    public E getFirst() {
        if (isEmpty())
            throw new InvalidStateException("Linked list is empty");

        return first.item;
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
