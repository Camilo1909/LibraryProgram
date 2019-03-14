package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import model.Client;

public class IndexController {
	
	
	
	
	public void initialize() {
		
	}
	
	@FXML
	void selectBooks(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/selectClient.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML
    void newClient(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("NEW CLIENT");
		dialog.setHeaderText("NEW CLIENT ALERT");
		dialog.setContentText("Please enter your id:");

		
		Optional<String> result = dialog.showAndWait();
		
		if (result.isPresent()){
		    String id = result.get();
		    Client newClient = new Client(id);
		    Main.getLibrary().getInitialClients().add(newClient);
		    Main.getLibrary().setActualClient(newClient);
		}
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("DONE");
		alert.setContentText("Client added");
		alert.showAndWait();
		
    }

    @FXML
    void pay(ActionEvent event) {
    	
    }
	
}
