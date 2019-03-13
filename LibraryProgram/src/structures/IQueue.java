package structures;

public interface IQueue<T> {

	 	T element();
	    boolean offer(T element);
	    T peek() throws NoSuchElementException;
	    T poll() throws NoSuchElementException;
	    T remove();
	    boolean isEmpty();

}
