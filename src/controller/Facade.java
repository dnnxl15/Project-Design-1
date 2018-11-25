package controller;

import domain.Client;
import domain.Manager;

public abstract class Facade
{
	private String address;
    private Manager manager;
    
    public abstract void loadData();

    
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
