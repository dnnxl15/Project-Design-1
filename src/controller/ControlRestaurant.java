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
import library.EmployeeUI;
import library.IConstant;
import library.RestaurantUI;
import library.interfaces.IProcedure;

import static library.interfaces.IProcedure.*;


public class ControlRestaurant extends Control{
	
	private static ControlRestaurant instance;
	
	private ControlRestaurant()
	{
		
	}
	
	public static ControlRestaurant getInstance()
	{
		if(instance == null)
		{
			instance = new ControlRestaurant();
		}
		return instance;
	}
 
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
        public ArrayList<RestaurantUI> getRestaurant(){
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
        
        //Obtener todos lo empleados
        public ArrayList<EmployeeUI> getEmployee(String legalNumber){
            ArrayList objectArray = new ArrayList();
            objectArray.add(legalNumber);
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_EMPLOYEE_PROCEDURE, objectArray);
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
}
