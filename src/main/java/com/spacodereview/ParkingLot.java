package com.spacodereview;

import java.util.*;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private Map<String, ParkingSpot> carToSpotMap;
    private int numSpots;
    private int availableSpotsLeft;

    public ParkingLot(int numSpots) {
        this.numSpots = numSpots;
        this.availableSpotsLeft = numSpots;
        this.parkingSpots = new ArrayList<>();
        this.carToSpotMap = new HashMap<>();

        for (int i = 0; i < numSpots; i++) {
            ParkingSpot spot;
            if (i < numSpots * 0.2) {
                spot = new HandicappedSpot(i + 1);
            } else if (i < numSpots * 0.5) {
                spot = new CompactSpot(i + 1);
            } else {
                spot = new RegularSpot(i + 1);
            }
            parkingSpots.add(spot);
        }
    }
    /**
     * Adds car to carToSpotMap, reduces availableSpotsLeft, and adds
     * car to available ParkingSpot.
     * @param car Car to be parked
     * @return boolean true if successful, false if not available
     * @throws IllegalArgumentException if car exists in map
     */
    public boolean parkCar(Car car) throws Exception {
        if (carToSpotMap.get(car.getLicensePlate()) != null) {
            throw new IllegalArgumentException("Parking Lot (parkCar): Car Already Exists in carToSpotMap");
        }
        if (availableSpotsLeft == 0) {
            return false;
        }
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable()) {
                continue;
            }
            if ((car.isCompact() && spot.getType().equals("Compact")) ||
                    (car.isHandicapped() && spot.getType().equals("Handicapped")) ||
                    (spot.getType().equals(("Regular")))) {
                spot.parkCar(car);
                String licensePlate = car.getLicensePlate();
                carToSpotMap.put(licensePlate, spot);
                availableSpotsLeft--;
                return true;
            }
        }
        return false;
    }
    /**
     * Removes car from carToSpotMap and ParkingSpot, and adds
     * additional available spot to availableSpotsLeft.
     * @param licensePlate licensePlate of car to be removed
     * @return boolean true if successful, false if not available
     */
    public boolean removeCar(String licensePlate) {
        if (!carToSpotMap.containsKey(licensePlate)) {
            return false;
        }
        ParkingSpot spot = carToSpotMap.get(licensePlate);
        spot.removeCar();
        availableSpotsLeft++;

        carToSpotMap.remove(licensePlate);
        return true;
    }

    public int getAvailableSpots() {
        return availableSpotsLeft;
    }

    public int getNumSpots() {
        return numSpots;
    }
}