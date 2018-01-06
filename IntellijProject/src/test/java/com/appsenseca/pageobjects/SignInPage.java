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
public class SignInPage {


    public void fillInUsername(WebDriver driver, String s) {
        WebElement UsernameTextbox = driver.findElement(By.id("Email"));
        UsernameTextbox.clear();
        UsernameTextbox.sendKeys(s);
    }

    public void clickNext(WebDriver driver) {

        WebElement eleNext = driver.findElement(By.id("next"));
        eleNext.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
    }

    public void fillInPassword(WebDriver driver, String s) {

        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
       WebElement PasswordTextBox = driver.findElement(By.id("Passwd"));
        PasswordTextBox.sendKeys(s);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {

        WebElement eleSignIn = driver.findElement(By.id("signIn"));
        eleSignIn.click();

        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        return PageFactory.initElements(driver,EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {


        return driver.findElements(By.id("SignIn")).size() > 0;
    }
}
