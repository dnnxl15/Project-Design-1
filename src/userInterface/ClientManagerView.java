package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import library.RestaurantUI;
import library.interfaces.IConstantWindow;

public class ClientManagerView extends Controller implements IConstantWindow, Initializable

{
	@FXML private TableView<RestaurantUI> client_table;
	//@FXML private TableColumn<ClientUI, String> name_column;
	//@FXML private TableColumn<ClientUI, String> lastname_column;
	//@FXML private TableColumn<ClientUI, String> email_column;
	//@FXML private TableColumn<ClientUI, String> username_column;
	@FXML private Button cancel_button;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//name_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress()));
		//lastname_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLegalNumber()));
		//email_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLegalNumber()));
		//username_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLegalNumber()));

		//ObservableList<ClientUI> newListRestaurant = null;
		//newListRestaurant = FXCollections.observableArrayList(Restaurant.getInstance().getRestaurant());//ControlSystem.getInstance().loadProduct());
		//mount_restaurant_label.setText("("+newListRestaurant.size()+")");
		//restaurant_table.setItems(newListProduct);
		//newListProduct = FXCollections.observableArrayList();
		//client_table.setItems(newListRestaurant);
		
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
