/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.*;
import java.sql.DriverManager;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author egapb
 */
public class ConnectionPool {
    private static ConnectionPool connectionPoolD;
    private static Connection conect;
    private static final String driver = "org.gjt.mm.mysql.Driver";
    private static final String user = "root";
    private static final String url = "jdbc:mysql://localhost:3306/ovnidatabase";
   
    private ConnectionPool() {
    }
    
    public static ConnectionPool getInstance(){
              
     if(connectionPoolD == null){
         connectionPoolD = new ConnectionPool();
        }
     return connectionPoolD;
    }
    public Connection getConnection(){
        if(conect == null){
        try{
          Class.forName(driver);
          conect = (Connection) DriverManager.getConnection(url,user,"");
             if(conect != null){
              System.out.println("Conexcion");
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexion de la base de datos");
            }
        }
        
        return conect;
    }
    
    public void desconectar(){
        conect = null;
    }

  
    }
    
    

