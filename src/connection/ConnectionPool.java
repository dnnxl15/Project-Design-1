/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.interfaces.IDatabaseInfo;

/**
 *
 * @author egapb
 */
public class ConnectionPool extends ObjectPool<Connection> implements IDatabaseInfo
{
	private static ConnectionPool instance;
	
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
		Connection connection;
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
}