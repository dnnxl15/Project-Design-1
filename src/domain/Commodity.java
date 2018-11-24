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
public class Commodity {
    private String name;
    private double price;
    private int idPerson;
   
    public int getIdPerson() {
        return idPerson;
    }
    
    public Commodity(String name, double price) {
        this.name = name;
        this.price = price;
        this.setDescription(description);
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    private String description;
    public Commodity(String name, double price,String description,int idperson, int status) {
        this.name = name;
        this.price = price;
        this.idPerson = idperson;
        this.setDescription(description);
 
    }
    public Commodity(String name, double price,String description,int idperson) {
        this.name = name;
        this.price = price;
        this.idPerson = idperson;
        this.setDescription(description);
    }
        public Commodity(String name, double price, int idperson) {
        this.name = name;
        this.price = price;
        this.idPerson = idperson;
        this.setDescription(description);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
