package model;

public class Book {

	private String isbn;
	private int amount;
	private double price;
	
	public Book(String isbn, int amount, double price) {
		this.isbn = isbn;
		this.amount = amount;
		this.price = price;
	}

	public void decreaseAmount() {
		amount--;
	}
	
	
	public String getIsbn() {
		return isbn;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

}
