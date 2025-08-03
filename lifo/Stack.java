public class Stack<E>{
	
	private E[] stack;
	private int top;
	private static final int DEFAULT_CAPACITY = 20;
	
	public Stack(){
		this(DEFAULT_CAPACITY);
	}

	public Stack(int capacity){
		this.stack = (E[]) new Object[capacity];
		this.top = -1;
	}

	public boolean isFull(){
		return this.top == stack.length - 1;
	}

	public boolean isEmpty(){
		return this.top == -1;
	}

	public int size(){
		return this.top + 1;
	}

	public void push(E element){
		if (this.isFull())
			throw new IllegalStateException("Full stack");
		
		this.stack[++top] = element;
	}

	public E pop(){
		if (this.isEmpty())
			throw new IllegalStateException("Empty stack");
		return this.stack[top--];
	}

	public E peek(){
		if (this.isEmpty())
			throw new IllegalStateException("Empty stack");	
		return this.stack[top];
	}

	public void clear(){
		this.top = -1;
	}

	public boolean contains(E element){
		return this.indexOf(element) != -1;
	} 
	
	//dont use index
	public int indexOf(E element){
		Stack<E> aux = new Stack(this.size());;
		
		int index = -1;

		while (!this.isEmpty()){

			if (this.peek().equals(element)){
				index = this.size() - 1;
				break;
			}

			aux.push(this.pop());
		}

		while(!aux.isEmpty())
			this.push(aux.pop());

		return index;

	}

	public String toString(){
		Stack<E> aux = new Stack(this.size());
		
		String output = "";
		while(!this.isEmpty()){

			E current = this.pop();

			if (aux.isEmpty()) output += current.toString();
			else output = current.toString() + ", " + output;

			aux.push(current);
		}

		while(!aux.isEmpty())
			this.push(aux.pop());
		
		return output;

	}

}
