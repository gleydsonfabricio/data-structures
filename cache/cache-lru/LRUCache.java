public class LRUCache<T>{

	private LinkedList<T> cache;
	private int capacity;

	public LRUCache(int capacity){
		this.cache = new LinkedList<>();
		this.capacity = capacity;
	}

	public boolean isEmpty(){
		return cache.isEmpty();
	}

	public boolean isFull(){
		return cache.size() >= capacity;
	}

	public void add(T element){
	
		if (isFull())
			cache.removeFirst();

		cache.push(element);

	}

	public T get(T element){
		
		Node<T> node = cache.getNode(element);

		if (node != null)
			cache.moveToTail(node);

		return node == null ? null : node.value;

	}

	public T remove(){
		return cache.removeFirst();
	}

	public T getFirst(){
		return cache.getFirst();
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
