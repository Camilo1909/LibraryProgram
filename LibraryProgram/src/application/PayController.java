package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import model.Client;

public class PayController implements Initializable{
	
	@FXML
    private TextArea information;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		information.setText(Main.getLibrary().showInformation());
	}
	
}
