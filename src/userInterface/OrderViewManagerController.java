package userInterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Restaurant;
import domain.Commodity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.EmployeeUI;
import library.interfaces.IConstantWindow;

public class OrderViewManagerController extends Controller implements Initializable, IConstantWindow
{
	@FXML private Button cancel_button;
	@FXML private ComboBox<String> employeeCombobox;
	@FXML private TextField textFieldBonus;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		employeeCombobox.getItems().setAll(getNameEmployee(Restaurant.getInstance().getEmployee()));
	}
	
	public ArrayList<String> getNameEmployee(ArrayList<EmployeeUI> pListEmployee)
	{
		int index = 0;
    	ArrayList<String> listRol = new ArrayList<String>();
    	while(index < pListEmployee.size())
    	{
    		listRol.add(pListEmployee.get(index).getName());
    		index++;
    	}
    	return listRol;
	}
	
	public void closeWindow(){
		closeWindow(cancel_button);
		
	}
	
	public void addBonus()
	{
		int bonus;
		String name = employeeCombobox.getSelectionModel().getSelectedItem().toString();
    	try
		{
    		bonus =  Integer.parseInt(textFieldBonus.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Bonus" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || name == null)
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
		showAlert(AlertType.INFORMATION ,"Bonus added" , "Bonus added to the system");
		textFieldBonus.setText(EMPTY);
	}
	
}