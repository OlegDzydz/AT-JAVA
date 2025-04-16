package com.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverPool {
    private static final ThreadLocal<WebDriver> pool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (pool.get() == null) {
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    pool.set(new FirefoxDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    pool.set(new ChromeDriver());
            }
        }
        return pool.get();
    }

    public static void quitDriver() {
        WebDriver driver = pool.get();
        if (driver != null) {
            driver.quit();
            pool.remove();
        }
    }
}
