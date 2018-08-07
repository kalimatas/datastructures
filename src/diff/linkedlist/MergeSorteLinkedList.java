package diff.linkedlist;

public class MergeSorteLinkedList {
    private static class Node {
        int item;
        Node next;

        Node(int e) { item = e; }
    }

    private static Node push(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        Node head;

        head = push(null, 60);
        head = push(head, 50);
        head = push(head, 40);
        head = push(head, 30);
        head = push(head, 20);

        Node head2 = push(null, 70);
        head2 = push(head2, 55);
        head2 = push(head2, 44);
        head2 = push(head2, 28);

        display(head);
        display(head2);

        Node headMerged = merge(head, head2);
        display(headMerged);
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node headMerged, tailMerged;
        if (head1.item < head2.item) {
            headMerged = head1;
            head1 = head1.next;
        } else {
            headMerged = head2;
            head2 = head2.next;
        }

        tailMerged = headMerged;
        while (head1 != null && head2 != null) {
            if (head1.item < head2.item) {
                tailMerged.next = head1;
                tailMerged = head1;
                head1 = head1.next;
            } else {
                tailMerged.next = head2;
                tailMerged = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            tailMerged.next = head1;
        }

        if (head2 != null) {
            tailMerged.next = head2;
        }

        return headMerged;
    }

    private static void display(Node head) {
        while (head != null) {
            System.out.printf("%d ", head.item);
            head = head.next;
        }
        System.out.println();
    }
}
