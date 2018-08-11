package diff.linkedlist;

public class ReverseEven {
    private static class Node {
        int item;
        Node next;

        Node(int e) {
            item = e;
        }
    }

    private static Node push(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        Node head;

        head = push(null, 28);
        head = push(head, 50);
        head = push(head, 42);
        head = push(head, 74);
        head = push(head, 56);
        head = push(head, 18);

        display(head);

        display(reverseEven(head));
    }

    /**
     * O(n) time
     * O(1) memory
     */
    private static Node reverseEven(Node head) {
        Node current = head;
        Node evenHead = null;
        while (current != null && current.next != null) {
            Node even = current.next;
            current.next = even.next;
            even.next = evenHead;
            evenHead = even;
            current = current.next;
        }

        return mergeAlternating(head, evenHead);
    }

    private static Node mergeAlternating(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node merged = head1;
        while (head1.next != null && head2 != null) {
            Node tmp = head2;
            head2 = head2.next;

            tmp.next = head1.next;
            head1.next = tmp;
            head1 = tmp.next;
        }

        if (head1.next == null) {
            head1.next = head2;
        }

        return merged;
    }

    private static void display(Node head) {
        while (head != null) {
            System.out.printf("%d ", head.item);
            head = head.next;
        }
        System.out.println();
    }
}
