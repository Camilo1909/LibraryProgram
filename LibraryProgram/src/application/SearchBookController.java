package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Book;

public class SearchBookController implements Initializable {

	@FXML
	private TextField isbn;

	@FXML
	private TextField price;

	@FXML
	private TextField amount;
	
	private Book actualBook;
	
	@FXML
	private ListView<String> ISBNBooks;
	

	@FXML
	void addBook(ActionEvent event) {
		if(!isbn.getText().isEmpty()){
			if(Main.getLibrary().getActualClient()!=null) {
				if(actualBook.getAmount() > 0) {
					Main.getLibrary().getActualClient().getBasket().push(actualBook);
					actualBook.decreaseAmount();
					amount.setText(actualBook.getAmount() + "");
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("No hay mas de estos libros");
					alert.show();
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
