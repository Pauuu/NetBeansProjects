package city;

import city.Car.Direction;
import city.Car.CarStatus;
import static city.Car.CarType.BYKE;
import static city.Car.CarType.MOTORCYCLE;
import static city.Car.CarType.TRUCK;
import static city.Car.CarType.TURISM;
import java.awt.Color;

/**
 *
 * @author Jumi
 */
public class Driver extends Thread {

    public static enum DriverType {

        ILLEGAL(250, 100, 80, 100, Color.RED),
        RISKY(140, 100, 80, 120, Color.YELLOW),
        PRUDENT(120, 80, 100, 240, Color.WHITE),
        GRANDMOTHER(80, 60, 120, 600, Color.BLACK);
        private int usualSpeedInKmHour;
        private int usualAcceleration;
        private int usualSafetyDistance;
        private int limitTimeUnderUsualSpeedInSeconds; // To activate turns
        private Color color;

        private DriverType(int usualSpeedInKmHour, int usualAcceleration, int usualSafetyDistance, int limitTimeUnderUsualSpeedInSeconds, Color color) {
            this.usualSpeedInKmHour = usualSpeedInKmHour;
            this.usualAcceleration = usualAcceleration;
            this.usualSafetyDistance = usualSafetyDistance;
            this.limitTimeUnderUsualSpeedInSeconds = limitTimeUnderUsualSpeedInSeconds;
            this.color = color;
        }

        public int getUsualSpeedInCmSecond() {
            return this.usualSpeedInKmHour * 1000 / 36;
        }

        public int getUsualAcceleration() {
            return this.usualAcceleration;
        }

        public int getUsualSafetyDistance() {
            return this.usualSafetyDistance;
        }

        public int getIimitTimeUnderUsualSpeedInSeconds() {
            return this.limitTimeUnderUsualSpeedInSeconds;
        }

        public Color getColor() {
            return this.color;
        }

        public String toString() {
            switch (this) {
                case RISKY:
                    return "RISKY";
                case PRUDENT:
                    return "PRUDENT";
                case GRANDMOTHER:
                    return "GRANDMOTHER";
            }
            return "Other Drivet type ...";
        }
    }
    private static final byte FREQ_CONDUCTOR = 10; // Hz
    private int usualSpeedinCmSecond;
    private int usualAcceleration;
    private int usualSafetyDistance;
    private int limitTimeUnderUsualSpeedInSeconds;
    private int averageSpeed;
    private Car car;
    private DriverType driverType;

    public Driver(DriverType driverType) {
        this.driverType = driverType;
        this.usualSpeedinCmSecond = this.driverType.getUsualSpeedInCmSecond();
        this.usualAcceleration = this.driverType.getUsualAcceleration();
        this.usualSafetyDistance = this.driverType.usualSafetyDistance;
    }

    private int getSafetyDistanceInCm() {
        float speedInMetersSecond;
        float safetyDistanceInMeters;

        speedInMetersSecond = this.car.getSpeedInCmSecond() / 100.0F;
        safetyDistanceInMeters = (float) Math.pow(speedInMetersSecond, 2) / 12.75F;

        // Correction
        safetyDistanceInMeters = safetyDistanceInMeters * this.usualSafetyDistance / 100;

        return Math.max(100, (int) (safetyDistanceInMeters) * 100);
    }

    public DriverType getDriverType() {
        return this.driverType;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }

    private int avoidFrontalCollisions() {
        Car inFrontCar;
        int distance;
        int distanceError;
        float percentError;
        float kP, kD, kI;

        inFrontCar = this.car.getWay().inFrontCar(this.car);
        if (inFrontCar == null) {
            return 0; // =====================================================>>
        }

        distance = Math.abs(inFrontCar.getCmPosition() - this.car.getCmPosition()) - (inFrontCar.getCarType().getCmLong() / 2);
        distanceError = (int) this.getSafetyDistanceInCm() - distance;
        percentError = (float) distanceError / (float) this.getSafetyDistanceInCm();

        kP = percentError * 2.0f;
        if (kP < 0) {
            return -1 * (int) (kP * (float) this.car.getMaxAcceleration());
        }
        return (int) (kP * (float) this.car.getMaxDeceleration());
    }

