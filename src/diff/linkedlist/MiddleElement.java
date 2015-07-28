package diff.linkedlist;

public class MiddleElement {
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
        //head = push(head, 60);

        System.out.printf("%d \n", middleV2(head));
    }

    static int middle(Node head) {
        if (head == null) return -1;

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.item;
    }

    // increment only if count is odd
    static int middleV2(Node head) {
        int count = 0;
        Node mid = head;

        while (head != null) {
            if ((count & 1) == 1)
                mid = mid.next;

            count++;
            head = head.next;
        }

        return mid.item;
    }
}
