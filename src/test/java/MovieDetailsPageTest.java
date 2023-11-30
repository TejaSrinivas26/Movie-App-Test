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


public class MovieDetailsPageTest {
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
    public void homePageClick(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement movie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='No Time to Die']")));
            System.out.println("Element found, proceeding to click.");
            movie.click();

            Thread.sleep(2000);

            WebElement titleCard = driver.findElement(By.className("title-details-container"));
            titleCard.isDisplayed();
            System.out.println("Movie Name Displayed");

            WebElement discrptionOfMovie = driver.findElement(By.className("movie-overview"));
            discrptionOfMovie.isDisplayed();
            System.out.println("Discrption of Movie the Displayed");

            WebElement playButton = driver.findElement(By.className("play-button"));
            playButton.isDisplayed();
            System.out.println("Play  Button is Displayed");

            WebElement movieDetails = driver.findElement(By.className("detailed-movie-categories-container"));
            movieDetails.isDisplayed();
            System.out.println("Movie Details is Displayed");

            WebElement similarMovies = driver.findElement(By.className("similar-movies-container"));
            similarMovies.isDisplayed();
            System.out.println("Similar Movie Section is Displayed");

            WebElement contantsSection = driver.findElement(By.className("contact-us-paragraph"));
            contantsSection.isDisplayed();
            System.out.println("Contants Section is Displayed");

        } catch (InterruptedException e) {
            System.out.println("Element not found within the specified time.");
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void popularPageClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            WebElement popularSec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Popular']")));
            popularSec.click();

            Thread.sleep(2000);

            WebElement movieSelection = driver.findElement(By.cssSelector("img[alt='The Boss Baby: Family Business']"));
            movieSelection.click();

            Thread.sleep(2000);

            WebElement movieTitleCard = driver.findElement(By.cssSelector(".title-details-container .movie-title"));
            String actulaMovieTitle = movieTitleCard.getText();
            String expectedMovieTitle = "The Boss Baby: Family Business";
            Assert.assertEquals(actulaMovieTitle, expectedMovieTitle, "Movie Title not Match");

            WebElement moviedetails = driver.findElement(By.className("detailed-movie-categories-container"));
            moviedetails.isDisplayed();

            WebElement similarMovies = driver.findElement(By.className("similar-movies-container"));
            similarMovies.isDisplayed();

            WebElement contactSections = driver.findElement(By.className("footer-container"));
            contactSections.isDisplayed();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
