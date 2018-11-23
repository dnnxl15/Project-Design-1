package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.RestaurantUI;
import library.interfaces.IProcedure;
import static library.interfaces.IProcedure.INSERT_RESTAURANT_PROCEDURE;
import connection.*;

public class ManagerFacade extends Facade
{
	
	private static ManagerFacade instance;
	
	private ManagerFacade()
	{
		ControlUser.getInstance();
	}

	public static ManagerFacade getInstance()
	{	
		if(instance == null)
		{
			instance = new ManagerFacade();
		}
		return instance;
	}
	
	public boolean verifyMainManager(String pUsername, String pPassword)
	{
		ArrayList<Object> listParameters = new ArrayList<Object>();
		listParameters.add(pUsername);
		listParameters.add(pPassword);
		return ControlUser.getInstance().verifyManager(listParameters);
	}
        

	//Obtener todos los restaurantes
	public ArrayList<RestaurantUI> getRestaurant()
	{
		return ControlRestaurant.getInstance().getRestaurant();
	}
	
	public void createRestarant(ArrayList<Object> pListObject)
	{
		ControlRestaurant.getInstance().createRestaurant(pListObject);
	}

    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
