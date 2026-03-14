package com.example.baitap2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.example.utils.DriverFactory;

public class CartTest {

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver("chrome");

        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        System.out.println("Setup CartTest - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void testAddToCart() throws InterruptedException {

        System.out.println("Add product to cart - Thread ID: " + Thread.currentThread().getId());

        Thread.sleep(5000); // giữ browser 5 giây

        Assert.assertTrue(true);

    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();

    }
}