package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import library.JobTitleUI;
import library.RestaurantUI;
import library.interfaces.IConstantWindow;

public class EmployeeViewController extends Controller implements Initializable, IConstantWindow
{
	@FXML private TableView<EmployeeUI> employee_table;
	@FXML private TableColumn<EmployeeUI, String> columnName;
	@FXML private TableColumn<EmployeeUI, String> columnLastaname;
	@FXML private TableColumn<EmployeeUI, Number> columnSalary;
	@FXML private TableColumn<EmployeeUI, String> columnRol;
	@FXML private TableColumn<EmployeeUI, String> columnRestaurant;
	@FXML private Button cancel_button;
	@FXML private Label result_label;
	@FXML private TextField name_textfield;
	@FXML private TextField lastname_textfield;
	@FXML private TextField slary_textfield;
	@FXML private ComboBox<String> role_combobox;
	@FXML private ComboBox<String> restaurant_combobox;
	private EmployeeUI selected;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		columnLastaname.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLastname()));
		columnSalary.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getSalary()));
		columnRol.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRol()));
		columnRestaurant.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRestaurant()));
		employee_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoEmployeeUI((EmployeeUI) newValue));
		ObservableList<EmployeeUI> newListEmployee;
		newListEmployee = FXCollections.observableArrayList(Restaurant.getInstance().getEmployee());
		result_label.setText("("+newListEmployee.size()+")");
		employee_table.setItems(newListEmployee);
		role_combobox.getItems().clear();
		role_combobox.getItems().addAll(getRole(Restaurant.getInstance().getJobTitle()));
		
		restaurant_combobox.getItems().clear();
		restaurant_combobox.getItems().addAll(getLegalNumber(Restaurant.getInstance().getRestaurant()));
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
			role_combobox.getSelectionModel().select(pEmployeeUI.getRol());
			restaurant_combobox.getSelectionModel().select(pEmployeeUI.getRestaurant());
			selected = pEmployeeUI;
		}
	}
	
    public ArrayList<String> getRole(ArrayList<JobTitleUI> pJob)
    {
    	int index = 0;
    	ArrayList<String> listRol = new ArrayList<String>();
    	while(index < pJob.size())
    	{
    		listRol.add(pJob.get(index).getName());
    		index++;
    	}
    	return listRol;
    }
    
    public ArrayList<String> getLegalNumber(ArrayList<RestaurantUI> pRestaurant)
    {
    	int index = 0;
    	ArrayList<String> listRest = new ArrayList<String>();
    	while(index < pRestaurant.size())
    	{
    		listRest.add(pRestaurant.get(index).getLegalNumber());
    		index++;
    	}
    	return listRest;
    }
    
	public void updateEmployee()
	{
		String lastname = lastname_textfield.getText().toString();
    	int salary;
    	String name = name_textfield.getText().toString();
    	String value = role_combobox.getSelectionModel().getSelectedItem();
    	String restaurant = restaurant_combobox.getSelectionModel().getSelectedItem();;
    	try
		{
    		salary =  Integer.parseInt(slary_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Salary" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || lastname.equals(EMPTY) || value.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
   			Restaurant.getInstance().updateEmployee(selected.getIdEmployee(), name, lastname, salary, value, restaurant);
   			showAlert(AlertType.CONFIRMATION ,"Employee update" , "Employee is updated in the system");
   			lastname_textfield.setText(EMPTY);
   			name_textfield.setText(EMPTY);
   			slary_textfield.setText(EMPTY);
   			initialize(null, null);
    	}
		System.out.println(selected.getIdEmployee());

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