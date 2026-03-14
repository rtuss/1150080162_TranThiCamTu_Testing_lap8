package com.example.baitap2;

import org.testng.annotations.Test;
import org.testng.Assert;

public class CheckoutTest {
    @Test(groups = {"smoke", "regression"})
    public void testCheckout() {
        System.out.println("Checkout success");
        Assert.assertTrue(true);
    }   

    @Test(groups = {"regression"})
    public void testCancelCheckout() {
        System.out.println("Cancel Checkout ");
        Assert.assertTrue(true);
    }
    
}
