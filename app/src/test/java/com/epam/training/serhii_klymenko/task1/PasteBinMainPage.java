package com.epam.training.serhii_klymenko.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinMainPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//a[@class='header__btn']/span")
    private WebElement createNewPaste;
    @FindBy(xpath = "//textarea[@name='PostForm[text]']")
    private WebElement pastePostForm;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationTimeSelector;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationTimeTenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteNameInput;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement submitNewPaste;
    @FindBy(xpath = "//div[contains(@class, 'notice -success -post-view')]")
    private WebElement successNotice;

    public PasteBinMainPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewPasteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(createNewPaste));
    }

    public void inputCodeIntoPostForm(String paste) {
        wait.until(ExpectedConditions.visibilityOf(pastePostForm)).sendKeys(paste);
    }

    public void clickPasteExpirationDropdown() {
        wait.until(ExpectedConditions.visibilityOf(pasteExpirationTimeSelector)).click();
    }

    public void clickTenMinutesExpiration() {
        wait.until(ExpectedConditions.visibilityOf(pasteExpirationTimeTenMinutes)).click();
    }

    public void insertPasteName(String pasteName) {
        wait.until(ExpectedConditions.visibilityOf(pasteNameInput)).sendKeys(pasteName);
    }

    public void clickSubmitNewPaste() {
        wait.until(ExpectedConditions.visibilityOf(submitNewPaste)).click();
    }

    public boolean isSuccessNoticeDisplayed() {
        return successNotice.isDisplayed();
    }

}
