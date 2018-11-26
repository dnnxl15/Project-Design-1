package userInterface;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import controller.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import library.GlobalChart;
import library.ReportUI;
import library.enumerations.ChartType;
import library.enumerations.ReportType;
import library.interfaces.IConstantWindow;

public class GraphViewController extends Controller implements IConstantWindow, Initializable 
{
	@FXML private Button cancel_button;
	@FXML private PieChart pie_chart;
	@FXML private BarChart<String, Number> bar_chart;
	@FXML private LineChart<String, Number> line_chart;
	@FXML private NumberAxis number_axis;
	@FXML private CategoryAxis category_axis;
	@FXML private CategoryAxis category_axis_line;
	@FXML private NumberAxis number_axis_line;
	private ChartType chartType;

	
	public void initData(ReportUI pReportUI, ChartType pChartType) 
	{
		  chartType = pChartType;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chartType = GlobalChart.getInstance().getChartType();
		if(chartType== ChartType.Pie_Chart_Type)
		{

			if(ReportType.Branch_Type_Branch == ReportUI.getInstance().getType())
			{
				
			}
			if(ReportType.Branch_Type_General == ReportUI.getInstance().getType())
			{
				
			}
			else if(ReportType.Date_Type_Branch == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Date_Type_Manager == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Product_Type_Manager == ReportUI.getInstance().getType())
			{
				pie_chart.setData(Restaurant.getInstance().getPieChartDataProductByGeneral());
				pie_chart.setTitle("Product vs Sale");
				
				bar_chart.setVisible(false);
				line_chart.setVisible(false);
				pie_chart.setVisible(true);
			}
			else
			{
			}	

	        bar_chart.setVisible(false);
	    	line_chart.setVisible(false);
	    	pie_chart.setVisible(true);
		}
		else if(chartType== ChartType.Bar_Chart_Type)
		{
			if(ReportType.Branch_Type_Branch == ReportUI.getInstance().getType())
			{
				
			}
			if(ReportType.Branch_Type_General == ReportUI.getInstance().getType())
			{
				
			}
			else if(ReportType.Date_Type_Branch == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Date_Type_Manager == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Product_Type_Manager == ReportUI.getInstance().getType())
			{
		        category_axis.setLabel("Product");
		        number_axis.setLabel("Sales");
		        bar_chart.setTitle("Product vs Sales");
		        bar_chart.getData().addAll(Restaurant.getInstance().getProductBarByGeneral());
				pie_chart.setTitle("Product vs Sale");

				bar_chart.setVisible(true);
				line_chart.setVisible(false);
				pie_chart.setVisible(false);
			}
			else
			{
			}	
	        //bar_chart.setVisible(false);
	    	//line_chart.setVisible(false);
	    	//pie_chart.setVisible(true);
		}
		else
		{
			if(ReportType.Branch_Type_Branch == ReportUI.getInstance().getType())
			{
				
			}
			if(ReportType.Branch_Type_General == ReportUI.getInstance().getType())
			{
				
			}
			else if(ReportType.Date_Type_Branch == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Date_Type_Manager == ReportUI.getInstance().getType())
			{
			}
			else if(ReportType.Product_Type_Manager == ReportUI.getInstance().getType())
			{
				category_axis.setLabel("Product");
		        number_axis.setLabel("Sales");
		        line_chart.setTitle("Product vs Sales");
		        line_chart.getData().addAll(Restaurant.getInstance().getProductBarByGeneral());

				pie_chart.setTitle("Product vs Sale");
				
				bar_chart.setVisible(false);
				line_chart.setVisible(true);
				pie_chart.setVisible(false);
			}
			else
			{
			}	
		}
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
}