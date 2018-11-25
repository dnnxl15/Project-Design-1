package library;

import domain.Client;

public class GlobalUser 
{
	private static GlobalUser globalUser;
	private Client client;
	private boolean subManager;
	private String legalNumber;
	private boolean manager;

	private GlobalUser()
	{
		
	}
	
	public static GlobalUser getInstance()
	{
		if(globalUser == null)
		{
			globalUser = new GlobalUser();
		}
		return globalUser;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isSubManager() {
		return subManager;
	}

	public void setSubManager(boolean subManager) {
		this.subManager = subManager;
	}

	public String getLegalNumber() {
		return legalNumber;
	}

	public void setLegalNumber(String legalNumber) {
		this.legalNumber = legalNumber;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}


}
