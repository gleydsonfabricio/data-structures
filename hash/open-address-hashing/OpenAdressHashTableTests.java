public class OpenAdressHashTableTests {

    public static void main(String[] args) {

        OpenAdressHashTable table = new OpenAdressHashTable();

        // Put drivers
        table.put(1, "Max Verstappen");
        table.put(16, "Charles Leclerc");
        table.put(63, "George Russell");

        // Get drivers
        assert table.get(1).equals("Max Verstappen");
        assert table.get(16).equals("Charles Leclerc");
        assert table.get(63).equals("George Russell");

        // Replace a value (same number)
        table.put(1, "Sergio Pérez");
        assert table.get(1).equals("Sergio Pérez");

        // Get non-existing key
        assert table.get(77) == null;

        // Contains key
        assert table.containsKey(1);
        assert table.containsKey(16);
        assert !table.containsKey(44); // Lewis Hamilton not added

        // Contains value
        assert table.containsValue("Charles Leclerc");
        assert table.containsValue("Sergio Pérez");
        assert !table.containsValue("Lewis Hamilton");

        // Remove existing key
        String removed = table.remove(16);
        assert removed.equals("Charles Leclerc");
        assert table.get(16) == null;
        assert !table.containsKey(16);

        // Remove non-existing key
        assert table.remove(99) == null;

        // Add after delete (check reusability of deleted slots)
        table.put(16, "Oscar Piastri");
        assert table.get(16).equals("Oscar Piastri");

        System.out.println("✅ All Open Address Hash Table tests passed.");
    }
}

