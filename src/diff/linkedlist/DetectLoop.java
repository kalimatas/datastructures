package diff.linkedlist;

public class DetectLoop {
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
        Node head, last;

        last = push(null, 10);
        head = push(last, 20);
        head = push(head, 30);
        head = push(head, 40);
        head = push(head, 50);
        head = push(head, 60);
        last.next = head;

        System.out.printf("%s ", hasLoop(head));
    }

    static boolean hasLoop(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) return true;
        }

        return false;
    }
}
