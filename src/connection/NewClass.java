/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egapb
 */
public class NewClass {
    public static void main(String [] args)
{
    ConnectionPool hola = ConnectionPool.getInstance();
    Connection ovni = hola.checkOut();
     String sql = "INSERT INTO person(personID,name,lastname,identification) VALUES (?,?,?,?)";
        try {
            PreparedStatement stm = (PreparedStatement) ovni.prepareStatement(sql);
            stm.setInt(1, 9);
            stm.setString(2,"eparra");
            stm.setString(3,"prueba");
            stm.setInt(4, 123546);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
}
