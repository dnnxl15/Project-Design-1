package userInterface;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

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
	private ReportUI reportUI;

	
	public void initData(ReportUI pReportUI, ChartType pChartType) 
	{
		  reportUI = pReportUI;
		  chartType = pChartType;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chartType = GlobalChart.getInstance().getChartType();
		if(chartType== ChartType.Pie_Chart_Type)
		{
			ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Grapefruit", 13),
	                new PieChart.Data("Oranges", 25),
	                new PieChart.Data("Plums", 10),
	                new PieChart.Data("Pears", 22),
	                new PieChart.Data("Apples", 30),
	                new PieChart.Data("Apples", 30));
	        pie_chart.setData(pieChartData);
	        pie_chart.setTitle("Imported Fruits");
	        
	        bar_chart.setVisible(false);
	    	line_chart.setVisible(false);
	    	pie_chart.setVisible(true);
		}
		else if(chartType== ChartType.Bar_Chart_Type)
		{
	        category_axis.setLabel("Product");
	        category_axis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
	                "January", 
	                "February",
	                "March")));
	        number_axis.setLabel("Sales");
	        bar_chart.setTitle("StackedBarChart");
	          
	        XYChart.Series<String,Number> series1 = new XYChart.Series();
	        series1.setName("XYChart.Series 1");
	           
	        series1.getData().add(new XYChart.Data("January", 100));
	        series1.getData().add(new XYChart.Data("February", 200));
	        series1.getData().add(new XYChart.Data("March", 50));
	          
	        XYChart.Series<String,Number> series2 = new XYChart.Series();
	        series2.setName("XYChart.Series 2");
	           
	        series2.getData().add(new XYChart.Data("January", 150));
	        series2.getData().add(new XYChart.Data("February", 100));
	        series2.getData().add(new XYChart.Data("March", 60));
	          
	        bar_chart.getData().addAll(series1, series2);
	        
	        bar_chart.setVisible(true);
	    	line_chart.setVisible(false);
	    	pie_chart.setVisible(false);
		}
		else
		{
	        category_axis_line.setLabel("Product");
	        category_axis_line.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
	                "January", 
	                "February",
	                "March")));
	        number_axis_line.setLabel("Sales");
	           
	        line_chart.setTitle("StackedBarChart");
	          
	        XYChart.Series<String,Number> series1 = new XYChart.Series();
	        series1.setName("XYChart.Series 1");
	           
	        series1.getData().add(new XYChart.Data("January", 100));
	        series1.getData().add(new XYChart.Data("February", 200));
	        series1.getData().add(new XYChart.Data("March", 50));
	          
	        XYChart.Series<String,Number> series2 = new XYChart.Series();
	        series2.setName("XYChart.Series 2");
	           
	        series2.getData().add(new XYChart.Data("January", 150));
	        series2.getData().add(new XYChart.Data("February", 100));
	        series2.getData().add(new XYChart.Data("March", 60));
	          
	        line_chart.getData().addAll(series1, series2);
	        
	        bar_chart.setVisible(false);
	    	line_chart.setVisible(true);
	    	pie_chart.setVisible(false);
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