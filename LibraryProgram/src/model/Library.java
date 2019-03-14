package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import structures.HashTable;
import structures.Queue;

public class Library {

	
	private Queue<Client> queueClients;
	
	private HashTable<String,Book> bookshelves;
	
	private ArrayList<Client> initialClients;
	
	
	
	public Library() {
		queueClients = null;
		bookshelves = null;
		initialClients = new ArrayList<Client>();
	}
	
	
	public void loadData() throws FileNotFoundException {
	
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
	
	
	

}
