package structures;

public class Node<T> {

	
	private T value;

	private Node<T> next;
	
	public Node(T value) {
		this.value = value;
		this.next = null;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void insert(Node<T> node) {
		if (next==null) {
			next = node;
		}else {
				next.insert(node);
			}
	}

}
