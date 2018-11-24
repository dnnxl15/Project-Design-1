
package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author egapb
 */
public class EmployeeRegisterController extends Controller implements Initializable {

    
    @FXML private Button signUp_button;
    @FXML private Button cancel_button;
    
    @FXML private TextField name_textfield;
    @FXML private TextField lastName_textfield;
    @FXML private TextField email_textfield;
    @FXML private TextField identification_textfield;
    @FXML private TextField salary_textfield;
    @FXML private ComboBox<String> role_combo;
    @FXML private ComboBox<String> legal_number;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	role_combo.getItems().clear();
    	role_combo.getItems().addAll();//Arralist
    	
    	legal_number.getItems().clear();
    	legal_number.getItems().addAll();//Arralist
    }    
    
    public void signUp() throws IOException
    {
    	String name = name_textfield.getText().toString();
    	String lastname = lastName_textfield.getText().toString();
    	String email = email_textfield.getText().toString();
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
    	if(email.equals(EMPTY) || name.equals(EMPTY) || lastname.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
    		name_textfield.setText(EMPTY);
    		lastName_textfield.setText(EMPTY);
    		email_textfield.setText(EMPTY);
    		identification_textfield.setText(EMPTY);
    		salary_textfield.setText(EMPTY);
			showAlert(AlertType.CONFIRMATION ,"User register" , "User is registered in the system");
    	}	
    	
    }
    
    public void closeWindow()
    {
    	closeWindow(signUp_button);
    }
}
