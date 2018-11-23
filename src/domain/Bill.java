/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.enumerations.PaymentType;

/**
 *
 * @author Personal
 */
public class Bill {
    private int id;
    private Order order;
    private int mount;
    private PaymentType payment;

    public Bill(int id, Order order, int mount, PaymentType payment) {
        this.id = id;
        this.order = order;
        this.mount = mount;
        this.payment = payment;
    }
    public Bill(int id, Order order){
        this.id = id;
        this.order = order;
        
        double currentMount = 0;
        for(int i=0;i < order.getOrderCommodities().size() ;i++){
            Commodity com = (Commodity) order.getOrderCommodities().get(i);
            currentMount += com.getPrice();
            
        }
        this.mount = (int) currentMount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public PaymentType getPayment() {
        return payment;
    }

    public void setPayment(PaymentType payment) {
        this.payment = payment;
    }
    
}
