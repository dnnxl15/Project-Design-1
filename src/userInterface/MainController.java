/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.ClientGlobal;
import library.IConstant;
import library.interfaces.IConstantWindow;

/**
 * FXML Controller class
 *
 * @author egapb
 */
public class MainController extends Controller implements Initializable, IConstantWindow {
	
	@FXML private Button enter_button;
	@FXML private Button sign_up_button;
	@FXML private Button sign_in_button;
	@FXML private TextField textfield_username;
	@FXML private TextField textfield_password;
	@FXML private Label wrong_label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	wrong_label.setText(EMPTY);
    }    
    
    public void signIn() throws IOException
    {
    	String username = textfield_username.getText().toString();
    	String password = textfield_password.getText().toString();
    	boolean clientValue = Restaurant.getInstance().verifyUser(username, password);
    	boolean branchManagerValue = Restaurant.getInstance().verifyBranchManager(username, password);
    	boolean mainManagerValue = Restaurant.getInstance().verifyMainManager(username, password);
    	if(clientValue)
    	{
        	openWindow(SIGN_IN_CLIENT_WINDOW_UI, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
        	//ClientGlobal.getInstance().setClient(Restaurant.getInstance().getClientInfo(username, password));
        	closeWindow(enter_button);
    	}
    	else if(branchManagerValue)
    	{
    		
    	}
    	else if(mainManagerValue)
    	{
    		
    	}
    	else
    	{
        	wrong_label.setText("Password or username incorrect");
    	}
    }
    
    public void signUp() throws IOException
    {
    	openWindow(SIGN_UP_CLIENT_WINDOW_UI, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
    	closeWindow(enter_button);
    }
}