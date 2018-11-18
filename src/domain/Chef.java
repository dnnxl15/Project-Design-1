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
    private int chefKitchenPlace;

    public Chef( double salary, int branch,int chefId, int chefKitchenPlace) {
        super( salary, branch);
        this.chefId = chefId;
        this.chefKitchenPlace = chefKitchenPlace;
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

    public int getChefKitchenPlace() {
        return chefKitchenPlace;
    }

    public void setChefKitchenPlace(int chefKitchenPlace) {
        this.chefKitchenPlace = chefKitchenPlace;
    }
    
    
}
