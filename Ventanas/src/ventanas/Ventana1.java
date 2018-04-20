/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author pau
 */
public class Ventana1 extends JFrame {

    public Ventana1() {
        super("Ventana 1");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //PANEL PRINCIPAL (PANEL MAIN)
        JPanel jpMain = new JPanel();
        jpMain.setLayout(new BorderLayout());

        //PPANEL NORTE
        JPanel jpNorte = new JPanel();
        jpNorte.setLayout(new FlowLayout());

        //Elementos:
        JLabel etiqueta = new JLabel("<html>URL to<br>download:</html>");

        JTextField campoTexto = new JTextField(30);

        JButton boton1 = new JButton("-");
        JButton boton2 = new JButton("Start the grabbing");
        JButton boton3 = new JButton("?");

        boton2.setPreferredSize(new Dimension(200, 30));
        boton3.setPreferredSize(new Dimension(41, 30));

        jpNorte.add(etiqueta);
        jpNorte.add(campoTexto);
        jpNorte.add(boton1);
        jpNorte.add(boton2);
        jpNorte.add(boton3);

        //PANEL CENTRAL
        JTabbedPane jtpCentro = new JTabbedPane();

        //PESTAÑA UNO
        //PESTAÑA DOS
        //PESTAÑA TRES
        JPanel jpTab3 = new JPanel();
        jpTab3.setLayout(new GridBagLayout());

        JButton b1 = new JButton("Hola que tal");
        jpTab3.add(b1);

        //Elementos:
        jtpCentro.addTab("Simple", new JPanel());
        jtpCentro.addTab("Standard", new JPanel());
        jtpCentro.addTab("direct .bat acces", jpTab3);

        //Container:
        Container cp = getContentPane();

        cp.add(jpNorte, BorderLayout.NORTH);
        cp.add(jtpCentro, BorderLayout.CENTER); //crear jpTabbs

        //JTabbedPane jpTabs = new JTabbedPane(),
    }

    private void panelNorte() {

    }

    private void panelCentro_1() {

    }

    private void panelCentro_2() {

    }

    private void panelCentro_3() {

    }
}
