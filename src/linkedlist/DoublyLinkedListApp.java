package linkedlist;

public class DoublyLinkedListApp {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        //list.insertFirst(10);
        //list.insertFirst(20);
        //list.insertFirst(13);

        list.insertLast(25);
        list.deleteKey(25);
        //list.insertLast(33);

        list.displayForward();
        list.displayBackward();

        list.insertAfter(13, 14);
        list.displayForward();

        list.insertAfter(33, 34);
        list.displayForward();

        System.out.println("first: " + list.deleteFirst());
        list.displayForward();

        System.out.println("last: " + list.deleteLast());
        list.displayForward();
    }
}
