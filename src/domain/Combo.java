/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Combo extends Commodity{
    private ArrayList listProduct;
    private Boolean enabled;
    
    public Combo(String name, double price,String description,int cpersonid) {
        super(name, price,description,cpersonid);
        listProduct = new ArrayList();
        enabled = true;
    }

    public ArrayList getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList listProduct) {
        this.listProduct = listProduct;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
}
