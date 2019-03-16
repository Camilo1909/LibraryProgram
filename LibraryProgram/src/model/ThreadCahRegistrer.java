package model;

public class ThreadCahRegistrer {
	
	private Library library;
	private CashRegister cajera;
	private Client cliente;

	public ThreadCahRegistrer(Library library, CashRegister cajera, Client cliente) {
		super();
		this.library = library;
		this.cajera = cajera;
		this.cliente = cliente;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			library.addAlready(cajera.pay(this.cliente));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
