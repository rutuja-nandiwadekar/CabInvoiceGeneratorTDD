package com.blz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
      invoiceGenerator = new InvoiceGenerator();
    }

    //Step 1 - Calculate fare

    //TC1 for Calculate total fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }

    //tc2 for Calculate minimum fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    //Step 2 - Multiple Rides

    //tc3 for Calculate total fare for Multiple Rides
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1,1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    //Step 4 : Invoice Service
    @Test
    public void givenUserAndRides_ShouldReturnInvoiceSummary() {
        String user1 = "abc.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides(user1, rides);
        String user2 = "pqr.com";
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides(user2, rides1);
        InvoiceSummary summary = invoiceGenerator.getInvoiceService(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

}
