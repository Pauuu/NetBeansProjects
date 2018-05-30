package city;

import city.Car.CarType;
import city.Car.Direction;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class City extends JFrame implements Runnable, MouseWheelListener, ActionListener, ComponentListener {

    public static final int CIUTAT_CM_WIDTH = 60000; // Amplada ciutat
    public static final int CIUTAT_CM_HEIGHT = 34500; // Alçada ciutat
    public static final int FRAME_PIX_WIDTH = 1350; // Amplada window
    public static final int FRAME_PIX_HEIGHT = 750;  // Alçada window 
    public static final int MAPA_PIX_WIDTH = 1080; // Amplada window
    public static final int MAPA_PIX_HEIGH = 621;  // Alçada window 
    private JButton bUp, bDown, bLeft, bRight, bZoomPlus, bZoomMinus;
    private JButton bBottomFill1, bBottomFill2;
    private JTable tStatistics;
    private Map map;
    private Traffic traffic;
    private static volatile boolean pauseCity;
    private static volatile boolean endCity;

    public City() {
        this.map = new Map(
                City.CIUTAT_CM_WIDTH, City.CIUTAT_CM_HEIGHT,
                City.MAPA_PIX_WIDTH, City.MAPA_PIX_HEIGH
        );

        this.createFrame();
        this.traffic = new Traffic(this.map.getWays());
        this.map.setTraffic(traffic);
        this.traffic.start();

        new Thread(this.map).start();
        this.play(); // Arrencar el simul·lador

        new Thread(this).start();
    }

    public static void main(String[] args) {
        City ciutat = new City();
        ciutat.play();
    }

    public static int getCmWidth() {
        return City.CIUTAT_CM_WIDTH;
    }

    public static int getCmHeight() {
        return City.CIUTAT_CM_HEIGHT;
    }

    public static int getFramePixWidth() {
        return City.FRAME_PIX_WIDTH;
    }

    public static int getFramePixHeight() {
        return City.FRAME_PIX_HEIGHT;
    }

    private void addButtonsToPane(Container pane) {
        this.bUp = new JButton("Up");
        this.bDown = new JButton("Down");
        this.bLeft = new JButton("<");
        this.bRight = new JButton(">");
        this.bZoomPlus = new JButton("Z+");
        this.bZoomMinus = new JButton("Z-");
        this.bBottomFill1 = new JButton("6");
        this.bBottomFill2 = new JButton("7");

        this.bUp.addActionListener(this);
        this.bDown.addActionListener(this);
        this.bLeft.addActionListener(this);
        this.bRight.addActionListener(this);
        this.bZoomPlus.addActionListener(this);
        this.bZoomMinus.addActionListener(this);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 10;
        pane.add(this.bUp, c);

        c.weightx = 0;
        c.gridx++;
        pane.add(this.bDown, c);

        c.weightx = 0.0;
        c.gridx++;
        pane.add(this.bLeft, c);

        c.gridx++;
        pane.add(this.bRight, c);

        c.gridx++;
        pane.add(this.bZoomPlus, c);

        c.gridx++;
        pane.add(this.bZoomMinus, c);

        c.gridx++;
        pane.add(this.bBottomFill1, c);

        c.weightx = 0;
        c.weighty = 0;
        c.gridx++;
        pane.add(this.bBottomFill2, c);
    }

    private void addMapToPane(Container pane) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1F;
        c.weighty = 0;
        c.gridheight = 10;
        c.gridwidth = 8;
        pane.add(this.map, c);
    }

    private void addStatisticsToPane(Container pane) {
        String[] columnCarTypes = {"Description", "Qty", "Crash"};
        Object[][] dataCarTypes = {
            {"CAR STATUS", "Live", "Crash"},
            {"  · Runing", "", ""},
            {"  · Stoped", "", ""},
            {"  · Crashed", "", ""},
            {"  · Arrived", "", ""},
            {"  · Hided", "", ""},
            {"CAR TYPES", "", ""},
            {"  · Trucks", "", ""},
            {"  · Turisms", "", ""},
            {"  · Motocycle", "", ""},
            {"  · Byke", "", ""},
            {"DRIVER TYPES", "", ""},
            {"  · Illegal", "", ""},
            {"  · Risky", "", ""},
            {"  · Normal", "", ""},
            {"  · Prudent", "", ""},
            {"", "", ""},
            {"ROADS", "Qty", "Km"},
            {"  · Horizontals", "", ""},
            {"  · Verticals", "", ""},
            {"CROSSROADS", "", ""},
            {"SEMAPHORES", "", ""}
        };

        this.tStatistics = new JTable(dataCarTypes, columnCarTypes);
        this.tStatistics.setFillsViewportHeight(true);
        this.tStatistics.setSize(160, 800);
        this.tStatistics.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.tStatistics.getColumnModel().getColumn(1).setPreferredWidth(35);
        this.tStatistics.getColumnModel().getColumn(2).setPreferredWidth(45);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0;
        c.weighty = 1F;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 10;
        pane.add(this.tStatistics, c);
    }

    private void createTraffic() {
        Car car;

        this.traffic = new Traffic(this.map.getWays());

//        this.traffic.addCar(this.map.getWays().get(1), CarType.MOTORCYCLE, Direction.BACKWARD);        
//        this.traffic.addCar(this.map.getWays().get(5), CarType.TRUCK, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(5), CarType.TRUCK, Direction.FORWARD);
//        car = this.traffic.addCar(this.map.getWays().get(9), CarType.TRUCK, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(0), CarType.TURISM, Direction.FORWARD);      
//        this.traffic.addCar(this.map.getWays().get(0), CarType.TURISM, Direction.BACKWARD);   
//        this.traffic.addCar(this.map.getWays().get(0), CarType.TRUCK, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(0), CarType.BYKE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(0), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(0), CarType.MOTORCYCLE, Direction.FORWARD); 
//        this.traffic.addCar(this.map.getWays().get(1), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(1), CarType.BYKE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(2), CarType.TRUCK, Direction.FORWARD);        
//        this.traffic.addCar(this.map.getWays().get(2), CarType.TRUCK, Direction.BACKWARD);      
//        this.traffic.addCar(this.map.getWays().get(2), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(3), CarType.TURISM, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(3), CarType.TRUCK, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(4), CarType.MOTORCYCLE, Direction.BACKWARD);        
//        this.traffic.addCar(this.map.getWays().get(4), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(5), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(5), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(6), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(6), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(8), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(8), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(8), CarType.MOTORCYCLE, Direction.BACKWARD);        
//        this.traffic.addCar(this.map.getWays().get(8), CarType.MOTORCYCLE, Direction.FORWARD);
//        this.traffic.addCar(this.map.getWays().get(8), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(9), CarType.MOTORCYCLE, Direction.FORWARD);        
//        car = this.traffic.addCar(this.map.getWays().get(2), CarType.MOTORCYCLE, Direction.BACKWARD);
//        this.traffic.addCar(this.map.getWays().get(10), CarType.MOTORCYCLE, Direction.FORWARD);
    }

    private void createFrame() {
        Container panel;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        panel = this.getContentPane();

        this.addMapToPane(panel);
        this.addButtonsToPane(panel);
        this.addStatisticsToPane(panel);

        panel.addMouseWheelListener(this);

        this.pack();
        this.setVisible(true);

        this.addComponentListener(this);
    }

    public static boolean isEnd() {
        return City.endCity;
    }

    public static boolean isPaused() {
        return City.pauseCity;
    }

    public static void play() {
        // Iniciar el rellotge
        // Engegar el generador de trafic
        City.pauseCity = false;
        City.endCity = false;
    }

    public static void pause() {
        // Aturar el rellotge
        // Aturar el generador de trafic
        // Bloquejar el vehicles

        City.pauseCity = true;
    }

    private void showStatistics() {
        int row, col;
        // Temps de simulació transcorregut
        // Velocitat máxima
        // Velocitat mínima
        // Velocitat mitja
        // Dimensions de la ciutat
        // Km de carreteres

        this.traffic.updateCarStatistics();
        Integer[] carStatistics = this.traffic.getCarStatistics();

        javax.swing.table.TableModel model = this.tStatistics.getModel();

        // Car status
        row = 1;
        model.setValueAt(carStatistics[Traffic.RUN], row++, 1);
        model.setValueAt(carStatistics[Traffic.STOP], row++, 1);
        model.setValueAt(carStatistics[Traffic.CRASHED], row++, 2);
        model.setValueAt(carStatistics[Traffic.ARRIVED], row++, 1);
        model.setValueAt(carStatistics[Traffic.HIDE], row++, 1);

        // Car types
        row = 7;
        model.setValueAt(carStatistics[Traffic.TRUCKS], row++, 1);
        model.setValueAt(carStatistics[Traffic.TURISM], row++, 1);
        model.setValueAt(carStatistics[Traffic.MOTORCYCLE], row++, 1);
        model.setValueAt(carStatistics[Traffic.BYKE], row++, 1);

        // Car crashes
        row = 7;
        col = 2;
        model.setValueAt(carStatistics[Traffic.CRASH_TRUCKS], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_TURISM], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_MOTORCYCLES], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_BYKES], row++, col);

        // Driver types
        row = 12;
        model.setValueAt(carStatistics[Traffic.ILLEGAL], row++, 1);
        model.setValueAt(carStatistics[Traffic.RISKY], row++, 1);
        model.setValueAt(carStatistics[Traffic.PRUDENT], row++, 1);
        model.setValueAt(carStatistics[Traffic.GRANDMOTHER], row++, 1);

        // Driver crashes
        row = 12;
        col = 2;
        model.setValueAt(carStatistics[Traffic.CRASH_ILLEGAL], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_RISKY], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_PRUDENT], row++, col);
        model.setValueAt(carStatistics[Traffic.CRASH_GRANDMOTHER], row++, col);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if (str.equals("Z+")) {
            this.map.zoomIn(0.1f);
            
        } else if (str.equals("Z-")) {
            this.map.zoomOut(0.1f);
            
        } else if (str.equals("Up")) {
            this.map.moveUp();
            
        } else if (str.equals("Down")) {
            this.map.moveDown();
            
        } else if (str.equals("<")) {
            this.map.moveLeft();
            
        } else if (str.equals(">")) {
            this.map.moveRight();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.map.setFactorXY();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        String message;
        int notches = e.getWheelRotation();
        if (notches < 0) {
            this.map.zoomIn();
        } else {
            this.map.zoomOut();
        }
    }

    @Override
    public void run() {
        while (!City.isEnd()) {
            if (!City.isPaused()) {
                this.showStatistics();
            }

            try {
                Thread.sleep(800); // nano -> ms
            } catch (InterruptedException ex) {
            }
        }

    }
}
