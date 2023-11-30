import java.time.Duration;
import java.util.List;

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

public class SearchPageTest {
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
    public void SearchFunctionality(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
        search.click();

        try{
            String[] movieNames = {"Venom", "Spider-Man", "Jungle Cruise"};

            int moviesDisplayedCount = 0;

            for(String movieName : movieNames){
                WebElement searchInput = driver.findElement(By.className("search-input-field"));
                searchInput.clear();
                searchInput.sendKeys(movieName);
                WebElement enterSearchInput = driver.findElement(By.className("search-button"));
                enterSearchInput.click();

                Thread.sleep(2000);

                List<WebElement> movieElement = driver.findElements(By.xpath("//ul[@class='search-movies-container']/li/a[@class='link-item']/img[@class='movie-image']"));

                if(movieElement.size() > 0) {
                    System.out.println("Movies displayed for " + movieName + " : " + movieElement.size());
                    moviesDisplayedCount += movieElement.size();
                }else{
                    System.out.println("No Movies displayed");
                }
            }
            System.out.println("Total Movies Displayed: " + moviesDisplayedCount);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
