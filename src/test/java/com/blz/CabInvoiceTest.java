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

}
