package linkedlist;

import java.util.Iterator;

public class LinkedListApp {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);

        System.out.println("deleted first: " + list.deleteFirst());

        list.display();

        System.out.println("20 is in the list: " + list.contains(20));
        System.out.println("42 is in the list: " + list.contains(42));

        System.out.println("delete 20: " + list.delete(20));
        System.out.println("20 is in the list: " + list.contains(20));

        list.display();

        System.out.println("iterate over linked list");
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        list.insertFirst(13);
        list.insertFirst(20);
        list.insertFirst(33);
        list.insertFirst(50);
        list.display();

        list.swap(30, 33);
        list.display();

        list.swap(50, 10);
        list.display();


        System.out.println("DoublyEndedLinkedList");

        DoublyEndedLinkedList<Integer> dList = new DoublyEndedLinkedList<Integer>();
        dList.insertFirst(10);
        dList.insertFirst(20);
        dList.insertFirst(30);
        dList.insertLast(40);

        dList.display();

        dList.deleteFirst();

        System.out.println("SortedList");

        SortedList<Integer> sList = new SortedList<Integer>();
        sList.insert(20);
        sList.insert(10);
        sList.insert(15);
        sList.insert(42);

        sList.display();

        System.out.println("smallest: " + sList.remove());
        sList.display();

        sList.delete(20);
        sList.display();

        Integer f = sList.find(42);
        System.out.println("found: " + f);
    }
}
