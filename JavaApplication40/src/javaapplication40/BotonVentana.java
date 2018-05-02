package javaapplication40;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author pauJButton
 */
public class BotonVentana extends JFrame {

    public BotonVentana() {
        super("Botón");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        
        JPanel mainPanel = new JPanel(new GridBagLayout());

        EventoBotonPulsado evento = new EventoBotonPulsado();

        JButton boton = new JButton("a");
        boton.addActionListener(evento);
        mainPanel.add(boton);

        JButton jb = new JButton("n");
        jb.addActionListener(evento);
        mainPanel.add(jb);

        //JPanel opciones = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        
        for (int i = 1; i <= 9; i++) {
            JButton b = new JButton(Integer.toString(i));
            b.addActionListener(evento);
            mainPanel.add(b, c);
        }

     

        cp.add(mainPanel);
        
    }
}
