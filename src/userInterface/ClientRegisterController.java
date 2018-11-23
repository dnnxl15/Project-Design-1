package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.IConstant;
import library.interfaces.IConstantWindow;

public class ClientRegisterController extends Controller implements Initializable, IConstantWindow
{	
	@FXML private Button signUp_button;
	@FXML private Button signIn_button;
	@FXML private Button cancel_button;
	@FXML private TextField name_textfield;
	@FXML private TextField lastName_textfield;
	@FXML private TextField email_textfield;
	@FXML private TextField username_textfield;
	@FXML private TextField password_textfield;
	@FXML private TextField rePassword_textfield;
	@FXML private TextField identification_textfield;

    public void signIn() throws IOException
    {
    	openWindow(SIGN_IN_CLIENT_WINDOW_UI, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
    	closeWindow(signUp_button);
    }
    
    public void closeWindow()
    {
    	closeWindow(signUp_button);
    }
    
    public void signUp() throws IOException
    {
    	String username = username_textfield.getText().toString();
    	String password = password_textfield.getText().toString();
    	String name = name_textfield.getText().toString();
    	String lastname = lastName_textfield.getText().toString();
    	String rePassword = rePassword_textfield.getText().toString();
    	int  identification;
    	String email = email_textfield.getText().toString();
    	try
		{
    		identification =  Integer.parseInt(identification_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Identification" , "Must be a number");
			return;
		}
    	if(username.equals(EMPTY) || name.equals(EMPTY) || lastname.equals(EMPTY) || email.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else if(!password.equals(rePassword))
    	{
			showAlert(AlertType.ERROR ,"Password" , "Password and confirm password must be the same");
			return;
    	}
    	else
    	{
    		Restaurant.getInstance().createUser(name, lastname, identification, username, email, password);
			showAlert(AlertType.CONFIRMATION ,"User register" , "User is registered in the system");
	       	openWindow(SIGN_IN_CLIENT_WINDOW_UI, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
    	}	
    	closeWindow(signUp_button);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}