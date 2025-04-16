package com.example.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.example.tests.BaseTest;

import java.nio.charset.StandardCharsets;

public class AllureAttachmentListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] data) {
        return data;
    }

    @Attachment(value = "Page Source", type = "text/html")
    private byte[] savePageSource(String html) {
        return html.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object inst = result.getInstance();
        if (inst instanceof BaseTest) {
            WebDriver driver = ((BaseTest) inst).getDriver();
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            savePageSource(driver.getPageSource());
        }
    }

    // інші методи порожні
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
