package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "videoModal")
    private WebElement modal;

    @FindBy(css = "#videoModal .modal-title")
    private WebElement modalTitle;

    @FindBy(css = "#videoModal .btn-secondary")
    private WebElement closeButton;

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /** Чекаємо, поки модалка з’явиться */
    public void waitForModal() {
        wait.until(ExpectedConditions.visibilityOf(modal));
    }

    /** Повертаємо заголовок модалки */
    public String getTitle() {
        return modalTitle.getText();
    }

    /** Закриваємо модалку */
    public void close() {
        closeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(modal));
    }
}
