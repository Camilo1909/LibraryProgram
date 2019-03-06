package structures;

public interface IQueue<T> {

	 	T element();
	    boolean offer(T element);
	    T peek();
	    T poll();
	    T remove();


}
