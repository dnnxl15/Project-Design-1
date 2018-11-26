package library;

import domain.Client;
import library.enumerations.ReportType;

public class ClientGlobal 
{
	private Client client;
	
	private static ClientGlobal clientGlobal;

	private ClientGlobal()
	{
		
	}
	
	public static ClientGlobal getInstance()
	{
		if(clientGlobal == null)
		{
			clientGlobal = new ClientGlobal();
		}
		return clientGlobal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}