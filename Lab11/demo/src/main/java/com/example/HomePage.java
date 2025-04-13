package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By aboutUsLink = By.linkText("About us");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickAboutUs() {
        driver.findElement(aboutUsLink).click();
    }
}
