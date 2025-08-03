public class QueueTests {

    // running: java -ea QueueTests
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>(5);

        assert queue.isEmpty();
        assert !queue.isFull();

        // cant remove
        try {
            queue.pop();
            assert false;
        } catch (Exception e) {}

        try {
            queue.peek();
            assert false;
        } catch (Exception e) {}

        queue.push("Leclerc");
        assert !queue.isEmpty();
        assert queue.peek().equals("Leclerc");
	assert queue.toString().equals("Leclerc");		

        queue.push("Hamilton");
        queue.push("Alonso");

	assert queue.toString().equals("Leclerc, Hamilton, Alonso");

        assert queue.size() == 3;

        // peek dont remove
        assert queue.peek().equals("Leclerc");
        assert queue.size() == 3;

        // pop remove
        assert queue.pop().equals("Leclerc");
        assert queue.peek().equals("Hamilton");
        assert queue.size() == 2;

        queue.push("Piastri");
        queue.push("Norris");

        assert !queue.isFull();

        queue.push("Russell");
        assert queue.isFull();

        // try push, isFull
        try {
            queue.push("Sainz");
            assert false;
        } catch (Exception e) {}

	// contains and indexOf
        assert queue.contains("Piastri");
        assert !queue.contains("Gasly");

        assert queue.indexOf("Hamilton") == 0;
        assert queue.indexOf("Russell") == 4;
        assert queue.indexOf("Gasly") == -1;

        assert queue.size() == 5;
        queue.pop();
        assert queue.size() == 4;

        queue.peek(); //no change
        assert queue.size() == 4;

        queue.clear();
        assert queue.isEmpty();
        assert queue.size() == 0;

        // clear queue, can push
        queue.push("Verstappen");
        assert !queue.isEmpty();
        assert queue.peek().equals("Verstappen");

        System.out.println("all tests passed successfully");

    }
}

