package com.example.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * Додає паузу перед кожною дією WebDriver,
 * щоб загальну швидкість виконання тестів зробити ~2× повільнішою.
 */
public class SlowListener implements WebDriverListener {
    /** 1000 мс пауза перед кожним викликом */
    private static final long PAUSE_MS = 1000;

    private void pause() {
        try {
            Thread.sleep(PAUSE_MS);
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        pause();
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        pause();
    }

    @Override
    public void beforeClick(WebElement element) {
        pause();
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keys) {
        pause();
    }

    // За потреби можна додати інші beforeXxx методи
}
