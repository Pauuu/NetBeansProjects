package city;

import static city.Driver.DriverType.GRANDMOTHER;
import static city.Driver.DriverType.PRUDENT;
import static city.Driver.DriverType.RISKY;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public final class Car extends Thread {

    public static final int FREQ_VEHICLES = 140; // Hz

    public static enum CarStatus {

        HIDE, STOP, RUN, ARRIVED, CRASHED
    };

    public static enum Orientation {

        NORTH(Direction.BACKWARD),
        SOUDTH(Direction.FORWARD),
        WEST(Direction.BACKWARD),
        EAST(Direction.FORWARD);
        private Direction direction;

        private Orientation(Direction direction) {
            this.direction = direction;
        }

        public static Direction getDirection(Orientation orientation) {
            if ((orientation == Orientation.SOUDTH) || (orientation == Orientation.EAST)) {
                return Direction.FORWARD; // =================================>>
            }
            return Direction.BACKWARD;
        }

        public static Orientation getOrientation(Car car) {
            return getOrientation(car.getWay(), car.getDirection());
        }

        public static Orientation getOrientation(Way way, Direction direction) {
            if (way instanceof VWay) {
                if (direction == Direction.FORWARD) {
                    return Orientation.SOUDTH; //=============================>>
                } else {
                    return Orientation.NORTH; //==============================>>
                }
            }

            if (way instanceof HWay) {
                if (direction == Direction.FORWARD) {
                    return Orientation.EAST; //===============================>>
                } else {
                    return Orientation.WEST; //===============================>>
                }
            }

            return Orientation.WEST;
        }

        public static int getDegrees(Orientation orientation) {
            switch (orientation) {
                case NORTH:
                    return 0;
                case EAST:
                    return 90;
                case SOUDTH:
                    return 180;
                case WEST:
                    return 270;
            }

            return 0;
        }
    }

    public static enum Direction {

        FORWARD(1), BACKWARD(-1);
        private int increment;

        private Direction(int increment) {
            this.increment = increment;
        }

        public int getIncrement() {
            return this.increment;
        }

        public Orientation getOrientation(Way way) {
            if (way instanceof VWay) {
                if (this == Direction.FORWARD) {
                    return Orientation.SOUDTH; //=============================>>
                } else {
                    return Orientation.NORTH; //==============================>>
                }
            }

            if (way instanceof HWay) {
                if (this == Direction.FORWARD) {
                    return Orientation.EAST; //===============================>>
                } else {
                    return Orientation.WEST; //===============================>>
                }
            }

            return Orientation.WEST;
        }

        @Override
        public String toString() {
            switch (this) {
                case FORWARD:
                    return "FORWARD";
                case BACKWARD:
                    return "BACKWARD";
            }
            return "Undefined";
        }
    }

    public static enum CarType {

        BYKE(Color.GREEN, 75, 220, 30, 300, -600),
        MOTORCYCLE(Color.CYAN, 100, 275, 250, 1100, -1600),
        TURISM(Color.BLUE, 220, 400, 150, 600, -980),
        TRUCK(Color.PINK, 325, 800, 90, 500, -750);
        private int maxSpeedInKmHore;
        private int maxAcceleration; // In units compatibles with speed
        private int maxDeceleration;
        private int cmWidth;
        private int cmLong;
        private Color color;

        private CarType(Color color, int cmWidth, int cmHeig, int maxSpeedInKmHore, int maxAcceleration, int maxDeceleration) {
            this.color = color;
            this.cmWidth = cmWidth;
            this.cmLong = cmHeig;
            this.maxSpeedInKmHore = maxSpeedInKmHore;
            this.maxAcceleration = maxAcceleration;
            this.maxDeceleration = maxDeceleration;
        }

        public Color getColor() {
            return this.color;
        }

        public int getCmWidth() {
            return this.cmWidth;
        }

        public int getCmLong() {
            return this.cmLong;
        }

        public int getMaxSpeedInKmHore() {
            return this.maxSpeedInKmHore;
        }

        public int getMaxSpeedInCmSecond() {
            return this.maxSpeedInKmHore * 1000 / 36;
        }

        public int getMaxAcceleration() {
            return this.maxAcceleration;
        }

        public int getMaxDeceleration() {
            return this.maxDeceleration;
        }

        public String toString() {
            switch (this) {
                case BYKE:
                    return "BYKE";
                case MOTORCYCLE:
                    return "MOTORCYCLE";
                case TURISM:
                    return "TURISM";
                case TRUCK:
                    return "TRUCK";
            }
            return "Other Car Type ...";
        }
    }
    private int cmLong;
    private int cmWidth;
    private int maxSpeedInCmSecond;
    private int maxAcceleration; // In units compatibles with speed
    private int maxDeceleration;
    private volatile int cmPosition;             // Car position relative to actual way   
    private volatile int acceleration;
    private volatile int speedInCmSecond;
    private volatile long lastUpdateTime;
    private boolean turn;
    private double course;
    private float factorX, factorY;
    private BufferedImage imgCar;
    private volatile Way way;
    private Driver driver;
    private Color color;
    private String idCar;
    private CarType carType;
    private CarStatus status;
    private Direction direction;

    public Car(String idCar, Driver driver, Way way, CarType carType) {
        this.idCar = idCar;
        this.carType = carType;
        this.cmLong = carType.getCmLong();
        this.cmWidth = carType.getCmWidth();
        this.maxSpeedInCmSecond = carType.getMaxSpeedInCmSecond();
        this.maxAcceleration = carType.getMaxAcceleration(); // cm/s^2
        this.maxDeceleration = carType.getMaxDeceleration();

        this.factorX = this.factorY = -1;
        this.course = -1;

        this.driver = driver;
        this.driver.setCar(this);
        this.setDefaultColor();

        this.status = CarStatus.HIDE;
        this.cmPosition = 0;
        this.speedInCmSecond = 0;

        this.turn = false;
        this.setWay(way);
        this.setDirection(Direction.FORWARD);
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public CarType getCarType() {
        return this.carType;
    }

    public int getCmPosition() {
        return this.cmPosition;
    }

    public Color getColor() {
        return this.color;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public String getIdCar() {
        return this.idCar;
    }

    public int getLongInCm() {
        return this.cmLong;
    }

    public int getMaxAcceleration() {
        return this.maxAcceleration;
    }

    public int getMaxDeceleration() {
        return this.maxDeceleration;
    }

    public int getMaxSpeedInKmHore() {
        float kmHore;

        kmHore = (float) (this.maxSpeedInCmSecond) / 1000.0f * 36.0f;

        return (int) Math.round(kmHore);
    }

    public CarStatus getStatus() {
        return this.status;
    }

    public int getSpeedInCmSecond() {
        return this.speedInCmSecond;
    }

    public int getSpeedInKmHore() {
        float kmHore;

        kmHore = (float) (this.speedInCmSecond) / 1000.0f * 36.0f;

        return (int) Math.round(kmHore);
    }

    public Way getWay() {
        return this.way;
    }

    public int getWidthInCm() {
        return this.cmWidth;
    }

    //-- setes
    public void setAcceleration(int acceleration) {
        if (acceleration > this.maxAcceleration) {
            this.acceleration = this.maxAcceleration;
        } else if (acceleration < this.maxDeceleration) {
            this.acceleration = this.maxDeceleration;
        } else {
            this.acceleration = acceleration;
        }

        if ((this.speedInCmSecond >= this.maxSpeedInCmSecond) && (this.acceleration > 0)) {
            this.acceleration = 0;
        }

        if ((this.speedInCmSecond == 0) && (this.acceleration < 0)) {
            this.acceleration = 0;
        }
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDefaultColor() {
        if (this.driver.getDriverType() == Driver.DriverType.PRUDENT) {
            this.setColor(this.carType.getColor());
        } else {
            this.setColor(this.driver.getDriverType().getColor());
        }
    }

    public void setDimension(int cmWidth, int cmHigh) {
        this.cmWidth = cmWidth;
        this.cmLong = cmHigh;
    }

    public void setDirection(Direction direction) {
        if (this.direction != null) {
            if (this.direction.equals(direction)) {
                return; // ===================================================>>
            }
        }

        if (this.way != null) {
            this.way.removeCar(this);
            this.direction = direction;
            this.way.addCar(this);
        }
    }

    public void setMaxAcceleration(int maxAcceleration) {
        this.maxAcceleration = maxAcceleration;
    }

    public void setMaxDeceleration(int maxDeceleration) {
        this.maxDeceleration = maxDeceleration;
    }

    public void setMaxSpeedInCmSecond(int maxSpeedInCmSecond) {
        this.maxSpeedInCmSecond = maxSpeedInCmSecond;
    }

    public void setMaxSpeedInKmHore(int speedInKmH) {
        float cmSecond;

        cmSecond = (int) Math.round(speedInKmH * 1000.0f / 36.0f);
        this.maxSpeedInCmSecond = (int) cmSecond;
    }

    public void setPositionInCm(int cmPos) {
        this.cmPosition = cmPos;
    }

    public void setSpeedInKmHour(int speedInKmHour) {
        float cmSecond;

        cmSecond = (int) Math.round(speedInKmHour * 1000.0f / 36.0f);

        if (cmSecond > 0) {
            this.status = CarStatus.RUN;
        }

        this.speedInCmSecond = (int) cmSecond;
    }

    public void setStatus(CarStatus newStatus) {
        this.status = newStatus;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setWay(Way way) {
        if (this.way != null) {
            if (this.way.equals(way)) {
                return; //====================================================>>
            } else {
                this.way.removeCar(this);
                this.way = way;
                this.way.addCar(this);
            }
        } else {
            this.way = way;
            this.way.addCar(this);
        }
    }

    private synchronized void doTurn() {
        CrossRoad crossRoad;
        Orientation orientation;
        Boolean canContinue;
        Way actualWay;
        Way newWay;
        Direction actualDirection;

        crossRoad = this.way.intersectedCrossRoad(this.cmPosition);
        if (crossRoad == null) {
            return; // ======= No crossroad intersection no turn ... =========>>
        }
        // Test if I can continue in the same way
        orientation = this.direction.getOrientation(this.way);
        canContinue = crossRoad.testOrientationAvailable(orientation);
        if ((canContinue) && (!this.turn)) {
            return; // ========= No desired turn =============================>>
        }
        // Comprobar si estamos en la posicion de cambio de via

        // Change way
        actualWay = this.way;
        actualDirection = this.direction;
        int actualCmPosition = this.cmPosition;
        newWay = crossRoad.getRandomWay(actualWay);
        this.setDirection(crossRoad.getRandomDirection(newWay));
        this.setWay(newWay);

        // Calculate new position in the new way
        this.cmPosition =
                this.way.getCmPosition(
                actualWay.getCmPosX(actualCmPosition, actualDirection),
                actualWay.getCmPosY(actualCmPosition, actualDirection),
                this.direction);

        this.turn = false; 
    }

    public synchronized void paint(Graphics g, float factorX, float factorY, int offsetX, int offsetY) {
        float elapsedSeconds;
        int cmPosX, cmPosY, interpoledPosition;
        int x, y;
        double course;

        if ((this.status == CarStatus.HIDE)
                || (this.status == CarStatus.ARRIVED)
                || (this.status == CarStatus.CRASHED)) {
            return; // =======================================================>>
        }

        // Interpole position
        elapsedSeconds = ((float) (System.nanoTime() - this.lastUpdateTime)) / 1000000000.0f;
        interpoledPosition = this.cmPosition + this.direction.getIncrement() * (int) (elapsedSeconds * (float) (this.speedInCmSecond));
        cmPosX = this.way.getCmPosX(interpoledPosition, this.direction);
        cmPosY = this.way.getCmPosY(interpoledPosition, this.direction);
        course = this.way.getCourse(interpoledPosition, this.direction);

        if ((this.imgCar == null)
                || (this.factorX != factorX)
                || (this.factorY != factorY)
                || (this.course != course)) {
            
            this.factorX = factorX;
            this.factorY = factorY;
            this.course = course;
            this.imgCar = CarGraphics.getCarImage(this, factorX, factorY, course);
        }

        // Posicio central per dibuixar
        x = (int) ((cmPosX / factorX)) + offsetX - this.imgCar.getWidth() / 2;
        y = (int) ((cmPosY / factorY)) + offsetY - this.imgCar.getHeight() / 2;
        g.drawImage(this.imgCar, x, y, null);
    }

    @Override
    public void run() {
        this.status = CarStatus.RUN;
        this.lastUpdateTime = System.nanoTime();
        while (!City.isEnd() && (this.status != CarStatus.ARRIVED) && (this.status != CarStatus.CRASHED)) {
            try {
                Thread.sleep(1000 / Car.FREQ_VEHICLES); // nano -> ms
            } catch (InterruptedException ex) {
            }

            if (!City.isPaused()) {
                this.updateAll();
            }
        }
    }

    @Override
    public void start() {
        this.driver.start();
        super.start();
    }

    @Override
    public String toString() {
        return "Car Id: " + this.getIdCar();
    }

    public void updateAll() {
        float elapsedSeconds;
        long elapsedNanos;
        long now;

        if (this.status == CarStatus.ARRIVED) {
            return; // ========================>>
        }
        if (this.status == CarStatus.CRASHED) {
            return; // ===========================>>
        }
        now = System.nanoTime();
        elapsedNanos = now - this.lastUpdateTime;
        this.lastUpdateTime = now;
        elapsedSeconds = ((float) (elapsedNanos)) / 1000000000.0f;

        this.updatePosition(elapsedSeconds);
        this.doTurn();
        this.updateSpeed(elapsedSeconds);
    }

    private synchronized void updatePosition(float elapsedSeconds) {
        Car car;

        this.cmPosition = this.cmPosition + this.direction.getIncrement() * (int) (elapsedSeconds * (float) (this.speedInCmSecond));

        // Updade car status
        if (this.speedInCmSecond == 0) {
            this.status = CarStatus.STOP;
        } else {
            this.status = CarStatus.RUN;
        }

        if (!this.way.posIsInside(cmPosition, direction)) {
            this.status = CarStatus.ARRIVED;
            this.way.removeCar(this);
            this.imgCar = null;
        }

        car = this.way.otherCarInSamePosition(this);
        if (car != null) {
            this.status = CarStatus.CRASHED;
            this.way.removeCar(this);
            car.setStatus(CarStatus.CRASHED);
            car.getWay().removeCar(car);
            this.imgCar = null;
        }
    }

    private synchronized void updateSpeed(float elapsedSeconds) {
        this.speedInCmSecond = this.speedInCmSecond + (int) (elapsedSeconds * (float) (this.acceleration));

        if (this.maxSpeedInCmSecond < this.speedInCmSecond) {
            this.speedInCmSecond = this.maxSpeedInCmSecond;
        }

        if (this.speedInCmSecond < 0) {
            this.speedInCmSecond = 0;
        }

        // System.out.println(this +" Speed:" + this.getSpeedInKmHore());
    }
}