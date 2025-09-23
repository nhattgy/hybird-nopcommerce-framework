package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToRegister() {
        waitForElementClickable(driver, HomePageUI.BUTTON_REGISTER_LINK);
        clickToElement(driver, HomePageUI.BUTTON_REGISTER_LINK);
    }

    public void clickToLoginPage() {
        waitForElementClickable(driver, HomePageUI.BUTTON_LOGIN_LINK);
        clickToElement(driver, HomePageUI.BUTTON_LOGIN_LINK);
    }

    public void clickMyAccount() {
        waitForElementClickable(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
    }
}
