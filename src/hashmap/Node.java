package hashmap;

public class Node<K, V> {

    Node<K, V> next;
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }



}
