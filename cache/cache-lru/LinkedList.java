import java.util.NoSuchElementException;

public class LinkedList<T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	//dont need
	public LinkedList(){
		this.tail = null;
		this.head = null;
		this.size = 0;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.head == null;
	}
	
	public T getFirst(){

		if (isEmpty())
			throw new NoSuchElementException();

		return head.value;
	}

	public T getLast(){

		if (isEmpty())
			throw new NoSuchElementException();
		
		return tail.value;
	}

	public void push(T element){
		
		Node<T> newNode = new Node(element);

		if (isEmpty()){
			this.head = newNode;
			this.tail = newNode;
		}
		else{
			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
		}

		size++;

	}

	public void set(int index, T element){
		
		checkIndex(index);

		Node<T> node = this.getNode(index);
		node.value = element;
	}

	public void add(int index, T element){

		checkIndex(index);

		if (index == 0) {addFirst(element); return;}
		
		Node<T> newNode = new Node(element);
		Node<T> nextNode = this.getNode(index);
		
		newNode.next = nextNode;
		newNode.prev = nextNode.prev;
		nextNode.prev = newNode;
		newNode.prev.next = newNode;

		size++;

	}

	public T remove(int index){
		
		checkIndex(index);

		if (isEmpty())
			throw new NoSuchElementException();
		
		if (index == 0) return removeFirst();

		if (index == this.size() - 1) return removeLast();

		Node<T> node = getNode(index);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		size--;
		return node.value;
		
	}

	public T removeLast(){
		
		if (isEmpty())
			throw new NoSuchElementException();
		
		Node<T> removed = tail;

		if (this.size() == 1)
			head = tail = null;
		else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}

		size--;
		return removed.value;

	}

	public T removeFirst(){
		if (isEmpty())
			throw new NoSuchElementException();
		
		Node<T> removed = head;

		if (this.size() == 1)
			head = tail = null;
		else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		
		size--;
		return removed.value;

	}

	public void addFirst(T element){
		Node<T> newNode = new Node(element);
		
		if (isEmpty()){
			this.head = newNode;
			this.tail = newNode;
		} else{
			this.head.prev = newNode;
			newNode.next = this.head;
			this.head = this.head.prev;
		}

		size++;

	}

	public void removeByValue(T element){
		
		Node<T> aux = head;
		while (aux != null && !aux.value.equals(element))
			aux = aux.next;	
		
		if (aux == null) return;
		if (aux == head){ removeFirst(); return; }
		if (aux == tail){ removeLast(); return; }

		aux.prev.next = aux.next;
		aux.next.prev = aux.prev;
		size--;

	}

	public int indexOf(T element){
			
		Node<T> aux = head;
		
		for (int i = 0; i < this.size(); i++){

			if (aux.value.equals(element))
				return i;

			aux = aux.next;
		}

		return -1;
		
	}

	public boolean contains(T element){
		return this.indexOf(element) != -1;
	}

	public void clear(){
		this.head = tail = null;
		this.size = 0;
	}
	
	public String toString(){
		
		if (isEmpty()) return "";	

		String output = "";

		Node<T> aux = head;
		while(aux != null){
			output += aux.value.toString() + ", ";	
			aux = aux.next;
		}

		return output.substring(0, output.length() - 2);
		
	}

	private Node<T> getNode(int index){
		
		checkIndex(index);

		Node<T> aux = head;

		for (int i = 0; i < index; i++)
			aux = aux.next;
		
		return aux;

	}

	private void checkIndex(int index){
		if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
	}

	
	public Node<T> getNode(T element){
		
		Node<T> aux = head;

		while (aux != null && !aux.value.equals(element))
			aux = aux.next;

		return aux;

	}

	public void moveToTail(Node<T> node){
		
		if (node == tail) return;

		if (node == head){
			head = node.next;
			node.next.prev = null;
		}

		tail.next = node;
		node.prev = tail;
		node.next = null;
		tail = node;

	}


}

class Node<T>{
	
	T value;
	Node<T> prev;
	Node<T> next;

	public Node(T value){
		this.value = value;
	}


}
