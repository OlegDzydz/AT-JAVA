package com.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "logInModal")
    private WebElement modal;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(css = "#logInModal .btn-primary")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /** Чекаємо, поки модалка стане видимою */
    public void waitForModal() {
        wait.until(ExpectedConditions.visibilityOf(modal));
    }

    /**
     * Виконує вхід:
     * 1. Чекає появи модалки
     * 2. Вводить user і pass
     * 3. Натискає кнопку "Log in"
     * 4. Якщо з’явився alert (Wrong password), приймає його
     * і натискає кнопку "Close" у модалці
     * 5. Чекає, поки модалка зникне (успішний вхід)
     *
     * @return true — якщо вхід успішний, false — якщо був alert і модалка закрилася
     *         через Close
     */
    public boolean login(String user, String pass) {
        waitForModal();
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginButton.click();

        // Обробляємо можливий alert "Wrong password."
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = alertWait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            // Коли пароль неправильний — натискаємо кнопку "Close" у модалці
            WebElement closeBtn = modal.findElement(
                    By.cssSelector(".modal-footer .btn-secondary"));
            closeBtn.click();
            return false;
        } catch (TimeoutException ignored) {
            // Нема alert — продовжуємо як успішний вхід
        }

        // Чекаємо, поки модалка зникне
        wait.until(ExpectedConditions.invisibilityOf(modal));
        return true;
    }
}
