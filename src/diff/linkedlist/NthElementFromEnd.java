package diff.linkedlist;

public class NthElementFromEnd {
    private static class Node {
        int item;
        Node next;

        Node(int e) { item = e; }
    }

    static Node push(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        Node head;

        head = push(null, 10);
        head = push(head, 20);
        head = push(head, 30);
        head = push(head, 40);
        head = push(head, 50);
        head = push(head, 60);

        System.out.printf("2: %d \n", nthFromEnd(head, 2));
        System.out.printf("7: %d \n", nthFromEnd(head, 7));
        System.out.printf("5: %d \n", nthFromEnd(head, 5));
    }

    static int nthFromEnd(Node head, int n) {
        Node first = head, second = head;
        int count = 0;

        while (count < n) {
            if (first == null) return -1;
            first = first.next;
            count++;
        }

        // move both pointers
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.item;
    }
}
