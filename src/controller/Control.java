package controller;

import connection.ConnectionPool;

public class Control 
{
	protected ConnectionPool connectionPool;
	
	public Control()
	{
		connectionPool = ConnectionPool.getInstance();
	}
	
	public void loadData()
	{
		
	}
}