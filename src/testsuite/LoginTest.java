package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String BaseUrl = "https://courses.ultimateqa.com/";
    @Before

    public void setUp()
    {
        openBrowser(BaseUrl);
    }
    // Verifying user should be able to navigate to log in page
    @Test
    public void userShouldNavigateToLoginPageSuccessfully (){
        // This is from requirement
        String expectedText = "Welcome Back!";
        WebElement signinLink=driver.findElement(By.linkText("Sign In"));
        signinLink.click();
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualText = actualTextElement.getText();
        // Verifying actual text is equals to expected text
        Assert.assertEquals("Welcome Back message not displayed",actualText,expectedText);
    }
    // Verifying the error message with invalid credentials
    @Test
    public void verifyTheErrorMessage() {

        WebElement signinLink=driver.findElement(By.linkText("Sign In"));
        signinLink.click();

        WebElement emailField = driver.findElement(By.name("user[email]"));
        emailField.sendKeys("abc@gmail.com");

        WebElement PasswordField = driver.findElement(By.id("user[password]"));
        PasswordField.sendKeys("abc123");

        WebElement signinButton = driver.findElement(By.xpath("//div/input[@value='Sign in']"));
        signinButton.click();

        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualText = actualTextElement.getText();

        String expectedText = "Invalid email or password.";
        // Verifying actual text is equals to expected text
        Assert.assertEquals("Invalid email/password message not displayed",actualText,expectedText);
    }
    @After
    public void tearDown()
    {
        //closeBrowser();
    }
}


