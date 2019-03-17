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
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Client;

public class SelectClientController implements Initializable {
	
	
	private Client actualClient;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		actualClient = Main.getLibrary().getActualClient();
		
		// TODO Auto-generated method stub
		listClients.getItems().clear();
		for(int i = 0; i < Main.getLibrary().getInitialClients().size(); i++) {
			listClients.getItems().add(Main.getLibrary().getInitialClients().get(i).getId());
		}
		
	}
	

	@FXML
	private ListView<String> listClients;

	@FXML
	void exit(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/Index.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

    @FXML
    void takeBook(ActionEvent event) throws IOException {
    	try {
    		String idClient = listClients.getSelectionModel().getSelectedItem();
			actualClient = Main.getLibrary().searchActualClient(idClient);
		if(actualClient!=null) Main.getLibrary().setActualClient(actualClient);
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/SearchBook.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    	}catch(Exception e){
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("You haven't selected any client");
    		alert.showAndWait();
    	}
    }
    

	
}
