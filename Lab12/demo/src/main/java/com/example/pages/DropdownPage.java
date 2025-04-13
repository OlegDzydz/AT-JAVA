package com.example.pages;

import com.example.wrappers.DropdownWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Сторінка з одним dropdown:
 * https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
 */
public class DropdownPage {
    private final WebDriver driver;

    @FindBy(id = "select-demo")
    private WebElement daySelect;

    public final DropdownWrapper dayDropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // Обгортаємо WebElement у наш DropdownWrapper
        this.dayDropdown = new DropdownWrapper(driver, daySelect);
    }

    public void open() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
}
