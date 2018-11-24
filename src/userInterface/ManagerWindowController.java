package userInterface;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;

import controller.Restaurant;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import library.RestaurantUI;
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
	@FXML private TableView<RestaurantUI> restaurant_table;
	@FXML private TableColumn<RestaurantUI, String> columnAddress;
	@FXML private TableColumn<RestaurantUI, String> columnLegalName;
	@FXML private Label mount_restaurant_label;
	@FXML private Label restaurant_label;
	@FXML private TextField search_restaurant_textfield;
	@FXML private Button search_restaurant_button;
	@FXML private Label report_general_label1;
	@FXML private AnchorPane panel_restaurant;
	@FXML private Button add_restaurant_button;
	
	@FXML private Button see_combo_button;
	@FXML private Button update_combo_button;
	@FXML private Button update_product_button;
	@FXML private Button see_product_button;
	
	@FXML private Line product_line;
	@FXML private Line combo_line;
	@FXML private Label combo_label;
	@FXML private Label product_label;
	
	@FXML private ImageView search_image;
	@FXML private ImageView search_image_product;
	@FXML private ImageView update_image;
	@FXML private ImageView update_product_image;

	
	
	@FXML private Line employee_line;
	@FXML private Line subamanager_line;
	@FXML private Label employee_label;
	@FXML private Label submanager_label;
	@FXML private Button see_employee_button;
	@FXML private Button add_submanager_buttton;
	@FXML private Button add_employee_button;

	
	public void showHome()
	{
		showComponentRestaurant(false);
		showComponentMenu(false);
		showComponentHome(true);
	}
	
	public void showComponentHome(boolean pVisible)
	{
		main_label.setText(HOME_TEXT);	
		main_label.setVisible(pVisible);
	}
	
	public void showMenu()
	{
		showComponentHome(false);
		showComponentRestaurant(false);	
		showComponentEmployee(false);
		showComponentUser(false);
		//showComponentReport(false);
		showComponentMenu(true);
	}
	
	public void showComponentMenu(boolean pBoolean)
	{
		main_label.setText(MENU_TEXT);
		main_label.setVisible(pBoolean);
		see_combo_button.setVisible(pBoolean);
		update_combo_button.setVisible(pBoolean);
		update_product_button.setVisible(pBoolean);
		see_product_button.setVisible(pBoolean);
		product_line.setVisible(pBoolean);
		combo_line.setVisible(pBoolean);
		combo_label.setVisible(pBoolean);
		product_label.setVisible(pBoolean);
		search_image.setVisible(pBoolean);
	    search_image_product.setVisible(pBoolean);
		update_image.setVisible(pBoolean);
		update_product_image.setVisible(pBoolean);
	}
	
	public void showReport()
	{
		showComponentHome(false);
		showComponentMenu(false);
		showComponentRestaurant(false);	
		showComponentEmployee(false);
		showComponentUser(false);
		//showComponentReport(true);

	}
	
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
		main_label.setText(REPORT_TEXT);
		main_label.setVisible(true);
	}
	
	public void showUser()
	{
		showComponentHome(false);
		showComponentMenu(false);
	  //showComponentReport(false);
		showComponentRestaurant(false);	
		showComponentEmployee(false);
		showComponentUser(true);

	}
	

	
	public void showComponentUser(boolean pVisible)
	{
		
	}
	
	public void showEmployee()
	{
		showComponentHome(false);
		showComponentMenu(false);
		//showComponentReport(false);
		showComponentUser(false);
		showComponentRestaurant(false);	
		showComponentEmployee(true);
	}
	
	public void showComponentEmployee(boolean pVisible)
	{
		employee_line.setVisible(pVisible);
		subamanager_line.setVisible(pVisible);
		employee_label.setVisible(pVisible);
		submanager_label.setVisible(pVisible);
		see_employee_button.setVisible(pVisible);
		add_submanager_buttton.setVisible(pVisible);
		add_employee_button.setVisible(pVisible);

		//update_employee_button.setVisible(pVisible);
		//update_submanager_button.setVisible(pVisible);
		///inactive_employee_button.setVisible(pVisible);
		//inactive_submanager_button.setVisible(pVisible);
		main_label.setText("Employee");
		main_label.setVisible(true);
	}
	
	public void showRestaurant()
	{
		showComponentHome(false);
		showComponentMenu(false);
		//showComponentReport(false);
		showComponentUser(false);
		showComponentEmployee(false);
		showComponentRestaurant(true);
	}
	
	public void showComponentRestaurant(boolean pVisible)
	{
		restaurant_label.setVisible(pVisible);
		restaurant_table.setVisible(pVisible);
		address_textfield.setVisible(pVisible);
		legal_number_textfield.setVisible(pVisible);
        mount_restaurant_label.setVisible(pVisible);
		restaurant_label.setVisible(pVisible);
		search_restaurant_textfield.setVisible(pVisible);
		search_restaurant_button.setVisible(pVisible);
		main_label.setText("Restaurant");
		main_label.setVisible(pVisible);
		report_general_label1.setVisible(pVisible);
		panel_restaurant.setVisible(pVisible);
		add_restaurant_button.setVisible(pVisible);
	}
	
	public void openViewCombos()
	{
		try {
			openWindow(COMBO_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openViewProduct()
	{
		try {
			openWindow(PRODUCT_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void openRegisterEmployee()
	{
		try {
			openWindow(EMPLOYEE_REGISTER_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void openViewEmployee()
	{
		try {
			openWindow(EMPLOYEE_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void openRegisterManager()
	{
		try {
			openWindow(MANAGER_REGISTER_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void seeCombos()
	{
		
	}
	
	public void addCombo()
	{
		try {
			openWindow(COMBO_REGISTER_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct()
	{
		try {
			openWindow(PRODUCT_REGISTER_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public void showComponentUser()
	{
		main_label.setText(USER_TEXT);
		main_label.setVisible(true);
		showComponentRestaurant(false);
	}
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value)
		{
			closeWindow(home_button);
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
		String address = address_textfield.getText().toString();
		String legalNumber = legal_number_textfield.getText().toString();
		if(address.equals(EMPTY) || legalNumber.equals(EMPTY))
		{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
		}
		else
		{
			Restaurant.getInstance().createRestaurant(address, legalNumber);
			showAlert(AlertType.CONFIRMATION ,"Restaurant register" , "Restaurant is registered in the system");
			address_textfield.setText(EMPTY);
			legal_number_textfield.setText(EMPTY);
			initialize(null, null);
		}
		//restaurant_table;
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		columnAddress.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress()));
		columnLegalName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLegalNumber()));
	
		ObservableList<RestaurantUI> newListRestaurant = null;
		newListRestaurant = FXCollections.observableArrayList(Restaurant.getInstance().getRestaurant());//ControlSystem.getInstance().loadProduct());
		mount_restaurant_label.setText("("+newListRestaurant.size()+")");
		//restaurant_table.setItems(newListProduct);
		//newListProduct = FXCollections.observableArrayList();
		restaurant_table.setItems(newListRestaurant);


		//tableProduct.setItems(newListProduct);
		showComponentMenu(false);
		//showComponentReport(false);
		showComponentUser(false);
		showComponentRestaurant(false);	
		showComponentEmployee(false);
		showComponentHome(true);

	}
}
