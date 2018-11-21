package connection;
import com.mysql.jdbc.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ObjectPool {
    
    public static void main(String [] args)
{
    ConnectionPool con = ConnectionPool.getInstance();
    Connection ing = con.getConnection();
    String sql = "INSERT INTO person(personID,name,lastname,identification) VALUES (?,?,?,?)";
        try {
            PreparedStatement stm = (PreparedStatement) ing.prepareStatement(sql);
            stm.setInt(1, 9);
            stm.setString(2,"eparra");
            stm.setString(3,"prueba");
            stm.setInt(4, 123546);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    con.desconectar();
    
}
    

}
