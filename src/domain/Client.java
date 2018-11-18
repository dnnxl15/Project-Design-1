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
public class Client extends User{

    public Client(String username, String password, String email, String name, String lastName, int id) {
        super(username, password, email, name, lastName, id);
    }

    @Override
    public UserType getType() {
        return UserType.Client_Type;
                
    }
    
}
