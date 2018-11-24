package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domain.Commodity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import library.EmployeeUI;
import library.Gain;
import library.ReportUI;
import library.enumerations.ReportType;
import library.interfaces.IConstantWindow;

public class ReportSalesController extends Controller implements IConstantWindow, Initializable
{
	private ReportUI reportUI;
	@FXML private TableColumn<Gain, String> columnProduct;
	@FXML private TableColumn<Gain, Number> columnSale;
	@FXML private TableView<Gain> saleTable;
	@FXML private Button cancel_button;
	
	public void initData(ReportUI pReportUI) 
	{
		  reportUI = pReportUI;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		columnProduct.setText(getTypeText(ReportType.Branch_Type_Branch)); /////////////////
		columnProduct.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTypeName()));
		columnSale.setCellValueFactory(cellData->new SimpleIntegerProperty(cellData.getValue().getGain()));
		
		ObservableList<Gain> newListSale = null;
		//newListRestaurant = FXCollections.observableArrayList(Restaurant.getInstance().getRestaurant());//ControlSystem.getInstance().loadProduct());
		//mount_restaurant_label.setText("("+newListRestaurant.size()+")");

		//employee_table.setItems(newListEmployee);
		//result_label.setText("("+newListEmployee.size()+")");
		
	}
	
	public String getTypeText(ReportType pType)
	{
		if(ReportType.Branch_Type_Branch == pType || ReportType.Branch_Type_General == pType )
		{
			return "Branch";
		}
		else if(ReportType.Date_Type_Branch == pType || ReportType.Date_Type_Manager == pType)
		{
			return "Date";
		}
		else if(ReportType.Product_Type_Branch == pType || ReportType.Product_Type_Manager == pType)
		{
			return "Product";
		}
		else
		{
			return "";
		}
	}
	
	public void closeWindow()
	{
		closeWindow(cancel_button);
		
	}
	
	//////////////////////////////////
	public void openSalaryWindow()
	{
		try {
			openWindow(EMPLOYEE_SALARY_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
