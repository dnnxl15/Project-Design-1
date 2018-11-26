package library;

import library.enumerations.ReportType;

public class ClientGlobal 
{
	private String lastname;
	private int identification;
	private String name;
	private String email;
	private String password;
	private int id;
	private String username;
	
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
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getIdentification() {
		return identification;
	}
	public void setIdentification(int identification) {
		this.identification = identification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	} 

}
