package LRU_cache;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {

    private final Node<K, V> head;
    private final Node<K, V> tail;

    private final int CAPACITY;
    private final Map<K, Node<K, V>> map;

    public Cache(int CAPACITY) {
        if (CAPACITY <= 0) throw new RuntimeException("Negative values not allowed");
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.CAPACITY = CAPACITY;
        this.map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node<K, V> node) {
        //you have only the node and their prev and next to remove the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node<K, V> node) {
        //focus on head and new node adding next to head
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node<K, V> val = map.get(key);
        remove(val);
        addToHead(val);
        return val.value;
    }


    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            map.put(key, node);
            remove(node);
            addToHead(node);

        } else {
            Node<K, V> node = new Node<>(key, value);
            addToHead(node);
            map.put(key, node);
        }

        if (map.size() > CAPACITY) {
            Node<K, V> last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
    }


    public void printCache() {
        Node<K, V> current = head.next;

        System.out.print("HEAD -> ");

        while (current != tail) {
            System.out.print("[" + current.key + ":" + current.value + "] -> ");
            current = current.next;
        }

        System.out.println("TAIL");
    }
}