    private int crossRoadSafetySpeed() {
        CrossRoad inFrontCR;
        int speed;
        int distanceToCrossRoad;
        float speedError;
        float percentError;
        float kP, kD, kI;

        inFrontCR = this.car.getWay().inFrontCrossRoad(this.car);
        if (inFrontCR == null) {
            // System.out.println(this.car + " NULL");
            return 0; // =====================================================>>
        }

        distanceToCrossRoad = this.car.getWay().distanceToCrossRoadInCm(inFrontCR, this.car);
        if ((this.getSafetyDistanceInCm() * 2) <= distanceToCrossRoad) {
            return 0; // =====================================================>>        
        }

        speed = this.car.getSpeedInCmSecond();
        speedError = (float) (inFrontCR.getSafetySpeedInCmHour() - speed);
        percentError = speedError / (float) inFrontCR.getSafetySpeedInCmHour();

        kP = percentError * 1.0f;
        if (kP < 0) {
            // Correction
            return -1 * (int) (kP * (float) this.car.getMaxDeceleration());
        }

        // Correction
        return (int) (kP * (float) this.car.getMaxAcceleration());
    }

    private int usualSpeed() {
        int speed;
        float speedError;
        float percentError;
        float kP;

        // Test safetyDistance
        speed = this.car.getSpeedInCmSecond();
        speedError = (float) (this.usualSpeedinCmSecond - speed);
        percentError = speedError / (float) this.usualSpeedinCmSecond;

        kP = percentError * 2.0f;
        if (kP < 0) {
            // Correction
            return -1 * (int) (kP * (float) this.car.getMaxDeceleration());
        }

        // Correction
        return (int) (kP * (float) this.car.getMaxAcceleration());
    }

    private void driving() {
        int accAvoidCollision;
        int accUsualSpeed;
        int newAcceleration;
        int accCrossRoadSafetySpeed;

        accAvoidCollision = this.avoidFrontalCollisions();
        accUsualSpeed = this.usualSpeed();
        accCrossRoadSafetySpeed = this.crossRoadSafetySpeed();

        newAcceleration = accUsualSpeed;
        if (accAvoidCollision != 0) {
            newAcceleration = Math.min(accUsualSpeed, accAvoidCollision);
        }

        if (accCrossRoadSafetySpeed != 0) {
            newAcceleration = Math.min(accCrossRoadSafetySpeed, newAcceleration);
        }

        this.car.setAcceleration(newAcceleration);
    }

    public void trace(int accAvoidCollision, int accUsualSpeed, int accCrossRoadSafetySpeed) {
        if ((this.car.getSpeedInCmSecond() == 0) && (this.car.getAcceleration() == 0) && (accAvoidCollision == -2147483648)) {
            System.out.println(
                    this.car
                    + " Speed:" + this.car.getSpeedInKmHore()
                    + " Acc:" + this.car.getAcceleration()
                    + " Usual speed:" + this.usualSpeedinCmSecond);

            System.out.println("    Avoid:" + accAvoidCollision + " Usual:" + accUsualSpeed + " CrossRoad:" + accCrossRoadSafetySpeed);
        }
    }

    @Override
    public void run() {
        if (this.car == null) {
            System.out.println("No car for this driver...");
            return; // ======================================================>>
        }

        while (!City.isEnd()
                && (this.car.getStatus() != CarStatus.ARRIVED)
                && (this.car.getStatus() != CarStatus.CRASHED)) {

            if (!City.isPaused()) {
                this.driving();
            }
            try {
                Thread.sleep(1000 / Driver.FREQ_CONDUCTOR); // nano -> ms
            } catch (InterruptedException ex) {
            }
        }
    }
}