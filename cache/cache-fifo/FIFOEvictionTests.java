public class FIFOEvictionTests {

    // run with: java -ea FIFOEvictionTests
    public static void main(String[] args) {
        
        FIFOEviction<String> fifo = new FIFOEviction<>(3);

        assert fifo.size() == 0;

        // First accesses are MISS
        assert fifo.get("A").equals("MISS");
        assert fifo.get("B").equals("MISS");
        assert fifo.get("C").equals("MISS");

        assert fifo.size() == 3;

        // Now A, B, and C are cached
        assert fifo.get("A").equals("HIT");
        assert fifo.get("B").equals("HIT");
        assert fifo.get("C").equals("HIT");

        // D is not in the cache → MISS
        assert fifo.get("D").equals("MISS");

        // Since capacity is 3, now D was added and A should be evicted
        // So D, B, C are now in the cache (A was first in, and got removed)
        assert fifo.getNextEviction().equals("B"); // B is the next to be evicted

        // Accessing an element already present is still a HIT
        assert fifo.get("C").equals("HIT");

        // Add E → should evict B
        assert fifo.get("E").equals("MISS");
        assert fifo.getNextEviction().equals("C");

        // Add F → should evict C
        assert fifo.get("F").equals("MISS");
        assert fifo.getNextEviction().equals("D");

        // Add G → should evict D
        assert fifo.get("G").equals("MISS");
        assert fifo.getNextEviction().equals("E");

        System.out.println("All FIFO eviction tests passed!");
    }
}

