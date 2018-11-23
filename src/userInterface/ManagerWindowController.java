package userInterface;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
	
	@FXML private Button see_combo_button;
	@FXML private Button update_combo_button;
	@FXML private Button dissable_combo_product;
	@FXML private Button dissable_product_button;
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
	@FXML private ImageView disable_image;
	@FXML private ImageView disable_image_product;
	
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
	
	public void showReport()
	{
		showComponentReport(false);
		showMenu(false);
	}
	
	public void showComponentMenu()
	{
		showMenu(true);
	}
	
	public void showMenu(boolean pBoolean)
	{
		main_label.setText(MENU_TEXT);
		see_combo_button.setVisible(pBoolean);
		update_combo_button.setVisible(pBoolean);
		dissable_combo_product.setVisible(pBoolean);
		dissable_product_button.setVisible(pBoolean);
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
		disable_image.setVisible(pBoolean);
		disable_image_product.setVisible(pBoolean);
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
	
	public void showComponentHome()
	{
		main_label.setText(HOME_TEXT);
		main_label.setVisible(true);
		showMenu(false);

	}
	
	public void showComponentUser()
	{
		main_label.setText(USER_TEXT);
		main_label.setVisible(true);
		showMenu(false);
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
		}
		//restaurant_table;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		/*
		columnAddress.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress()));
		columnLegalName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLegalNumber()));
	
		ObservableList<RestaurantUI> newListProduct = null;
		newListProduct = FXCollections.observableArrayList();//ControlSystem.getInstance().loadProduct());
		RestaurantUI o = new RestaurantUI("San Jose", "52s");
		RestaurantUI op = new RestaurantUI("San Jose", "529s");
		newListProduct.add(o);
		newListProduct.add(op);
		//restaurant_table.setItems(newListProduct);
		//newListProduct = FXCollections.observableArrayList();
		restaurant_table.setItems(newListProduct);


		//tableProduct.setItems(newListProduct);
		*/
	}
}
