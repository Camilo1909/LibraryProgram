package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import model.Client;

public class IndexController {
	
	
	
	
	public void initialize() {
		
	}
	
	@FXML
	void selectBooks() {
		
	}
	
	
	@FXML
    void newClient(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("NEW CLIENT");
		dialog.setHeaderText("NEW CLIENT ALERT");
		dialog.setContentText("Please enter your id:");

		
		Optional<String> result = dialog.showAndWait();
		

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(id -> Main.getLibrary().getInitialClients().add(new Client(id)));
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("DONE");
		alert.setContentText("Client added");
		alert.showAndWait();
		
    }

    @FXML
    void pay(ActionEvent event) {
    	
    }
	
}
