package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import domain.Commodity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import library.EmployeeUI;
import library.RestaurantUI;
import library.interfaces.IConstantWindow;

public class EmployeeViewController extends Controller implements Initializable, IConstantWindow
{
	@FXML private TableView<EmployeeUI> employee_table;
	@FXML private TableColumn<EmployeeUI, String> columnName;
	@FXML private TableColumn<EmployeeUI, String> columnLastaname;
	@FXML private TableColumn<EmployeeUI, Number> columnSalary;
	@FXML private TableColumn<EmployeeUI, String> columnRol;
	@FXML private TableColumn<EmployeeUI, CheckBox> columnDisable;
	@FXML private Button cancel_button;
	@FXML private Label result_label;
	@FXML private TextField name_textfield;
	@FXML private TextField lastname_textfield;
	@FXML private TextField slary_textfield;
	@FXML private ComboBox<String> role_combobox;
	private EmployeeUI selected;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		columnLastaname.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLastname()));
		columnSalary.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getSalary()));
		columnRol.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRol()));
		columnDisable.setCellValueFactory(new PropertyValueFactory<EmployeeUI, CheckBox>("check"));
		employee_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoEmployeeUI((EmployeeUI) newValue));
	
		ObservableList<EmployeeUI> newListEmployee = null;
		//newListRestaurant = FXCollections.observableArrayList(Restaurant.getInstance().getRestaurant());//ControlSystem.getInstance().loadProduct());
		//mount_restaurant_label.setText("("+newListRestaurant.size()+")");

		employee_table.setItems(newListEmployee);
		result_label.setText("("+newListEmployee.size()+")");
	}
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, "Close window", "Are you sure to close the window?");
		if(value)
		{
			closeWindow(cancel_button);
		}
	}
	
	/**
	 * Method show the info of the product
	 * Author: Danny Xie Li
	 * Description: The next method show the info of the product.
	 * Last modification: 08/10/18
	 */
	public void showInfoEmployeeUI(EmployeeUI pEmployeeUI)
	{
		if(pEmployeeUI == null)
		{
			name_textfield.setText(EMPTY);
			lastname_textfield.setText(EMPTY);
			slary_textfield.setText(EMPTY);
		}
		else
		{
			name_textfield.setText(pEmployeeUI.getName().toString());
			lastname_textfield.setText(String.valueOf(pEmployeeUI.getLastname()));
			slary_textfield.setText(String.valueOf(pEmployeeUI.getSalary()));
			selected = pEmployeeUI;
		}
		
	}
	
	public void updateEmployee()
	{
		String lastname = lastname_textfield.getText().toString();
    	int salary;
    	String name = name_textfield.getText().toString();
    	String value = role_combobox.getSelectionModel().getSelectedItem();
    	try
		{
    		salary =  Integer.parseInt(slary_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Salary" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || lastname.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
   			//Restaurant.getInstance().updateCombo(product.getIdPerson(), name, price, description, value);//////////////////////////////////////////////////////
   			showAlert(AlertType.CONFIRMATION ,"Combo update" , "Combo is updated in the system");
   			lastname_textfield.setText(EMPTY);
   			name_textfield.setText(EMPTY);
   			slary_textfield.setText(EMPTY);
   			initialize(null, null);
    	}
	}
	
	public void openSalaryWindow()
	{
		try {
			openWindow(EMPLOYEE_SALARY_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}