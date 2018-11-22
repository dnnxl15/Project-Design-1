package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    public void signIn() throws IOException
    {
    	openWindow(SIGN_IN_CLIENT_WINDOW_UI);
    	closeWindow(signUp_button);
    }
    
    public void signUp() throws IOException
    {
    	String username = username_textfield.getText().toString();
    	String password = password_textfield.getText().toString();
    	
    	
    	openWindow(SIGN_UP_CLIENT_WINDOW_UI);
    	closeWindow(signUp_button);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


}
