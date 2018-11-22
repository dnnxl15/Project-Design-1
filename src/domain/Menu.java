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
public class Menu {
    private ArrayList<Commodity> listComodity;

    public Menu(ArrayList<Commodity> listComodity) {
        this.listComodity = listComodity;
    }

    public Menu() {
        listComodity = new ArrayList<>();
    }

    public void addCombo(Combo combo){
        listComodity.add(combo);
    }
    public void removeCombo(Combo combo){
        listComodity.remove(combo);
        combo.setEnabled(false);
    }
    public void addProduct(Product product){
        listComodity.add(product);
    }
    public void removeProduct(Product product){
        listComodity.remove(product);
        product.setEnabled(false);
    }
    
}
