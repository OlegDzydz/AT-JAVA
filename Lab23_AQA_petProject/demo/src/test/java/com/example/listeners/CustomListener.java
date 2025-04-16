package com.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

// Додаємо ITestNGListener у implements
public class CustomListener implements
        ITestNGListener,
        IExecutionListener,
        ISuiteListener,
        IInvokedMethodListener,
        ITestListener {

    private static final Logger logger = LogManager.getLogger(CustomListener.class);

    // IExecutionListener
    @Override
    public void onExecutionStart() {
        logger.info("=== Execution started ===");
    }

    @Override
    public void onExecutionFinish() {
        logger.info("=== Execution finished ===");
    }

    // ISuiteListener
    @Override
    public void onStart(ISuite suite) {
        logger.info("Suite started: {}", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("Suite finished: {}", suite.getName());
    }

    // IInvokedMethodListener
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        logger.info("Before invocation: {}.{}",
                method.getTestMethod().getTestClass().getName(),
                method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        logger.info("After invocation: {}.{}",
                method.getTestMethod().getTestClass().getName(),
                method.getTestMethod().getMethodName());
    }

    // ITestListener
    @Override
    public void onStart(ITestContext context) {
        logger.info("Test context started: {}", context.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Failed within success %: {}", result.getName());
    }

    // Інші методи ITestListener лишаємо порожніми
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
