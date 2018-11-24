package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import controller.Restaurant;
import domain.Commodity;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ComboViewController extends Controller implements Initializable
{
	@FXML private TableView<Commodity> combo_table;
	@FXML private TableColumn<Commodity, String> colunmDescription;
	@FXML private TableColumn<Commodity, Number> columnPrice;
	@FXML private TableColumn<Commodity, String> columnName;
	
	@FXML private TextField name_textfield_t;
	@FXML private TextField price_textfield11;
	@FXML private JFXTextArea description_textarea1;
	@FXML private CheckBox checkbox_product;
	@FXML private Button signUp_button;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		colunmDescription.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDescription()));
		columnPrice.setCellValueFactory(cellData->new SimpleIntegerProperty((int) cellData.getValue().getPrice()));
		columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		
		combo_table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showInfoProduct((Commodity) newValue));
		ObservableList<Commodity> newListProduct = FXCollections.observableArrayList(Restaurant.getInstance().getCombos());
		combo_table.setItems(newListProduct);
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
			checkbox_product.setSelected(false);
		}
		else
		{
			name_textfield_t.setText(pProduct.getName().toString());
			price_textfield11.setText(String.valueOf(pProduct.getPrice()));
			description_textarea1.setText(String.valueOf(pProduct.getDescription()));
			checkbox_product.selectedProperty().set(true);
		}
		
	}
	
	public void closeWindow()
	{
		closeWindow(signUp_button);
	}
}
