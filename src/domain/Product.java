/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Personal
 */
public class Product extends Commodity{
    private Boolean enabled;
    
    public Product(String name, float price, String descripcion,int idperson) {
        super(name, price, descripcion,idperson);
        enabled = true;
    }
    public Product(String name, float price, String descripcion,int idperson,int status) {
        super(name, price, descripcion,idperson);
        if(status == 1){
        enabled = true;
        }else{
        enabled = false;
        }
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
}
