package com.example.pages;

import com.example.wrappers.DropdownWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Тепер локатор на id="oldSelectMenu" на сторінці DemoQA
    @FindBy(id = "oldSelectMenu")
    private WebElement demoQaSelect;

    public DropdownWrapper demoQaDropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        // 1) Відкриваємо сторінку з Select Menu
        driver.get("https://demoqa.com/select-menu");

        // 2) Чекаємо, доки дропдаун стане видимим
        wait.until(ExpectedConditions.visibilityOf(demoQaSelect));

        // 3) Ініціалізуємо обгортку
        this.demoQaDropdown = new DropdownWrapper(driver, demoQaSelect);
    }
}
