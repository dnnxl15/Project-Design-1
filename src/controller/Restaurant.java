package controller;

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

}
