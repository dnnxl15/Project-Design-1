/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.enumerations.UserType;

/**
 *
 * @author Personal
 */
public class Chef extends Employee{
    private int chefId;


    public Chef( String name, String lastName, int id,double salary, int branch) {
        super(name, lastName,id, salary, branch);
        this.chefId = id;
 
        super.setMinimunSalary(1500);
        super.setMaximunSalary(3000);
    }

    @Override
    public UserType getType() {
        return UserType.Chef_Type;
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }
    
}
