package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class ClientWindowController extends Controller implements Initializable
{
	@FXML private AnchorPane panel_home;
	@FXML private AnchorPane panel_user;
	@FXML private TextField lastname_textfield;
	@FXML private TextField name_textfield;
	@FXML private TextField email_textfield;
	@FXML private TextField identification_textfield;
	@FXML private TextField old_password_textfield;
	@FXML private TextField new_password_textfield;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void showHome()
	{
		showUserComponent(false);
		showHomeComponent(true);
	}
	
	public void showHomeComponent(boolean pVisible)
	{
		panel_home.setVisible(pVisible);
	}
	
	public void showUser()
	{
		showHomeComponent(false);
		showUserComponent(true);
	}
	
	public void showUserComponent(boolean pVisible)
	{
		panel_user.setVisible(pVisible);
		lastname_textfield.setVisible(pVisible);
		name_textfield.setVisible(pVisible);
		email_textfield.setVisible(pVisible);
		identification_textfield.setVisible(pVisible);
		old_password_textfield.setVisible(pVisible);
		new_password_textfield.setVisible(pVisible);
	}
	
	public void updateClient()
	{
		String lastname = lastname_textfield.getText().toString();
    	int identification;
    	String name = name_textfield.getText().toString();
    	String email = email_textfield.getText().toString();
    	String old_password = old_password_textfield.getText().toString();
    	String new_password = new_password_textfield.getText().toString();
    	try
		{
    		identification =  Integer.parseInt(identification_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Identification" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || lastname.equals(EMPTY) || email.equals(EMPTY) || old_password.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
   			//Restaurant.getInstance().updateEmployee(selected.getIdEmployee(), name, lastname, salary, value);
   			showAlert(AlertType.CONFIRMATION ,"Client update" , "Client is updated in the system");
   			lastname_textfield.setText(EMPTY);
   			name_textfield.setText(EMPTY);
   			identification_textfield.setText(EMPTY);
   			old_password_textfield.setText(EMPTY);
   			new_password_textfield.setText(EMPTY);
   			email_textfield.setText(EMPTY);
   			initialize(null, null);
    	}
	}
}