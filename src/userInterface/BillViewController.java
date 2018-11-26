package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Commodity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		paymentTextfield.setText(GlobalPay.getInstance().getPaymentMethod());
		paymentTextfield.setText(GlobalPay.getInstance().getPaymentMethod());
		String selectedMethod = GlobalPay.getInstance().getPaymentMethod();
		  if(selectedMethod.equals(TRANSFER_TEXT))
		  {
			  labelCreditCard.setText("Transfer number account");
		  }
		  else if(selectedMethod.equals(CHECK_TEXT))
		  {
			  labelCreditCard.setText("Check number");
		  }
		  else if(selectedMethod.equals(CREDIT_TEXT))
		  {
			  labelCreditCard.setText("Credit card number");
		  }
		  else 
		  {
			  labelCreditCard.setText("Mount cash");
		  }
		  creditTextfield.setText(GlobalPay.getInstance().getInfo());
		  deliverTextField.setText(GlobalPay.getInstance().getDeliever());
		 
		  if(GlobalPay.getInstance().getDeliever().equals("Express"))
			{
				labelDirection.setVisible(false);
				direction_textfield.setVisible(false);
			}
			else
			{
				labelDirection.setVisible(true);
				direction_textfield.setVisible(true);
				direction_textfield.setText(GlobalPay.getInstance().getDirection());

			}
		  restaurant_textfield.setText(GlobalPay.getInstance().getRestaurant());
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