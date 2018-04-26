/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pau
 */
public class Ventana1 extends JFrame {

    public Ventana1() {
        super("Ventana 1");
        this.setSize(1200, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //PANEL PRINCIPAL (PANEL NORTE)
        JPanel jpMain = new JPanel(new BorderLayout());

        //PPANEL NORTE
        JPanel jpNorte = new JPanel(new FlowLayout());

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

        //--------------------Pestaña uno:----------------------------
        JPanel jpTab1 = new JPanel(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();

        //FILA 0
        JPanel jpFila0 = new JPanel();
        jpFila0.setLayout(new FlowLayout());

        JLabel texto0 = new JLabel("<html>You can change the options for each "
                + "URL you add to the top of the textbox."
                + "If you have added all <br>"
                + "that you want to the job list, start the grabbing</html>");

        jpFila0.add(texto0);

        c1.gridy = 0;
        c1.anchor = GridBagConstraints.WEST;
        jpTab1.add(jpFila0, c1);

        //FILA 1
        JPanel jpFila1 = new JPanel();
        jpFila1.setLayout(new FlowLayout());

        jpFila1.setBorder(BorderFactory.createTitledBorder("Behaviour"));

        JButton b0 = new JButton("<html>Empty the job list before adding new"
                + "<br> URL's</html>");

        JLabel texto1 = new JLabel("<html>Do you want wget to be"
                + "<br>polite or agressive?</html>");

        jpFila1.add(b0);
        jpFila1.add(texto1);

        c1.gridy = 1;
        jpFila1.setPreferredSize(new Dimension(1000, 70));
        jpTab1.add(jpFila1, c1);

        //FILA 2
        JPanel jpFila2 = new JPanel(new FlowLayout());

        jpFila2.setBorder(BorderFactory.createTitledBorder("Amount of Download"));

        JLabel texto2 = new JLabel("<html>When you entera page"
                + "<br>as starting URL, what do"
                + "<br>you want to download?</html>");

        jpFila2.add(texto2);

        JRadioButton rb0 = new JRadioButton();
        rb0.setText("<html>single"
                + "<br>page only</html>");
        jpFila2.add(rb0);

        JRadioButton rb1 = new JRadioButton();
        rb1.setText("<html>single page with"
                + "<br>images and stuff</html>");
        jpFila2.add(rb1);

        JRadioButton rb2 = new JRadioButton();
        rb2.setText("<html>All pages on that server, if"
                + "<br>they are underneath the"
                + "<br>start page</html>");
        jpFila2.add(rb2);

        JRadioButton rb3 = new JRadioButton();
        rb3.setText("<html>All pages on"
                + "<br>that server</html>");
        jpFila2.add(rb3);

        c1.gridy = 2;
        jpFila2.setPreferredSize(new Dimension(1000, 90));
        jpTab1.add(jpFila2, c1);

        //FILA 3
        JPanel jpFila3 = new JPanel();
        jpFila3.setLayout(new FlowLayout());

        jpFila3.setBorder(BorderFactory.createTitledBorder("Saving location"));

        JRadioButton rb4 = new JRadioButton();
        rb4.setText("This directory");
        jpFila3.add(rb4);

        JRadioButton rb5 = new JRadioButton();
        rb5.setText("Named like the server");
        jpFila3.add(rb5);

        JRadioButton rb6 = new JRadioButton();
        rb6.setText("Custom directory:");
        jpFila3.add(rb6);

        JTextField tField0 = new JTextField(40);
        jpFila3.add(tField0);

        c1.gridy = 3;
        jpFila3.setPreferredSize(new Dimension(1000, 50));
        jpTab1.add(jpFila3, c1);

        //FILA 4
        JPanel jpFila4 = new JPanel();
        jpFila4.setLayout(new FlowLayout());

        jpFila4.setBorder(BorderFactory.createTitledBorder("What to download"));

        JRadioButton rb7 = new JRadioButton();
        rb7.setText("Named like the server");
        jpFila4.add(rb7);

        JRadioButton rb8 = new JRadioButton();
        rb8.setText("Named like the server");
        jpFila4.add(rb8);

        JRadioButton rb9 = new JRadioButton();
        rb9.setText("Named like the server");
        jpFila4.add(rb9);

        c1.gridy = 4;
        jpFila4.setPreferredSize(new Dimension(1000, 70));
        jpTab1.add(jpFila4, c1);

        //FILA 5
        JPanel jpFila5 = new JPanel();
        jpFila5.setLayout(new FlowLayout());

        JButton b12 = new JButton("Add the URL ABABAR DE ESCRIBIR");
        jpFila5.add(b12);

        JButton b13 = new JButton("Start the Grabbing!");
        jpFila5.add(b13);

        c1.gridy = 5;
        jpFila5.setPreferredSize(new Dimension(1000, 70));
        jpTab1.add(jpFila5, c1);

        //-------------------Pestaña dos:----------------------------
        JPanel jpTab2 = new JPanel(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        JPanel jp1 = new JPanel(new FlowLayout());
        jp1.setBorder(BorderFactory.createTitledBorder("Hosts"));

        JRadioButton jrb1 = new JRadioButton("Texto uno");
        jp1.add(jrb1);

        JTextField jtf1 = new JTextField(40);
        jp1.add(jtf1);

        JButton jb1 = new JButton("Clear");
        jp1.add(jb1);

        c2.gridx = 0;
        c2.gridy = 0;
        c2.weightx = 400;
        c2.ipadx = 20;
        
        jpTab2.add(jp1, c2);

        JPanel jp2 = new JPanel(new GridLayout());
        jp2.setBorder(BorderFactory.createTitledBorder("Retrieval Options"));

        c2.gridx = 3;
        c2.gridy = 1;
        c2.weightx = 400;
        jpTab2.add(jp2, c2);

        JPanel jp3 = new JPanel(new GridBagLayout());
        jp3.setBorder(BorderFactory.createTitledBorder("Accept/Reject"));

        c2.gridx = 0;
        c2.gridy = 1;
        c2.weightx = 400;
        jpTab2.add(jp3, c2);

        JPanel jp4 = new JPanel(new FlowLayout());
        jp4.setBorder(BorderFactory.createTitledBorder("Behaviour of wget"));

        c2.gridx = 1;
        c2.gridy = 1;
        c2.weightx = 400;
        jpTab2.add(jp4, c2);

        JPanel jp5 = new JPanel(new FlowLayout());
        jp5.setBorder(BorderFactory.createTitledBorder("Running & Logging"));

        c2.gridx = 2;
        c2.gridy = 1;
        c2.weightx = 400;
        jpTab2.add(jp5, c2);

        //-------------------Pestaña tres:----------------------------
        JPanel jpTab3 = new JPanel();
        jpTab3.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        JButton b31 = new JButton("1");
        b31.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 0.0;
        c3.gridx = 0;
        c3.gridy = 0;
        jpTab3.add(b31, c3);

        JButton b2 = new JButton("2");
        b2.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 0;
        c3.gridx = 1;
        c3.gridy = 0;
        jpTab3.add(b2, c3);

        JButton b3 = new JButton("3");
        b3.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 0;
        c3.gridx = 2;
        c3.gridy = 0;
        jpTab3.add(b3, c3);

        JButton b4 = new JButton("4");
        b4.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 1;
        c3.gridx = 0;
        c3.gridy = 1;
        jpTab3.add(b4, c3);

        JButton b5 = new JButton("5");
        b5.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 1;
        c3.gridx = 1;
        c3.gridy = 1;
        jpTab3.add(b5, c3);

        JButton b6 = new JButton("6");
        b6.setPreferredSize(new Dimension(250, 26));
        c3.anchor = GridBagConstraints.NORTH;
        c3.weighty = 1;
        c3.gridx = 2;
        c3.gridy = 1;
        jpTab3.add(b6, c3);

        TextArea tArea = new TextArea();
        c3.gridx = 0;
        c3.gridy = 2;
        c3.gridwidth = 3;
        c3.gridheight = 150;
        c3.weighty = 3.0;
        c3.anchor = GridBagConstraints.CENTER;
        c3.fill = GridBagConstraints.BOTH;
        jpTab3.add(tArea, c3);
        /*
        crearBotonGBL(jpTab3, "uno", 250, 26, 0, 0);

        crearBotonGBL(jpTab3, "dos", 250, 26, 0, 0);

        crearBotonGBL(jpTab3, "tres", 250, 26, 0, 2);

        crearBotonGBL(jpTab3, "cuatro", 250, 26, 1, 0);

        crearBotonGBL(jpTab3, "cinco", 250, 26, 1, 1);

        crearBotonGBL(jpTab3, "seis", 250, 26, 1, 2);
         */

 /*
        int x = 0;
        int y = 0;

        for (int boton = 0; boton < 6; boton++) {

            JButton b00000 = new JButton("0");
            b00000.setPreferredSize(new Dimension(250, 26));

            c.gridx = x;
            c.gridy = y;
            jpTab3.add(b00000, c);

            x++;

            if (x >= 3) {
                x = 0;
                y = 1;
            }
        }
         */
        //Elementos:
        jtpCentro.addTab("Simple", jpTab1);
        jtpCentro.addTab("Standard", jpTab2);
        jtpCentro.addTab("direct .bat acces", jpTab3);

        //CONTAINER:
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

    /*
    private void crearBotonGBL(JPanel panel, String nombre, int dimX, int dimY, int posX, int posY) {
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JButton b = new JButton(nombre);
        b.setPreferredSize(new Dimension(dimX, dimY));

        c.gridx = posX;
        c.gridy = posY;

        panel.add(b, c);
    }
     */
}
