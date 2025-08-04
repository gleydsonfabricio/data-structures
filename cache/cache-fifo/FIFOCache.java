public class FIFOCache<T>{

	private Queue<T> cache;

	public FIFOCache(int capacity){
		this.cache = new Queue<>(capacity);
	}

	public boolean isEmpty(){
		return cache.isEmpty();
	}

	public boolean isFull(){
		return cache.isFull();
	}

	public void add(T element){
	
		if (isFull())
			cache.pop();

		cache.push(element);
	}

	public T remove(){
		return cache.pop();
	}

	public T getFirst(){
		return cache.peek();
	}

	public T getLast(){
		return cache.getLast();
	}

	public boolean contains(T element){
		return cache.contains(element);
	}

	public String toString(){
		return cache.toString();
	}

	public int size(){
		return cache.size();
	}

}
