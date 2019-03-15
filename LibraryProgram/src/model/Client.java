package model;

import structures.Stack;

public class Client implements Comparable<Client> {
	
	private String id;
	
	private Stack<Book> basket;
	
	private int queuePos;

	public Client(String id) {
		this.id = id;
		this.basket = new Stack<Book>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Stack<Book> getBasket() {
		return basket;
	}

	public void setBasket(Stack<Book> basket) {
		this.basket = basket;
	}

	public int getQueuePos() {
		return queuePos;
	}

	public void setQueuePos(int queuePos) {
		this.queuePos = queuePos;
	}

	@Override
	public int compareTo(Client c1) {
		if(this.getQueuePos() > c1.getQueuePos()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	

}
