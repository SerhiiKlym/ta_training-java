package com.epam.training.serhii_klymenko.task1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CreateTest extends BaseTest {
    @Test(groups = "selenium")
    public void testCreatingSimplePaste() throws IOException {
        driver.get("https://pastebin.com/");
        PasteBinMainPage mainPage = new PasteBinMainPage(driver);
        Map<String, String> testData = JsonDataUtility.getTestData();

        mainPage.clickCreateNewPasteBtn();
        mainPage.inputCodeIntoPostForm(testData.get("post"));
        mainPage.clickPasteExpirationDropdown();
        mainPage.clickTenMinutesExpiration();
        mainPage.insertPasteName(testData.get("pasteName"));
        mainPage.clickSubmitNewPaste();

        assertTrue(mainPage.isSuccessNoticeDisplayed(), testData.get("failMsg"));
    }
}
