package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Commodity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import library.GlobalCart;
import library.GlobalPay;
import library.interfaces.IConstantWindow;

public class BillViewController extends Controller implements IConstantWindow, Initializable
{
	@FXML private Button cancel_button;
	
	@FXML private TextField paymentTextfield;
	@FXML private TextField creditTextfield;
	@FXML private TextField deliverTextField;
	@FXML private TextField direction_textfield;
	@FXML private TextField restaurant_textfield;
	@FXML private Label labelMount;
	@FXML private TableView<Commodity> product_table;
	@FXML private TableColumn<Commodity, String> columnName;
	@FXML private TableColumn<Commodity, Number>  columnPrice;
	@FXML private TableColumn<Commodity, Number>  colunmMount;
	@FXML private Label labelDirection;
	@FXML private Label labelCreditCard;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		paymentTextfield.setText(GlobalPay.getInstance().getPaymentMethod());
		String selectedMethod = GlobalPay.getInstance().getPaymentMethod();
		  if(selectedMethod.equals(TRANSFER_TEXT))
		  {
			  labelCreditCard.setText("Transfer number account");
			  creditTextfield.setText(GlobalPay.getInstance().getInfo());
		  }
		  else if(selectedMethod.equals(CHECK_TEXT))
		  {
			  labelCreditCard.setText("Check number");
			  creditTextfield.setText(GlobalPay.getInstance().getInfo());
		  }
		  else if(selectedMethod.equals(CREDIT_TEXT))
		  {
			  labelCreditCard.setText("Credit card number");
			  creditTextfield.setText(GlobalPay.getInstance().getInfo());
		  }
		  else 
		  {
			  labelCreditCard.setText("Mount cash");
			  creditTextfield.setText(GlobalPay.getInstance().getInfo());
		  }
		  deliverTextField.setText(GlobalPay.getInstance().getDeliever());
		 
		  if(GlobalPay.getInstance().getDeliever().equals("Express"))
			{
				labelDirection.setVisible(true);
				direction_textfield.setVisible(true);
			}
			else
			{
				labelDirection.setVisible(false);
				direction_textfield.setVisible(false);
				direction_textfield.setText(GlobalPay.getInstance().getDirection());

			}
		  labelMount.setText(String.valueOf(GlobalCart.getInstance().calculateMount()));
		  restaurant_textfield.setText(GlobalPay.getInstance().getRestaurant());
		  
		  columnName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		  colunmMount.setCellValueFactory(cellData->new SimpleIntegerProperty(cellData.getValue().getMount()));
			columnPrice.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getPrice()));
			ObservableList<Commodity> newListProduct;
			newListProduct = FXCollections.observableArrayList(GlobalCart.getInstance().getListCommodity());
			product_table.setItems(newListProduct);
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