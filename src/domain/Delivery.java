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
public class Delivery extends Employee{
    private int deliveryId;


    public Delivery(String name, String lastName, int id, double salary, int branch) {
        super(name, lastName,id, salary, branch);
        this.deliveryId = id;

        super.setMinimunSalary(1200);
        super.setMaximunSalary(2100);
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }


    @Override
    public UserType getType() {
        return UserType.Delivery_Type;
    }
    
}
