package com.spacodereview;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(5);
    }

    @Test
    public void testSimpleParkCar() throws Exception {
        assertEquals(5, parkingLot.getAvailableSpots());
        Car car = new Car("ABC123", false, true);
        parkingLot.parkCar(car);
        assertEquals(4, parkingLot.getAvailableSpots());
    }

    @Test
    public void testSimpleRemoveCar() throws Exception {
        Car car = new Car("ABC123", false, true);
        parkingLot.parkCar(car);
        assertEquals(4, parkingLot.getAvailableSpots());
        parkingLot.removeCar("ABC123");
        assertEquals(5, parkingLot.getAvailableSpots());
    }

    @Test
    public void testSimpleGetAvailableSpots() throws Exception {
        Car car1 = new Car("ABC123", false, true);
        Car car2 = new Car("DEF456", false, false);
        parkingLot.parkCar(car1);
        assertEquals(4, parkingLot.getAvailableSpots());
        parkingLot.parkCar(car2);
        assertEquals(3, parkingLot.getAvailableSpots());
    }

    @Test
    public void testSimpleParkCarFull() throws Exception {
        Car car6 = new Car("PQR678", false, false);
        Car car1 = new Car("ABC123", false, true);
        Car car5 = new Car("MNO345", true, false);
        Car car2 = new Car("DEF456", false, false);
        Car car3 = new Car("GHI789", false, false);
        Car car4 = new Car("JKL012", false, true);
        assertTrue(parkingLot.parkCar(car1));
        assertTrue(parkingLot.parkCar(car2));
        assertTrue(parkingLot.parkCar(car3));
        assertTrue(parkingLot.parkCar(car4));
        assertTrue(parkingLot.parkCar(car5));
        assertFalse(parkingLot.parkCar(car6));
    }
}