package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ManagerRegisterController extends Controller implements Initializable 
{
	@FXML private TextField name_textfield;
	@FXML private TextField lastName_textfield;
	@FXML private TextField username_textfield;
	@FXML private TextField identification_textfield;
	@FXML private TextField password_textfield;
	@FXML private TextField salary_textfield;
	@FXML private ComboBox<?> role_combo;
    @FXML private Button signUp_button;
    @FXML private Button cancel_button;
	
	public void signUp() throws IOException
    {
    	String username = username_textfield.getText().toString();
    	String password = password_textfield.getText().toString();
    	String name = name_textfield.getText().toString();
    	String lastname = lastName_textfield.getText().toString();
    	//String role = role_combo.getText().toString();
    	int  identification;
    	int salary;
    	try
		{
    		identification =  Integer.parseInt(identification_textfield.getText().toString());
    		salary = Integer.parseInt(salary_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Identification" , "Must be a number");
			return;
		}
    	if(username.equals(EMPTY) || name.equals(EMPTY) || lastname.equals(EMPTY) || password.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
    		////////
			showAlert(AlertType.CONFIRMATION ,"User register" , "User is registered in the system");
    	}	
    	closeWindow(signUp_button);
    }
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
	    
	public void closeWindow()
	{
		closeWindow(cancel_button);
	}
}
