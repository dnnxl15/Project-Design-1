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
public class Express extends Service{
    private Delivery delivery;

    public Express(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public ServiceType getType() {
        return ServiceType.Express_Type;
    }
}
