package userInterface;

import java.io.IOException;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import library.interfaces.IConstantWindow;

public class ManagerWindowController extends Controller implements IConstantWindow
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
	@FXML private JFXTreeView restaurant_table;
	
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
}
