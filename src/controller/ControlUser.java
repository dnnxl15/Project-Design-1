package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import library.JobTitleUI;
import connection.ConnectionPool;
import domain.Client;
import domain.User;
import java.sql.ResultSet;
import library.EmployeeUI;
import library.RestaurantUI;
import library.interfaces.IProcedure;

public class ControlUser extends Control implements IProcedure
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
	
	public void createUser(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_CLIENT_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean verifyUser(ArrayList<Object> pListObject)
	{
		try {
			boolean value = connectionPool.requestWithOutParamenter(IS_CLIENT_FUNCTION, pListObject);
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyManager(ArrayList<Object> pListObject)
	{
		try {
			boolean value = connectionPool.requestWithOutParamenter(IS_MAIN_MANAGER_FUNCTION, pListObject);
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyManagerSub(ArrayList<Object> pListObject)
	{
		try {
			boolean value = connectionPool.requestWithOutParamenter(IS_BRANCH_MANAGER_FUNCTION, pListObject);
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
        
        //Insertar empleaados
        public void createEmployee(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_EMPLOYEE_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
       public void createJobTitle(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_JOBTITLE_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        
        
        //Insertar manager
        public void createManager(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_MANAGER_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public ArrayList<JobTitleUI> getJobTitle(){
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_JOB_TITLE_PROCEDURE, null);
                ArrayList<JobTitleUI> listJobsTmp = new ArrayList<JobTitleUI>();
                
                    while (resultSet.next()) {
                        
                        String jName =  resultSet.getString("name");
                        int jMinSalary = resultSet.getInt("minSalary");
                        int jMaxSalary = resultSet.getInt("maxSalary");
                        JobTitleUI jobtitle = new JobTitleUI(jName,jMinSalary, jMaxSalary);
                        listJobsTmp.add(jobtitle);
                        }                       
                    return listJobsTmp;
                
            }catch (SQLException e) {
			e.printStackTrace();
		}
            return null;
        }
        public ArrayList<EmployeeUI> getEmployee(){
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_EMPLOYEE_PROCEDURE, null);
                ArrayList<EmployeeUI> listEmployeeTmp = new ArrayList<EmployeeUI>();
                
                    while (resultSet.next()) {
                        int idEmployee = resultSet.getInt("employeeID");
                        String eName =  resultSet.getString("name");
                        String eLastName = resultSet.getString("lastname");
                        String eEmail= resultSet.getString("email");
                        float eSalary = resultSet.getFloat("salary");
                        String eRol = resultSet.getString("rol");
                        String idRestaurant = resultSet.getString("restaurant");
                        EmployeeUI employee = new EmployeeUI(idEmployee,eName, eLastName,eEmail,eSalary,eRol,idRestaurant);
                        listEmployeeTmp.add(employee);
                        }
                        
                    return listEmployeeTmp;
                
            }catch (SQLException e) {
			e.printStackTrace();
		}
            return null;
        }
        public ArrayList<Client> getClient(){
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_CLIENT_PROCEDURE, null);
                ArrayList<Client> listClientTmp = new ArrayList<Client>();
                
                    while (resultSet.next()) {
 
                        String eName =  resultSet.getString("name");
                        String eLastName = resultSet.getString("lastname");
                        String eEmail= resultSet.getString("email");
                        int idClient = resultSet.getInt("personID");
                        String eUsername = resultSet.getString("username");
                        Client client = new Client(eUsername, "NO", eEmail, eName, eLastName, idClient);
                        listClientTmp.add(client);
                        }
                        
                    return listClientTmp;
                
            }catch (SQLException e) {
			e.printStackTrace();
		}
            return null;
        }
        public void updateEmployee(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(UPDATE_EMPLOYEE_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void updateJobTitle(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(UPDATE_JOBTITLE_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void updateClient(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(UPDATE_CLIENT_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}