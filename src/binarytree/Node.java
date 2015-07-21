package binarytree;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> leftChild;
    Node<K, V> rightChild;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
