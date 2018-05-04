package city;

import city.Car.Direction;
import static city.Car.Direction.BACKWARD;
import static city.Car.Direction.FORWARD;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;

public abstract class Way {

    protected String idWay;
    protected int cmLong;
    protected int cmIniX;
    protected int cmIniY;
    protected int cmFinX;
    protected int cmFinY;
    protected int cmWidth;
    protected int cmMark;
    protected ArrayList<Car> carsForward = new ArrayList();
    protected ArrayList<Car> carsBackward = new ArrayList();
    protected ArrayList<CrossRoad> crossRoads = new ArrayList();
    protected ArrayList<Integer> forwardEntryPoint = new ArrayList();
    protected ArrayList<Integer> backwardEntryPoint = new ArrayList();

    public Way(String idWay, int cmWayWidth, int cmWayMark, int cmLong, int cmPosIniX, int cmPosIniY) {
        this.idWay = idWay;
        this.cmLong = cmLong;
        this.cmWidth = cmWayWidth;
        this.cmMark = cmWayMark;
        this.cmIniX = cmPosIniX;
        this.cmIniY = cmPosIniY;

        this.createDefaultEntryPoints();
    }

    public String getId() {
        return this.idWay;
    }

    public abstract double getCourse(int cmPosition, Direction direction);    
    
    public int getCmLong() {
        return this.cmLong;
    }

    public abstract int getCmPosX(int cmPosition, Direction direction);

    public abstract int getCmPosY(int cmPosition, Direction direction);

    public abstract int getCmPosition(int cmPosX, int cmPosY, Car.Direction direction);

    public int getCmPosIniX() {
        return this.cmIniX;
    }

    public int getCmPosIniY() {
        return this.cmIniY;
    }

    public int getEntryPoint(Direction direction) {
        int cmPosition = 0;

        switch (direction) {
            case FORWARD:
                cmPosition = this.forwardEntryPoint.get(0);
                break;
            case BACKWARD:
                cmPosition = this.backwardEntryPoint.get(0);
                break;
            default:
                throw new AssertionError(direction.name());
        }

        return cmPosition;
    }

    public synchronized void addCar(Car car) {
        if (car.getDirection() == Direction.FORWARD) {
            this.carsForward.add(car);
        } else {
            this.carsBackward.add(car);
        }
    }

    public abstract void addCrossRoad(CrossRoad cr);

    private void createDefaultEntryPoints() {
        this.forwardEntryPoint.add(0);
        this.backwardEntryPoint.add(this.cmLong);
    }

    public abstract int distanceToCrossRoadInCm(CrossRoad cr, Car car);

    public abstract CrossRoad inFrontCrossRoad(Car car);

    public synchronized Car inFrontCar(Car car) {
        ArrayList<Car> carList;
        Car inFrontCar, actualCar;
        int minDistance, actualDistance;

        inFrontCar = null;
        if (car.getDirection() == Direction.FORWARD) {
            carList = this.carsForward;
        } else {
            carList = this.carsBackward;
        }

        minDistance = this.getCmLong() + 1;

        Iterator<Car> itr = carList.iterator();
        while (itr.hasNext()) {
            actualCar = itr.next();

            if (!actualCar.equals(car)) {
                actualDistance = car.getDirection().getIncrement() * (actualCar.getCmPosition() - car.getCmPosition());

                if ((actualDistance < minDistance) && (actualDistance > 0)) {
                    minDistance = actualDistance;
                    inFrontCar = actualCar;
                }
            }
        }

        return inFrontCar;
    }

    public abstract boolean insideAnyCrossRoad(int cmPosition);

    public abstract CrossRoad intersectedCrossRoad(int cmPosition);

    public abstract boolean insideThisCrossRoad(int cmPosition, CrossRoad crossRoad);

    public synchronized Car otherCarInSamePosition(Car testCar) {
        Car actualCar;
        int actualCarLong;
        int testCarPosition;
        int testCarLong;
        int distance;
        Iterator<Car> itr;

        testCarPosition = testCar.getCmPosition();
        testCarLong = testCar.getLongInCm() / 2;

        if (testCar.getDirection() == Direction.FORWARD) {
            itr = this.carsForward.iterator();
        } else {
            itr = this.carsBackward.iterator();
        }

        while (itr.hasNext()) {
            actualCar = itr.next();

            if (!actualCar.equals(testCar)) {
                actualCarLong = actualCar.getLongInCm() / 2;
                distance = Math.abs(actualCar.getCmPosition() - testCarPosition);
                if (distance < (actualCarLong + testCarLong)) {
                    System.out.println(">" + testCar + " " + this + " Position:" + testCarPosition + " - " + actualCar + " Position:" + actualCar.getCmPosition() + " Distance:" + distance + " Long:" + (actualCarLong + testCarLong));
                    return actualCar; // ==============================================>>
                }
            }
        }

        return null;
    }

    public abstract boolean posIsInside(int cmPosition, Direction direction);

    public synchronized void removeCar(Car car) {
        this.carsForward.remove(car);
        this.carsBackward.remove(car);
    }

    public boolean wayIntersection(Way way) {
        Way vWay, hWay;

        hWay = vWay = null;
        if (way instanceof VWay) {
            vWay = way;
        }

        if (way instanceof HWay) {
            hWay = way;
        }

        if (this instanceof VWay) {
            vWay = this;
        }

        if (this instanceof HWay) {
            hWay = this;
        }

        if ((vWay == null) || (hWay == null)) {
            return false; // =================>
        }

        return (hWay.cmIniX <= vWay.cmFinX)
                && (vWay.cmIniX <= hWay.cmFinX)
                && (hWay.cmIniY <= vWay.cmFinY)
                && (vWay.cmIniY <= hWay.cmFinY);
    }

    public abstract void paint(Graphics g, float factorX, float factorY, int offsetX, int offsetY);

    @Override
    public String toString() {
        return "Way " + this.getId();
    }
}