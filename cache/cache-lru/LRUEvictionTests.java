public class LRUEvictionTests {

    // run with: java -ea LRUEvictionTests
    public static void main(String[] args) {
        
        LRUEviction<String> lru = new LRUEviction<>(3);

        assert lru.size() == 0;

        // First accesses → all are MISS
        assert lru.get("A").equals("MISS"); // cache: A
        assert lru.get("B").equals("MISS"); // cache: A, B
        assert lru.get("C").equals("MISS"); // cache: A, B, C

        assert lru.size() == 3;

        // Now A, B, C are cached
        assert lru.get("A").equals("HIT"); // A becomes most recently used (MRU)
        assert lru.get("B").equals("HIT"); // B becomes MRU

        // Add D → should evict **C** (least recently used)
        assert lru.get("D").equals("MISS"); // cache: A, B, D (C evicted)
        assert lru.getNextEviction().equals("A"); // A is now LRU

        // Access A → becomes MRU again
        assert lru.get("A").equals("HIT"); // cache order: B, D, A
        assert lru.getNextEviction().equals("B");

        // Add E → should evict B
        assert lru.get("E").equals("MISS"); // cache: D, A, E
        assert lru.getNextEviction().equals("D");

        // Add F → evicts D
        assert lru.get("F").equals("MISS"); // cache: A, E, F
        assert lru.getNextEviction().equals("A");

        // HIT on E
        assert lru.get("E").equals("HIT"); // E becomes MRU
        assert lru.getNextEviction().equals("A");

        // Add G → evict A
        assert lru.get("G").equals("MISS"); // cache: F, E, G
        assert !lru.get("A").equals("HIT"); // A was evicted earlier

        System.out.println("All LRU eviction tests passed!");
    }
}

