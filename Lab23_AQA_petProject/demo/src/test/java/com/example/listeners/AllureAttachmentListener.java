package com.example.listeners;

import com.example.tests.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class AllureAttachmentListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).getDriver();

            // 1) Додаємо скриншот
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(
                    "Screenshot",
                    new ByteArrayInputStream(screenshot));

            // 2) Додаємо HTML‑дамп сторінки
            String pageSource = driver.getPageSource();
            Allure.addAttachment(
                    "Page source",
                    "text/html",
                    new ByteArrayInputStream(pageSource.getBytes(StandardCharsets.UTF_8)),
                    ".html");
        }
    }
}
