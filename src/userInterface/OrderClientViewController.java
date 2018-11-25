package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import controller.Restaurant;
import domain.Commodity;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import library.EmployeeUI;
import library.GlobalCart;
import library.interfaces.IConstantWindow;

public class OrderClientViewController extends Controller implements Initializable, IConstantWindow
{
    @FXML private Spinner<Integer> spinner;
    @FXML private TextField name_textfield;
    @FXML private TextField price_textfield;
    @FXML private Button cancel_button;
	@FXML private TableColumn<Commodity, String> colunmDescription;
	@FXML private TableColumn<Commodity, Number> columnPrice;
	@FXML private TableColumn<Commodity, String> columnName;
	@FXML private TableView<Commodity> product_table;
	private Commodity comoditySelected;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spinner.getValueFactory().setValue(ONE);
		spinner.getValueFactory().increment(ONE);
		IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(CERO, CERO);
		factory.setMax(100);
		factory.setMin(ONE);
		factory.setValue(ONE);
		spinner.setValueFactory(factory);	
		
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		colunmDescription.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDescription()));
		columnPrice.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getPrice()));
		product_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoComodity((Commodity) newValue));
		ObservableList<Commodity> newListProduct;
		//newListProduct = FXCollections.observableArrayList(Restaurant.getInstance().getEmployee());
	}
	
	/**
	 * 
	 */
	public void closeWindow(){
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value){
			closeWindow(cancel_button);
		}
	}
	
	/**
	 * Method show the info of the product
	 * Author: Danny Xie Li
	 * Description: The next method show the info of the product.
	 * Last modification: 08/10/18
	 */
	public void showInfoComodity(Commodity pComoditySelected)
	{
		if(pComoditySelected == null)
		{
			name_textfield.setText(EMPTY);
			price_textfield.setText(EMPTY);
		}
		else
		{
			name_textfield.setText(pComoditySelected.getName().toString());
			price_textfield.setText(String.valueOf(pComoditySelected.getPrice()));
			comoditySelected = pComoditySelected;
		}
	}
	
	public void selectedProduct()
	{
		// Set Amount
		GlobalCart.getInstance().addProduct(comoditySelected);
	}
	
	public void openCartWindow()
	{
		try {
			openWindow(CART_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}