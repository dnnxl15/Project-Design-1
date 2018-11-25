package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import domain.Client;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import library.RestaurantUI;
import library.interfaces.IConstantWindow;

public class ClientManagerView extends Controller implements IConstantWindow, Initializable

{
	@FXML private TableView<Client> client_table;
	@FXML private TableColumn<Client, String> name_column;
	@FXML private TableColumn<Client, String> lastname_column;
	@FXML private TableColumn<Client, String> email_column;
	@FXML private TableColumn<Client, String> username_column;
	@FXML private Button cancel_button;
	@FXML private Label label_result;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		lastname_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLastName()));
		email_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getEmail()));
		username_column.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getUsername()));

		ObservableList<Client> newListClient = null;
		newListClient = FXCollections.observableArrayList(Restaurant.getInstance().getClient());//ControlSystem.getInstance().loadProduct());
		label_result.setText("("+newListClient.size()+")");
		client_table.setItems(newListClient);
		//newListProduct = FXCollections.observableArrayList();
		//client_table.setItems(newListRestaurant);
	}

	public void closeWindow()
	{
		closeWindow(cancel_button);
	}
}
