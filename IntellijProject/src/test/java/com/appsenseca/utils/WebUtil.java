package com.appsenseca.utils;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Debadatta_Rath on 3/30/2017.
 */
public class WebUtil {


    public static SignInPage goToSignInPage(WebDriver driver) {

        driver.get("http://www.gmail.com");

        return PageFactory.initElements(driver, SignInPage.class);
    }

}
