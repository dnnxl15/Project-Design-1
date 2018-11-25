package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ClientWindowController extends Controller implements Initializable
{
	@FXML private AnchorPane panel_home;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void showHome()
	{
		showHomeComponent(true);
	}
	
	public void showHomeComponent(boolean pVisible)
	{
		panel_home.setVisible(pVisible);
	}
}