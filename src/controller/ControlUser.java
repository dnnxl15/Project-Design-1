package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionPool;
import domain.User;
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
        
        
        //Insertar manager
        public void createManager(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_MANAGER_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}