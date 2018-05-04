package city;

import static city.Car.CarStatus.CRASHED;
import city.Car.CarType;
import static city.Car.CarType.BYKE;
import static city.Car.CarType.MOTORCYCLE;
import static city.Car.CarType.TRUCK;
import static city.Car.CarType.TURISM;
import city.Car.Direction;
import city.Driver.DriverType;
import static city.Driver.DriverType.GRANDMOTHER;
import static city.Driver.DriverType.ILLEGAL;
import static city.Driver.DriverType.PRUDENT;
import static city.Driver.DriverType.RISKY;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Jumi
 *
 * Inyecta vehiculos en la ciudad.
 *
 */
public class Traffic extends Thread {

    public static final int TOTAL = 0;
    public static final int TRUCKS = 1;
    public static final int TURISM = 2;
    public static final int MOTORCYCLE = 3;
    public static final int BYKE = 4;
    public static final int RUN = 6;    // ---
    public static final int STOP = 7;
    public static final int CRASHED = 8;
    public static final int ARRIVED = 9;    // ---
    public static final int HIDE = 10;
    public static final int ILLEGAL = 12;
    public static final int RISKY = 13;    // ---
    public static final int PRUDENT = 14;
    public static final int GRANDMOTHER = 15;
    public static final int CRASH_TRUCKS = 16;
    public static final int CRASH_TURISM = 17;
    public static final int CRASH_MOTORCYCLES = 18;
    public static final int CRASH_BYKES = 19;
    public static final int CRASH_ILLEGAL = 20;
    public static final int CRASH_RISKY = 21;
    public static final int CRASH_PRUDENT = 22;
    public static final int CRASH_GRANDMOTHER = 23;
    private int turismPercent;
    private int bykesPercent;
    private int trucksPercent;
    private int motorcyclesPercent;
    private int prudentDriverPercent;
    private int riskyDriverPercent;
    private int illegalDriverPercent;
    private int grandMatherDriverPercent;
    private int numberOfCarsObjective; // ***********   
    private Integer carStatistics[];
    private ArrayList<Car> cars;
    private ArrayList<Way> ways;

    public Traffic(ArrayList<Way> ways) {
        this.turismPercent = 20;
        this.bykesPercent = 15;
        this.trucksPercent = 30;
        this.motorcyclesPercent =35;

        this.illegalDriverPercent = 10;
        this.prudentDriverPercent = 15;
        this.riskyDriverPercent = 40;
        this.grandMatherDriverPercent = 35;

        this.ways = ways;
        this.cars = new ArrayList<Car>();
        this.carStatistics = new Integer[32];
    }

    public synchronized ArrayList<Car> getCars() {
        return this.cars;
    }

    public synchronized Car addCar(Way way, CarType carType, Direction direction, DriverType driverType) {
        Car car;
        Driver driver;

        driver = new Driver(driverType);
        return this.addCar(way, carType, direction, driver);
    }

    public synchronized Car addCar(Way way, CarType carType, Direction direction, Driver driver) {
        Car car;

        car = new Car(way.getId() + "-" + carType, driver, way, carType);
        car.setDirection(direction);
        car.setPositionInCm(way.getEntryPoint(direction));
        car.start();

        this.cars.add(car);
        return car;
    }

    private CarType getRandomCarType() {
        int randomInt;
        int turismMax;
        int bykesMax;
        int trucksMax;

        turismMax = this.turismPercent;
        bykesMax = turismMax + this.bykesPercent;
        trucksMax = bykesMax + this.trucksPercent;

        Random rand = new Random();
        randomInt = rand.nextInt(100);

        if (randomInt <= turismMax) {
            return CarType.TURISM;
        }

        if (randomInt <= bykesMax) {
            return CarType.BYKE;
        }

        if (randomInt <= trucksMax) {
            return CarType.TRUCK;
        }

        return CarType.MOTORCYCLE;
    }

    private Direction getRandomDirection() {
        int randomInt;

        Random rand = new Random();
        randomInt = rand.nextInt(2);

        if (randomInt == 0) {
            return Direction.FORWARD;
        }

        return Direction.BACKWARD;
    }

    private DriverType getRandomDriverType() {
        int randomInt;
        int prudentMax;
        int riskyMax;
        int illegalMax;

        prudentMax = this.prudentDriverPercent;
        riskyMax = prudentMax + this.riskyDriverPercent;
        illegalMax = riskyMax + this.illegalDriverPercent;

        Random rand = new Random();
        randomInt = rand.nextInt(100);

        if (randomInt <= prudentMax) {
            return DriverType.PRUDENT;
        }

        if (randomInt <= riskyMax) {
            return DriverType.RISKY;
        }

        if (randomInt <= illegalMax) {
            return DriverType.ILLEGAL;
        }

        return DriverType.GRANDMOTHER;
    }

