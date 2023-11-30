
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TEJASURYA\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //TestLoginPageUI
    @Test(priority = 1)
    public void logoIsDisplayed(){
        WebElement logo = driver.findElement(By.className("login-website-logo"));
        Assert.assertTrue(logo.isDisplayed(), "Logo image not displayed");

    }

    @Test(priority = 2)
    public void loginText(){
        WebElement loginHeadingTest = driver.findElement(By.className("sign-in-heading"));
        String actualHeadingText = loginHeadingTest.getText();

        String expectedHeadingText = "Login";
        Assert.assertEquals(actualHeadingText, expectedHeadingText, "Heading text does not match");
    }

    @Test(priority = 3)
    public void usernameText(){
        WebElement usernameText = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label"));
        String actualUsernameTest = usernameText.getText();

        String expectedUsernameText = "USERNAME";
        Assert.assertEquals(actualUsernameTest, expectedUsernameText, "username text does not match");
    }

    @Test(priority = 4)
    public void passwordText(){
        WebElement passwordText = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label"));
        String actualPasswordText = passwordText.getText();

        String expectedPasswordText = "PASSWORD";
        Assert.assertEquals(actualPasswordText, expectedPasswordText, "password text does not match");
    }

    @Test(priority = 5)
    public void buttonText(){
        WebElement buttonText = driver.findElement(By.className("login-button"));
        String actualButtonText = buttonText.getText();

        String expectedButtonText = "Login";
        Assert.assertEquals(actualButtonText, expectedButtonText, "Button text does not match");
    }


    //Login page Functionality
    @Test(priority = 6)
    public void emptyInputField() {
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessage = driver.findElement(By.className("error-message"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid", "Error text with empty input fields does not match");
    }

    @Test(priority = 7)
    public void emptyUsername(){
        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        passwordField.sendKeys("rahul@2021");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessage = driver.findElement(By.className("error-message"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid", "Error text with empty input fields does not match");
    }

    @Test(priority = 8)
    public void emptyPassword(){
        WebElement usernameField = driver.findElement(By.id("usernameInput"));
        usernameField.sendKeys("rahul");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessage = driver.findElement(By.className("error-message"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid", "Error text with empty input fields does not match");
    }

    @Test(priority = 9)
    public void invalidCredentials1(){
        WebElement usernameField = driver.findElement(By.id("usernameInput"));
        usernameField.sendKeys("rhul"); //invalidUsername

        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        passwordField.sendKeys("rahul@2021");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessage = driver.findElement(By.className("error-message"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, "*invalid username", "Error text with empty input fields does not match");
    }

    @Test(priority = 10)
    public void invalidCredentials2(){
        WebElement usernameField = driver.findElement(By.id("usernameInput"));
        usernameField.sendKeys("rahul");

        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        passwordField.sendKeys("rahul@2020"); //invalidPassword

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessage = driver.findElement(By.className("error-message"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, "*username and password didn't match", "Error text with empty input fields does not match");
    }

    @Test(priority = 11)
    public void validCredential(){
        WebElement usernameField = driver.findElement(By.id("usernameInput"));
        usernameField.sendKeys("rahul");

        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        passwordField.sendKeys("rahul@2021");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "URL Not match");

    }
}
