package com.blz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    //Step 1 - Calculate fare

    //TC1 for Calculate total fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }

    //tc2 for Calculate minimum fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    //Step 2 - Multiple Rides

    //tc3 for Calculate total fare for Multiple Rides
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(62.1, fare, 0.0);
    }

}
