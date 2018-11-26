package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Restaurant;
import domain.Commodity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import library.EmployeeUI;
import library.Gain;
import library.GlobalChart;
import library.ReportUI;
import library.enumerations.ChartType;
import library.enumerations.ReportType;
import library.interfaces.IConstantWindow;

public class ReportSalesController extends Controller implements IConstantWindow, Initializable
{
	@FXML private TableColumn<Gain, String> columnProduct;
	@FXML private TableColumn<Gain, Number> columnSale;
	@FXML private TableView<Gain> saleTable;
	@FXML private Button cancel_button;
	@FXML private Label mount_restaurant_label;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		columnProduct.setText(getTypeText(ReportUI.getInstance().getType()));
		columnProduct.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTypeName()));
		columnSale.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getGain()));
		ObservableList<Gain> newListSale = null;
		newListSale = FXCollections.observableArrayList(Restaurant.getInstance().getProductByGeneral());
		mount_restaurant_label.setText("("+newListSale.size()+")");
		saleTable.setItems(newListSale);		
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
	
	public void openGraphPie() throws IOException
	{
		GlobalChart.getInstance().setChartType(ChartType.Pie_Chart_Type);
		try {
			openWindow(GRAPH_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openGraphBar() throws IOException
	{
		GlobalChart.getInstance().setChartType(ChartType.Bar_Chart_Type);
		try {
			openWindow(GRAPH_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openGraphLine() throws IOException
	{
		GlobalChart.getInstance().setChartType(ChartType.Line_Chart_Type);
		try {
			openWindow(GRAPH_VIEW_WINDOW, MAX_HEIGHT_WINDOW, MAX_WIDTH_WINDOW, OVNI_IMAGE_COLOR_PATH, OVNIRESTAURANT_TITLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}