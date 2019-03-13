package structures;

public interface IStack<T> {

	
	
	boolean isEmpty();
	T peek() throws NoSuchElementException;
	T pop() throws NoSuchElementException;
	T push(T element);
	int search(T element);
	
	
}
