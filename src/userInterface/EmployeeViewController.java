package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import library.EmployeeUI;
import library.RestaurantUI;

public class EmployeeViewController extends Controller implements Initializable
{
	@FXML private TableView<EmployeeUI> employee_table;
	@FXML private TableColumn<EmployeeUI, String> columnName;
	@FXML private TableColumn<EmployeeUI, String> columnLastaname;
	@FXML private TableColumn<EmployeeUI, String> columnEmail;
	@FXML private TableColumn<EmployeeUI, Number> columnSalary;
	@FXML private TableColumn<EmployeeUI, String> columnRol;
	@FXML private TableColumn<EmployeeUI, CheckBox> columnDisable;
	@FXML private Button cancel_button;
	@FXML private Label result_label;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		columnLastaname.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLastname()));
		columnEmail.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getEmail()));
		columnSalary.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getSalary()));
		columnRol.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRol()));
		columnDisable.setCellValueFactory(new PropertyValueFactory<EmployeeUI, CheckBox>("check"));

	
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
}