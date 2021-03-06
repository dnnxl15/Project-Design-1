package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import library.GlobalUser;
import javafx.scene.control.Alert.AlertType;

import domain.*;

public class ComboRegisterController extends Controller implements Initializable
{
	@FXML private TableView<Commodity> product_table;
	@FXML private TableColumn<Commodity, String> colunmDescription;
	@FXML private TableColumn<Commodity, Number> columnPrice;
	@FXML private TableColumn<Commodity, String> columnName;
	@FXML private Button add_button;
	
	@FXML private TextField name_textfield;
	@FXML private TextField price_textfield;
	@FXML private TextArea description_textarea;
	
	@FXML private TextField name_textfield_t;
	@FXML private TextField price_textfield11;
	@FXML private TextArea description_textarea1;
	@FXML private Button cancel_button;

	public void registerCombo()
	{
    	String name = name_textfield.getText().toString();
    	int price;
    	String description = description_textarea.getText().toString();
    	try
		{
    		price =  Integer.parseInt(price_textfield.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Price" , "Must be a number");
			return;
		}
    	if(name.equals(EMPTY) || description.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
   			Restaurant.getInstance().createCombo(name, price, description, GlobalUser.getInstance().getUsername());
   			showAlert(AlertType.CONFIRMATION ,"Product register" , "Product is registered in the system");
   			name_textfield.setText(EMPTY);
   			description_textarea.setText(EMPTY);
   			price_textfield.setText(EMPTY);
    	}	
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunmDescription.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		columnPrice.setCellValueFactory(cellData->new SimpleIntegerProperty((int) cellData.getValue().getPrice()));
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDescription()));
		
		product_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoProduct((Commodity) newValue));
		ObservableList<Commodity> newListProduct = FXCollections.observableArrayList(Restaurant.getInstance().getProducts());
		product_table.setItems(newListProduct);
	}
	
	/**
	 * Method show the info of the product
	 * Author: Danny Xie Li
	 * Description: The next method show the info of the product.
	 * Last modification: 08/10/18
	 */
	public void showInfoProduct(Commodity pProduct)
	{
		if(pProduct == null)
		{
			name_textfield_t.setText(EMPTY);
			price_textfield11.setText(EMPTY);
			description_textarea1.setText(EMPTY);
		}
		else
		{
			name_textfield_t.setText(pProduct.getName().toString());
			price_textfield11.setText(String.valueOf(pProduct.getPrice()));
			description_textarea1.setText(String.valueOf(pProduct.getDescription()));
		}
		
	}
	
	public void closeWindow()
	{
		closeWindow(cancel_button);
	}
}
