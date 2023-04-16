package com.spacodereview;

public abstract class ParkingSpot {
    protected int spotNumber;
    protected boolean available;
    private String type;

    public ParkingSpot(int spotNumber, String type) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void parkCar(Car car) {
        available = false;
    }

    public void removeCar() {
        available = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getType() {
        return type;
    }
}

class CompactSpot extends ParkingSpot {
    public CompactSpot(int spotNumber) {
        super(spotNumber, "Compact");
    }
}

class RegularSpot extends ParkingSpot {
    public RegularSpot(int spotNumber) {
        super(spotNumber, "Regular");
    }
}

class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(int spotNumber) {
        super(spotNumber, "Handicapped");
    }
}

