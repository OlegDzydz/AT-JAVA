package com.example.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownWrapper extends ElementWrapper {
    private final Select select;

    public DropdownWrapper(WebDriver driver, WebElement element) {
        super(driver, element);
        this.select = new Select(element);
    }

    public void selectByValue(String v) {
        select.selectByValue(v);
    }

    public void selectByIndex(int idx) {
        select.selectByIndex(idx);
    }

    public void selectByVisibleText(String t) {
        select.selectByVisibleText(t);
    }
}
