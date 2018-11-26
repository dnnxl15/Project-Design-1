package controller;

import domain.Client;
import domain.Combo;
import domain.Manager;
import domain.Product;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import library.EmployeeUI;
import library.JobTitleUI;

public class Branch 
{
	private static Branch instance;
	private Facade facade;
	
	private Branch()
	{
	}

	public static Branch getInstance()
	{	
		if(instance == null)
		{
			instance = new Branch();
		}
		return instance;
	}
	
	public boolean verifyUser(String pUsername, String pPassword)
	{
		boolean value = ClientFacade.getInstance().verifyClient(pUsername, pPassword);
		return value;
	}
	
	public void createUser(String pName, String pLastname, int pIdentification, String pUsername, String pEmail, String pPassword )
	{
		ClientFacade.getInstance().createUser(pName, pLastname, pIdentification, pUsername, pEmail,pPassword);
	}
	
	public boolean verifyMainManager(String pUsername, String pPassword)
	{
		return ManagerFacade.getInstance().verifyMainManager(pUsername, pPassword);
	}
	
	public boolean verifyBranchManager(String pUsername, String pPassword)
	{
		return BranchManagerFacade.getInstance().verifyBranchManager(pUsername, pPassword);
	}
	
	public void createProduct(String name, float price,String description, String idPerson)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(name);
		listParameters.add(price);
                listParameters.add(description);
                listParameters.add(idPerson);
	    ManagerFacade.getInstance().createProduct(listParameters);
	}
        public void createCombo(String cname, double price, String description, String cpersonid)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(cname);
		listParameters.add(price);
                listParameters.add(description);
                listParameters.add(cpersonid);
	    ManagerFacade.getInstance().createCombo(listParameters);
	}
        public void createJobTitle(String cname, float minSalary,float maxSalary)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(cname);
		listParameters.add(minSalary);
                listParameters.add(maxSalary);

	    ManagerFacade.getInstance().createJobTitle(listParameters);
	}
        public void updateJobTitle(int idJobTitle,String cname, float minSalary,float maxSalary)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(idJobTitle);
                listParameters.add(cname);
		listParameters.add(minSalary);
                listParameters.add(maxSalary);

	    ManagerFacade.getInstance().updateJobTitle(listParameters);
	}
        public void updateProduct(int productID, String newName, float newPrice , String newDescription,Boolean status)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(productID);
		listParameters.add(newName);
                listParameters.add(newPrice);
                listParameters.add(newDescription);
                listParameters.add(status);
	    ManagerFacade.getInstance().updateProduct(listParameters);
	}
        public void updateCombo(int comboID, String newName, float newPrice , String newDescription,Boolean status)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(comboID);
		listParameters.add(newName);
                listParameters.add(newPrice);
                listParameters.add(newDescription);
                listParameters.add(status);
	    ManagerFacade.getInstance().updateCombo(listParameters);
	}
        
        
        
        public ArrayList<Product> getAllProducts()
	{
		return ManagerFacade.getInstance().getAllProducts();
	}
        public ArrayList<Combo> getAllCombos()
	{
		return ManagerFacade.getInstance().getAllCombos();
	}
        public ArrayList<Client> getClient()
	{
		return ManagerFacade.getInstance().getClient();
	}
        public ArrayList<Product> getProducts()
	{
		return ManagerFacade.getInstance().getProducts();
	}
        public ArrayList<Combo> getCombos()
	{
		return ManagerFacade.getInstance().getCombos();
	}
        public ArrayList<JobTitleUI> getJobTitle()
	{
		return ManagerFacade.getInstance().getJobTitle();
	}
        public void createRestaurant(String pAddress, String pLegalNumber)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pAddress);
		listParameters.add(pLegalNumber);
	    ManagerFacade.getInstance().createRestarant(listParameters);
	}
        public void createEmployee(String eName, String eLastName,int eIdentification,String email,String eJobTitle,float eSalary ,String eRestNum )
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(eName);
		listParameters.add(eLastName);
                listParameters.add(eIdentification);
		listParameters.add(email);
                listParameters.add(eJobTitle);
		listParameters.add(eSalary);
                listParameters.add(eRestNum);
    
                ManagerFacade.getInstance().createEmployee(listParameters);
	}
        
        //-------------
        
        
        public void disableProduct(String pname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(pname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void disableCombo(String cname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(cname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void enableProduct(String pname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(pname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        public void enableCombo(String cname)
	{
	    ArrayList<Object> listParameters = new ArrayList<Object>();
	    listParameters.add(cname);
	    ManagerFacade.getInstance().disableProduct(listParameters);
	}
        // ----------------
        public ArrayList<EmployeeUI> getEmployee()
	{
		return ManagerFacade.getInstance().getEmployee();
	}
        
        public void updateEmployee(int pEmployeeID,String newName, String newLastName , float newSalary,String newRol ,String newidRestaurant)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pEmployeeID);
		listParameters.add(newName);
                listParameters.add(newLastName);
                listParameters.add(newSalary);
                listParameters.add(newRol);
                listParameters.add(newidRestaurant);
	    ManagerFacade.getInstance().updateEmployee(listParameters);
	}
        public void updateClient(int pClientID,String pNewName, String pNewLastname , int pNewIdentification,String pNewUsername ,int pNewPassword	)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pClientID);
		listParameters.add(pNewName);
                listParameters.add(pNewLastname);
                listParameters.add(pNewIdentification);
                listParameters.add(pNewUsername);
                listParameters.add(pNewPassword);
	    ManagerFacade.getInstance().updateClient(listParameters);
	}

		public Facade getFacade() {
			return facade;
		}

		public void setFacade(Facade facade) {
			this.facade = facade;
		}
        public ObservableList<PieChart.Data> getPieChartDataProductByGeneral()
        {
                return ManagerFacade.getInstance().getPieChartDataProductByGeneral();
        }
        
        
}