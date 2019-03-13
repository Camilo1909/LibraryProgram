package structures;

public class Stack<T> implements IStack<T>  {

	private Node<T> top;
	
	private int size;
	
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}

	
	
	public int getSize() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public T peek() throws NoSuchElementException {
		 if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return top.getValue();
	}

	@Override
	public T pop() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T element = top.getValue();     // save item to return
        top = top.getNext();            // delete first node
        size--;
        return element;
	}

	@Override
	public T push(T element) {
		Node<T> oldfirst = top;
	    top = new Node<T>(element);
	    top.setNext(oldfirst);
	    size++;
		
		
		return element;
		
	}

	@Override
	public int search(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

}
