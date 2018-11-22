/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.interfaces.IDatabaseInfo;

/**
 *
 * @author egapb
 */
public class ConnectionPool extends ObjectPool<Connection> implements IDatabaseInfo
{
	private static ConnectionPool instance;
	private Connection connection;
	
	private ConnectionPool()
	{
		super();
		try {
			try {
				Class.forName(DATABASE_DRIVER).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
	}

	public static ConnectionPool getInstance()
	{
		if(instance == null)
		{
			instance = new ConnectionPool();
		}
		return instance;
	}

	@Override
	protected Connection create() 
	{
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean validate(Connection pConnection) 
	{
		 try 
		 {
			 return (!((Connection) pConnection).isClosed());
		 } 
		 catch (SQLException e) 
		 {
		      e.printStackTrace();
		      return (false);
		 }
	}

	@Override
	public void expire(Connection pConnection) 
	{
		try {
			pConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Method to send a request
     * Author: Danny Xie Li
     * Description: The next method send a request to the database.
     * Last modification: 28/10/17
     */
    public ResultSet request(String pProcedure, ArrayList<Object> pParameters) throws SQLException
    {
    	CallableStatement callStatement;
    	ResultSet resultSet;
    	if (pParameters == null)
    	{
    		callStatement = connection.prepareCall(pProcedure);
    		resultSet = callStatement.executeQuery();
    		return resultSet;
    	}
    	else
    	{
	    	int position = ONE;
		    callStatement = connection.prepareCall(pProcedure);
	    	while(position < pParameters.size()+ONE)
	    	{
	    		callStatement.setObject(position, pParameters.get(position-ONE));
	    		position = position+ONE;
	    		continue;
	    	}
	    	resultSet = callStatement.executeQuery();
	    	return resultSet;
    	}
    }
}