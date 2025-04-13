package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsModalPage {
    private final WebDriver driver;
    // Зазвичай заголовок модалки має id="videoModalLabel"
    private final By modalLabel = By.id("videoModalLabel");
    // Кнопка закриття в модалці
    private final By closeButton = By.cssSelector("#videoModal .btn-close");

    public AboutUsModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isModalVisible() {
        return driver.findElement(modalLabel).isDisplayed();
    }

    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
