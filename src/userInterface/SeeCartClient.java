package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domain.Commodity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.GlobalCart;
import library.interfaces.IConstantWindow;

public class SeeCartClient extends Controller implements Initializable, IConstantWindow
{
    @FXML private Label amount_label;
    @FXML private Label name_label;
    @FXML private Label price_label;
    @FXML private Button cancel_button;
	@FXML private TableColumn<Commodity, String> colunmDescription;
	@FXML private TableColumn<Commodity, Number> columnPrice;
	@FXML private TableColumn<Commodity, String> columnName;
	@FXML private TableView<Commodity> product_table;
	private Commodity selected;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		colunmDescription.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDescription()));
		columnPrice.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getPrice()));
		product_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoComodity((Commodity) newValue));
		ObservableList<Commodity> newListProduct;
		newListProduct = FXCollections.observableArrayList(GlobalCart.getInstance().getListCommodity());
		product_table.setItems(newListProduct);
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
			name_label.setText(EMPTY);
			amount_label.setText(EMPTY);
			price_label.setText(EMPTY);
		}
		else
		{
			name_label.setText(pComoditySelected.getName().toString());
			amount_label.setText(String.valueOf(pComoditySelected.getMount()));
			price_label.setText(String.valueOf(pComoditySelected.getPrice()));
			selected = pComoditySelected;
		}
	}
	
	public void deleteCommodity()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, "Delete product", "Are you sure you wanna delete it?");
		if(value){
			GlobalCart.getInstance().deleteProduct(selected);
			initialize(null,null);
		}
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
	
	public void openCartPayWindow()
	{
		try {
			if(GlobalCart.getInstance().getListCommodity().isEmpty())
			{
				showAlert(AlertType.ERROR, "Product", "You must have something in your cart");
				return;
			}
			openWindow(PAY_CLIENT_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}