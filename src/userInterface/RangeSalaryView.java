package userInterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Restaurant;
import domain.Commodity;
import domain.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.EmployeeUI;
import library.JobTitleUI;

public class RangeSalaryView extends Controller implements Initializable
{
	@FXML private TableView<JobTitleUI> employee_table;
	@FXML private TableColumn<JobTitleUI, String> columnRole;
	@FXML private TableColumn<JobTitleUI, Number> columnMaximun;
	@FXML private TableColumn<JobTitleUI, Number> columnMinimum;
	@FXML private Button cancel_button;
	@FXML private TextField newRole_textfield;
	@FXML private TextField minimum_textfield;
	@FXML private ComboBox<String> role_combobox;
	@FXML private TextField maximum_textfield;
	@FXML private Label result_label;
	private JobTitleUI jobTitleUI;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		columnRole.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		columnMaximun.setCellValueFactory(cellData->new SimpleIntegerProperty((int) cellData.getValue().getMaxSalary()));
		columnMinimum.setCellValueFactory(cellData->new SimpleIntegerProperty(cellData.getValue().getMinSalary()));
		
		employee_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoJobTitleUI((JobTitleUI) newValue));
		ObservableList<JobTitleUI> newListProduct = FXCollections.observableArrayList(Restaurant.getInstance().getJobTitle());
		employee_table.setItems(newListProduct);
		result_label.setText("("+newListProduct.size()+")");
		role_combobox.getItems().clear();
		role_combobox.getItems().addAll(getAllRole(newListProduct));
	}
	
	public ArrayList<String> getAllRole(ObservableList<JobTitleUI> pRole)
	{
		ArrayList<String> listString = new ArrayList<String>();
		for(JobTitleUI jobTitle : pRole) 
		{
			listString.add(jobTitle.getName());
		}
		return listString;
	}
	
	/**
	 * Method show the info of the product
	 * Author: Danny Xie Li
	 * Description: The next method show the info of the product.
	 * Last modification: 08/10/18
	 */
	public void showInfoJobTitleUI(JobTitleUI pJobTitleUI)
	{
		if(pJobTitleUI == null)
		{
			minimum_textfield.setText(EMPTY);
			maximum_textfield.setText(EMPTY);
		}
		else
		{
			role_combobox.getSelectionModel().select(pJobTitleUI.getName());
			minimum_textfield.setText(String.valueOf(pJobTitleUI.getMinSalary()));
			maximum_textfield.setText(String.valueOf(pJobTitleUI.getMaxSalary()));
			jobTitleUI = pJobTitleUI;
		}
		
	}
	
	public void closeWindow()
	{
		closeWindow(cancel_button);
	}
	
	public void addRole()
	{
    	int max;
    	int min;
    	String value = newRole_textfield.getText().toString();
    	try
		{
    		max =  Integer.parseInt(maximum_textfield.getText().toString());
    		min =  Integer.parseInt(minimum_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Maximum and minimum" , "Must be a number");
			return;
		}
    	if(value.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else if(max<min)
    	{
			showAlert(AlertType.ERROR ,"Salary" , "Maximum salary must be > minimum salary");
			return;
    	}
    	else
    	{
   			Restaurant.getInstance().createJobTitle(value, min, max);
   			showAlert(AlertType.CONFIRMATION ,"Role created" , "Role created in the system");
   			minimum_textfield.setText(EMPTY);
   			newRole_textfield.setText(EMPTY);
   			maximum_textfield.setText(EMPTY);
   			initialize(null,null);
    	}
	}

	public void updateRole()
	{
		int max;
    	int min;
    	String value = role_combobox.getSelectionModel().getSelectedItem();
    	try
		{
    		max =  Integer.parseInt(maximum_textfield.getText().toString());
    		min =  Integer.parseInt(minimum_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Maximum and minimum" , "Must be a number");
			return;
		}
    	if(value == null)
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else if(max<min)
    	{
			showAlert(AlertType.ERROR ,"Salary" , "Maximum salary must be > minimum salary");
			return;
    	}
    	else
    	{
   			Restaurant.getInstance().updateJobTitle(jobTitleUI.getIdJobTitle(), value, min, max);
   			showAlert(AlertType.CONFIRMATION ,"Combo update" , "Combo is updated in the system");
   			minimum_textfield.setText(EMPTY);
   			maximum_textfield.setText(EMPTY);
   			initialize(null,null);
    	}
	}
}
