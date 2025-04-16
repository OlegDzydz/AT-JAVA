package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "login2")
    private WebElement loginLink;

    @FindBy(linkText = "About us")
    private WebElement aboutUsLink;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(id = "signin2")
    private WebElement signUpLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.demoblaze.com");
    }

    public void goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void goToAboutUs() {
        // Тепер просто клікаємо по лінку за текстом
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void goToSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
    }
}
