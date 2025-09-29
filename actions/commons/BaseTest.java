package commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    public WebDriver getMultipleBrowser(String browserName){
        GetBrowserName getBrowserName = GetBrowserName.valueOf(browserName.toUpperCase());
        switch (getBrowserName){
            case FIREFOX:
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case CHROME:
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case EDGE:
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("No Browser");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    public int randomNumber(){
       return new Random().nextInt(9999);
    }
}
