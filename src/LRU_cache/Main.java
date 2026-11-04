package LRU_cache;

public class Main {

    public static void main(String[] arg) {
        Cache<Integer, Integer> cache = new Cache<>(3);

        cache.put(1, 100);
        cache.put(2, 100);
        cache.put(3, 100);

        cache.printCache();
        cache.put(4, 100);
        cache.printCache();
    }
}
