package library;

import java.util.ArrayList;

import domain.Commodity;

public class GlobalCart 
{
	private ArrayList<Commodity> listCommodity;
	private static GlobalCart globalCart;

	private GlobalCart()
	{
		setListCommodity(new ArrayList<Commodity>());
	}
	
	public double calculateMount()
	{
		int index = 0;
    	double mount = 0;
    	while(index < listCommodity.size())
    	{
    		mount = mount + listCommodity.get(index).getMount()*listCommodity.get(index).getPrice();
    		index++;
    	}
    	return mount;
	}
	
	public static GlobalCart getInstance()
	{
		if(globalCart == null)
		{
			globalCart = new GlobalCart();
		}
		return globalCart;
	}

	public ArrayList<Commodity> getListCommodity() {
		return listCommodity;
	}

	public void setListCommodity(ArrayList<Commodity> listCommodity) {
		this.listCommodity = listCommodity;
	}
	
	public void addProduct(Commodity pComodity)
	{
		listCommodity.add(pComodity);
	}
	
	public void deleteProduct(Commodity pComodity)
	{
		int index = 0;
    	ArrayList<Commodity> listCommodityNew = new ArrayList<Commodity>();
    	while(index < listCommodity.size())
    	{
    		if(pComodity.getName().equals(listCommodity.get(index).getName()))
    		{
    		}
    		else
    		{
        		listCommodityNew.add(listCommodity.get(index));
    		}
    		index++;
    	}
    	listCommodity = listCommodityNew;
	}

}
