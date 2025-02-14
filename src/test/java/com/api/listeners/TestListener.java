package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger Logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {
        Logger.info("Test Suite Started");
    }

    public void onFinish(ITestContext context) {
        Logger.info("Test Suite Completed.");
    }

    public void onTestStart(ITestResult result) {
        Logger.info("Test Start : -----> " + result.getMethod().getMethodName());
        Logger.info("Test Description : -----> " + result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        Logger.info("Test Passed : -----> " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        Logger.error("Test Failed : -----> " + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        Logger.info("Test Skipped : -----> " + result.getMethod().getMethodName());
    }


}
