package hashmap;

import java.util.Objects;

public class HashMap<K, V> {

    private  int SIZE = 0;
    private  int CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private Node<K, V>[] buckets;


    //to get the index
    private int getIndex(K key) {

        if (Objects.isNull(key)) {
            throw new NullPointerException("null not allowed");
        }
        int hashCode = key.hashCode();
        return hashCode & (CAPACITY - 1);
    }

    //to check the load factor have reached its capacity
    private boolean isLoadFactorReached() {
        return SIZE > CAPACITY * DEFAULT_LOAD_FACTOR;
    }


    //put method
    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new NullPointerException("null key not allowed");
        }
        int index = getIndex(key);
        Node<K, V> curr = buckets[index];

        while (curr != null) {
            if (key.equals(curr.key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;

        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        SIZE++;

        if (isLoadFactorReached()) restructure();
    }


    //if threshold reached then restructure the entier bucket
    private void restructure() {

        int oldCapacity = CAPACITY;
        Node<K, V>[] oldBuckets = buckets;

        CAPACITY = CAPACITY * 2;
        buckets = (Node<K, V>[]) new Node[CAPACITY];

        for (int i = 0; i < oldCapacity; i++) {

            Node<K, V> curr = oldBuckets[i];

            while (curr != null) {

                Node<K, V> next = curr.next;

                int index = getIndex(curr.key);

                curr.next = buckets[index];
                buckets[index] = curr;

                curr = next;
            }
        }
    }


}


