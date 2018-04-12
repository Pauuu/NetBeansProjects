package gestor_producos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Salidas extends JFrame {

    JLabel jb;

    public static void main(String[] args) {
        Salidas sa = new Salidas();
        sa.setVisible(true);

        try {
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/1", "root", "1234");
            Statement stmt = c.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Salidas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Salidas() {
        this.setTitle("pene");
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {
        jb = new JLabel();
       
        jb.setText("PENIses");
        jb.setBounds(0, 0, 0, 230); //(posicion) x,y, (div) x,y
        getContentPane().add(jb);
        
     
                
    }

}
