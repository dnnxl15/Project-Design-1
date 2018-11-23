package controller;

import domain.Product;
import java.util.ArrayList;

public class Branch 
{
	private static Branch instance;
	private Facade facade;
	
	private Branch()
	{
	}

	public static Branch getInstance()
	{	
		if(instance == null)
		{
			instance = new Branch();
		}
		return instance;
	}
	
	public boolean verifyUser(String pUsername, String pPassword)
	{
		boolean value = ClientFacade.getInstance().verifyClient(pUsername, pPassword);
		return value;
	}
	
	public void createUser(String pName, String pLastname, int pIdentification, String pUsername, String pEmail, String pPassword )
	{
		ClientFacade.getInstance().createUser(pName, pLastname, pIdentification, pUsername, pEmail,pPassword);
	}
	
	public boolean verifyMainManager(String pUsername, String pPassword)
	{
		return ManagerFacade.getInstance().verifyMainManager(pUsername, pPassword);
	}
	
	public boolean verifyBranchManager(String pUsername, String pPassword)
	{
		return BranchManagerFacade.getInstance().verifyBranchManager(pUsername, pPassword);
	}
	
	public void createProduct(String name, float price,String description, int idPerson)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(name);
		listParameters.add(price);
                listParameters.add(description);
                listParameters.add(idPerson);
	    ManagerFacade.getInstance().createProduct(listParameters);
	}
        public void createCombo(String cname, double price, int cpersonid)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(cname);
		listParameters.add(price);
                listParameters.add(cpersonid);
	    ManagerFacade.getInstance().createCombo(listParameters);
	}
        public ArrayList<Product> getProducts()
	{
		return ManagerFacade.getInstance().getProducts();
	}
        public void createRestaurant(String pAddress, String pLegalNumber)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pAddress);
		listParameters.add(pLegalNumber);
	    ManagerFacade.getInstance().createRestarant(listParameters);
	}
        
        //-------------
        
        
        public void disableProduct(String pname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(pname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void disableCombo(String cname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(cname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void enableProduct(String pname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(pname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void enableCombo(String cname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(cname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
}