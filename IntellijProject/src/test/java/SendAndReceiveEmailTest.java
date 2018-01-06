import com.appsenseca.categories.Critical;
import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.EmailViewPage;
import com.appsenseca.pageobjects.SignInPage;
import com.appsenseca.utils.WebUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendAndReceiveEmailTest {

        @Category({Critical.class})
        @Test

        public void GmailSignInTest() {

            System.setProperty("webdriver.gecko.driver", "C:\\seleniumfiles\\geckodriver-v0.15.0-win64\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            //1. Go to Gmail website
            SignInPage SignInPage= WebUtil.goToSignInPage(driver);

            //2. Fill in username
            SignInPage.fillInUsername(driver,"sudevna2@gmail.com");


            //3. Click Next
            SignInPage.clickNext(driver);

            //4. Fill in the password
            //could not locate password element--hence use wait command
            SignInPage.fillInPassword(driver, "Nicename123#");

            //5. Click SignIn
            EmailHomePage emailHomePage=SignInPage.clickSignIn(driver);

            //6. Verify User did SignIn
            Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(driver));


            //7. Sign out---when we click signout , we should be back in signin page
            SignInPage = emailHomePage.signOut(driver);


            //8. Verify able to signout
           // Assert.assertTrue("SignIn button should exist", SignInPage.isSignInButtonExist(driver));



        }
            //Scenario-2- Send and Receive email
        @Test

            public void SendAndReceiveEmail(){
                //1. Click SignIn
                System.setProperty("webdriver.gecko.driver", "C:\\seleniumfiles\\geckodriver-v0.15.0-win64\\geckodriver.exe");
                WebDriver driver = new FirefoxDriver();
                //1. Go to Gmail website
            SignInPage SignInPage= WebUtil.goToSignInPage(driver);

            //2. Fill in username
            SignInPage.fillInUsername(driver,"sudevna2@gmail.com");


            //3. Click Next
            SignInPage.clickNext(driver);

            //4. Fill in the password
            //could not locate password element--hence use wait command
            SignInPage.fillInPassword(driver, "Nicename123#");

            //5. Click SignIn
            EmailHomePage emailHomePage=SignInPage.clickSignIn(driver);


                //2. Click compose
            emailHomePage.clickComposeButton(driver);

                //3.Fill in Recipient
            emailHomePage.fillInReceipient(driver,"sudevna2@gmail.com");

                //4.Fill in subject
            final String subject="Email Test-Gmail";
            emailHomePage.fillInSubject(driver,subject);

                //5.Fill in email body
            final String body="Hello Testers! Good Morning";
            emailHomePage.fillInBody(driver, body);

                //6.Click Send
            emailHomePage.clickSendEmail(driver);

                //7.Click Inbox again
            emailHomePage.clickInboxWithNewEmail(driver, "a[aria-label*='Inbox']");

                //8.Click email
            EmailViewPage emailViewPage = emailHomePage.clickNewEmail(driver);

                //9.Verify email subject and email body is correct
            String actualSubject = emailViewPage.getEmailSubjectText(driver);

           Assert.assertEquals("Email Subject Text should be same",subject,actualSubject);

            String actualBody=emailViewPage.getEmailBodyText(driver);

            Assert.assertEquals("Email body area Text should be same",body,actualBody);
                //10. SignOut
            emailHomePage.signOut(driver);
            }
            //9.Exit
            //driver.quit();



        }



