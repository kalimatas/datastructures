package diff.linkedlist;

public class LinkedListInsertionSort {
    private static class Node {
        int item;
        Node next;

        Node(int e) { item = e; }
    }

    private static Node push(Node head, int data) {
        var node = new Node(data);
        node.next = head;
        return node;
    }

    private static void display(Node head) {
        while (head != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * O(n^2) time
     * O(1) memory
     */
    private static Node insertionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node resHead = null;
        while (head != null) {
            Node current = head;
            head = head.next;
            if (resHead == null || resHead.item > current.item) {
                // first element
                current.next = resHead;
                resHead = current;
            } else {
                Node p = resHead;
                while (p != null) {
                    // last elem of sorted list of middle of the the list
                    if (p.next == null || current.item < p.next.item) {
                        current.next = p.next;
                        p.next = current;
                        break;
                    }
                    p = p.next;
                }
            }
        }

        return resHead;
    }

    public static void main(String[] args) {
        Node head, last;

        last = push(null, 29);
        head = push(last, 23);
        head = push(head, 11);
        head = push(head, 82);

        display(head);
        Node sortedHead = insertionSort(head);
        display(sortedHead);
    }
}
