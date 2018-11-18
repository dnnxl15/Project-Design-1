/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.enumerations.UserType;
import static library.enumerations.UserType.Manager_Type;

/**
 *
 * @author Personal
 */
public class Manager extends User{

    public Manager(String username, String password, String email, String name, String lastName, int id) {
        super(username, password, email, name, lastName, id);
    }

    
    public UserType getType() {
        return Manager_Type;
    }
    
}
