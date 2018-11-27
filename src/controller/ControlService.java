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
import static library.interfaces.IProcedure.*;

/**
 *
 * @author Personal
 */
public class ControlService extends Control{
    private ControlService controlService;
    
    private ControlService(){}
    
    public ControlService getInstance(){
        if(controlService == null){
            controlService = new ControlService();
        }
        return controlService;
    }
    /*
    public void createExpressOrder(ArrayList pListObject,Delivery delivery){
	try {
            
            connectionPool.request(, pListObject);
            
	} catch (SQLException e) {
		e.printStackTrace();
	}	
        
    }*/
    public void createOrder(ArrayList pListObject,Order order){
        for(int i=0;i < order.getOrderCommodities().size();i++){
            if(order.getOrderCommodities().get(i).getClass().isInstance(Combo.class)){
                createOrderCombo(pListObject);
            }else if(order.getOrderCommodities().get(i).getClass().isInstance(Product.class)){
                createOrderProduct(pListObject);
            }
        }	
        
    }
    //producto:----------> pName, pPrice, pDescription, 1, getPersonID(pIdentificator
    
    public void createOrderCombo(ArrayList pListObject){
        try {
            
            connectionPool.request(INSERT_COMBO_PURCHASE, pListObject);
            
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
    public void createOrderProduct(ArrayList pListObject){
        try {
            
            connectionPool.request(INSERT_PRODUCT_PURCHASE, pListObject);
            
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
}
