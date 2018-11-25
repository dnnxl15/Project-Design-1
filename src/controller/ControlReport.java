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


public class ControlReport extends Control {
    	private static ControlReport instance;
	
	private ControlReport()
	{
		
	}
	
	public static ControlReport getInstance()
	{
		if(instance == null)
		{
			instance = new ControlReport();
		}
		return instance;
	}
 
}
