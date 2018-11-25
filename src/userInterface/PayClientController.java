package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import library.interfaces.IConstantWindow;

public class PayClientController extends Controller implements IConstantWindow, Initializable
{
	@FXML private StackPane stackPanel;
	@FXML private RadioButton express_radioButton;
	@FXML private RadioButton pickUp_radioButton;
	@FXML private Button cancel_button;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{		
		
	}

	public void markExpress()
	{
		if(express_radioButton.isSelected())
		{
			showInfoDialog("Method express deliver", "The deliver method express will take approximately between 20 to 30 minutes", "Accept");
			pickUp_radioButton.selectedProperty().set(!express_radioButton.isSelected());
		}
		else
		{
			pickUp_radioButton.selectedProperty().set(!express_radioButton.isSelected());
		}
	}
	
	public void markPickUp()
	{
		if(pickUp_radioButton.isSelected())
		{
			showInfoDialog("Method pick up deliver", "Your order will take approximately between 20 to 30 minutes", "Accept");
			express_radioButton.selectedProperty().set(!pickUp_radioButton.isSelected());
		}
		else
		{
			express_radioButton.selectedProperty().set(!pickUp_radioButton.isSelected());
		}
	}
	
	public void showInfoDialog(String pHeader, String pBody, String pButton){
	    JFXDialogLayout content = new JFXDialogLayout();
	    content.setHeading(new Text(pHeader));
	    content.setBody(new Text(pBody));
	    stackPanel.toFront();
	    JFXDialog dialog = new JFXDialog(stackPanel, content, JFXDialog.DialogTransition.CENTER);
	    JFXButton button = new JFXButton(pButton);
	    button.addEventHandler(ActionEvent.ACTION, (e)-> {
	   		dialog.close();
	   		stackPanel.toBack();
	   	});
	    content.setActions(button);
	    dialog.show();
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
