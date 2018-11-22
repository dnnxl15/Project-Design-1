package controller;

import java.util.ArrayList;

public class ManagerFacade 
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

}
