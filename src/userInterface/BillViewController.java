package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import library.interfaces.IConstantWindow;

public class BillViewController extends Controller implements IConstantWindow, Initializable
{
	@FXML private Button cancel_button;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value)
		{
			closeWindow(cancel_button);
		}
	}
}