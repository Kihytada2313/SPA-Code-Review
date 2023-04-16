package com.spacodereview;

public class Car {
    private String licensePlate;
    private boolean isHandicapped;
    private boolean isCompact;

    private static int numCars;

    public Car(String licensePlate) {
        this(licensePlate, false, false);
    }
    public Car(String licensePlate, boolean isHandicapped, boolean isCompact) {
        this.licensePlate = licensePlate;
        this.isHandicapped = isHandicapped;
        this.isCompact = isCompact;
        numCars++;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public boolean isCompact() {
        return isCompact;
    }

    public static int getNumCars() {
        return numCars;
    }
}