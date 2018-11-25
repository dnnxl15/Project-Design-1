package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class OrderClientViewController extends Controller implements Initializable 
{
    @FXML private Spinner<Integer> spinner;
    @FXML private TextField name_textfield;
    @FXML private TextField price_textfield;
    @FXML private Button cancel_button;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spinner.getValueFactory().setValue(ONE);
		spinner.getValueFactory().increment(ONE);
		IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(CERO, CERO);
		factory.setMax(100);
		factory.setMin(ONE);
		factory.setValue(ONE);
		spinner.setValueFactory(factory);		
	}
	
	public void closeWindow(){
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value){
			closeWindow(cancel_button);
		}
	}
}