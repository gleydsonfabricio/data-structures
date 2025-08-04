public class LinkedListTests {

    // run with: java -ea LinkedListTests
    public static void main(String[] args) {
        
        LinkedList<String> list = new LinkedList<>();

        assert list.isEmpty();
        assert list.size() == 0;

        // push appends elements to the end
        list.push("Leclerc");
        list.push("Hamilton");
        list.push("Alonso");

        assert !list.isEmpty();
        assert list.size() == 3;
        assert list.toString().equals("Leclerc, Hamilton, Alonso");

        // set replaces value at index
        list.set(1, "Verstappen");
        assert list.toString().equals("Leclerc, Verstappen, Alonso");

        // set out of bounds
        try {
            list.set(10, "Sainz");
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        // add at index (middle)
        list.add(1, "Gasly");
        assert list.toString().equals("Leclerc, Gasly, Verstappen, Alonso");
        assert list.size() == 4;

        // add at index 0 (head)
        list.add(0, "Norris");
        assert list.toString().equals("Norris, Leclerc, Gasly, Verstappen, Alonso");
        assert list.size() == 5;

        // add out of bounds
        try {
            list.add(10, "Russell");
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        // remove by index
        assert list.remove(2).equals("Gasly"); // remove "Gasly"
        assert list.toString().equals("Norris, Leclerc, Verstappen, Alonso");
        assert list.size() == 4;

        // remove first
        assert list.removeFirst().equals("Norris");
        assert list.toString().equals("Leclerc, Verstappen, Alonso");
        assert list.size() == 3;

        // remove last
        assert list.removeLast().equals("Alonso");
        assert list.toString().equals("Leclerc, Verstappen");
        assert list.size() == 2;

        // remove index out of bounds
        try {
            list.remove(10);
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        // remove from empty list
        list.clear();
        try {
            list.removeFirst();
            assert false;
        } catch (Exception e) {}

        try {
            list.removeLast();
            assert false;
        } catch (Exception e) {}

        // addFirst
        list.addFirst("Albon");
        list.addFirst("Piastri");
        assert list.toString().equals("Piastri, Albon");

        // removeByValue
        list.push("Magnussen");
        list.push("Bottas");
        list.push("Zhou");

        assert list.toString().equals("Piastri, Albon, Magnussen, Bottas, Zhou");

        list.removeByValue("Albon");
        assert list.toString().equals("Piastri, Magnussen, Bottas, Zhou");

        list.removeByValue("Piastri");
        assert list.toString().equals("Magnussen, Bottas, Zhou");

        list.removeByValue("Zhou");
        assert list.toString().equals("Magnussen, Bottas");

        list.removeByValue("Ricciardo"); // not in list, should do nothing
        assert list.toString().equals("Magnussen, Bottas");

        // contains and indexOf
        assert list.contains("Bottas");
        assert !list.contains("Russell");

        assert list.indexOf("Bottas") == 1;
        assert list.indexOf("Magnussen") == 0;
        assert list.indexOf("Russell") == -1;

        // clear
        list.clear();
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.toString().equals("");

        System.out.println("All tests passed!");
    }
}

