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

public class HomePageTest {

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
    public void movieHeadingText(){
        WebElement headingText1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/h1"));
        headingText1.isDisplayed();

        WebElement headingText2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/h1"));
        headingText2.isDisplayed();
    }

    @Test(priority = 2)
    public void playButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playButtonExits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='home-movie-play-button']")));
        playButtonExits.isDisplayed();
    }

    @Test(priority = 3)
    public void movieSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playButtonExits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slick-list']")));

        playButtonExits.isDisplayed();

        WebElement originalMovies = driver.findElement(By.className("slick-list"));
        originalMovies.isDisplayed();
    }

    @Test(priority = 4)
    public void contectSection(){
        WebElement contectsSecs = driver.findElement(By.className("contact-us-paragraph"));
        contectsSecs.isDisplayed();
    }
}
