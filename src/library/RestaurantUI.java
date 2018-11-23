package library;

public class RestaurantUI 
{
	private String address;
	private String legalNumber;
	
	public RestaurantUI(String pAddress, String pLegalNumber)
	{
		address = pAddress;
		legalNumber = pLegalNumber;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLegalNumber() {
		return legalNumber;
	}
	public void setLegalNumber(String legalNumber) {
		this.legalNumber = legalNumber;
	}

	
}
