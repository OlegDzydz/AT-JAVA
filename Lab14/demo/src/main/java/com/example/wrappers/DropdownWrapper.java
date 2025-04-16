package com.example.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownWrapper {
    private final WebDriver driver;
    private final WebElement element;
    private final Select select;

    public DropdownWrapper(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
        this.select = new Select(element);
    }

    public void selectByValue(String value) {
        System.out.println("[LOG] selectByValue(\"" + value + "\")");
        select.selectByValue(value);
    }

    public void selectByIndex(int index) {
        System.out.println("[LOG] selectByIndex(" + index + ")");
        select.selectByIndex(index);
    }

    public void selectByVisibleText(String text) {
        System.out.println("[LOG] selectByVisibleText(\"" + text + "\")");
        select.selectByVisibleText(text);
    }
}
