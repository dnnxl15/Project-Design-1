package userInterface;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;

import domain.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import library.interfaces.IConstantWindow;

public class ManagerWindowController extends Controller implements IConstantWindow, Initializable
{
	@FXML private Button home_button;
	@FXML private Button menu_button;
	@FXML private Button report_button;
	@FXML private Button user_button;
	@FXML private Button signOff_button;
	@FXML private Label main_label;
	@FXML private ImageView main_image;
	@FXML private JFXTreeTableView<?> report_table;

	@FXML private TextField search_report_textfield;
	@FXML private Label report_general_label;
	@FXML private Label mount_register_label;
	@FXML private Label generate_graphics_label;
	@FXML private Button bar_button;
	@FXML private Button line_button;
	@FXML private Button pie_button;
	@FXML private Button search_button;
	
	@FXML private TextField address_textfield;
	@FXML private TextField legal_number_textfield;
	@FXML private TreeTableView<String> restaurant_table;
	@FXML private TreeTableColumn<String, String> columnAddress;
	@FXML private TreeTableColumn<String, String> columnLegalName;
	
	public void showComponentReport(boolean pVisible)
	{
		search_report_textfield.setVisible(pVisible);
		report_general_label.setVisible(pVisible);
		mount_register_label.setVisible(pVisible);
		generate_graphics_label.setVisible(pVisible);
		bar_button.setVisible(pVisible);
	    line_button.setVisible(pVisible);
		pie_button.setVisible(pVisible);
		search_button.setVisible(pVisible);
		report_table.setVisible(pVisible);
		main_label.setText(REPORT_TEXT);
		main_label.setVisible(true);

	}
	
	public void showReport()
	{
		showComponentReport(false);
	}
	
	public void showComponentMenu()
	{
		main_label.setText(MENU_TEXT);
		main_label.setVisible(true);

	}
	
	public void showComponentHome()
	{
		main_label.setText(HOME_TEXT);
		main_label.setVisible(true);
	}
	
	public void showComponentUser()
	{
		main_label.setText(USER_TEXT);
		main_label.setVisible(true);

	}
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value)
		{
			closeWindow(bar_button);
		}
	}
	
	public void showFormRegisterEmployee()
	{
    	try {
			openWindow(EMPLOYEE_REGISTER_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addRestaurant()
	{
		//address_textfield;
		//legal_number_textfield;
		//restaurant_table;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		columnAddress.setCellValueFactory(cellData->new SimpleStringProperty("Address"));
		columnLegalName.setCellValueFactory(cellData->new SimpleStringProperty("Legal number"));
		restaurant_table.getColumns().add(columnAddress);
		restaurant_table.getColumns().add(columnLegalName);

		//ObservableList<Product> newListProduct = null;
		
		//newListProduct = FXCollections.observableArrayList();
		
		//tableProduct.setItems(newListProduct);
		
	}
}
