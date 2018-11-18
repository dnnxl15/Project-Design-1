/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.IConstant;

/**
 * FXML Controller class
 *
 * @author egapb
 */
public class MainController extends Controller implements Initializable, IConstant {
	
	@FXML private Button enter_button;
	@FXML private Button sign_up_button;
	@FXML private Button sign_in_button;
	@FXML private TextField textfield_username;
	@FXML private TextField textfield_password;

       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void signIn() throws IOException
    {
    	String username = textfield_username.getText().toString();
    	String password = textfield_password.getText().toString();
    	openWindow(SIGN_IN_CLIENT_WINDOW_UI);
    	closeWindow(enter_button);
    }
    
    public void signUp() throws IOException
    {
    	openWindow(SIGN_UP_CLIENT_WINDOW_UI);
    	closeWindow(enter_button);
    }
}