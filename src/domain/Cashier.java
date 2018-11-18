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
public class Cashier extends Employee{
    private int cashierId;
    private int machine;

    public Cashier(double salary, int branch, int cashierId, int machine) {
        super(salary, branch);
        this.cashierId = cashierId;
        this.machine = machine;
        super.setMinimunSalary(1000);
        super.setMaximunSalary(1600);
    }

    @Override
    public UserType getType() {
        return UserType.Cashier_Type;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }
    
}
