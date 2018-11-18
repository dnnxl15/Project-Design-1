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
public class BranchManager extends Manager{
    private String branch;

    public BranchManager(String username, String password, String email, String name, String lastName, int id,String branch) {
        super(username, password, email, name, lastName, id);
        this.branch = branch;
    }
    
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    
}
