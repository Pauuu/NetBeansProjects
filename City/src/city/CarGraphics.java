/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package city;

import static city.Car.CarType.BYKE;
import static city.Car.CarType.MOTORCYCLE;
import static city.Car.CarType.TRUCK;
import static city.Car.CarType.TURISM;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jumi
 */
public class CarGraphics {

    public static BufferedImage imgTurism;
    public static BufferedImage imgTruck;
    public static BufferedImage imgByke;
    public static BufferedImage imgMotocycle;
    private static boolean isLoad = false;

    private static void loadCarImages() {
        if (CarGraphics.isLoad) {
            return; //========================================================>>
        }
        CarGraphics.imgTurism = CarGraphics.loadImage("turism.gif");
        CarGraphics.imgTruck = CarGraphics.loadImage("truck.gif");
        CarGraphics.imgByke = CarGraphics.loadImage("byke.gif");
        CarGraphics.imgMotocycle = CarGraphics.loadImage("motocycle.gif");

        CarGraphics.isLoad = true;
    }

    private static BufferedImage loadImage(String fileName) {
        BufferedImage img;

        img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.out.println("Load image error: <" + fileName + ">");
            img = null;
        }

        return img;
    }

    public static BufferedImage processCarImg(BufferedImage imgSrc, int cmWidth, int cmHeight, float factorX, float factorY, double rotationAngle) {
        int xCenterTranslate, yCenterTranslate;
        float xCenterNew, yCenterNew;
        float xCenterFinal, yCenterFinal;
        int xyPixRotate, xPixFinal, yPixFinal;
        BufferedImage imgRotate, imgFinal;
        Graphics2D g2d;

        if (imgSrc == null) {
            return null; //====================================================>>
        }
        xyPixRotate = (int) (Math.sqrt(Math.pow(imgSrc.getHeight(), 2) + Math.pow(imgSrc.getWidth(), 2) / 4));
        imgRotate = new BufferedImage(xyPixRotate, xyPixRotate, BufferedImage.TYPE_INT_ARGB);

        xCenterNew = imgSrc.getWidth() / 2.0f;
        yCenterNew = imgSrc.getHeight() / 2.0f;
        xCenterFinal = xyPixRotate / 2.0f;
        yCenterFinal = imgRotate.getHeight() / 2.0f;
        xCenterTranslate = (int) (xCenterFinal - xCenterNew);
        yCenterTranslate = (int) (yCenterFinal - yCenterNew);

        g2d = imgRotate.createGraphics();
        g2d.translate(xCenterTranslate, yCenterTranslate);
        g2d.rotate(rotationAngle, xCenterNew, yCenterNew);

        g2d.drawImage(imgSrc, 0, 0, null);
        g2d.dispose();

        yPixFinal = (int) ((Math.sqrt(Math.pow(cmHeight, 2) + Math.pow(cmWidth, 2) / 4)) / factorY);
        xPixFinal = (int) ((Math.sqrt(Math.pow(cmHeight, 2) + Math.pow(cmWidth, 2) / 4)) / factorX);

        imgFinal = new BufferedImage(xPixFinal, yPixFinal, BufferedImage.TYPE_INT_ARGB);
        g2d = imgFinal.createGraphics();
        g2d.drawImage(imgRotate, 0, 0, xPixFinal, yPixFinal, 0, 0, xyPixRotate, xyPixRotate, null);
        g2d.dispose();

        return imgFinal;
    }

    public static BufferedImage getCarImage(Car car, float factorX, float factorY, double rotationAngle) {
        BufferedImage imgSrc;

        if (!CarGraphics.isLoad) {
            CarGraphics.loadCarImages();
        }

        imgSrc = null;
        switch (car.getCarType()) {
            case TURISM:
                imgSrc = CarGraphics.imgTurism;
                break;

            case TRUCK:
                imgSrc = CarGraphics.imgTruck;
                break;

            case MOTORCYCLE:
                imgSrc = null;
//                img = CarGraphics.imgMotocycle;
                break;

            case BYKE:
                imgSrc = null;
//                img = CarGraphics.imgByke;
                break;
        }

        if (imgSrc == null) {
            imgSrc = CarGraphics.createCarImg(car, factorX, factorY);
        }

        imgSrc = CarGraphics.processCarImg(imgSrc, car.getWidthInCm(), car.getLongInCm(), factorX, factorY, rotationAngle);


        return imgSrc;
    }

    public static BufferedImage getCarImage(Car car) {
        BufferedImage imgSource, imgTarget;
        Graphics2D g2d;

        if (!CarGraphics.isLoad) {
            CarGraphics.loadCarImages();
        }

        imgTarget = imgSource = null;
        switch (car.getCarType()) {
            case TURISM:
                imgSource = CarGraphics.imgTurism;
                break;

            case TRUCK:
                imgSource= CarGraphics.imgTruck;
                break;

            case MOTORCYCLE:
                imgSource = null;
//                img = CarGraphics.imgMotocycle;
                break;

            case BYKE:
                imgSource = null;
//                img = CarGraphics.imgByke;
                break;
        }

        if (imgSource != null) {
            imgTarget = new BufferedImage(imgSource.getWidth(), imgSource.getHeight(), BufferedImage.TYPE_INT_ARGB);
            g2d = (Graphics2D) imgTarget.getGraphics();
            g2d.drawImage(imgSource, 0, 0, imgSource.getWidth(), imgSource.getHeight(), null);
            g2d.dispose();
        }

        return imgTarget;
    }

    private static BufferedImage createCarImg(Car car, float factorX, float factorY) {
        BufferedImage imgSrc;
        Graphics2D g2d;

        imgSrc = new BufferedImage(
                (int) (Math.max(1, car.getWidthInCm() / factorX)),
                (int) Math.max(1, car.getLongInCm() / factorY),
                BufferedImage.TYPE_INT_ARGB);

        g2d = imgSrc.createGraphics();

        g2d.setColor(car.getColor());
        g2d.fillRect(0, 0, imgSrc.getWidth(), imgSrc.getHeight());
        g2d.setColor(car.getColor().darker());
        g2d.drawRect(0, 0, imgSrc.getWidth(), imgSrc.getHeight());

        g2d.dispose();

        return imgSrc;
    }
}