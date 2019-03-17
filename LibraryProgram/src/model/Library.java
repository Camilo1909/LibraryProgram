package model;

import java.io.BufferedReader;
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
		csc = new CashRegister[3];
		csc[0] = new CashRegister();
		csc[1] = new CashRegister();
		csc[2] = new CashRegister();
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
		for (int i = 0; i < clone.size()-1; i++) {
			for (int j = 1; j < clone.size(); j++) {
				if(clone.get(i).compareTo(clone.get(j)) >0) {
					Client aux = clone.get(i);
					clone.set(i,clone.get(j));
					clone.set(j,aux);
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
			
			cadena += (i+1) + ". " + already.get(i).getId() + " Saldo: " + already.get(i).getSaldo() + "Tiempo: " + already.get(i).getQueuePos() + "\n";
			while(!already.get(i).getBag().isEmpty()) {
				try {
					cadena += "- " + already.get(i).getBag().pop().getIsbn()+ "\n";
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
	
	
	
	public void pay() throws NoSuchElementException {
	
		//Hasta que no hayan clientes
		boolean ready = false;
		
		while(!ready) {
			
			//Llenar todas las cajas
			for(int j = 0; j < csc.length; j++) {
				if(!queueClients.isEmpty() && csc[j].getClient()==null) {
					csc[j].setClient(queueClients.poll());
				}
			}
			
			//Pasar primer libro 
			for(int k = 0; k < csc.length; k++) {
				
				if(csc[k].getClient() != null) {
					Client aux = csc[k].getClient();
					
					//Si tiene libros pasa el primero
					if(!aux.getBasket().isEmpty()) {
						Book book = aux.getBasket().peek();
						aux.getBag().push(aux.getBasket().pop());
						aux.setSaldo(book.getPrice());
						aux.setQueuePos(1);
					} else { //si no tiene, pasa a la lista de pagado y la caja vuelve a estar vacía
						already.add(aux);
						csc[k].setClient(null);
					}
				}
				
			}
			
			int account = 0;
			if(queueClients.isEmpty()) {
				for(int i = 0; i < csc.length; i++) {
					if(csc[i].getClient() == null) {
						account++;
					}
				}
				
				if(account == csc.length) {
					ready = true;
				}
			}
			
		}
		
	}
	
	public void reiniciarPrograma() {
		initialClients = new ArrayList<Client>();
		already = new ArrayList<Client>();
		queueClients = null;
	}

}
