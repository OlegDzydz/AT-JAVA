package com.example.pages;

import com.example.wrappers.DropdownWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DropdownPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "oldSelectMenu")
    private WebElement selectEl;

    public DropdownWrapper dropdown;

    public DropdownPage(WebDriver d) {
        this.driver = d;
        this.wait = new WebDriverWait(d, Duration.ofSeconds(10));
        PageFactory.initElements(d, this);
    }

    public void open() {
        driver.get("https://demoqa.com/select-menu");
        wait.until(ExpectedConditions.visibilityOf(selectEl));
        dropdown = new DropdownWrapper(driver, selectEl);
    }
}
