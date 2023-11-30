import java.time.Duration;

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

public class HeaderSectionTest {
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

    // Header Section UI
    @Test(priority = 1)
    public void wibsiteLogo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoWibsite= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        logoWibsite.isDisplayed();
    }

    @Test(priority = 2)
    public void navBarHome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Home')]")));
        homeElement.isDisplayed();
    }

    @Test(priority = 3)
    public void navBarPopular(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-menu-list")));
        popularElement.isDisplayed();
    }

    //Header Section Functionalities
    @Test(priority = 4)
    public void homeSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeSec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class=\"list-item\"][1]")));
        homeSec.click();

        String expectedUrlHome = "https://qamoviesapp.ccbp.tech/";


        String actualUrlHome = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlHome, actualUrlHome, "Home Page URL not match");
    }

    @Test(priority = 6)
    public void PopularSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularSec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Popular']")));
        popularSec.click();

        String expectedPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe(expectedPopularUrl));

        String actualUrlPopular = driver.getCurrentUrl();
        Assert.assertEquals(expectedPopularUrl, actualUrlPopular, "Popular Page Url Not Match");
    }
//
    @Test(priority = 6)
    public void accountSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountSectionOnHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        accountSectionOnHeader.click();

        String expectedUrlOfAccounts = "https://qamoviesapp.ccbp.tech/account";

        String currentAccountUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlOfAccounts, currentAccountUrl, "accounts URL not match");
    }
}
