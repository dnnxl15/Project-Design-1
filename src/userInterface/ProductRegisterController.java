package userInterface;

import controller.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ProductRegisterController extends Controller
{
	@FXML private TextField name_textfield;
	@FXML private TextField price_textfield;
	@FXML private TextArea description_textarea;
	@FXML private Button signUp_button;

	public void registerProduct()
	{
    	String name = name_textfield.getText().toString();
    	int price;
    	String description = description_textarea.getText().toString();
    	try
		{
    		price =  Integer.parseInt(price_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Price" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || description.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
   			Restaurant.getInstance().createProduct(name, price, description, "dnnxl"); //////////////////////
   			showAlert(AlertType.CONFIRMATION ,"Product register" , "Product is registered in the system");
   			name_textfield.setText(EMPTY);
   			description_textarea.setText(EMPTY);
   			price_textfield.setText(EMPTY);
    	}	
	}

	public void closeWindow()
	{
		closeWindow(signUp_button);
	}
}