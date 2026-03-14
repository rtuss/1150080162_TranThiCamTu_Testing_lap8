package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import org.testng.Assert;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    // 1 Login thành công
    public void testLoginSuccess() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();      

        wait.until(ExpectedConditions.urlContains("inventory.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login đúng phải chuyển sang trang inventory.html");
    
}

// 2, Sai password
@Test
public void testLoginWrongPassword() {
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("login-button")).click();

    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
     Assert.assertTrue(
                error.getText().contains("Username and password do not match"),
                "Sai mật khẩu phải xuất hiện thông báo lỗi"
        );

}

// 3, Username rỗng
@Test
public void testLoginEmptyUsername() {
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();                          
    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
     Assert.assertTrue(
                error.getText().contains("Username is required"),
                "Username rỗng phải xuất hiện thông báo lỗi"
        );
}

// 4, Password rỗng
@Test
public void testLoginEmptyPassword() {                          
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("login-button")).click();      
    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
     Assert.assertTrue(
                error.getText().contains("Password is required"),
                "Phải hiển thị lỗi Password is required"
        );
}

//5, User bị khóa
@Test
public void testLoginLockedUser() {
    driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();  
    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
     Assert.assertTrue(
                error.getText().contains("locked out"),
                "User bị khóa phải hiển thị thông báo locked out"
        );
}
}
