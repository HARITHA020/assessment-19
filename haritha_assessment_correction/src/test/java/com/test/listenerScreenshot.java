package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class listenerScreenshot {

    public static void captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File folder = new File("screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");
        try {
            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}