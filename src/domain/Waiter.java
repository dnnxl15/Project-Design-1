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
public class Waiter extends Employee{
    private int waiterId;
    
    public Waiter(String name, String lastName, int id, double salary, int branch) {
        super(name, lastName,id, salary, branch);
        this.waiterId = id;
        super.setMinimunSalary(1100);
        super.setMaximunSalary(2000);
        
    }

    @Override
    public UserType getType() {
         return UserType.Waiter_Type;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }
    
}
