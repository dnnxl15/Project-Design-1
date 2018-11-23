/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import library.enumerations.FacadeType;

/**
 *
 * @author Personal
 */
public class FacadeFactory {
    private FacadeFactory facadeFactory;
    
    private FacadeFactory(){    }

    public FacadeFactory getInstance(){
        if(facadeFactory == null){
            facadeFactory = new FacadeFactory();
        }
        return facadeFactory;
    }
    
    //Por implementar
    public Facade createFacade(FacadeType pType){
        return null;
    }
}
