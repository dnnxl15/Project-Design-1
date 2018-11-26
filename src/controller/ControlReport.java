/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.Gain;
import library.IConstant;
import library.RestaurantUI;
import library.interfaces.IProcedure;

import static library.interfaces.IProcedure.*;


public class ControlReport extends Control 
{
	private static ControlReport instance;
	
	private ControlReport()
	{
	}
	
	public static ControlReport getInstance()
	{
		if(instance == null)
		{
			instance = new ControlReport();
		}
		return instance;
	}
	
	/**
	 * Pie chart data
	 * @return
	 */
	public ObservableList<PieChart.Data> getPieChartDataProductByGeneral()
	{       
            //Fechas
		 try
		 {
			 //Product
             ResultSet resultSet = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             ObservableList<PieChart.Data> listProductTmp = FXCollections.observableArrayList();
             while (resultSet.next()) 
             {
            	 String name =  resultSet.getString("name");
            	 float gain = resultSet.getInt("Gain");
            	 PieChart.Data data = new PieChart.Data(name, gain);
            	 listProductTmp.add(data);
              }
             //Combox
             ResultSet resultSet2 = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             while (resultSet2.next()) 
             {
            	 String name =  resultSet2.getString("name");
            	 float gain = resultSet2.getInt("Gain");
            	 PieChart.Data data = new PieChart.Data(name, gain);
            	 listProductTmp.add(data);
              }
             return listProductTmp;
         }
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
         return null;
     }
	
	/**
	 * Table data
	 * @return
	 */
	public ArrayList<Gain> getProductByGeneral()
	{
		 try
		 {
			 // Product
             ResultSet resultSet = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             ArrayList<Gain> listGain = new ArrayList<Gain>();
             while (resultSet.next()) 
             {
            	 String name =  resultSet.getString("name");
            	 float gain = resultSet.getInt("Gain");
            	 Gain gainTmp = new Gain(name, gain);
            	 listGain.add(gainTmp);
              }
             // Combobox
             ResultSet resultSet2 = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             while (resultSet2.next()) 
             {
            	 String name =  resultSet2.getString("name");
            	 float gain = resultSet2.getInt("Gain");
            	 Gain gainTmp = new Gain(name, gain);
            	 listGain.add(gainTmp);
              }
             return listGain;
         }
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
         return null;
     }
	
	/**
	 * Bar chart data
	 * @return
	 */
	public XYChart.Series<String,Number> getProductBarByGeneral()
	{
		 try
		 {
	     //Product
             XYChart.Series<String,Number> series1 = new XYChart.Series();
	     series1.setName("Product");
             ResultSet resultSet = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             while (resultSet.next()) 
             {
            	 String name =  resultSet.getString("name");
            	 float gain = resultSet.getInt("Gain");
            	 series1.getData().add(new XYChart.Data(name, gain));
              }
             // Combobox
             ResultSet resultSet2 = connectionPool.request(IProcedure.REPORT_PRODUCT_PROCEDURE, null);
             while (resultSet2.next()) 
             {
            	 String name =  resultSet2.getString("name");
            	 float gain = resultSet2.getInt("Gain");
            	 series1.getData().add(new XYChart.Data(name, gain));
              }
             return series1;
         }
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
         return null;
     }
}