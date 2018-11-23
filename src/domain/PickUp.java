/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.enumerations.ServiceType;

/**
 *
 * @author Personal
 */
public class PickUp extends Service{

    public PickUp() {
        
    }
    
    @Override
    public ServiceType getType() {
        return ServiceType.PickUp_Type;
    }
    
}
