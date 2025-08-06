import java.util.ArrayList;

public class ClosedAdressHashTable{

	private ArrayList<Pair>[] table;
	private int DEFAULT_SIZE = 53;

	public ClosedAdressHashTable(){
		this.table = new ArrayList[DEFAULT_SIZE];
	}

	public int hash(int key){
		return key % DEFAULT_SIZE;
	}

	public void put(int key, String value){

		Pair newPair = new Pair(key, value);
		int hash = hash(key);

		if (table[hash] == null)
			table[hash] = new ArrayList<>();

		// if contains key, replace
		for (int i = 0; i < table[hash].size(); i++){
			if (table[hash].get(i).equals(newPair)){
				table[hash].set(i, newPair);
				return;
			}
		}
		
		//case dont contains key
		table[hash].add(newPair);
	}

	public String get(int key){
		
		int hash = hash(key);

		if (table[hash] == null) return null;
		
		for (Pair pair: table[hash])
			if (pair.key == key) return pair.value;

		return null;

	}

	public String remove(int key){
		
		int hash = hash(key);

		if (table[hash] == null) return null;

		for (int i = 0; i < table[hash].size(); i++){			
			if (table[hash].get(i).key == key)
				return table[hash].remove(i).value;

		}

		return null;

	}

	public boolean containsKey(int key){
		
		int hash = hash(key);

		if (table[hash] == null) return false;

		for (Pair pair: table[hash])
			if (pair.key == key) return true;

		return false;

	}

	public boolean containsValue(String value){
		
		for (ArrayList<Pair> pairs: table)
			if (pairs != null)
				for (Pair pair: pairs)
					if (pair.value.equals(value))
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

	public boolean equals(Pair p){
		return p.key == this.key;
	}

}
