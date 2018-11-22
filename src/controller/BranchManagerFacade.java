package controller;

import java.util.ArrayList;

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

}
