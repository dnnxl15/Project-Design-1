package controller;

import java.util.ArrayList;

import library.RestaurantUI;

public class BranchManagerFacade 
{
	
	private static BranchManagerFacade instance;
	
	private BranchManagerFacade()
	{
		ControlUser.getInstance();
	}

	public static BranchManagerFacade getInstance()
	{	
		if(instance == null)
		{
			instance = new BranchManagerFacade();
		}
		return instance;
	}
	
	public boolean verifyBranchManager(String pUsername, String pPassword)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pUsername);
		listParameters.add(pPassword);
		return ControlUser.getInstance().verifyManagerSub(listParameters);
	}
	
	public ArrayList<RestaurantUI> getRestaurant()
	{
		return ControlRestaurant.getInstance().getRestaurant();
	}
	
	public void createRestaurant(String pAddress, String pLegalNumber)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pAddress);
		listParameters.add(pLegalNumber);
	    ManagerFacade.getInstance().createRestarant(listParameters);
	}

}
