package diff.linkedlist;

public class LinkedListIntersection {
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

    private static int length(Node head) {
        var c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    /**
     * Intersection means there are two same Node object
     *
     * O(m + n) time
     * O(1) memory
     */
    private static Node intersection(Node first, Node second) {
        if (first == null || second == null) {
            return null;
        }

        var firstLength = length(first);
        var secondLength = length(second);
        if (firstLength > secondLength) {
            first = moveForward(first, firstLength - secondLength);
        } else {
            second = moveForward(second, secondLength - firstLength);
        }

        while (first != null && second != null) {
            if (first == second) {
                return first;
            }
            first = first.next;
            second = second.next;
        }

        return null;
    }

    private static Node moveForward(Node head, int n) {
        var resHead = head;
        while (n-- > 0) {
            resHead = resHead.next;
        }
        return resHead;
    }

    public static void main(String[] args) {
        var n6 = push(null, 29);
        var n5 = push(n6, 23);
        var n4 = push(n5, 11);
        var n3 = push(n4, 82);
        var n2 = push(n3, 33);
        var n1 = push(n2, 56);

        var n21 = push(n4, 14);

        display(n1);
        display(n21);

        Node n;
        if ((n = intersection(n1, n21)) != null) {
            System.out.println(n.item);
        }
    }
}
