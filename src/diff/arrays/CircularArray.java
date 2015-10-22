package diff.arrays;

import java.util.Iterator;

class CArray<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    @SuppressWarnings("unchecked")
    CArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index = (index % items.length) + items.length;
        }

        return (head + index) % items.length;
    }

    void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    void set(int i, T item)  {
        items[convert(i)] = item;
    }

    T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[convert(i)];
    }

    @Override
    public Iterator<T> iterator() {
        return new CArrayIterator<>(this);
    }

    private class CArrayIterator<TI> implements Iterator<TI> {
        private int _current = -1;
        private TI[] _items;

        CArrayIterator(CArray<TI> array) {
            _items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }
        @Override
        public TI next() {
            _current++;
            return (TI) _items[convert(_current)];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

public class CircularArray {
    public static void main(String[] args) throws IndexOutOfBoundsException {
        CArray<Integer> array = new CArray<>(6);
        array.set(0, 0);
        array.set(1, 1);
        array.set(2, 2);
        array.set(3, 3);
        array.set(4, 4);
        array.set(5, 5);

        //System.out.println(array.get(1));

        //array.set(-8, 42);
        array.rotate(-8);
        //array.set(-8, 42);
        //System.out.println(array.get(0));

        //array.rotate(1);
        //System.out.println(array.get(0));

        for (Integer s : array) {
            System.out.println(s);
        }
    }
}
