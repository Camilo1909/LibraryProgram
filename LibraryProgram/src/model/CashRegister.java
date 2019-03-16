package model;

import structures.NoSuchElementException;

public class CashRegister {
	
	String name;
	
	public CashRegister(String name) {
		this.name = name;
	}
	
	public Client pay(Client client) {
		for (int i = 0; i < client.getBasket().getSize(); i++) { 
			try {
				client.getBag().push(client.getBasket().pop());
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return client;
	}

}