    private Way getRandomWay() {
        int randomInt;
        Way way;

        if (this.ways.size() < 1) {
            return null; // ==================================================>>
        }
        Random rand = new Random();
        randomInt = rand.nextInt(this.ways.size());

        return this.ways.get(randomInt);
    }

    public synchronized Integer[] getCarStatistics() {
        return this.carStatistics;
    }

    private Car generateCar() {
        CarType carType;
        Way way;
        Direction direction;
        DriverType driverType;
        Car car;

        carType = this.getRandomCarType();
        way = this.getRandomWay();
        direction = this.getRandomDirection();
        driverType = this.getRandomDriverType();

        car = this.addCar(way, carType, direction, driverType);

        return car;
    }

    public synchronized void paintCars(Graphics g, float factorX, float factorY, int offsetX, int offsetY) {
        Car actualCar;

        Iterator<Car> itr = cars.iterator();
        while (itr.hasNext()) {
            actualCar = itr.next();

            if ((actualCar.getStatus() != Car.CarStatus.ARRIVED)
                    && (actualCar.getStatus() != Car.CarStatus.CRASHED)
                    && (actualCar.getStatus() != Car.CarStatus.HIDE)) {
                
                actualCar.paint(g, factorX, factorY, offsetX, offsetY);
            }
        }
    }

    public synchronized void updateCarStatistics() {
        Car actualCar;

        for (int i = 0; i < this.carStatistics.length; i++) {
            this.carStatistics[i] = 0;
        }

        Iterator<Car> itr = cars.iterator();
        while (itr.hasNext()) {
            actualCar = itr.next();
            this.carStatistics[Traffic.TOTAL]++;

            // Car types
            switch (actualCar.getCarType()) {
                case TURISM:
                    this.carStatistics[Traffic.TURISM]++;
                    break;

                case TRUCK:
                    this.carStatistics[Traffic.TRUCKS]++;
                    break;

                case BYKE:
                    this.carStatistics[Traffic.BYKE]++;
                    break;

                case MOTORCYCLE:
                    this.carStatistics[Traffic.MOTORCYCLE]++;
                    break;
            }

            // Car types
            switch (actualCar.getStatus()) {
                case RUN:
                    this.carStatistics[Traffic.RUN]++;
                    break;

                case STOP:
                    this.carStatistics[Traffic.STOP]++;
                    break;

                case CRASHED:
                    this.carStatistics[Traffic.CRASHED]++;

                    // Driver types
                    switch (actualCar.getDriver().getDriverType()) {
                        case ILLEGAL:
                            this.carStatistics[Traffic.CRASH_ILLEGAL]++;
                            break;
                        case RISKY:
                            this.carStatistics[Traffic.CRASH_RISKY]++;
                            break;
                        case PRUDENT:
                            this.carStatistics[Traffic.CRASH_PRUDENT]++;
                            break;
                        case GRANDMOTHER:
                            this.carStatistics[Traffic.CRASH_GRANDMOTHER]++;
                            break;
                    }

                    // Car types
                    switch (actualCar.getCarType()) {
                        case TURISM:
                            this.carStatistics[Traffic.CRASH_TURISM]++;
                            break;
                        case TRUCK:
                            this.carStatistics[Traffic.CRASH_TRUCKS]++;
                            break;
                        case BYKE:
                            this.carStatistics[Traffic.CRASH_BYKES]++;
                            break;
                        case MOTORCYCLE:
                            this.carStatistics[Traffic.CRASH_MOTORCYCLES]++;
                            break;
                    }
                    break;

                case ARRIVED:
                    this.carStatistics[Traffic.ARRIVED]++;
                    break;

                case HIDE:
                    this.carStatistics[Traffic.HIDE]++;
                    break;

            }

            // Driver types
            switch (actualCar.getDriver().getDriverType()) {
                case ILLEGAL:
                    this.carStatistics[Traffic.ILLEGAL]++;
                    break;
                case RISKY:
                    this.carStatistics[Traffic.RISKY]++;
                    break;
                case PRUDENT:
                    this.carStatistics[Traffic.PRUDENT]++;
                    break;
                case GRANDMOTHER:
                    this.carStatistics[Traffic.GRANDMOTHER]++;
                    break;
            }
        }
    }

    @Override
    public void run() {
        while (!City.isEnd()) {
            if (!City.isPaused()) {
                this.generateCar();
            }

            try {
                Thread.sleep(500); // nano -> ms
            } catch (InterruptedException ex) {
            }
        }
    }
}
