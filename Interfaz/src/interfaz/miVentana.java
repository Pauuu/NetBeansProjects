/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author pau
 */
public class miVentana extends JFrame {
    public miVentana(String titulo){
        super(titulo);
        setSize(400,300);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        
    }
}
