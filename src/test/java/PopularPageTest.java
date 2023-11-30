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
import java.util.List;

public class PopularPageTest {
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
    public void popularMoviesPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularSec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Popular']")));
        popularSec.click();

        try {
            List<WebElement> movieElement = driver.findElements(By.xpath("//div[@class='search-movies-container']/li/a[@class='link-item']/img[@class='movie-image']"));
            for(WebElement element : movieElement){
                if(!element.isDisplayed()){
                    System.out.println("Movie Element not Displayed");
                }
            }
            System.out.println("All Movie are Displayed");
        }finally {
            driver.quit();
        }
    }
}
