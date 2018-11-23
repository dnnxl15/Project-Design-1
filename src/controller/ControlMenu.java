/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.JobTitleUI;
import library.interfaces.IProcedure;
import static library.interfaces.IProcedure.DISABLE_COMBO_PROCEDURE;
import static library.interfaces.IProcedure.DISABLE_PRODUCTS_PROCEDURE;
import static library.interfaces.IProcedure.ENABLE_COMBO_PROCEDURE;
import static library.interfaces.IProcedure.ENABLE_PRODUCTS_PROCEDURE;
import static library.interfaces.IProcedure.INSERT_COMBO_PROCEDURE;
import static library.interfaces.IProcedure.INSERT_MANAGER_PROCEDURE;
import static library.interfaces.IProcedure.INSERT_PRODUCT_PROCEDURE;

/**
 *
 * @author egapb
 */
public class ControlMenu extends Control{
    
    	private static ControlMenu controlMenu;
	
	private ControlMenu()
	{
		super();
	}
	
	public static ControlMenu getInstance()
	{
		if(controlMenu == null)
		{
			controlMenu = new ControlMenu();
		}
		return controlMenu;
	}
        public ArrayList<Product> getProducts(){
            try{
                ResultSet resultSet = connectionPool.request(IProcedure.GET_PRODUCTS_PROCEDURE, null);
                ArrayList<Product> listProductsTmp = new ArrayList<Product>();
                
                    while (resultSet.next()) {
                        
                        String pName =  resultSet.getString("name");
                        float pPrice = resultSet.getFloat("price");
                        String pDescription = resultSet.getString("description");
                        int pPersonId = resultSet.getInt("personID");
                        Product products = new Product(pName,pPrice, pDescription,pPersonId);
                        listProductsTmp.add(products);
                        }
                        
                    return listProductsTmp;
                
            }catch (SQLException e) {
			e.printStackTrace();
		}
            return null;
        }
        public void createCombo(ArrayList<Object> cListObject)
	{
		try {
			connectionPool.request(INSERT_COMBO_PROCEDURE, cListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
         public void createProduct(ArrayList<Object> pListObject)
	{
		try {
			connectionPool.request(INSERT_PRODUCT_PROCEDURE, pListObject);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void disableProduct(ArrayList<Object> pName)
	{
		try {
			connectionPool.request(DISABLE_PRODUCTS_PROCEDURE, pName);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void disableCombo(ArrayList<Object> cName)
	{
		try {
			connectionPool.request(DISABLE_COMBO_PROCEDURE, cName);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void enableProduct(ArrayList<Object> pName)
	{
		try {
			connectionPool.request(ENABLE_PRODUCTS_PROCEDURE, pName);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
        public void enableCombo(ArrayList<Object> cName)
	{
		try {
			connectionPool.request(ENABLE_COMBO_PROCEDURE, cName);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}