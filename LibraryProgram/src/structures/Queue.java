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
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
