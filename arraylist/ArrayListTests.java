public class ArrayListTests {

    // run with: java -ea ArrayListTests
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>(3);

        assert list.isEmpty();
        assert list.size() == 0;

        // push adds to the end
        list.push("Leclerc");
        list.push("Hamilton");
        list.push("Alonso");

        assert !list.isEmpty();
        assert list.size() == 3;
        assert list.toString().equals("Leclerc, Hamilton, Alonso");

        // set replaces existing value
        list.set(1, "Verstappen");
        assert list.toString().equals("Leclerc, Verstappen, Alonso");

        // set out of bounds
        try {
            list.set(5, "Sainz");
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        // add at middle position
        list.add(1, "Gasly"); // inserts at index 1
        assert list.size() == 4;
        assert list.toString().equals("Leclerc, Gasly, Verstappen, Alonso");

        // add out of bounds
        try {
            list.add(10, "Russell");
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        // remove by index
        String removed = list.remove(2); // removes "Verstappen"
        assert removed.equals("Verstappen");
        assert list.size() == 3;
        assert list.toString().equals("Leclerc, Gasly, Alonso");

        // remove by value
        list.removeByValue("Gasly");
        assert list.toString().equals("Leclerc, Alonso");
        assert list.size() == 2;

        // remove non-existent value → should do nothing
        list.removeByValue("Ricciardo");
        assert list.size() == 2;

        // removeLast
        assert list.removeLast().equals("Alonso");
        assert list.toString().equals("Leclerc");

        // contains and indexOf
        assert list.contains("Leclerc");
        assert !list.contains("Sainz");

        assert list.indexOf("Leclerc") == 0;
        assert list.indexOf("Gasly") == -1;

        // clear the list
        list.clear();
        assert list.isEmpty();
        assert list.size() == 0;

        // test resizing
        for (int i = 0; i < 25; i++) {
            list.push("Item" + i);
        }
        assert list.size() == 25;
        assert list.toString().startsWith("Item0, Item1, Item2");

        System.out.println("All tests passed!");
    }
}

