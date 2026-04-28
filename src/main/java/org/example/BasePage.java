package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Automatically downloads and sets up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleSearch() {
        // 1. Navigate to URL
        driver.get("https://www.google.com");

        // 2. Find Search Box and Type
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // 3. Click the Search button (or hit Enter)
        searchBox.submit();

        // 4. Verification/Assertion
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Selenium WebDriver"), "Title did not match!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Closes all windows and ends the session
        }
    }
}
