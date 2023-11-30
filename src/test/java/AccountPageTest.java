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

public class AccountPageTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TEJASURYA\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void accountPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accounts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));
        accounts.click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Account Url Not Match");

        WebElement userName = driver.findElement(By.className("membership-username"));
        String expectedUserName = userName.getText();
        String actualUserName = "User name : rahul";
        Assert.assertEquals(expectedUserName, actualUserName, "Accounts Username Not Match");

        WebElement password = driver.findElement(By.className("membership-password"));
        String expectedpassword = password.getText();
        String actualPasswords = "Password : **********";
        Assert.assertEquals(expectedpassword, actualPasswords, "Account Page Password not Match");

        WebElement planDetails = driver.findElement(By.className("plan-container"));
        Assert.assertTrue(planDetails.isDisplayed());
    }

    @Test(priority = 2)
    public void logoutFunctionality(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accounts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));
        accounts.click();

        WebElement logoutButton = driver.findElement(By.className("logout-button"));
        logoutButton.click();

        String expectedURl = "https://qamoviesapp.ccbp.tech/login";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedURl, actualUrl, "Logout URl not Match");
    }
}
