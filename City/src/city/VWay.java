package city;

import city.Car.Direction;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

public class VWay extends Way {

    private CrossRoad cr;

    public VWay(String idWay, int cmLong, int cmPosIniX, int cmPosIniY, int cmWayWidth, int cmWayMark) {

        super(idWay, cmLong, cmPosIniX, cmPosIniY, cmWayWidth, cmWayMark);

        this.cmFinX = this.cmIniX + this.cmWidth;
        this.cmFinY = this.cmIniY + this.cmLong;
    }

    @Override
    public void addCrossRoad(CrossRoad cr) {
        this.crossRoads.add(cr);

        if (cr.getIniY() < this.getCmPosIniY()) {
            this.cmIniY = cr.getIniY();
        }

        if (cr.getFinY() > this.cmFinY) {
            this.cmFinY = cr.getFinY();
        }
    }

    @Override
    public int distanceToCrossRoadInCm(CrossRoad cr, Car car) {
        int crossRoadPos;

        crossRoadPos = cr.getFinY();
        if (car.getDirection() == Direction.FORWARD) {
            crossRoadPos = cr.getIniY();
        }
        return car.getDirection().getIncrement() * (crossRoadPos - this.getCmPosY(car.getCmPosition(), car.getDirection()));
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

            crossRoadPos = actualCR.getFinY();
            if (car.getDirection() == Direction.FORWARD) {
                crossRoadPos = actualCR.getIniY();
            }
            actualDistance = car.getDirection().getIncrement() * (crossRoadPos - this.getCmPosY(car.getCmPosition(), car.getDirection()));

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
    public CrossRoad intersectedCrossRoad(int cmPosition) {
        CrossRoad cr;
        int cmPosY;

        cmPosY = this.getCmPosY(cmPosition, Direction.FORWARD);

        Iterator<CrossRoad> itr = this.crossRoads.iterator();
        while (itr.hasNext()) {
            cr = itr.next();

            if (this.insideThisCrossRoad(cmPosY, cr)) {
                return cr; // ================================================>>
            }
        }
        return null;
    }

    @Override
    public boolean insideThisCrossRoad(int cmPosY, CrossRoad crossRoad) {
        return ((cmPosY >= crossRoad.getIniY())
                && (cmPosY <= crossRoad.getFinY()));
    }

    @Override
    public boolean posIsInside(int cmPosition, Direction direction) {
        int cmPosY = this.cmIniY + cmPosition;

        if (cmPosY < this.cmIniY) {
            return false;
        }
        if (cmPosY > this.cmFinY) {
            return false;
        }

        return true;
    }

    @Override
    public double getCourse(int cmPosition, Direction direction) {
        if (direction == null) {
            return 0; // =====================================================>>
        }

        if (direction == Direction.FORWARD) {
            return Math.PI;
        } else {
            return 0;
        }
    }

    @Override
    public int getCmPosX(int cmPosition, Direction direction) {
        if (direction == Direction.FORWARD) {
            return this.cmIniX + (this.cmWidth / 4); // ======================>>
        }

        return this.cmFinX - (this.cmWidth / 4);
    }

    @Override
    public int getCmPosY(int cmPosition, Car.Direction direction) {
        int cmPosY;

        cmPosY = this.cmIniY + cmPosition;
        if (cmPosY < this.cmIniY || cmPosY > this.cmFinY) {
            return -1; // Fuera de la via ====================================>>
        }
        return cmPosY;
    }

    @Override
    public int getCmPosition(int cmPosX, int cmPosY, Car.Direction direction) {
        int cmPosition;

        cmPosition = cmPosY - this.cmIniY;
        if (cmPosY < this.cmIniY || cmPosY > this.cmFinY) {
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

        wayMark = (int) (((float) this.cmMark) / factorY);

        if (wayMark <= 0) {
            return; // ===========================================>>
        }
        wayWidth = (int) (((float) this.cmWidth) / factorX);
        xIni = (int) ((this.cmIniX / factorX) + offsetX);
        yIni = (int) ((this.cmIniY / factorY) + offsetY);
        xFin = (int) ((this.cmFinX / factorX) + offsetX);
        yFin = (int) ((this.cmFinY / factorY) + offsetY);


        // Road
        g2d = (Graphics2D) g;
        GradientPaint gp5 =
                new GradientPaint(xIni, 0, Color.decode("0x404040"), xIni + (wayWidth / 2.9F), 0, Color.decode("0x606060"), true);
        g2d.setPaint(gp5);
        g.fillRect(xIni, yIni, xFin - xIni, yFin - yIni);
        g.setColor(Color.decode("0x505050"));
        g.drawRect(xIni, yIni, xFin - xIni, yFin - yIni);


        // Central Mark
        widthMark = Math.max(1, (int) (50 / factorX));
        g2d = (Graphics2D) g;
        stk = (BasicStroke) g2d.getStroke();
        g2d.setStroke(new BasicStroke(widthMark, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 5.0f, new float[]{wayMark}, 0.0f));
        g.setColor(Color.decode("0xc5a002"));
        g.drawLine(xIni + (wayWidth / 2), yIni, xIni + (wayWidth / 2), yFin);
        g2d.setStroke(stk);

        // Lateral marks
        gp5 = new GradientPaint(0, yIni, Color.decode("0x787800"), 0, yIni + widthMark * 100F, Color.decode("0x505000"), true);
//        gp5 = new GradientPaint(0, yIni, Color.decode("0x999999"), 0, yIni + widthMark * 110F, Color.decode("0x606060"), true);
        g2d.setPaint(gp5);
        g.fillRect(xIni + widthMark, yIni, widthMark, yFin - yIni);

        gp5 = new GradientPaint(0, yFin / 2, Color.decode("0x787800"), 0, yFin / 2 + widthMark * 125F, Color.decode("0x505000"), true);
        g2d.setPaint(gp5);
        g.fillRect(xFin - 2 * widthMark, yIni, widthMark, yFin - yIni);

        //g.setColor(Color.black);
        //g.drawString(this.idWay, xIni + (int) ((float) this.cmWidth / factorX) + 3, yFin + 12);
    }
}
