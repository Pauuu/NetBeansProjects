package basesdedades;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import sun.awt.X11.XConstants;

public class BasesDeDades {

    public static void main(String[] args) {

        BasesDeDades b = new BasesDeDades();

        Scanner scan = new Scanner(System.in);

        System.out.println("Write some query: ");
        String consulta = scan.nextLine();

        b.Consulta(consulta);
    }

    public void Consulta(String consulta) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //ResultSetMetaData rsmd = rs.getMetaData();

        } catch (Exception ex) {
            System.out.println("La conexión NO se ha realizado");

        }

        try {
            /*Creacion de la conexión*/
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    + "/mydb?autoReconnect=true&useSSL=false&"
                    + "user=root&password=1234");

            /*Creacion de una instancia*/
            stmt = conn.createStatement();

            /*Ejecucion de una consulta*/
            rs = stmt.executeQuery(consulta);

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Resultado de la consulta:");

            //Imprimir la consulta
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }

                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }

                System.out.println("");
            }

        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }
}
