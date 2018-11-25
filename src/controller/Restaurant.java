package controller;

import domain.Combo;
import domain.Product;
import java.util.ArrayList;
import library.EmployeeUI;
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
        public void updateEmployee(int pEmployeeID,String newName, String newLastName , float newSalary,String newRol){
            Branch.getInstance().updateEmployee(pEmployeeID,newName,newLastName,newSalary,newRol);
        }
        
}
