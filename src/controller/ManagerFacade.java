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
        public ArrayList getRestaurant(){
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_RESTAURAN_PROCEDURE, null);
                ArrayList<RestaurantUI> listProductTmp = new ArrayList<RestaurantUI>();
                
                    while (resultSet.next()) {
                        
                        int restID =  resultSet.getInt("restID");
                        String address = resultSet.getString("address");
                        String legalNumber = resultSet.getString("legalNumber");
                        RestaurantUI restaurant = new RestaurantUI(address,legalNumber, restID);
                        listProductTmp.add(restaurant);
                        }
                        
                    return listProductTmp;
                
            }catch (SQLException e) {
			e.printStackTrace();
		}
            return null;
        }
        
        public void createRestarant(){
            try {
			connectionPool.request(INSERT_RESTAURANT_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }

    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
