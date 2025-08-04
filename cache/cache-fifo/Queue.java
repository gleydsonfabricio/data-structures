public class Queue<E>{
	
	private E[] queue;
	private int head;
	private int tail;
	private int size;
	private static final int DEFAULT_CAPACITY = 20;
	
	public Queue(){
		this(DEFAULT_CAPACITY);
	}

	public Queue(int capacity){
		this.queue = (E[]) new Object[capacity];
		this.head = -1;
		this.tail = -1;
	}

	public boolean isFull(){
		return this.size == queue.length;
	}

	public boolean isEmpty(){
		return this.head == -1;
	}

	public int size(){
		return this.size;
	}

	public void push(E element){

		if (this.isFull())
			throw new IllegalStateException("Full queue");
		
		if (this.isEmpty()) 
			this.head = this.tail = 0;
		else
			this.tail = (this.tail + 1) % queue.length;

		this.queue[this.tail] = element;
		this.size++;

	}

	public E pop(){

		if (this.isEmpty())
			throw new IllegalStateException("Empty queue");
			
		E toRemove = this.queue[head];
		
		if (head == tail)
			this.head = this.tail = -1;
		else
			this.head = (this.head + 1) % queue.length;
		
		this.size--;
		return toRemove;

	}

	public E peek(){
		if (this.isEmpty())
			throw new IllegalStateException("Empty queue");

		return this.queue[this.head];
	}

	public E getLast(){
		if (this.isEmpty())
			throw new IllegalStateException("Empty queue");

		return this.queue[this.tail];	
	}

	public void clear(){
		this.size = 0;
		this.head = this.tail = -1;
	}

	public boolean contains(E element){
		return this.indexOf(element) != -1;
	} 
	
	//using queue aux
	public int indexOf(E element){
		
		Queue<E> aux = new Queue(this.size());
		
		int index = -1;

		while (!this.isEmpty()){
			E current = this.pop();
			if (index == -1 && current.equals(element))
				index = aux.size();

			aux.push(current);
		}

		while (!aux.isEmpty())
			this.push(aux.pop());

		return index;

	}

	public String toString(){
		
		Queue<E> aux = new Queue(this.size());
		
		String output = "";

		while (!this.isEmpty()){
			E current = this.pop();
			
			if (!aux.isEmpty()) output += ", "; 
			output += current.toString();

			aux.push(current);
		}

		while (!aux.isEmpty())
			this.push(aux.pop());

		return output;

	}

}
