package library;

public class RestaurantUI 
{
	private String address;
	private String legalNumber;
	private int id;
        
	public RestaurantUI(String pAddress, String pLegalNumber, int pId)
	{
		address = pAddress;
		legalNumber = pLegalNumber;
                id = pId;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

	
}
