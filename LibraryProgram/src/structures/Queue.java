package structures;

public class Queue<T> implements IQueue<T> {

	private int size;
	
	private Node<T> first;
	private Node<T> last;
	
	
	public Queue() {
		this.size = 0;
		this.first = null;
		this.last = null;	
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean offer(T element) {
		// TODO Auto-generated method stub
		
		 Node<T> oldlast = last;
	        last = new Node<T>(element);
	        //last.item = item;
	        last.setNext(null); 
	        if (isEmpty()) first = last;
	        
	        else oldlast.setNext(last);
	        size++;
		
		return true;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.getValue();
	}

	@Override
	public T poll() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Node<T> node = (Node<T>) first;
        first = first.getNext();
        size--;
        if (isEmpty()) last = null;   // to avoid loitering
        return node.getValue();
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

}
