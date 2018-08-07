package diff.linkedlist;

public class MergeSortedLinkedList {
    private static class Pair<T> {
        T first;
        T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

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

        head = mergeSort(head);
        display(head);
    }

    private static Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // sort each half separately
        Pair<Node> firstSecond = new Pair<>(null, null);
        splitInHalf(head, firstSecond);

        firstSecond.first = mergeSort(firstSecond.first);
        firstSecond.second = mergeSort(firstSecond.second);

        // merge sorted halves
        return merge(firstSecond.first, firstSecond.second);
    }

    private static void splitInHalf(Node head, Pair<Node> firstSecond) {
        if (head == null) return;

        if (head.next == null) {
            firstSecond.first = head;
            firstSecond.second = null;
        } else {

            // find the middle
            Node slow, fast;
            slow = head;
            fast = head.next;

            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }

            firstSecond.first = head;
            firstSecond.second = slow.next;

            // terminate first list
            slow.next = null;
        }
    }

    /**
     * O(m + n) time
     * O(1) memory
     */
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
