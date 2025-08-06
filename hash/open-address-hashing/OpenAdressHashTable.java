public class OpenAdressHashTable{

	private Pair[] table;
	private static final int DEFAULT_SIZE = 53;
	private static final Pair deleted = new Pair(-1, "xDELETEDx");
	private int size;

	public OpenAdressHashTable(){
		this.table = new Pair[DEFAULT_SIZE];
	}

	private int hash(int key){
		return key % DEFAULT_SIZE;
	}

	public int size(){
		return this.size;
	}
	
	public void put(int key, String value){
		
		Pair newPair = new Pair(key, value);
		
		int probing = 0;
		int hash;
		while(probing < DEFAULT_SIZE){
			
			hash = hash(key + probing);

			if (table[hash] == null || table[hash].equals(deleted)){
				table[hash] = newPair;
				size++;
				return;
			}
			else if (table[hash].equals(newPair)){
				table[hash] = newPair;
				return;
			}

			probing++;

		}

	}

	public String get(int key){
		
		int probing = 0;
		int hash;

		while (probing < DEFAULT_SIZE){
			
			hash = hash(key + probing);

			if (table[hash] == null) return null;
			else if (table[hash].key == key) return table[hash].value;

			probing++;

		}
		
		return null;

	}
	
	public String remove(int key){
		
		int probing = 0;
		int hash;

		while(probing < DEFAULT_SIZE){
			hash = hash(key + probing);

			if (table[hash] == null) return null;
			else if (table[hash].key == key){			
				String out = table[hash].value;
				table[hash] = deleted;
				this.size--;
				return out;
			}
			
			probing++;
		}

		return null;

	}

	public boolean containsKey(int key){
		
		int hash;
		int probing = 0;
		while (probing < DEFAULT_SIZE){
			hash = hash(key + probing);

			if (table[hash] == null) return false;
			else if (table[hash].key == key) return true;

			probing++;
		}

		return false;

	}

	public boolean containsValue(String value){
		
		for (Pair pair: table)
			if (pair != null && pair.value.equals(value))
				return true;

		return false;

	}

}


class Pair{

	int key;
	String value;

	public Pair(int key, String value){
		this.key = key;
		this.value = value;
	}

	public boolean equals(Pair pair){
		return pair.key == this.key;
	}

}
