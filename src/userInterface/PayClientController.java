package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import controller.Restaurant;
import domain.Commodity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import library.ClientGlobal;
import library.GlobalCart;
import library.GlobalPay;
import library.IConstant;
import library.RestaurantUI;
import library.interfaces.IConstantWindow;

public class PayClientController extends Controller implements IConstantWindow, Initializable
{
	@FXML private StackPane stackPanel;
	@FXML private RadioButton express_radioButton;
	@FXML private RadioButton pickUp_radioButton;
	@FXML private TableColumn<Commodity, Number> colunmAmount;
	@FXML private TableColumn<Commodity, Number> columnPrice;
	@FXML private TableColumn<Commodity, String> columnName;
	@FXML private TableView<Commodity> product_table;
	@FXML private Button cancel_button;
	@FXML private Label labelMountTotal;
	@FXML private ComboBox<String> comboBoxPaymentMethod;
	@FXML private TextField number_card_something;
	@FXML private Label label_something;
	@FXML private TextField direction_textfield;
	@FXML private Label labelDirection;
	@FXML private Label labelRestaurant;
	@FXML private ComboBox<String> comboboxrestaurant;

	
	public void payMethod() throws IOException
    {
    	int numberCard;
    	boolean pickUp = pickUp_radioButton.isSelected();
    	boolean express = express_radioButton.isSelected();
    	String direction = direction_textfield.getText().toString();
    	String payment;
    	try
		{
        	payment = comboBoxPaymentMethod.getSelectionModel().getSelectedItem().toString();
    		numberCard =  Integer.parseInt(number_card_something.getText().toString());
		}
		catch(Exception e)
		{
			showAlert(AlertType.ERROR ,"Number" , "Must be a number");
			return;
		}
    	if(payment.equals(EMPTY))
    	{
			showAlert(AlertType.ERROR ,"All fields" , "All fields must be complete");
			return;
    	}
    	else
    	{
    		//Restaurant.getInstance().createEmployee(name, lastname, identification, email, role, salary, restaurant);
    		direction_textfield.setText(EMPTY);
    		number_card_something.setText(EMPTY);
			showAlert(AlertType.CONFIRMATION ,"Transaction" , "Transaction completed");
    	}	
    	payBill();
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{		
		comboboxrestaurant.getItems().clear();
		comboboxrestaurant.getItems().addAll(getDirections(Restaurant.getInstance().getRestaurant()));
		comboBoxPaymentMethod.getItems().clear();
	    comboBoxPaymentMethod.getItems().addAll(TRANSFER_TEXT, CHECK_TEXT, CREDIT_TEXT, CASH_TEXT);
	    labelMountTotal.setText(String.valueOf(GlobalCart.getInstance().calculateMount()));
	}
	
	public ArrayList<String> getDirections(ArrayList<RestaurantUI> pListRestaurant)
	{
		ArrayList<String> listDirections = new ArrayList<String>();
		int index = 0;
		while(pListRestaurant.size()>index){
			listDirections.add(pListRestaurant.get(index).getAddress());
			index++;
		}
		return listDirections;
	}
	
	
	@FXML
	private void handleComboBoxAction() {
	  String selectedMethod = comboBoxPaymentMethod.getSelectionModel().getSelectedItem();
	  if(selectedMethod.equals(TRANSFER_TEXT))
	  {
		  label_something.setText("Transfer number account");
	  }
	  else if(selectedMethod.equals(CHECK_TEXT))
	  {
		  label_something.setText("Check number");
	  }
	  else if(selectedMethod.equals(CREDIT_TEXT))
	  {
		  label_something.setText("Credit card number");
	  }
	  else 
	  {
		  label_something.setText("Mount cash");
	  }
	}
	

	public void markExpress()
	{
		if(express_radioButton.isSelected())
		{
			showInfoDialog("Method express deliver", "The deliver method express will take approximately between 20 to 30 minutes", "Accept");
			pickUp_radioButton.selectedProperty().set(!express_radioButton.isSelected());
			labelDirection.setVisible(true);
			direction_textfield.setVisible(true);
		}
		else
		{
			pickUp_radioButton.selectedProperty().set(!express_radioButton.isSelected());
			labelDirection.setVisible(false);
			direction_textfield.setVisible(false);
		}
	}
	
	public void markPickUp()
	{
		if(pickUp_radioButton.isSelected())
		{
			showInfoDialog("Method pick up deliver", "Your order will take approximately between 20 to 30 minutes", "Accept");
			express_radioButton.selectedProperty().set(!pickUp_radioButton.isSelected());
			labelDirection.setVisible(false);
			direction_textfield.setVisible(false);
		}
		else
		{
			express_radioButton.selectedProperty().set(!pickUp_radioButton.isSelected());
			labelDirection.setVisible(true);
			direction_textfield.setVisible(true);
		}
	}
	
	public void showInfoDialog(String pHeader, String pBody, String pButton){
	    JFXDialogLayout content = new JFXDialogLayout();
	    content.setHeading(new Text(pHeader));
	    content.setBody(new Text(pBody));
	    stackPanel.toFront();
	    JFXDialog dialog = new JFXDialog(stackPanel, content, JFXDialog.DialogTransition.CENTER);
	    JFXButton button = new JFXButton(pButton);
	    button.addEventHandler(ActionEvent.ACTION, (e)-> {
	   		dialog.close();
	   		stackPanel.toBack();
	   	});
	    content.setActions(button);
	    dialog.show();
	}
	
	public void closeWindow()
	{
		boolean value = showAlert(AlertType.CONFIRMATION, SIGN_OFF, MESSAGE_SIGN_OFF);
		if(value)
		{
			closeWindow(cancel_button);
		}
	}
	
	public String getRestaurantLegalNumber(String pDirection, ArrayList<RestaurantUI> pListRestaurant)
	{
		String legal;
		int index = 0;
		while(pListRestaurant.size()>index)
		{
			if(pListRestaurant.get(index).getAddress().equals(pDirection))
			{
				return pListRestaurant.get(index).getLegalNumber();
			}
			index++;
		}
		return "";
	}
	
	public int translatePaymentMethod(String pPayment)
	{
		if(pPayment.equals(IConstant.CASH_TEXT))
		{
			return 0;
		}
		else if(pPayment.equals(IConstant.CHECK_TEXT))
		{
			return 1;
		}
		else if(pPayment.equals(IConstant.CREDIT_TEXT))
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}

	
	public int translateDeliveryType()
	{
		if(express_radioButton.isSelected())
		{
			return 1;
			}
		else
		{
			return 0;
			}
	}
	
	public String translateDeliveryTypeString()
	{
		if(express_radioButton.isSelected())
		{
			return "Express";
			}
		else
		{
			return "Pick up";
			}
	}
	
	public void payBill()
	{
		String username = ClientGlobal.getInstance().getClient().getUsername();
		int typeDelivery = translateDeliveryType();
		int paymethod = translatePaymentMethod(comboBoxPaymentMethod.getSelectionModel().getSelectedItem().toString());
		String restaurant = comboboxrestaurant.getSelectionModel().getSelectedItem().toString();
		String legalNumber = getRestaurantLegalNumber(restaurant, Restaurant.getInstance().getRestaurant());
		
		GlobalPay.getInstance().setDeliever(translateDeliveryTypeString());
		GlobalPay.getInstance().setDirection(direction_textfield.getText().toString());
		GlobalPay.getInstance().setInfo(number_card_something.getText().toString());
		GlobalPay.getInstance().setListCommodity(GlobalCart.getInstance().getListCommodity());
		GlobalPay.getInstance().setPaymentMethod(comboBoxPaymentMethod.getSelectionModel().getSelectedItem().toString());
		GlobalPay.getInstance().setRestaurant(restaurant);
		
		try {
			openWindow(BILL_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
			try {
				Thread.sleep(OREDER_WAIT);
				openWindow(SERVICE_EVALUATION_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
