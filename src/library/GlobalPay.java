package library;

import java.util.ArrayList;

import domain.Commodity;

public class GlobalPay 
{
	private ArrayList<Commodity> listCommodity;
	private String paymentMethod;
	private String info;
	private String direction;
	private String deliever;
	private String restaurant;
	private static GlobalPay global;
	
	private GlobalPay()
	{
		
	}
	
	public static GlobalPay getInstance()
	{
		if(global == null)
		{
			global = new GlobalPay();
		}
		return global;
	}
	
	public ArrayList<Commodity> getListCommodity() {
		return listCommodity;
	}
	public void setListCommodity(ArrayList<Commodity> listCommodity) {
		this.listCommodity = listCommodity;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDeliever() {
		return deliever;
	}
	public void setDeliever(String deliever) {
		this.deliever = deliever;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}


}
