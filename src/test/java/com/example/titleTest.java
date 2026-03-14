package com.example;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class titleTest {
    @Test
    public void testPageSource() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        String source = driver.getPageSource();
        Assert.assertTrue(source.contains("login-button"));
        driver.quit();
    }

    @Test
    public void testLoginForm() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.id("user-name"));
        Assert.assertTrue(username.isDisplayed());
        driver.quit();
    }

}
