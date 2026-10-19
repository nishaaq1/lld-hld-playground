package hashmap;



public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        System.out.println("===== 1. PUT =====");
        map.put(1, "CLAIM_A");
        map.put(17, "CLAIM_B"); // Collision at capacity 16
        map.put(33, "CLAIM_C"); // Same initial bucket

        System.out.println("Inserted 3 entries");

        System.out.println("\n===== 2. GET =====");
        System.out.println("Key 1: " + map.get(1));
        System.out.println("Key 17: " + map.get(17));
        System.out.println("Key 33: " + map.get(33));
        System.out.println("Key 99: " + map.get(99)); // Missing key

        System.out.println("\n===== 3. UPDATE EXISTING KEY =====");
        map.put(17, "CLAIM_B_UPDATED");
        System.out.println("Key 17: " + map.get(17));

        System.out.println("\n===== 4. REMOVE =====");
        System.out.println("Removed key 1: " + map.remove(1));
        System.out.println("Key 1 after removal: " + map.get(1));
        System.out.println("Key 33 still exists: " + map.get(33));

        System.out.println("\n===== 5. RESIZING =====");

        // Insert enough distinct keys to cross
        // the initial threshold of 12.
        for (int i = 100; i < 115; i++) {
            map.put(i, "VALUE_" + i);
        }

        System.out.println("Key 100 after resizing: " + map.get(100));
        System.out.println("Key 114 after resizing: " + map.get(114));
        System.out.println("Key 17 after resizing: " + map.get(17));

        System.out.println("\n===== 6. REMOVE MISSING KEY =====");
        System.out.println("Removed key 999: " + map.remove(999));

        System.out.println("\n===== 7. INDEPENDENT MAP INSTANCES =====");
        HashMap<Integer, String> secondMap = new HashMap<>();
        secondMap.put(500, "SECOND_MAP_VALUE");

        System.out.println("First map, key 500: " + map.get(500));
        System.out.println("Second map, key 500: " + secondMap.get(500));

        System.out.println("\n===== TESTS COMPLETED =====");
    }
}
