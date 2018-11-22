/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import library.enumerations.UserType;
import static library.enumerations.UserType.*;


public class PersonFactory {
    private static PersonFactory personFactory;
    
    private PersonFactory(){
    
    }
    
    public PersonFactory getInstance(){
        if(personFactory == null)
		{
			personFactory = new PersonFactory();
		}
		return personFactory;
    }
    
    //Solo el branch manager ocupa el último parámetro(el branch), 
    //para cliente y el general manager ese último parámetro va null.
    public Person getUser(UserType pUserType,String pName, String pLastName, int pId,String pUserName,String pPassword, String pEmail, String pBranch){
        if (pUserType == Client_Type){
            Client newClient = new Client(pUserName, pPassword, pEmail, pName, pLastName, pId);
            return newClient;
        }
        if(pUserType == GeneralManager_Type){
            GeneralManager newManager = new GeneralManager(pUserName, pPassword, pEmail, pName, pLastName, pId);
            return newManager;
        }
        if(pUserType == BranchManager_Type){
            BranchManager newManager = new BranchManager(pUserName, pPassword, pEmail, pName, pLastName, pId, pBranch);
            return newManager;
        }
        
        return null;
    }
    
    public Person getEmployee(UserType pUserType,String pName, String pLastName, int pId,double pSalary,int pBranch){
        switch(pUserType) {
            case Waiter_Type:    
                return new Waiter(pName, pLastName, pId, pSalary, pBranch);
            case Chef_Type: 
                return new Chef(pName, pLastName, pId, pSalary, pBranch);   
            case Delivery_Type:
                return new Delivery(pName, pLastName, pId, pSalary, pBranch);
            case Cashier_Type:
                return new Cashier(pName, pLastName, pId, pSalary, pBranch);
            default: 
                return null;
        }
    }
}
