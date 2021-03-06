package controller;

import domain.Client;
import domain.Combo;
import domain.Product;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import library.EmployeeUI;
import library.Gain;
import library.JobTitleUI;

import library.RestaurantUI;

public class Restaurant 
{
	private Branch branch;
	
	private static Restaurant instance;
	
	private Restaurant()
	{
	}

	public static Restaurant getInstance()
	{	
		if(instance == null)
		{
			instance = new Restaurant();
		}
		return instance;
	}
	
	public boolean verifyUser(String pUsername, String pPassword)
	{
		boolean value = Branch.getInstance().verifyUser(pUsername, pPassword);
		return value;
	}
	
	public void createUser(String pName, String pLastname, int pIdentification, String pUsername, String pEmail, String pPassword )
	{
		Branch.getInstance().createUser(pName, pLastname, pIdentification, pUsername, pEmail,pPassword);
	}
	
	public boolean verifyBranchManager(String pUsername, String pPassword)
	{
		boolean value = Branch.getInstance().verifyBranchManager(pUsername, pPassword);
		return value;
	}
	
	public boolean verifyMainManager(String pUsername, String pPassword)
	{
		boolean value = Branch.getInstance().verifyMainManager(pUsername, pPassword);
		return value;
	}
	 public void createEmployee(String eName, String eLastName,int eIdentification,String email,String eJobTitle,float eSalary ,String eRestNum )
	{
             Branch.getInstance().createEmployee(eName, eLastName, eIdentification, email, eJobTitle, eSalary, eRestNum); 
        }
        public void createJobTitle(String cname, float minSalary,float maxSalary)
        {
             Branch.getInstance().createJobTitle(cname, minSalary, maxSalary);
        }
	public void createRestaurant(String pAddress, String pLegalNumber)
	{
		Branch.getInstance().createRestaurant(pAddress, pLegalNumber);
	}
        public void createProduct(String name, float price,String description, String idPerson)
	{
		Branch.getInstance().createProduct(name, price,description,idPerson);
	}
	public void createCombo(String cname, double price,String description ,String cpersonid)
	{
		Branch.getInstance().createCombo(cname, price,description,cpersonid);
	}
        public void updateCombo(int comboID, String newName, float newPrice , String newDescription, Boolean status)
	{
		Branch.getInstance().updateCombo(comboID,newName,newPrice,newDescription,status);
	}
        public void updateProduct(int productID, String newName, float newPrice , String newDescription,Boolean status)
	{
		Branch.getInstance().updateProduct(productID,newName,newPrice,newDescription,status);
	}
        public void updateJobTitle(int idJobTitle,String cname, float minSalary,float maxSalary)
	{
		Branch.getInstance().updateJobTitle(idJobTitle,cname,minSalary,maxSalary);
	}
	public ArrayList<Product> getAllProducts()
	{
		return Branch.getInstance().getAllProducts();
	}
        public ArrayList<Combo> getAllCombos()
	{
		return Branch.getInstance().getAllCombos();
	}
        
	public ArrayList<Product> getProducts()
	{
		return Branch.getInstance().getProducts();
	}
        public ArrayList<Combo> getCombos()
	{
		return Branch.getInstance().getCombos();
	}
        public ArrayList<EmployeeUI> getEmployee()
	{
		return Branch.getInstance().getEmployee();
	}
        public ArrayList<JobTitleUI> getJobTitle()
	{
		return Branch.getInstance().getJobTitle();
	}
        public ArrayList<Client> getClient()
	{
		return Branch.getInstance().getClient();
	}
	public ArrayList<RestaurantUI> getRestaurant()
	{
		return BranchManagerFacade.getInstance().getRestaurant();
	}
        public void enableProduct(String name)
	{
		Branch.getInstance().enableProduct(name);
	}
        public void disableProduct(String name )
	{
		Branch.getInstance().disableProduct(name);
	}
        public void enableCombo(String name)
	{
		Branch.getInstance().enableCombo(name);
	}
        public void disableCombo(String name )
	{
		Branch.getInstance().disableCombo(name);
	}
        public void updateEmployee(int pEmployeeID,String newName, String newLastName , float newSalary,String newRol,String newidRestaurant){
                Branch.getInstance().updateEmployee(pEmployeeID,newName,newLastName,newSalary,newRol,newidRestaurant);
        }
        public void updateClient(int pClientID,String pNewName, String pNewLastname , int pNewIdentification,String pNewUsername ,String pNewPassword	)
        {
               Branch.getInstance().updateClient( pClientID, pNewName,  pNewLastname ,  pNewIdentification, pNewUsername , pNewPassword);
        
        }
        public ObservableList<PieChart.Data> getPieChartDataProductByGeneral()
        {
                return Branch.getInstance().getPieChartDataProductByGeneral();
        }
        public ArrayList<Gain> getProductByGeneral()
        {
                return Branch.getInstance().getProductByGeneral();
        }
        public XYChart.Series<String,Number> getProductBarByGeneral()
        {
            return Branch.getInstance().getProductBarByGeneral();
        }
        public ObservableList<PieChart.Data> getPieChartDataComboByGeneral()
        {
                return Branch.getInstance().getPieChartDataComboByGeneral();
        }
        public ArrayList<Gain> getComboByGeneral()
        {
                return Branch.getInstance().getComboByGeneral();
        }
        
        public XYChart.Series<String,Number> getComboBarByGeneral()
        {
            return Branch.getInstance().getComboBarByGeneral();
        }
        public ObservableList<PieChart.Data> getPieChartDataByDateByGeneral()
        {
                return Branch.getInstance().getPieChartDataByDateByGeneral();
        }
        public ArrayList<Gain> getByDateByGeneral()
        {
                return Branch.getInstance().getByDateByGeneral();
        }
        
        public XYChart.Series<String,Number> getByDateBarByGeneral()
        {
            return Branch.getInstance().getByDateBarByGeneral();
        }
        
        
        public Branch getBranch() 
        {
		return branch;
	}

	public void setBranch(Branch branch) 
        {
		this.branch = branch;
	}
        
}
