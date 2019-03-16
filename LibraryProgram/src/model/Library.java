package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.HashTable;
import structures.NoSuchElementException;
import structures.Queue;
import structures.Stack;

public class Library {

	
	private Queue<Client> queueClients;
	
	
	private HashTable<String,Book> bookshelves;
	
	private ArrayList<Client> initialClients;
	
	private ArrayList<Client> already;
	
	private Client actualClient;
	
	private CashRegister[] csc;
	
	public Library() {
		queueClients = null;
		bookshelves = null;
		bookshelves = new HashTable<String,Book>();
		queueClients = new Queue<Client>();
		actualClient = null;
		initialClients = new ArrayList<Client>();
		already = new ArrayList<Client>();
		try {
			loadData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadData() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("files/Books.txt");
			BufferedReader br = new BufferedReader(fr);
			String cadena = "";
			br.readLine();
			while((cadena= br.readLine())!= null) {
				String[] data = cadena.split(",");
				String isbn = data[0];
				int amount = Integer.parseInt(data[1]);
				double price = Double.parseDouble(data[2]);
				bookshelves.add(isbn, new Book(isbn,amount,price));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public Client searchActualClient(String id) {
		for (int i = 0; i < initialClients.size(); i++) {
			if(initialClients.get(i).getId().compareToIgnoreCase(id) == 0)
			{
				return initialClients.get(i);
			}
		}	
		
		return null;
	}
	
	
	
	public void setQueueToPay() {
		for(int i = 0; i < initialClients.size(); i++) {
			initialClients.get(i).setQueuePos(calculateQueuePos(i+1,initialClients.get(i).getBasket().getSize()));
		}
		ArrayList<Client> aux = sortClients();
		for(int j = 0; j < aux.size(); j++) {
			queueClients.offer(aux.get(j));
		}
	}
	
	public int calculateQueuePos(int posArray, int numBooks) {
		return posArray +  numBooks;
	}
	
	public ArrayList<Client> sortClients(){
		ArrayList<Client> clone = (ArrayList<Client>) initialClients.clone();
		for (int i = 1; i < clone.size(); i++) {
			for (int j = clone.size() - 1; j >= i; j--) {
				if(clone.get(j).compareTo(clone.get(j-1)) >0) {
					Client aux = clone.get(j);
					clone.set(j,clone.get(j-1));
					clone.set(j-1,aux);
				}
			}
		}
		return clone;
	}
	
	
	public Stack<Book> cloneStack(Client client) throws NoSuchElementException{
		Stack<Book> temp = client.getBasket();
		Stack<Book> toReturn = new Stack<Book>();
		Stack<Book> tempStack = new Stack<Book>();
		while(!temp.isEmpty()) {
			tempStack.push(temp.pop());
		}
		while(!tempStack.isEmpty()) {
			toReturn.push(tempStack.pop());
		}
		
		client.setBasket(toReturn);
		
		return toReturn;
	}
	
	public void addAlready(Client client) {
		already.add(client);
	}
	
	public void createCashRegister(int n) {
		csc = new CashRegister[n];
	}
	
	public String showInformation(){
		String cadena = "";
		for(int i = 0 ; i<already.size();i++ ) {
			cadena += (i+1) + ". " + already.get(i).getId() + "\n";
			for(int j = 0; i<already.get(i).getBag().getSize();i++) {
				try {
					cadena += "- " + already.get(i).getBag().pop()+ "\n";
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cadena;
	}
	
	public Queue<Client> getQueueClients() {
		return queueClients;
	}


	public void setQueueClients(Queue<Client> queueClients) {
		this.queueClients = queueClients;
	}


	public HashTable<String, Book> getBookshelves() {
		return bookshelves;
	}


	public void setBookshelves(HashTable<String, Book> bookshelves) {
		this.bookshelves = bookshelves;
	}


	public ArrayList<Client> getInitialClients() {
		return initialClients;
	}


	public void setInitialClients(ArrayList<Client> initialClients) {
		this.initialClients = initialClients;
	}


	public Client getActualClient() {
		return actualClient;
	}


	public void setActualClient(Client actualClient) {
		this.actualClient = actualClient;
	}
	
	public ArrayList<Client> getAlready(){
		return already;
	}
	
	public CashRegister[] getCsc() {
		return csc;
	}

}
