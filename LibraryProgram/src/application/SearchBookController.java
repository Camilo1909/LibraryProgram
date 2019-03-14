package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Book;

public class SearchBookController {

	@FXML
	private TextField isbn;

	@FXML
	private TextField price;

	@FXML
	private TextField amount;
	
	private Book actualBook;
	

	@FXML
	void addBook(ActionEvent event) {
		if(!isbn.getText().isEmpty()){
			if(Main.getLibrary().getActualClient()!=null) {
				if(actualBook.getAmount() > 0) {
					Main.getLibrary().getActualClient().getBasket().push(actualBook);
					actualBook.decreaseAmount();
					amount.setText(actualBook.getAmount() + "");
				}else {
					//Tirar  LA excpecion
				}
			} 
		}
	}

	@FXML
	void exit(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/selectClient.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void searchISBN(ActionEvent event) {
		if(!isbn.getText().isEmpty()) {
			actualBook = Main.getLibrary().getBookshelves().get(isbn.getText());
			price.setText(actualBook.getPrice() + "");
			amount.setText(actualBook.getAmount() + "");
		}
	}
	
}
