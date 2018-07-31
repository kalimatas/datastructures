package diff.linkedlist;

public class Reverse {
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

        Node tmp = head;
        while (tmp != null) {
            System.out.printf("%d ", tmp.item);
            tmp = tmp.next;
        }

        //head = reverse(head);
        head = reverseRecursive(head);

        System.out.println();
        tmp = head;
        while (tmp != null) {
            System.out.printf("%d ", tmp.item);
            tmp = tmp.next;
        }
    }

    static Node reverse(Node head) {
        Node prev = null, current, next = null;
        current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node reversed = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return reversed;
    }
}
