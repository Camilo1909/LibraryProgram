package model;

import structures.NoSuchElementException;

public class CashRegister {
	
	String name;

	private Client client;
	
	public CashRegister() {
		client = null;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
