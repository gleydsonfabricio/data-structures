public class LRUEviction<T>{
	
	private LRUCache<T> cache;

	public LRUEviction(int capacity){
		this.cache = new LRUCache(capacity);
	}

	public String get(T element){
		
		if (cache.get(element) != null)
			return "HIT";
		
		cache.add(element);
		return "MISS";

	}
	
	//if isFull, remove first add
	public T getNextEviction(){
		return cache.isFull() ? cache.getFirst() : null;
	}

	public int size(){
		return cache.size();
	}

}
