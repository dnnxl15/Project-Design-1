package controller;

import connection.ConnectionPool;
import domain.User;

public class ControlUser extends Control
{
	private static ControlUser controlUser;
	
	private ControlUser()
	{
		super();
	}
	
	public static ControlUser getInstance()
	{
		if(controlUser == null)
		{
			controlUser = new ControlUser();
		}
		return controlUser;
	}
	
	public void createUser()
	{
		
	}
	
	public boolean verifyUser(User pUser)
	{
		return false;
	}
	
	public boolean removeUser(User pUser)
	{
		return false;
	}
}