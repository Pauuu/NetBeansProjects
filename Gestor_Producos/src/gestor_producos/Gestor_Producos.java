package gestor_producos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor_Producos {

    public static void main(String[] args) {

        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/1", "root", "1234");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "   " + "\t" + rs.getString("DNI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_Producos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
