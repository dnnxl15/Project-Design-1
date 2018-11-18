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
    private int vehicleAssign;

    public Delivery(double salary, int branch, int deliveryId, int vehicleAssign) {
        super( salary, branch);
        this.deliveryId = deliveryId;
        this.vehicleAssign = vehicleAssign;
        super.setMinimunSalary(1200);
        super.setMaximunSalary(2100);
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getVehicleAssign() {
        return vehicleAssign;
    }

    public void setVehicleAssign(int vehicleAssign) {
        this.vehicleAssign = vehicleAssign;
    }

    @Override
    public UserType getType() {
        return UserType.Delivery_Type;
    }
    
}
