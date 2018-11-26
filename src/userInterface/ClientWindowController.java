package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import library.ClientGlobal;
import library.interfaces.IConstantWindow;

public class ClientWindowController extends Controller implements Initializable, IConstantWindow
{
	@FXML private AnchorPane panel_home;
	@FXML private AnchorPane panel_user;
	@FXML private TextField lastname_textfield;
	@FXML private TextField name_textfield;
	@FXML private TextField email_textfield;
	@FXML private TextField identification_textfield;
	@FXML private TextField old_password_textfield;
	@FXML private TextField new_password_textfield;
	@FXML private Button cancel_button;
	@FXML private Label label_user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//label_user.setText(ClientGlobal.getInstance().getClient().getUsername());
		//lastname_textfield.setText(ClientGlobal.getInstance().getClient().getLastName());
		//email_textfield.setText(ClientGlobal.getInstance().getClient().getLastName());
		//name_textfield.setText(ClientGlobal.getInstance().getClient().getLastName());
	    //identification_textfield.setText(ClientGlobal.getInstance().getClient().getIdentification());
	}
	
	public void showMenuWindow()
	{
		try {
			openWindow(ORDER_CLIENT_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void showPageConstruction()
	{
		showAlert(AlertType.WARNING ,"Page underconstruction" , "Page underconstruction please come back later");
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
   			Restaurant.getInstance().updateClient(ClientGlobal.getInstance().getClient().getId(), name, lastname, identification, ClientGlobal.getInstance().getClient().getUsername(), new_password);
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
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value)
		{
			closeWindow(cancel_button);
		}
	}
}