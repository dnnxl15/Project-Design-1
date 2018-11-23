package userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import library.RestaurantUI;

public class EmployeeViewController 
{
	@FXML private TableView<RestaurantUI> restaurant_table;
	@FXML private TableColumn<RestaurantUI, String> columnAddress;
	@FXML private TableColumn<RestaurantUI, String> columnLegalName;


}
