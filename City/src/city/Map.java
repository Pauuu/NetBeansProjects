package city;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

/**
 *
 * @author Jumi
 */
public class Map extends Canvas implements Runnable {

    private int cityCmWidth;
    private int cityCmHeight;
    private int mapWidth;
    private int mapHeigth;
    private float factorX;
    private float factorY;
    private float zoomLevel;
    private int offsetX;
    private int offsetY;
    private int cmWayWidth;
    private int cmWayMark;
    private BufferedImage imgMap, imgBg;
    private Traffic traffic;
    private ArrayList<Way> ways;
    private ArrayList<CrossRoad> crossroads;

    public Map(int cityCmWidth, int cityCmHeight, int mapPixWidth, int mapPixHeight) {
        this.cityCmWidth = cityCmWidth;
        this.cityCmHeight = cityCmHeight;
        this.mapWidth = mapPixWidth;
        this.mapHeigth = mapPixHeight;

        this.offsetX = 0;
        this.offsetY = 0;
        this.zoomLevel = 2;
        this.setFactorXY();

        this.cmWayWidth = 800;
        this.cmWayMark = 300; // Longitud marcas viales en cm

        this.ways = new ArrayList<Way>();
        this.crossroads = new ArrayList<CrossRoad>();

        this.loadWays();
        this.calculateCrossRoads();

        Dimension d = new Dimension(300, 172);
        this.setPreferredSize(d);

        try {
            this.imgBg = ImageIO.read(new File("bg.jpg"));
        } catch (IOException e) {
            System.out.println("Img Error");
        }
    }

    public ArrayList<Way> getWays() {
        return this.ways;
    }

    public void setWidth(int mapWidth) {
        this.mapWidth = mapWidth;
        this.setFactorXY();
    }

    public void setHeig(int mapHeigth) {
        this.mapHeigth = mapHeigth;
        this.setFactorXY();
    }

    public void setTraffic(Traffic traffic) {
        this.traffic = traffic;
    }

    public void setFactorXY() {
        this.mapWidth = this.getWidth();
        this.mapHeigth = this.getHeight();

        this.factorX = ((float) this.cityCmWidth / (float) this.mapWidth / this.zoomLevel);
        this.factorY = ((float) this.cityCmHeight / (float) this.mapHeigth / this.zoomLevel);
        this.paintImgMap();
    }

