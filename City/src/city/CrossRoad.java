package city;

import city.Car.Direction;
import city.Car.Orientation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jumi
 */
public class CrossRoad {
    private String idCrossRoad;
    private boolean northWay;
    private boolean southWay;
    private boolean eastWay;
    private boolean westWay;
    private int safetySpeedInCmHour;
    
    private int cmCenterX, cmCenterY;
    private int cmIniX, cmIniY, cmFinX, cmFinY;
    private int cmWidthX, cmWidthY;
    
    private Semaphore semaphore;
    private Way hWay;
    private Way vWay;
    private ArrayList<Turn> turns = new ArrayList<Turn>();

    
    public CrossRoad(Way way1, Way way2) {
        this.safetySpeedInCmHour = 600;
        
        this.setWays(way1, way2);
        this.setDimension();
        this.setPosition();
        this.setTurns();
        this.setSemaphore();

        // Actualize crossferences
        this.hWay.addCrossRoad(this);
        this.vWay.addCrossRoad(this);
    }
    
    public boolean testOrientationAvailable(Orientation orientation) {
        switch (orientation) {
            case EAST:
                return (this.eastWay); // ====================================>>
            case WEST:
                return (this.westWay); // ====================================>>
            case NORTH:
                return (this.northWay); // ===================================>>
            case SOUDTH:
                return (this.southWay); // ===================================>>
        }
        
        return false;
    }

    public Way getRandomWay(Way actualWay) {
        if (actualWay instanceof VWay)
            return this.hWay;
        
        return this.vWay;
    }
    
    public Direction getRandomDirection(Way way) {
        int randomDirection;

        Random rand = new Random();
        randomDirection = rand.nextInt(2);


        if (way instanceof VWay) {
            if ((this.southWay) && (this.northWay)) {
                if (randomDirection == 0) {
                    return Direction.FORWARD;
                } else {
                    return Direction.BACKWARD;
                }
            } else {
                if (this.southWay) {
                    return Direction.FORWARD;
                } else {
                    return Direction.BACKWARD;
                }
            }
        }

        if (way instanceof HWay) {
            if ((this.eastWay) && (this.westWay)) {
                if (randomDirection == 0) {
                    return Direction.FORWARD;
                } else {
                    return Direction.BACKWARD;
                }
            } else {
                if (this.eastWay) {
                    return Direction.FORWARD;
                } else {
                    return Direction.BACKWARD;
                }
            }
        }

        return Direction.FORWARD;
    }
    
    public String getId() {
        return this.idCrossRoad;
    }
    
    public int getIniX() {        
        return this.cmIniX;
    }
    
    public int getFinX() {        
        return this.cmFinX;
    }
    
    public int getIniY() {        
        return this.cmIniY;
    }
    
    public int getFinY() {        
        return this.cmFinY;
    }

    public int getSafetySpeedInCmHour() {
        return this.safetySpeedInCmHour;
    }
    
    public Way getVWay() {
        return this.vWay;
    }
    
    public Way getHWay() {
        return this.hWay;
    }
    
    private void setTurns() {       
        this.eastWay = this.vWay.cmFinX<this.hWay.cmFinX;
        this.westWay = this.hWay.cmIniX<this.vWay.cmIniX;

        this.northWay = this.vWay.cmIniY<this.hWay.cmIniY;
        this.southWay = this.hWay.cmFinY<this.vWay.cmFinY;
    }

    private void setSemaphore() {
        this.semaphore = new Semaphore();
    }

    private void setWays(Way way1, Way way2) {
        if (way1 instanceof VWay) {
            this.vWay = way1;
        }

        if (way1 instanceof HWay) {
            this.hWay = way1;
        }

        if (way2 instanceof VWay) {
            this.vWay = way2;
        }

        if (way2 instanceof HWay) {
            this.hWay = way2;
        }
        
        this.idCrossRoad = this.vWay.getId() + "·" + this.hWay.getId();
    }

    private void setDimension() {
        this.cmWidthX = this.vWay.cmWidth;
        this.cmWidthY = this.hWay.cmWidth;
    }
    
    private void setPosition() {
        this.cmCenterX = this.vWay.cmIniX + (this.cmWidthX / 2);
        this.cmCenterY = this.hWay.cmIniY + (this.cmWidthY / 2);

        this.cmIniX = this.vWay.cmIniX;
        this.cmFinX = this.cmIniX + this.cmWidthX;
        this.cmIniY = this.hWay.cmIniY;
        this.cmFinY = this.cmIniY + this.cmWidthY;
    }
    
    public void setSafetySpeedInCmHour(int safetySpeedInCmHour) {
        this.safetySpeedInCmHour = safetySpeedInCmHour;
    }
    
    @Override
    public String toString() {
        return "Crossroad "+this.getId();
    }
    
    public void paint(Graphics g, float factorX, float factorY, int offsetX, int offsetY) {
        int iniX, iniY, finX, finY;
        
        iniX = (int)((this.cmIniX / factorX) + offsetX);
        iniY = (int)((this.cmIniY / factorY) + offsetY);
        finX = (int)((this.cmWidthX / factorX));
        finY = (int)((this.cmWidthY / factorY));                
                
        // Paint crossroad
        g.setColor(Color.GRAY);
        g.fillRect(iniX, iniY, finX, finY);
        g.setColor(Color.BLACK);
        g.drawRect(iniX, iniY, finX, finY);

        // Paint semaphore
    }
}