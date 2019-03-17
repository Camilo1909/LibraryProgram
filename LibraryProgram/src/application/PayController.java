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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PayController implements Initializable{
	
	@FXML
    private TextArea information;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		information.setText(Main.getLibrary().showInformation());
	}
	
	@FXML
	void exit(ActionEvent event) throws IOException {
		information.setText("");
		Main.getLibrary().reiniciarPrograma();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/Index.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	
}
