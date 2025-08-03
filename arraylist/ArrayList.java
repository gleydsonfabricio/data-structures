public class ArrayList<T>{

	private T[] list;
	private int last;
	private static final int DEFAULT_CAPACITY = 20;

	public ArrayList(){
		this(DEFAULT_CAPACITY);
	}

	public ArrayList(int capacity){
		this.list = (T[]) new Object[capacity];
		this.last = -1;
	}

	public int size(){
		return this.last + 1;
	}

	public boolean isEmpty(){
		return this.last == -1;
	}

	public void push(T element){
		ensuresCapacity(last + 1);
		list[++last] = element;
	}

	public void set(int index, T element){
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		this.list[index] = element;
	}

	public void add(int index, T element){
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		ensuresCapacity(last + 1);
		shiftRight(index);
	
		this.list[index] = element;
		last++;
	}

	public T remove(int index){
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		T removed = this.list[index];

		shiftLeft(index);
		last--;

		return removed;
	}

	public T removeLast(){
		return remove(this.last);
	}

	public void removeByValue(T element){
		int index = indexOf(element);
		if (index == -1) return;
		remove(index);
	}

	public int indexOf(T element){
		for (int i = 0; i < this.size(); i++)
			if (list[i].equals(element))
				return i;
		return -1;
	}

	public boolean contains(T element){
		return this.indexOf(element) != -1;
	}

	public void clear(){
		this.last = -1;
	}
	
	public String toString(){
		
		String output = "";
		
		for (int i = 0; i < this.size(); i++)
			output += list[i].toString() + ", ";
		
		return output.substring(0, output.length() - 2);

	}

	// used on remove
	private void shiftLeft(int index){
		for (int i = index; i < this.size() - 1; i++)
			this.list[i] = this.list[i + 1];
	}
	
	// used on add
	private void shiftRight(int index){
		for (int i = this.size(); i > index; i--)
			this.list[i] = this.list[i - 1];
	}
	
	private void ensuresCapacity(int newCapacity){
		if (newCapacity >= this.list.length)
			resize(Math.max(newCapacity, this.list.length * 2));
	}

	private void resize(int size){
		T[] newList = (T[]) new Object[size];

		for (int i = 0; i < this.size(); i++)
			newList[i] = this.list[i];

		this.list = newList;
	}
	

}
