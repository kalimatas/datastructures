package diff;

import java.util.HashMap;

public class LRUApp {

    private static class LRU {
        private static class Node {
            int key;
            int value;
            Node prev, next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        int capacity;
        Node head, tail;
        HashMap<Integer, Node> map = new HashMap<>();

        LRU(int capacity) {
            this.capacity = capacity;
        }

        void display() {
            Node current = head;
            while (current != null) {
                System.out.printf("%d ", current.value);
                current = current.next;
            }
            System.out.println();
        }

        int get(int key) {
            if (map.containsKey(key)) {
                Node tmp = map.get(key);
                remove(tmp);
                setHead(tmp);
                return tmp.value;
            }

            return -1;
        }

        void set(int key, int value) {
            if (map.containsKey(key)) {
                Node tmp = map.get(key);
                tmp.value = value;
                remove(tmp);
                setHead(tmp);
            } else {
                Node created = new Node(key, value);
                if (map.size() >= capacity) {
                    remove(tail);
                }
                setHead(created);
                map.put(key, created);
            }
        }

        private void remove(Node node) {
            if (node.prev == null)
                head = node.next;
            else
                node.prev.next = node.next;

            if (node.next == null)
                tail = node.prev;
            else
                node.next.prev = node.prev;
        }

        private void setHead(Node node) {
            if (tail == null)
                tail = node;
            else
                head.prev = node;

            node.next = head;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU(4);

        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);

        cache.display();

        cache.get(3);

        cache.display();

        cache.set(5, 5);

        cache.display();
    }
}
