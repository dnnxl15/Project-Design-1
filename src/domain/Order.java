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
public class Order {
    private Employee employee;
    private int id;
    private ArrayList<Commodity> orderCommodities;

    public Order(Employee employee, int id) {
        this.employee = employee;
        this.id = id;
        orderCommodities = new ArrayList<Commodity>();
    }

    public Order(Employee employee, int id, ArrayList<Commodity> orderCommodities) {
        this.employee = employee;
        this.id = id;
        this.orderCommodities = orderCommodities;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList getOrderCommodities() {
        return orderCommodities;
    }

    public void setOrderCommodities(ArrayList orderCommodities) {
        this.orderCommodities = orderCommodities;
    }
    
    //Agregar commodity a la orden
    public void addCommodity(Commodity commodity){
        orderCommodities.add(commodity);
    }
    //quitar commodity a la orden
    public void removeCommodity(Commodity commodity){
        orderCommodities.remove(commodity);
    }
}
