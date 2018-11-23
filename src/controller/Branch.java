package controller;

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
	
	public void createRestaurant(String pAddress, String pLegalNumber)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pAddress);
		listParameters.add(pLegalNumber);
	    ManagerFacade.getInstance().createRestarant(listParameters);
	}
}