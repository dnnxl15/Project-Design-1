package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.RestaurantUI;
import library.interfaces.IProcedure;
import static library.interfaces.IProcedure.INSERT_RESTAURANT_PROCEDURE;
import connection.*;
import domain.Client;
import domain.Combo;
import domain.Product;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import library.EmployeeUI;
import library.Gain;
import library.JobTitleUI;


public class ManagerFacade extends Facade
{
	
	private static ManagerFacade instance;
	
	private ManagerFacade()
	{
		ControlUser.getInstance();
	}

	public static ManagerFacade getInstance()
	{	
		if(instance == null)
		{
			instance = new ManagerFacade();
		}
		return instance;
	}
	
	public boolean verifyMainManager(String pUsername, String pPassword)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pUsername);
		listParameters.add(pPassword);
		return ControlUser.getInstance().verifyManager(listParameters);
	}
        

	//Obtener todos los restaurantes
	public ArrayList<RestaurantUI> getRestaurant()
	{
		return ControlRestaurant.getInstance().getRestaurant();
	}
	
	public void createRestarant(ArrayList<Object> pListObject)
	{
		ControlRestaurant.getInstance().createRestaurant(pListObject);
	}
        public ArrayList<Product> getAllProducts()
	{
		return ControlMenu.getInstance().getAllProducts();
	}
        public ArrayList<Combo> getAllCombos()
	{
		return ControlMenu.getInstance().getAllCombos();
	}
        
        public ArrayList<Product> getProducts()
	{
		return ControlMenu.getInstance().getProducts();
	}
        public ArrayList<Client> getClient()
	{
		return ControlUser.getInstance().getClient();
	}
        public ArrayList<Combo> getCombos()
	{
		return ControlMenu.getInstance().getCombos();
	}
	public ArrayList<JobTitleUI> getJobTitle()
	{
		return ControlUser.getInstance().getJobTitle();
	}
	public void createCombo(ArrayList<Object> cListObject)
	{
		ControlMenu.getInstance().createCombo(cListObject);
	}
        public void createProduct(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().createProduct(pListObject);
	}
        public void createEmployee(ArrayList<Object> pListObject)
	{
		ControlUser.getInstance().createEmployee(pListObject);
	}
       public void updateCombo(ArrayList<Object> cListObject)
	{
		ControlMenu.getInstance().updateCombo(cListObject);
	}
        public void updateProduct(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().updateProduct(pListObject);
	}
        public void createJobTitle(ArrayList<Object> pListObject)
	{
		ControlUser.getInstance().createJobTitle(pListObject);
	}
        public void updateJobTitle(ArrayList<Object> pListObject)
	{
		ControlUser.getInstance().updateJobTitle(pListObject);
	}
        
        //------------------------------------------
        
        
        public void disableProduct(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().disableProduct(pListObject);
	}
       public void disableCombo(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().disableCombo(pListObject);
	}
       public void enableProduct(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().enableProduct(pListObject);
	}
        public void enableCombo(ArrayList<Object> pListObject)
	{
		ControlMenu.getInstance().enableCombo(pListObject);
	}
        public ArrayList<EmployeeUI> getEmployee()
	{
		return ControlUser.getInstance().getEmployee();
	}
        public void updateEmployee(ArrayList<Object> cListObject)
	{
		ControlUser.getInstance().updateEmployee(cListObject);
	}
        public void updateClient(ArrayList<Object> cListObject)
	{
		ControlUser.getInstance().updateClient(cListObject);
	}
        public ObservableList<PieChart.Data> getPieChartDataProductByGeneral()
        {
                return ControlReport.getInstance().getPieChartDataProductByGeneral();
        }
        public ArrayList<Gain> getProductByGeneral()
        {
                return ControlReport.getInstance().getProductByGeneral();
        }
        
        public XYChart.Series<String,Number> getProductBarByGeneral()
        {
            return ControlReport.getInstance().getProductBarByGeneral();
        }
       public ObservableList<PieChart.Data> getPieChartDataComboByGeneral()
        {
                return ControlReport.getInstance().getPieChartDataComboByGeneral();
        }
        public ArrayList<Gain> getComboByGeneral()
        {
                return ControlReport.getInstance().getComboByGeneral();
        }
        
        public XYChart.Series<String,Number> getComboBarByGeneral()
        {
            return ControlReport.getInstance().getComboBarByGeneral();
        }
    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
