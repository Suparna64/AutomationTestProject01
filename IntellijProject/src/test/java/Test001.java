import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This code is main copy of entire code
public class Test001 {


    @Test

    public void MyFirsttestcase001() {

        System.setProperty("webdriver.gecko.driver", "C:\\seleniumfiles\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //1. Go to Gmail website
        driver.get("http://www.gmail.com");

        //2. Fill in username
        WebElement Usernametextbox = driver.findElement(By.id("Email"));

        Usernametextbox.clear();
        Usernametextbox.sendKeys("gmailid@gmail.com");

        //3. Click Next
        WebElement eleNext = driver.findElement(By.id("next"));
        eleNext.click();
        //4. Fill in the password
        //could not locate password element--hence use wait command
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        WebElement PasswordTextBox = driver.findElement(By.id("Passwd"));
        PasswordTextBox.sendKeys("GmailPassword");
        //5. Click SignIn
        WebElement eleSignIn = driver.findElement(By.id("signIn"));
        eleSignIn.click();
        //6. Verify User did SignIn
        //could not locate inbox--hence had to add wait syntax
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        //7. Sign out
        WebElement ProfileBtn = driver.findElement(By.cssSelector("span[class='gb_9a gbii']"));
        ProfileBtn.click();

        WebElement SignOutLinkage = driver.findElement(By.id("gb_71"));
        SignOutLinkage.click();

        //8. Verify able to signout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("SignIn button should exist", driver.findElements(By.id("SignIn")).size() > 0);

    }
        //Scenario-2- Send and Receive email
        @Test
        public void SendAndReceiveemail() {
            //1. Click SignIn
            System.setProperty("webdriver.gecko.driver", "C:\\seleniumfiles\\geckodriver-v0.15.0-win64\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            //1. Go to Gmail website
            driver.get("http://www.gmail.com");

            //2. Fill in username
            WebElement Usernametextbox= driver.findElement(By.id("Email"));

            Usernametextbox.clear();
            Usernametextbox.sendKeys("gmailid@gmail.com");

            //3. Click Next
            WebElement eleNext=driver.findElement(By.id("next"));
            eleNext.click();
            //4. Fill in the password
            //could not locate password element--hence use wait command
            WebDriverWait wait=new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
            WebElement PasswordTextBox= driver.findElement(By.id("Passwd"));
            PasswordTextBox.sendKeys("GmailPassword");
            //5. Click SignIn
            WebElement eleSignIn= driver.findElement(By.id("signIn"));
            eleSignIn.click();
            //6. Verify User did SignIn
            //could not locate inbox--hence had to add wait syntax
            WebDriverWait wait1 = new WebDriverWait(driver, 40);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

            Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);
            //2. Click compose
            //3.Fill in Recipient
            //4.Fill in subject
            //5.Fill in email body
            //6.Click Send
            //7.Click Inbox again
            //8.Click email
            //9.Verify email subject and email body is correct
            //10. SignOut
        }
        //9.Exit
       // driver.quit();
//Scenario-2- Send and Receive email
        @Test

        public void SendAndReceiveEmail(){
            //1. Click SignIn
            System.setProperty("webdriver.gecko.driver", "C:\\seleniumfiles\\geckodriver-v0.15.0-win64\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            //1. Go to Gmail website
            driver.get("http://www.gmail.com");

            //2. Fill in username
            WebElement Usernametextbox= driver.findElement(By.id("Email"));

            Usernametextbox.clear();
            Usernametextbox.sendKeys("Gmailid@gmail.com");

            //3. Click Next
            WebElement eleNext=driver.findElement(By.id("next"));
            eleNext.click();
            //4. Fill in the password
            //could not locate password element--hence use wait command
            WebDriverWait wait=new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
            WebElement PasswordTextBox= driver.findElement(By.id("Passwd"));
            PasswordTextBox.sendKeys("GmailPassword");
            //5. Click SignIn
            WebElement eleSignIn= driver.findElement(By.id("signIn"));
            eleSignIn.click();
            //6. Verify User did SignIn
            //could not locate inbox--hence had to add wait syntax
            WebDriverWait wait1 = new WebDriverWait(driver, 40);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

            Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);
            //2. Click compose
            WebElement ComposeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm'"));
            ComposeButton.click();
            //3.Fill in Recipient
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
            WebElement toTextArea = driver.findElement(By.cssSelector("textarea[name='to']"));
            toTextArea.clear();
            toTextArea.sendKeys("Gmailid@gmail.com");
            //4.Fill in subject
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='subjectbox']")));
            WebElement subjectTextArea = driver.findElement(By.cssSelector("input[name='subjectbox']"));
            final String subject="Email Test-Gmail";
            subjectTextArea.clear();
            subjectTextArea.sendKeys(subject);
            //5.Fill in email body
            WebElement bodyTextArea = driver.findElement(By.cssSelector("div[aria-label=\"Message Body\"]"));
            final String body="Hello Testers! Good Morning";
            bodyTextArea.clear();
            bodyTextArea.sendKeys(body);
            //6.Click Send
            WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*=\"Send\"]"));
            sendButton.click();
            //7.Click Inbox again
            WebElement inboxLinkage = driver.findElement(By.cssSelector("a[aria-label*='Inbox']"));
            inboxLinkage.click();
            //8.Click email
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b']")));
            WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
            newEmail.click();
            //9.Verify email subject and email body is correct
            WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP'"));
            Assert.assertEquals("Email Subject Text should be same",subject,subjectArea.getText());
            WebElement bodyArea = driver.findElement(By.cssSelector("div[class='nH aHU'] div[dir='ltr']"));
            Assert.assertEquals("Email body area Text should be same",body,bodyArea.getText());
            //10. SignOut
            WebElement ProfileBtn = driver.findElement(By.cssSelector("span[class='gb_9a gbii']"));
            ProfileBtn.click();

            WebElement SignOutLinkage = driver.findElement(By.id("gb_71"));
            SignOutLinkage.click();
        }


    }

