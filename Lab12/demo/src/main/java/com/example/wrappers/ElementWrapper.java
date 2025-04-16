package com.example.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementWrapper {
    protected final WebDriver driver;
    protected final WebElement element;

    public ElementWrapper(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public void click() {
        System.out.println("[LOG] click() on: " + element);
        element.click();
    }

    public void sendKeys(String text) {
        System.out.println("[LOG] sendKeys(\"" + text + "\") into: " + element);
        element.sendKeys(text);
    }
}
