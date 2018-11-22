package controller;

import java.util.ArrayList;

import connection.ConnectionPool;

public class ClientFacade extends Facade
{
	private static ClientFacade instance;
	
	private ClientFacade()
	{
		ControlUser.getInstance();
	}

	public static ClientFacade getInstance()
	{	
		if(instance == null)
		{
			instance = new ClientFacade();
		}
		return instance;
	}
	
	public void createUser(String pName, String pLastname, int pIdentification, String pUsername, String pEmail, String pPassword )
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pName);
		listParameters.add(pLastname);
		listParameters.add(pIdentification);
		listParameters.add(pUsername);
		listParameters.add(pEmail);
		listParameters.add(pPassword);
		ControlUser.getInstance().createUser(listParameters);
	}
	
	public boolean verifyClient(String pUsername, String pPassword)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pUsername);
		listParameters.add(pPassword);
		return ControlUser.getInstance().verifyUser(listParameters);
	}
}
