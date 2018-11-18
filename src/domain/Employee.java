/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.IConstant;
import library.enumerations.UserType;

/**
 *
 * @author Personal
 */
abstract class Employee implements IConstant{
    private double minimunSalary;
    private double maximunSalary;
    private double salary;
    private int branch;

    public Employee(double minimunSalary, double maximunSalary, double salary, int branch) {
        this.minimunSalary = minimunSalary;
        this.maximunSalary = maximunSalary;
        this.salary = salary;
        this.branch = branch;
    }
    
    public Employee(double salary, int branch){
        this.salary = salary;
        this.branch = branch;
        this.minimunSalary = MINIMUN_SALARY;
        this.maximunSalary = MAXIMUN_SALARY;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMinimunSalary() {
        return minimunSalary;
    }

    public void setMinimunSalary(double minimunSalary) {
        this.minimunSalary = minimunSalary;
    }

    public double getMaximunSalary() {
        return maximunSalary;
    }

    public void setMaximunSalary(double maximunSalary) {
        this.maximunSalary = maximunSalary;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }
    
    public abstract UserType getType();
}
