package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Базовий клас для всіх тестів.
 * Тут ми ініціалізуємо та закриваємо WebDriver.
 */
public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupClass() {
        // Підтягнути відповідний chromedriver під вашу версію Chrome
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        // Створити новий екземпляр ChromeDriver перед кожним тестом
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Закрити браузер після кожного тесту
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Допоміжний геттер для доступу до драйвера з листенерів
     */
    public WebDriver getDriver() {
        return driver;
    }
}
