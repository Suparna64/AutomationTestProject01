package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Debadatta_Rath on 3/30/2017.
 */
public class EmailHomePage {


    public SignInPage signOut(WebDriver driver) {
        WebElement ProfileBtn = driver.findElement(By.cssSelector("span[class='gb_9a gbii']"));
        ProfileBtn.click();

        WebElement SignOutLinkage = driver.findElement(By.id("gb_71"));
        SignOutLinkage.click();

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {

       return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
    }

    public void clickComposeButton(WebDriver driver) {

        WebElement ComposeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm'"));
        ComposeButton.click();

    }

    public void fillInReceipient(WebDriver driver, String s) {
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        WebElement toTextArea = driver.findElement(By.cssSelector("textarea[name='to']"));
        toTextArea.clear();
        toTextArea.sendKeys("sudevna2@gmail.com");
    }

    public void fillInSubject(WebDriver driver, String subject) {
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='subjectbox']")));
        WebElement subjectTextArea = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        subjectTextArea.clear();
        subjectTextArea.sendKeys(subject);
    }

    public void fillInBody(WebDriver driver, String body) {

        WebElement bodyTextArea = driver.findElement(By.cssSelector("div[aria-label=\"Message Body\"]"));

        bodyTextArea.clear();
        bodyTextArea.sendKeys(body);
    }

    public void clickSendEmail(WebDriver driver) {

        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*=\"Send\"]"));
        sendButton.click();
    }

    public void clickInboxWithNewEmail(WebDriver driver, String s) {
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label*='Inbox']")));
        WebElement inboxLinkage = driver.findElement(By.cssSelector("a[aria-label*='Inbox']"));
        inboxLinkage.click();
    }

    public EmailViewPage clickNewEmail(WebDriver driver) {
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
        newEmail.click();

        return PageFactory.initElements(driver,EmailViewPage.class);
    }
}
