/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.IConstant;
import library.RestaurantUI;
import library.interfaces.IProcedure;

import static library.interfaces.IProcedure.*;


public class ControlRestaurant extends Control{
 
    //Insertar restaurante
        public void createRestaurant(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_RESTAURANT_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
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
}
