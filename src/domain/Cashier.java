/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.Random;
import library.enumerations.UserType;


public class Cashier extends Employee{
    private int cashierId;


    public Cashier(String name, String lastName, int id,double salary, int branch) {
        super(name, lastName,id, salary, branch);
        this.cashierId = id;

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

 
    
}
