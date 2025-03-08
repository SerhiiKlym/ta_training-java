package com.epam.training.serhii_klymenko.task1;

import com.epam.training.serhii_klymenko.task1.driver.DriverSingleton;
import com.epam.training.serhii_klymenko.task1.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://pastebin.com/";

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();// was new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}