    private boolean addCrossRoad(CrossRoad newCr) {
        Iterator<CrossRoad> itr = this.crossroads.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(newCr)) {
                return false;  // ====== Crossroad duplicated ================>>
            }
        }

        this.crossroads.add(newCr);
        return true;
    }

    private void calculateCrossRoads() {
        Iterator<Way> itrWays1;
        Iterator<Way> itrWays2;
        Way auxWay1, auxWay2;

        itrWays1 = this.ways.iterator();
        while (itrWays1.hasNext()) {
            auxWay1 = itrWays1.next();

            itrWays2 = this.ways.iterator();
            while (itrWays2.hasNext()) {
                auxWay2 = itrWays2.next();
                if (auxWay1.wayIntersection(auxWay2)) {
                    this.addCrossRoad(new CrossRoad(auxWay1, auxWay2));
                }
            }
        }
    }

    private void loadWays() {
        this.ways.add(new HWay("H1", this.cmWayWidth, this.cmWayMark, 59800, 0, 0));
        this.ways.add(new HWay("H2", this.cmWayWidth, this.cmWayMark, 10000, 30000, 2500));
        this.ways.add(new HWay("H21", this.cmWayWidth, this.cmWayMark, 25000, 35000, 2500));
        this.ways.add(new HWay("H3", this.cmWayWidth, this.cmWayMark, 3000, 0, 19500));
        this.ways.add(new HWay("H4", this.cmWayWidth, this.cmWayMark, 40000, 0, 6500));
        this.ways.add(new HWay("H6", this.cmWayWidth, this.cmWayMark, 20000, 10000, 10500));
        this.ways.add(new HWay("H7", this.cmWayWidth, this.cmWayMark, 49500, 10000, 19500));
        // this.ways.add(new HWay("H7", this.cmWayWidth, this.cmWayMark, 220000, 3000, 12400));

        this.ways.add(new VWay("V1", this.cmWayWidth, this.cmWayMark, 20000, 0, 100));
        this.ways.add(new VWay("V2", this.cmWayWidth, this.cmWayMark, 20000, 3000, 0));
        this.ways.add(new VWay("V3", this.cmWayWidth, this.cmWayMark, 9700, 10000, 10500));
        this.ways.add(new VWay("V4", this.cmWayWidth, this.cmWayMark, 8700, 30000, 2500));
        this.ways.add(new VWay("V5", this.cmWayWidth, this.cmWayMark, 4500, 40000, 2500));
        this.ways.add(new VWay("V6", this.cmWayWidth, this.cmWayMark, 20100, 59200, 100));
        this.ways.add(new VWay("V7", this.cmWayWidth, this.cmWayMark, 20100, 45200, 100));
    }

    public void moveRight() {
        this.offsetX += 10;
        this.setFactorXY();
    }

    public void moveLeft() {
        this.offsetX -= 10;
        this.setFactorXY();
    }

    public void moveDown() {
        this.offsetY += 10;
        this.setFactorXY();
    }

    public void moveUp() {
        this.offsetY -= 10;
        this.setFactorXY();
    }

    public synchronized void paint() {
        BufferStrategy bs;
        
        bs = this.getBufferStrategy();
        if (bs == null) {
            System.out.println("kgd");
            return; // =======================================================>>
        }
        
        if ((this.mapWidth <= 0) || (this.mapHeigth <= 0)) {
            System.out.println("Map size error: (" + this.mapWidth + "," + this.mapHeigth + ")");
            return; // =======================================================>>
        }        
        
        Graphics gg = bs.getDrawGraphics();

        gg.drawImage(this.imgMap, 0, 0, this.mapWidth, this.mapHeigth, null);
        this.paintCars(gg);

     //   Toolkit.getDefaultToolkit().sync();
        bs.show();

        gg.dispose();
    }

    public void paintBackgroud(Graphics g) {
        //((Graphics2D)g).rotate(Math.PI/2,this.mapWidth,this.mapHeigth);
        g.drawImage(this.imgBg, 0, 0, null);
    }

    public void paintCars(Graphics g) {
        if (this.traffic == null) {
            System.out.println("No trafic");
            return; // =======================================================>>
        }

        if (factorX > 90) {
            System.out.println(factorX + " - " + this.mapWidth + " - " + this.mapHeigth);
        }
        
        this.traffic.paintCars(g, this.factorX, this.factorY, this.offsetX, this.offsetY);
    }

    public void paintCrossRoads(Graphics g) {
        Iterator<CrossRoad> itr = this.crossroads.iterator();

        while (itr.hasNext()) {
            itr.next().paint(g, this.factorX, this.factorY, this.offsetX, this.offsetY);
        }
    }

    public synchronized void paintImgMap() {
        if ((this.mapWidth <= 0) || (this.mapHeigth <= 0)) {
            System.out.println("Map size error: (" + this.mapWidth + "," + this.mapHeigth + ")");
            return; // ===================================================>>
        }

        this.imgMap = new BufferedImage(this.mapWidth, this.mapHeigth, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = this.imgMap.createGraphics();

        this.paintBackgroud(g);
        this.paintWays(g);
        this.paintCrossRoads(g);

        g.dispose();
    }

    public void paintWays(Graphics g) {
        Iterator<Way> itr = this.ways.iterator();

        while (itr.hasNext()) {
            itr.next().paint(g, this.factorX, this.factorY, this.offsetX, this.offsetY);
        }
    }

    @Override
    public void run() {
        this.createBufferStrategy(2);

        while (!City.isEnd()) {
            this.paint();

            do {
                try {
                    Thread.sleep(7); // nano -> ms
                } catch (InterruptedException ex) {
                }
            } while (City.isPaused());
        }
    }

    public void zoomIn() {
        this.zoomIn(0.01f);
    }

    public void zoomIn(float inc) {
        this.zoomLevel += inc;
        this.setFactorXY();

    }

    public void zoomOut() {
        this.zoomOut(0.01f);
        this.setFactorXY();
    }

    public void zoomOut(float inc) {
        this.zoomLevel -= inc;
        this.setFactorXY();
    }

    public void zoomReset() {
        this.zoomLevel = 1;
        this.setFactorXY();
    }
}