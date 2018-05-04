/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package city;

import city.Car.Direction;
import static city.Car.Orientation.EAST;
import static city.Car.Orientation.NORTH;
import static city.Car.Orientation.SOUDTH;
import static city.Car.Orientation.WEST;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

/**
 *
 * @author Jumi
 */
public class HWay extends Way {

    public HWay(String idWay, int cmWayWidth, int cmWayMark, int cmLong, int cmPosIniX, int cmPosIniY) {
        super(idWay, cmWayWidth, cmWayMark, cmLong, cmPosIniX, cmPosIniY);

        this.cmFinX = this.cmIniX + this.cmLong;
        this.cmFinY = this.cmIniY + this.cmWidth;
    }

    @Override
    public void addCrossRoad(CrossRoad cr) {
        this.crossRoads.add(cr);

        // Adjusts road dimensions
        if (cr.getIniX() < this.cmIniX) {
            this.cmIniX = cr.getIniX();
        }

        if (cr.getFinX() > this.cmFinX) {
            this.cmFinX = cr.getFinX();
        }
    }

    @Override
    public boolean posIsInside(int cmPosition, Direction direction) {
        int cmPosX = cmPosX = this.cmIniX + cmPosition;

        if (cmPosX < this.cmIniX) {
            return false;
        }
        if (cmPosX > this.cmFinX) {
            return false;
        }

        return true;
    }

    @Override
    public int distanceToCrossRoadInCm(CrossRoad cr, Car car) {
        int crossRoadPos;

        crossRoadPos = cr.getIniX();
        if (car.getDirection() == Direction.FORWARD) {
            crossRoadPos = cr.getFinX();
        }
        return car.getDirection().getIncrement() * (crossRoadPos - this.getCmPosX(car.getCmPosition(), car.getDirection()));
    }

    @Override
    public CrossRoad inFrontCrossRoad(Car car) {
        int minDistance;
        int actualDistance;
        int crossRoadPos;
        CrossRoad inFrontCR, actualCR;
        Iterator<CrossRoad> itr;

        inFrontCR = null;
        minDistance = this.getCmLong() + 1;
        itr = this.crossRoads.iterator();
        while (itr.hasNext()) {
            actualCR = itr.next();

            crossRoadPos = actualCR.getIniX();
            if (car.getDirection() == Direction.FORWARD) {
                crossRoadPos = actualCR.getFinX();
            }
            actualDistance = car.getDirection().getIncrement() * (crossRoadPos - this.getCmPosX(car.getCmPosition(), car.getDirection()));

            if ((actualDistance < minDistance) && (actualDistance > 0)) {
                minDistance = actualDistance;
                inFrontCR = actualCR;
            }
        }

        return inFrontCR;
    }

    @Override
    public boolean insideAnyCrossRoad(int cmPosition) {
        return this.intersectedCrossRoad(cmPosition) != null;
    }

    @Override
    public boolean insideThisCrossRoad(int cmPosX, CrossRoad crossRoad) {
        return ((cmPosX >= crossRoad.getIniX())
                && (cmPosX <= crossRoad.getFinX()));
    }

    @Override
    public CrossRoad intersectedCrossRoad(int cmPosition) {
        CrossRoad cr;
        int cmPosX;

        cmPosX = this.getCmPosX(cmPosition, Direction.FORWARD);
        Iterator<CrossRoad> itr = this.crossRoads.iterator();
        while (itr.hasNext()) {
            cr = itr.next();

            if (this.insideThisCrossRoad(cmPosX, cr)) {
                return cr; // ==============================================>>
            }
        }

        return null;
    }

    @Override
    public double getCourse(int cmPosition, Direction direction) {
        if (direction == null) {
            return 0; // =====================================================>>
        }

        if (direction == Direction.FORWARD) {
            return Math.PI / 2;
        } else {
            return Math.PI * 3 / 2;
        }
    }

    @Override
    public int getCmPosX(int cmPosition, Car.Direction direction) {
        int cmPosX;

        cmPosX = this.cmIniX + cmPosition;
        if (cmPosX < this.cmIniX || cmPosX > this.cmFinX) {
            return -1; // ============== Off road ============================>>
        }

        return cmPosX;
    }

    @Override
    public int getCmPosY(int cmPosition, Car.Direction direction) {
        if (direction == Car.Direction.FORWARD) {
            return this.cmFinY - (this.cmWidth / 4);
        } else {
            return this.cmIniY + (this.cmWidth / 4);
        }
    }

    @Override
    public int getCmPosition(int cmPosX, int cmPosY, Car.Direction direction) {
        int cmPosition;

        cmPosition = cmPosX - this.cmIniX;
        if (cmPosX < this.cmIniX || cmPosX > this.cmFinX) {
            return -1; // ============== Off road ============================>>
        }

        return cmPosition;
    }

    @Override
    public void paint(Graphics g, float factorX, float factorY, int offsetX, int offsetY) {
        int wayWidth;
        int wayMark;
        int widthMark;
        int xIni, yIni, xFin, yFin;
        Graphics2D g2d;
        BasicStroke stk;

        wayMark = (int) ((float) this.cmMark / factorY);

        if (wayMark <= 0) {
            return;
        }

        wayWidth = (int) ((float) this.cmWidth / factorY);
        xIni = (int) (((float) this.cmIniX / factorX) + offsetX);
        yIni = (int) (((float) this.cmIniY / factorY) + offsetY);
        xFin = (int) (((float) this.cmFinX / factorX) + offsetX);
        yFin = (int) (((float) this.cmFinY / factorY) + offsetY);


        // Road
        g2d = (Graphics2D) g;
        GradientPaint gp5 =
                new GradientPaint(0, yIni + 2, Color.decode("0x404040"), 0, yIni + wayWidth / 2.9F, Color.decode("0x606060"), true);
        g2d.setPaint(gp5);
        g.fillRect(xIni, yIni, xFin - xIni, yFin - yIni);
        g.setColor(Color.BLACK);
        g.drawRect(xIni, yIni, xFin - xIni, yFin - yIni);


        // Central mark
        widthMark = Math.max(1, (int) (50 / factorX));
        g2d = (Graphics2D) g;
        stk = (BasicStroke) g2d.getStroke();
        g2d.setStroke(new BasicStroke(widthMark, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 5.0f, new float[]{wayMark}, 0.0f));
        g.setColor(Color.decode("0xc5a002"));
        g.drawLine(xIni, yIni + (wayWidth / 2), xFin, yIni + (wayWidth / 2));
        g2d.setStroke(stk);

        // Lateral mark
        gp5 = new GradientPaint(xIni, 0, Color.decode("0x787800"), xIni + widthMark * 90F, 0, Color.decode("0x505000"), true);
        g2d.setPaint(gp5);
        g.fillRect(xIni, yIni + widthMark, xFin - xIni, widthMark);

        gp5 = new GradientPaint(xIni / 2, 0, Color.decode("0x787800"), xIni / 2 + widthMark * 125F, 0, Color.decode("0x505000"), true);
        g2d.setPaint(gp5);
        g.fillRect(xIni, yFin - 2 * widthMark, xFin - xIni, widthMark);

        // Label
        // g.setColor(Color.black);
        // g.drawString(this.idWay, xFin - 30, yFin+12);        
    }
}