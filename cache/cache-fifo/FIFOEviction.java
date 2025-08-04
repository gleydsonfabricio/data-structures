public class FIFOEviction<T>{
	
	private FIFOCache<T> cache;

	public FIFOEviction(int capacity){
		this.cache = new FIFOCache(capacity);
	}

	public String get(T element){
		
		if (cache.contains(element))
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
