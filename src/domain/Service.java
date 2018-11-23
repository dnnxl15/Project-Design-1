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
public abstract class Service {
    private float evaluation;
    
    public abstract ServiceType getType();

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }
    
}
