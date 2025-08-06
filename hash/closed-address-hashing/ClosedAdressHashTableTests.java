public class ClosedAdressHashTableTests {

    public static void main(String[] args) {

        ClosedAdressHashTable table = new ClosedAdressHashTable();

        // put and get
        table.put(1, "Max Verstappen");
        assert table.get(1).equals("Max Verstappen");

        // overwrite value
        table.put(1, "Sergio Pérez");
        assert table.get(1).equals("Sergio Pérez");

        // collision: 54 % 53 == 1, mesma posição que o número 1
        table.put(54, "Lewis Hamilton");
        assert table.get(1).equals("Sergio Pérez");
        assert table.get(54).equals("Lewis Hamilton");

        // non-existing key
        assert table.get(44) == null;

        // containsKey
        assert table.containsKey(1);
        assert table.containsKey(54);
        assert !table.containsKey(63);

        // containsValue
        assert table.containsValue("Sergio Pérez");
        assert table.containsValue("Lewis Hamilton");
        assert !table.containsValue("Charles Leclerc");

        // remove
        assert table.remove(1).equals("Sergio Pérez");
        assert table.get(1) == null;
        assert !table.containsKey(1);

        // remove non-existing key
        assert table.remove(16) == null;

        System.out.println("✅ All ClosedAdressHashTable tests passed!");
    }
}

