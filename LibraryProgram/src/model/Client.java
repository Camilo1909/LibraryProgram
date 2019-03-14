package model;

import structures.Stack;

public class Client {
	
	private String id;
	
	private Stack<Book> basket;

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
	
	

}
