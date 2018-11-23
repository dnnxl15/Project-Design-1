package controller;

public abstract class Facade
{
	private String address;
    public abstract void loadData();
    
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
}
