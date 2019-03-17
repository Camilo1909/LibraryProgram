package model;

import structures.Stack;

public class Client implements Comparable<Client> {
	
	private String id;
	
	private Stack<Book> basket;
	
	private Stack<Book> bag;
	
	private double saldo;
	
	private int queuePos;

	public Client(String id) {
		this.id = id;
		this.basket = new Stack<Book>();
		this.bag = new Stack<Book>();
		
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
	
	public Stack<Book> getBag() {
		return bag;
	}

	public void setBag(Stack<Book> bag) {
		this.bag = bag;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	

}
