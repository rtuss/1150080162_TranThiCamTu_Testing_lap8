package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test(description = "Kiem thu tieu de trang chu")
    public void testTitle() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Tieu de trang khong dung!");
    }

    @Test(description = "Kiem thu URL trang chu")
    public void testURL() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("saucedemo"), "URL khong hop le!");
    }

    @Test(description = "Kiem thu page source")
    public void testPageSource() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Swag Labs"), "Page source khong dung!");
    }

    @Test(description = "Kiem thu form dang nhap")
    public void testLoginForm() {
        boolean isDisplayed = driver.findElement(By.id("user-name")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Form dang nhap khong hien thi!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
