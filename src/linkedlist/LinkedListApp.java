package linkedlist;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
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
    }
}
