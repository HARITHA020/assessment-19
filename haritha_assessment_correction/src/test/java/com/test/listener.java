package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
       Object currentClass = result.getInstance();
        WebDriver driver = ((CommonTest) currentClass).driver;
        listenerScreenshot.captureScreenshot(driver, result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
}