package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGenerate {
    private WebDriver driver;
    public static HomeJqueryPO getHomeJquery(WebDriver driver){
        return new HomeJqueryPO(driver);
    }
}
