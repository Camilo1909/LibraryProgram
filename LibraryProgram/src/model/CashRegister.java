package model;

import structures.NoSuchElementException;

public class CashRegister {
	
	String name;
	private boolean empty;

	private Client client;
	
	public CashRegister() {
		empty = true;
		client = null;
	}
	
	
	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
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
