package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import library.interfaces.IConstantWindow;

public class ServiceEvaluationView extends Controller implements IConstantWindow, Initializable
{
	@FXML private Button cancel_button;
	@FXML private TextArea textArea_service_evaluation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void sendEvaluation()
	{
		String evaluation = textArea_service_evaluation.getText().toString();
		if(evaluation.equals(EMPTY))
		{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
		}
		else
		{
			showAlert(AlertType.CONFIRMATION ,"Evaluation sent" , "Thanks for choose Ovnirestaurant");
			closeWindow(cancel_button);
		}
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