package com.epam.training.serhii_klymenko.task1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CreateTest extends BaseTest {

    @Test(groups = "selenium")
    public void testCreatingSimplePaste() throws IOException {
        driver.get(HOMEPAGE_URL);
        PasteBinMainPage mainPage = new PasteBinMainPage(driver);
        Map<String, String> testData = JsonDataUtility.getTestData();

        mainPage.clickCreateNewPasteBtn()
                .inputCodeIntoPostForm(testData.get("post"))
                .clickPasteExpirationDropdown()
                .clickTenMinutesExpiration()
                .insertPasteName(testData.get("pasteName"))
                .clickSubmitNewPaste();

        assertTrue(mainPage.isSuccessNoticeDisplayed(), testData.get("failMsg"));
    }
}
