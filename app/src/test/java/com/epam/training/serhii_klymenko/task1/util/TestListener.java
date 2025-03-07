package com.epam.training.serhii_klymenko.task1.util;

import com.epam.training.serhii_klymenko.task1.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    private void saveScreenshot() {
        try {
            File screenCapture = ((TakesScreenshot) DriverSingleton
                            .getDriver())
                            .getScreenshotAs(OutputType.FILE);

            String screensDir = System.getProperty("screenshot.dir", "./build/screenshots/");

            File targetFile = new File(screensDir, getCurrentTimeAsString() + ".png");
            targetFile.getParentFile().mkdirs();

            FileUtils.copyFile(screenCapture, targetFile);
            logger.info("Screenshot saved at: " + targetFile.getAbsolutePath());

        } catch (WebDriverException e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        }catch (IOException e){
            logger.error("Failed to take screenshot: ", e);
        }

    }


    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
