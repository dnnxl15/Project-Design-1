package controller;

import domain.Product;
import java.util.ArrayList;

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
	
	public void createRestaurant(String pAddress, String pLegalNumber)
	{
		Branch.getInstance().createRestaurant(pAddress, pLegalNumber);
	}
        public void createProduct(String name, float price,String description, int idPerson)
	{
		Branch.getInstance().createProduct(name, price,description,idPerson);
	}
	public void createCombo(String cname, double price, int cpersonid)
	{
		Branch.getInstance().createCombo(cname, price,cpersonid);
	}

	public ArrayList<Product> getProducts()
	{
		return Branch.getInstance().getProducts();
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
        
}