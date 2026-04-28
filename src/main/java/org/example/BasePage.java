package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * The BasePage serves as the parent for all Page classes.
 * It initializes the driver and sets up common utilities like explicit waits.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Standardizing a 10-second explicit wait for all child pages
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Common utility method to get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Common utility to navigate to a URL
    public void navigateTo(String url) {
        driver.get(url);
    }
}
