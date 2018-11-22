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
public class MenuBuilder {
    public Menu buildMenu(ArrayList<Commodity> listCommodity){
        return new Menu(listCommodity);
    }
}
